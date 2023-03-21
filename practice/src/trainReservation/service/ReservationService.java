package trainReservation.service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import trainReservation.dto.GetReservationDto;
import trainReservation.dto.GetTrainListDto;
import trainReservation.dto.PostReservationDto;
import trainReservation.entity.Cost;
import trainReservation.entity.ReservationInfo;
import trainReservation.entity.Seat;
import trainReservation.entity.StopStation;
import trainReservation.entity.Train;

public class ReservationService {

	private static List<Train> trains = new ArrayList<>();
	private static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
	private static List<Cost> costs = new ArrayList<>();
	private List<ReservationInfo> reservations = new ArrayList<>();
	
	public ReservationService() {
		initData();
	}
	
	public List<Train> getPossibleTrainList(GetTrainListDto dto, LocalTime departureTime){
		
		List<Train> possibleTrains = new ArrayList<>();
		
		for(Train train : trains) {
			
			List<StopStation> stopStations = new ArrayList<>();
			
			int sameStationIndex = -1;
			
			for(int stopStationIndex = 0 ; stopStationIndex < stopStations.size() ; stopStationIndex++) {
				
				StopStation stopStation = stopStations.get(stopStationIndex);
				String stopStationName = stopStation.getStationName();
				
				if(!dto.isEqualDepartureStation(stopStationName)){
					continue;
				}
				//이게 뭘까
				if(stopStation.getDepartureTime().equals("")) continue;
				
				LocalTime stationDeparureTime = LocalTime.parse(stopStation.getDepartureTime(), timeFormatter);
				if(stationDeparureTime.isBefore(departureTime)) {
					break;
				}
				sameStationIndex = stopStationIndex;
				break;
			}
			
			if(sameStationIndex == -1) 
				continue;
			
			for(int stopStationIndex = 0; stopStationIndex < stopStations.size(); stopStationIndex++) {
				
				String stopStationName = stopStations.get(stopStationIndex).getStationName();
				
				if(!dto.isEqualArrivalStation(stopStationName)) {
					continue;
				}
				
				if(stopStationIndex <= sameStationIndex) {
					break;
				}
				
				possibleTrains.add(train);
			}
		}
		return possibleTrains;
		
	}
	
	public ReservationInfo postReservation(PostReservationDto postReservationDto,GetTrainListDto getTrainListDto) {
		
		Train train = null;
		
		for(Train trainItem : trains) {
			if(postReservationDto.isEqulaTrainNumber(trainItem.getTrainNumber())) {
				train = trainItem;
				break;
			}
		}
		
		if(train == null) {
			System.out.println("존재하지 않는 열차번호 입니다");
			return null;
		}
		
		boolean designationSeat = true;
		
		List<Seat> seats = train.getSeats();
		List<String> inputSeatNumbers = postReservationDto.getSeats();
		
		for(int index = 0 ; index < seats.size() ; index++) {
			Seat seat = seats.get(index);
			for(String seatNumber : inputSeatNumbers) {
				if(!seat.getSeatNumber().equals(seatNumber)) {
					continue;
				}
				
				if(seat.isSeatStatus()) {
					designationSeat = false;
					break;
				}
				seat.setSeatStatus(true);
					break;
			}
			
			if(!designationSeat)
				break;
		}
		if(!designationSeat) {
			System.out.println("좌석배정에 실패했습니다");
			return null;
		}
		
		int totalCost = 0;
		
		for(Cost cost : costs) {
			
			boolean isEqualDepartureStation =
					getTrainListDto.isEqualDepartureStation(cost.getDepartureStation());
			boolean isEqulaArrivalStaion=
					getTrainListDto.isEqualArrivalStation(cost.getArrivalStation());
			
			if(!isEqualDepartureStation || !isEqulaArrivalStaion) continue;
			
			totalCost= cost.getAmount() * getTrainListDto.getNumberOfPeople();
			break;
			}
		
		//for문 추가
		String departureTime = "";
		String arrivalTime = "";
		
		for(StopStation stopStation : train.getStopStations()) {
			boolean isEqualDepartureStation =
					getTrainListDto.isEqualDepartureStation(stopStation.getDepartureTime());
			boolean isEqualArrivalStation =
					getTrainListDto.isEqualArrivalStation(stopStation.getArrivalTime());
			
			if(isEqualDepartureStation) departureTime = stopStation.getDepartureTime();
			if(isEqualArrivalStation) arrivalTime = stopStation.getArrivalTime();
		}
		
		ReservationInfo reservationInfo = new ReservationInfo(
				postReservationDto.getTrainNumber(),
				postReservationDto.getSeats(),
				getTrainListDto.getDepartureStation(),
				departureTime,
				getTrainListDto.getArrivalStation(),
				arrivalTime,
				totalCost
				);
		
		reservations.add(reservationInfo);
		return reservationInfo;
	}
	
	public ReservationInfo getReservation(GetReservationDto dto) {
		
		ReservationInfo reservationInfo = null;
		String reservationNumber = dto.getReservationNumber();
		
		for(ReservationInfo item : reservations) {
			
			boolean isEqualReservationNumbet =
					reservationNumber.equals(item.getReservationNumber());
			
			if(!isEqualReservationNumbet) continue;
			
			reservationInfo = item;
			break;
		}
		return reservationInfo;
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
