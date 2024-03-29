package reservation.service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import reservation.dto.GetTrainListDto;
import reservation.dto.PostReservationDto;
import reservation.entity.Cost;
import reservation.entity.ReservationInfo;
import reservation.entity.Seat;
import reservation.entity.StopStation;
import reservation.entity.Train;


public class Service {

	private static List<Train> trains = new ArrayList<Train>();
	private static List<Cost> costs = new ArrayList<Cost>();
	
	private static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
	
	public Service() {
		initData();
	}
	
	public List<Train> getPossibleTrainList(GetTrainListDto dto, LocalTime departureTime){
		//가능한 열차정보를 저장할 리스트 생성
		List<Train> possibleTrains = new ArrayList<>();
		
		
		for(Train train : trains) {
			//해당 인덱스 요소의 정착역 리스트 가져오기
			List<StopStation> stopStations = train.getStopStations();
			
			//동일한 출발역 인덱스 번호 변수 만들어주기
			int sameStationIndex = -1;
			
			//출발역
			for(int stopStationIndex =0 ; stopStationIndex < stopStations.size(); stopStationIndex++) {
				
				//인덱스에 따른 역의 이름 반환
				String stopStationName = stopStations.get(stopStationIndex).getStationName();
				
				//출발역과 요소가 같은지?
				if(!dto.isEqualsDepartureStation(stopStationName)) {
					continue;
				}
				
				//출발시간 이전에 거치는지? 확인
				LocalTime stationDepartureTime = LocalTime.parse(dto.getDepartureTime(), timeFormatter);
				
				//출발시간 이전에 지나간 역이라면 지나친것
				if(stationDepartureTime.isBefore(departureTime)) {
					break; //이미 지나간 기차면 더이상 진행하지 않는다
				}
				
				//동일 출발역의 인덱스 번호 기입
				sameStationIndex = stopStationIndex;
				break;
			}
			
			//위 작업이 됐는지 아닌지 확인 
			if(sameStationIndex == -1) {
				continue;
			}
			
			boolean isPossible = false;
			
			//도착역, 도착역에 대한 정거장이 있는지 확인
			for(int stopStationIndex = 0; stopStationIndex < stopStations.size(); stopStationIndex++) {
				
				//인덱스에 대한 역 이름 반환
				String stationName = stopStations.get(stopStationIndex).getStationName();
				
				if(!dto.isEqualsArrivalStation(stationName)) {
					continue;
				}
				
				if(stopStationIndex <= sameStationIndex) {
					break;
				}
				//좌석 확인하기
				isPossible= true;
				break;
			}
			
			if(!isPossible)continue; //!isPossible = false값 다시 도착역문구로 돌아간다
			
			List<Seat> seats = train.getSeats(); 
			
			int possibleSeatCount = 0;
			
			for(Seat seat : seats) {
				if(!seat.isSeatStatus()) possibleSeatCount++;
			}
			
			if(possibleSeatCount < dto.getNumberOfPeople()) {
				continue;
			}
			possibleTrains.add(train);
		}
		
		return possibleTrains;
	}
	
	public ReservationInfo postReservation(PostReservationDto postReservationDto, GetTrainListDto getTrainListDto) {
		//존재하는 열차 변수 지정
		Train train = null;
		
		//해당 인덱스의 열차정보 가져오기
		for(Train trainItem : trains) {
			if(postReservationDto.isEqualTrainNumber(trainItem.getTrainNumber())) {
			train = trainItem;
			break;
			}
		}
		
		if (train == null) {
			System.out.println("존재하지 않는 열차번호입니다.");
			return null;
		}
		
		boolean designationState = true; //좌석 지정상태
		
		List<Seat> seats = train.getSeats();
		List<String> inputSeatNumbers = postReservationDto.getSeats();
		
		//해당인덱스 좌석 정보 가져오기 / 입력 반복문 제외 두번째 for문
		for(int index = 0 ; index < seats.size() ; index++) {
			
			Seat seat = seats.get(index);
			
			for(String seatNumber : inputSeatNumbers) {
				if(!seat.getSeatNumber().equals(seatNumber)) {
					continue;
				}
				if(seat.isSeatStatus()) {
					designationState = false;
					break;
				}
				seat.setSeatStatus(designationState);
			}
			
			if (!designationState) break;
		}
		//좌석이 정상 배정되었는지?
		if(!designationState) {
			System.out.println("좌석배정에 실패했습니다.");
			return null;
		}
		
		//가격 저장할 변수 지정
		int totalCost = 0;
		
		for(Cost cost : costs) {
			
			//해당 요소의 출발역과 도착역이 지정한 출발역과 도착역과 같은지?
			boolean isEqualDepartureStation = 
					getTrainListDto.isEqualsDepartureStation(cost.getDepartureStation());
			boolean isEqualArrivalStation =
					getTrainListDto.isEqualsArrivalStation(cost.getArrivalStation());
			
			if (!isEqualDepartureStation || !isEqualArrivalStation) continue;
			totalCost = cost.getAmount() * getTrainListDto.getNumberOfPeople(); //가격변수에 해당 가격 저장
			break;
			
		}
		
		//for문 프로세스 추가
		String departureTime = "";
		String arrivalTime = "";
		
		for(StopStation stopStation : train.getStopStations()) {
			boolean isEqualDepartureStaion =
					getTrainListDto.isEqualsDepartureStation(stopStation.getStationName());
			boolean isEqualarrivalStation =
					getTrainListDto.isEqualsArrivalStation(stopStation.getStationName());
			
			if(isEqualDepartureStaion) departureTime = stopStation.getDepartureTime();
			if(isEqualarrivalStation) arrivalTime = stopStation.getArrivalTime();
					
		}
		
		//예약정보 객체 생성
		ReservationInfo reservationInfo = new ReservationInfo(
				"",
				postReservationDto.getTrainNumber(),
				postReservationDto.getSeats(),
				getTrainListDto.getDepartureStation(),
				departureTime,
				getTrainListDto.getArrivalStation(),
				arrivalTime,
				totalCost
				);
		
		
		return reservationInfo;
	}

	public static void initData() {
		//부산 -> 대구 -> 대전 -> 서울 루트의 값입력
		
		//값초기화
		//상행
		costs.add(new Cost("부산역", "서울역", 30000));
		costs.add(new Cost("부산역", "대전역", 20000));
		costs.add(new Cost("부산역", "대구역", 10000));
		costs.add(new Cost("대구역", "서울역", 20000));
		costs.add(new Cost("대구역", "대전역", 10000));
		costs.add(new Cost("대전역", "서울역", 10000));
		
		//하행
		costs.add(new Cost("서울역", "부산역", 30000));
		costs.add(new Cost("대전역", "부산역", 20000));
		costs.add(new Cost("대구역", "부산역", 10000));
		costs.add(new Cost("서울역", "대구역", 20000));
		costs.add(new Cost("대전역", "대구역", 10000));
		costs.add(new Cost("서울역", "대전역", 10000));
		
		Train train; //이걸 왜하는걸까..
		List<Seat> seats = new ArrayList<>();
		List<StopStation> stopStations = new ArrayList<>();
		//배열말고 리스트 통해서 자료 가져옴 //Train과 Cost는 static으로 가져왔는데 나머지는 왜 아닐까.
		
		seats.add(new Seat(1,"A1",false));
		seats.add(new Seat(1,"B1",false));
		seats.add(new Seat(1,"A2",false));
		seats.add(new Seat(1,"B2",false));
		seats.add(new Seat(2,"A1",false));
		seats.add(new Seat(2,"B1",false));
		seats.add(new Seat(2,"A2",false));
		seats.add(new Seat(2,"B2",false));
		seats.add(new Seat(3,"A1",false));
		seats.add(new Seat(3,"B1",false));
		seats.add(new Seat(3,"A2",false));
		seats.add(new Seat(3,"B2",false));
		
		//하행
		stopStations.add(new StopStation("서울역","", "06:00"));
		stopStations.add(new StopStation("대전역","06:45", "07:00"));
		stopStations.add(new StopStation("대구역","07:45", "08:00"));
		stopStations.add(new StopStation("부산역","09:00", ""));
		
		//train값 초기화
		train = new Train("KTX001","서울역","06:00","부산역","09:00",180,"KTX", seats, stopStations);
		trains.add(train);
		
		seats = new ArrayList<>(); // 다시 초기화 하는 이유는 상행과 하행의 열차는 다른 열차니까
		//상행에 예매좌석변화와 하행 예매좌석 변화는 달라야한다. 그러니까 다시 초기화해서 메모리 주소 가져와서 새 공간 확보
		stopStations = new ArrayList<>();
		
		seats.add(new Seat(1,"A1",false));
		seats.add(new Seat(1,"B1",false));
		seats.add(new Seat(1,"A2",false));
		seats.add(new Seat(1,"B2",false));
		seats.add(new Seat(2,"A1",false));
		seats.add(new Seat(2,"B1",false));
		seats.add(new Seat(2,"A2",false));
		seats.add(new Seat(2,"B2",false));
		seats.add(new Seat(3,"A1",false));
		seats.add(new Seat(3,"B1",false));
		seats.add(new Seat(3,"A2",false));
		seats.add(new Seat(3,"B2",false));
		
		//상행
		stopStations.add(new StopStation("부산역","", "09:00"));
		stopStations.add(new StopStation("대구역","09:45", "10:00"));
		stopStations.add(new StopStation("대전역","10:45", "11:00"));
		stopStations.add(new StopStation("서울역","12:00", ""));
		
		//train값 초기화
		train = new Train("KTX002", "부산역", "09:00", "서울역", "12:00", 180, "KTX", seats, stopStations);
		trains.add(train);
	}
}
