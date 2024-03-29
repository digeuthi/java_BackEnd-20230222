package trainReservation.service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import trainReservation.dto.GetTrainListDto;
import trainReservation.dto.PostReservationDto;
import trainReservation.entity.Cost;
import trainReservation.entity.ReservationInfo;
import trainReservation.entity.Seat;
import trainReservation.entity.StopStation;
import trainReservation.entity.Train;

//Service class(계층)
//실제 비즈니스 로직을 담당 

public class ReservationService {
	
	private static List<Train> trains = new ArrayList<Train>(); 
	private static List<Cost> costs = new ArrayList<Cost>(); 
	
	private static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

	public ReservationService() {
		initData();
	}
	
	public List<Train> getPossibleTrainList(GetTrainListDto dto, LocalTime departureTime){
		
		List<Train> possibleTrains = new ArrayList<>();
		
		//해당 인덱스 정착역 리스트 가져오기
		for(Train train : trains) {
			List<StopStation> stopStations = train.getStopStations();
			
			int sameStationIndex = -1; 
			//동일한 출발역의 인덱스 번호 기차가 정차하는 역이 존재하는지 검사하는 용도 
			//존재하면 넘어가고 존재하지 않으면 -1??
			//존재하지 않는 인덱스면 -1의 값을 가지니까 그래서 -1로 설정한건가 ㅇㅇ
			
			for(int stopStationIndex = 0; stopStationIndex < stopStations.size(); stopStationIndex ++) {
				
				StopStation stopStation = stopStations.get(stopStationIndex);
				String stopStationName = stopStation.getStationName();
				
				if(!dto.isEqualsDepartureStation(stopStationName)) {
					continue;
				}
				//출발역 거치긴하는데 우리가 입력한 시간 이후에 거치는지 이전에 거치는지 시간 확인
				LocalTime stationDepartuerTime = LocalTime.parse(dto.getDepartureTime(),timeFormatter);
				
				if(stationDepartuerTime.isBefore(departureTime)) { //같을때는 제외 false
					break;
				} //이전에 지나간 기차면 진행멈추기
				
				sameStationIndex = stopStationIndex;
				break;

			}
			
			//위 작업이 됐는지 아닌지 확인 
			if(sameStationIndex == -1) {
				continue;
			}
			
			//좌석확인?
			boolean isPossible = false;
			
			
			//정거장 다시 돌기, 도착역에 대한 정거장이 있는지 확인
			for(int stopStationIndex = 0; stopStationIndex < stopStations.size(); stopStationIndex++) {
				
				String stationName = stopStations.get(stopStationIndex).getStationName();
				
				if(!dto.isEqualsArrivalStation(stationName)) {
					continue;
				}
				
				//작다면 거쳐서 온것이라서 안된다. 방향이 반대라 성립X
				if(stopStationIndex <= sameStationIndex) {
					break;
				}
				
				//좌석 확인하기
				isPossible= true;
				break;
			}
				
			if(!isPossible) continue;

			List<Seat> seats = train.getSeats();
				
			int possibleSeatCount = 0;
				
			for(Seat seat : seats) {
				if(!seat.isSeatStatus())possibleSeatCount++;
			}
				
			if (possibleSeatCount < dto.getNumberOfPeople()) {
				continue;
			}
			
			possibleTrains.add(train);
		 
		}
		return possibleTrains;
	}
	
	public ReservationInfo/*메서드의 결과물의 반환타입*/ postReservation(PostReservationDto dto/*매개변수, 입력에 대한 부분 dto로 받아온다*/) /*메서드 선언부*/{
		//예약정보 객체가 정상적인 결과물, 반환타입이 예약정보(클래스를 만들어준다)/ 비정상은 좌석배정 실패와 null인데 이 반환값은 뭐냐
		//예약정보 객체 ReservationInfo (클래스 만들어준다)
		/// 비정상의 경우 정보가 지정되지 않았다 -> 지정되지 않은 상태 null : 참조변수 형태일적에 값이 지정되지 않은 상태
		//정상적이지 않은 경우 반환을 null로 지정해주면 된다. 자바 내에서 프로그래밍 언어로 null (기본타입 변수에서는 null 안들어감)/ 데이터 베이스에서의 null과는 다르다!
		
		//존재하는 열차 변수 지정
		Train train = null;
		
		return null;
	}
	
	private static void initData() {
		
		costs.add(new Cost("부산역", "서울역", 30000));
		costs.add(new Cost("부산역", "대전역", 20000));
		costs.add(new Cost("부산역", "대구역", 10000));
		costs.add(new Cost("대구역", "서울역", 20000));
		costs.add(new Cost("대구역", "대전역", 10000));
		costs.add(new Cost("대전역", "서울역", 10000));
		
		costs.add(new Cost("서울역", "부산역", 30000));
		costs.add(new Cost("서울역", "대전역", 10000));
		costs.add(new Cost("서울역", "대구역", 20000));
		costs.add(new Cost("대전역", "부산역", 20000));
		costs.add(new Cost("대전역", "대구역", 10000));
		costs.add(new Cost("대구역", "부산역", 10000));
		
		Train train; //train은 정보입력이 많아서 2개만한다
		List<Seat> seats = new ArrayList<>();
		List<StopStation> stopStations = new ArrayList<>();
		
		seats.add(new Seat(1,"A1", false));
		seats.add(new Seat(1,"B1", false));
		seats.add(new Seat(1,"A2", false));
		seats.add(new Seat(1,"B2", false));
		seats.add(new Seat(2,"A1", false));
		seats.add(new Seat(2,"B1", false));
		seats.add(new Seat(2,"A2", false));
		seats.add(new Seat(2,"B2", false));
		seats.add(new Seat(3,"A1", false));
		seats.add(new Seat(3,"B1", false));
		seats.add(new Seat(3,"A2", false));
		seats.add(new Seat(3,"B2", false));
		
		stopStations.add(new StopStation("서울역","", "06:00"));
		stopStations.add(new StopStation("대전역","06:45", "07:00"));
		stopStations.add(new StopStation("대구역","07:45", "08:00"));
		stopStations.add(new StopStation("부산역","09:00", ""));
		
		train = new Train("KTX001", "서울역", "06:00", "부산역", "09:00", 180, "KTX",
				stopStations, seats); //왜 인스턴스생성을 했을까.. cost는 안했는데 직접입력하는 그건가..? ->cost도 했음
		trains.add(train);
		
		
		//*다시 생성해서 값 넣어주기
		seats = new ArrayList<>();
		stopStations = new ArrayList<>();
		
		seats.add(new Seat(1,"A1", false));
		seats.add(new Seat(1,"B1", false));
		seats.add(new Seat(1,"A2", false));
		seats.add(new Seat(1,"B2", false));
		seats.add(new Seat(2,"A1", false));
		seats.add(new Seat(2,"B1", false));
		seats.add(new Seat(2,"A2", false));
		seats.add(new Seat(2,"B2", false));
		seats.add(new Seat(3,"A1", false));
		seats.add(new Seat(3,"B1", false));
		seats.add(new Seat(3,"A2", false));
		seats.add(new Seat(3,"B2", false));
		
		stopStations.add(new StopStation("부산역","", "09:00"));
		stopStations.add(new StopStation("대구역","09:45", "10:00"));
		stopStations.add(new StopStation("대전역","10:45", "11:00"));
		stopStations.add(new StopStation("서울역","12:00", ""));
		
		train =  new Train("KTX002", "부산역", "09:00", "서울역", "12:00", 180, "KTX",
				stopStations, seats);
				/*seats가 가지고 있는 주소를 그대로 집어넣으면 KTX001이 변경이 되면 같이 변함 그래서 다시* 생성*/
		trains.add(train);
	}
}	
	
	

