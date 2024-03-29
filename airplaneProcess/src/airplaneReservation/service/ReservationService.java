package airplaneReservation.service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import airplaneReservation.dto.GetAirplaneListDto;
import airplaneReservation.dto.GetReservationDto;
import airplaneReservation.dto.PostReservationDto;
import airplaneReservation.entity.Airplane;
import airplaneReservation.entity.Cost;
import airplaneReservation.entity.ReservationInfo;
import airplaneReservation.entity.Seat;
import airplaneReservation.entity.StopCountry;


public class ReservationService {

	private static List<Airplane> airplanes = new ArrayList<>();
	private static List<Cost> costs = new ArrayList<>();
	private static List<ReservationInfo> reservations = new ArrayList<>();
	
	private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
	
	public ReservationService() {
		initData();
	}
	
	public List<Airplane> getPossibleAirplaneList(GetAirplaneListDto dto, LocalTime departureTime){
	
		//가능한 기체정보를 저장할 리스트
		List<Airplane> possibleAirplanes = new ArrayList<>();
	
		//해당 인덱스 정착국가 인덱스
		for(Airplane airplane : airplanes) {
			List<StopCountry> stopCountrys = airplane.getStopCountrys();
			
			//동일한 출발국가 인덱스 번호 변수 만들어주기
			int sameCountryIndex = -1;
			
			for(int stopCountryIndex = 0 ; stopCountryIndex < stopCountrys.size() ; stopCountryIndex++) {
				
				StopCountry stopCountry = stopCountrys.get(stopCountryIndex);
				String stopCountryName = stopCountry.getCountryName();
				
				if(!dto.getDepartureCountry().equals(stopCountryName)) {
					continue;
				}
				if(stopCountry.getDepartureTime().equals("")) continue;
				LocalTime countryDepartureTime = LocalTime.parse(dto.getDepartureTime(), dateTimeFormatter);
				
				if(countryDepartureTime.isBefore(departureTime)) {
					break;
				}
				
				sameCountryIndex = stopCountryIndex;
				break;
			}
			
			if(sameCountryIndex == -1) {
				continue;
			}
			//좌석요소
			boolean isPossibleSeats = false;
			//도착국가 요소와 같은지 반복문
			for(int stopCountryIndex = 0 ; stopCountryIndex < stopCountrys.size() ; stopCountryIndex++) {
				
				String countryName = stopCountrys.get(stopCountryIndex).getCountryName();
				
				if(!dto.getArrivalCountry().equals(countryName)){
					continue;
				}
				
				if(stopCountryIndex <= sameCountryIndex) {
					break;
				}
				
				isPossibleSeats = true;
				break;
			}
			if(!isPossibleSeats) {
				continue;
			}
			
			List<Seat> seats = airplane.getSeats();
			
			int possibleSeatCount = 0;
			
			for(Seat seat : seats) {
				if(!seat.isSeatStatus()) continue;
			}
			
			if(possibleSeatCount < dto.getNumberOfPeople()) {
				continue;
			}
			//가능한 비행기 리스트에 해당 비행기 객체 추가
			possibleAirplanes.add(airplane);
		}
		return possibleAirplanes;
}
	
	//'예약정보 객체'로 반환을 해줘야하는 2번째 다이어그램 데이터 검색관련 반복문들! reservationInfo를 반환타입으로 지정한다.
	public ReservationInfo postReservation(PostReservationDto postReservationDto, GetAirplaneListDto getAirplaneListDto) {
		
		//존재하는 비행기 변수 설정
		Airplane airplane = null;
		//데이터검색 첫번째 for문
		for(Airplane airplaneItem : airplanes) {
			if(postReservationDto.isEqualAriplaneNumber(airplaneItem.getAirplaneNumber())) {
				airplane = airplaneItem; //존재하는 비행기 변수에 해당 요소 저장
				break;
			}
		}
		
		if(airplane == null) {
			System.out.println("존재하지 않는 비행기 번호 입니다");
			return null;
		}
		
		//좌석 지정 상태
		boolean designationState = false;
		
		List<Seat> seats = airplane.getSeats();
		List<String> inputSeatNumbers = postReservationDto.getSeats();
		//두번째 for문
		for(int index = 0 ; index < seats.size() ; index++) {
			//해당 인덱스의 좌석 정보 가져오기
			Seat seat = seats.get(index);
			
			for(String seatNumber : inputSeatNumbers) {
				
				if(!seat.getSeatNumber().equals(seatNumber)) {
					continue;
				}
				
				if(seat.isSeatStatus()) {
					designationState = false;
					break;
				}
				
				//seat entity에 set추가함
				seat.setSeatStatus(true);
				
			}
			if(!designationState) break;
		}
		if(!designationState) {
			System.out.println("좌석 배정에 실패했습니다");
			return null;
		}
		
		//가격 지정할 변수
		int totalCost = 0;
		
		//세번째 for문
		for(Cost cost : costs) {
			//해당 요소의 출발역과 도착역이 지정한 출발역과 도착역과 같은지?를 비교하기 위해 GetAirplaneListDto에 메서드 추가
			boolean isEqualDepartureCountry=
					getAirplaneListDto.isEqualDepartureCountry(cost.getDepartureCountry());
			boolean isEqualArrivalCountry =
					getAirplaneListDto.isEqualArrivalCountry(cost.getArrivalCountry());
			
			if(!isEqualDepartureCountry || !isEqualArrivalCountry) continue;
			
			totalCost = cost.getAmount() * getAirplaneListDto.getNumberOfPeople();
			break;
		}
		
		//for문 프로세스 추가 (출발 도착 시간 관련)
		String departureTime = "";
		String arrivalTime = "";
		
		for(StopCountry stopsCountry : airplane.getStopCountrys()) {
			
			boolean isEqualDepartureCountry =
					getAirplaneListDto.isEqualDepartureCountry(stopsCountry.getCountryName());
			boolean isEqualArrivalCountry=
					getAirplaneListDto.isEqualArrivalCountry(stopsCountry.getCountryName());
			
			if(isEqualDepartureCountry) departureTime = stopsCountry.getDepartureTime();
			if(isEqualArrivalCountry) arrivalTime = stopsCountry.getArrivalTime();
		}
		
		ReservationInfo reservationInfo = new ReservationInfo(
				postReservationDto.getAirplaneNumber(),
				postReservationDto.getSeats(),
				getAirplaneListDto.getDepartureCountry(),
				departureTime,
				getAirplaneListDto.getArrivalCountry(),
				arrivalTime,
				totalCost
				);
		reservations.add(reservationInfo);
		return reservationInfo;
	}
	
	//예약번호 reservationNumber, reservationInfo entity에 생성
	//controller에서 진행 후 돌아옴
	//3번째 다이어그램 진행 		
	public ReservationInfo getReservation(GetReservationDto getReservationDto) {
		
		//예약번호를 저장할 변수
		ReservationInfo reservationInfo = null;
		String reservationNumber = getReservationDto.getReservationNumber();
		
		//예약번호 가져오는 반복문
		for(ReservationInfo item : reservations) {
			
			boolean isEqualReservationNumber =
					reservationNumber.equals(item.getReservationNumber());
			
			if(!isEqualReservationNumber) continue;
			
			//같은 경우 
			reservationInfo = item;
			break;
		}
		
		return reservationInfo;
	}

		
		//메서드
		public static void initData() {
		
		//대한민국 -> 홍콩 -> 영국 -> 미국 간다고하자.
		costs.add(new Cost("대한민국","미국",1_500_000));
		costs.add(new Cost("대한민국","영국",1_000_000));
		costs.add(new Cost("대한민국","홍콩",500_000));
		costs.add(new Cost("홍콩","미국",1_000_000));
		costs.add(new Cost("홍콩","영국",500_000));
		costs.add(new Cost("영국","미국",500_000));
		
		costs.add(new Cost("미국","대한민국",1_500_000));
		costs.add(new Cost("영국","대한민국",1_000_000));
		costs.add(new Cost("홍콩","대한민국",500_000));
		costs.add(new Cost("미국","홍콩",1_000_000));
		costs.add(new Cost("영국","홍콩",500_000));
		costs.add(new Cost("미국","영국",500_000));
		
		Airplane airplane;
		List<Seat> seats = new ArrayList<Seat>();
		List<StopCountry> stopCountrys = new ArrayList<StopCountry>();
		
		seats.add(new Seat("A1",false));
		seats.add(new Seat("B1",false));
		seats.add(new Seat("C1",false));
		seats.add(new Seat("A2",false));
		seats.add(new Seat("B2",false));
		seats.add(new Seat("C2",false));
		seats.add(new Seat("A3",false));
		seats.add(new Seat("B3",false));
		seats.add(new Seat("C3",false));
		
		//출국
		stopCountrys.add(new StopCountry("대한민국","","06:00"));
		stopCountrys.add(new StopCountry("홍콩","07:00","10:00"));
		stopCountrys.add(new StopCountry("영국","11:00","16:00"));
		stopCountrys.add(new StopCountry("미국","17:00",""));
		
		airplane = new Airplane("B767","대한민국","06:00","미국","17:00",11,"대한항공",stopCountrys, seats);
		airplanes.add(airplane);
		
		seats = new ArrayList<Seat>();
		stopCountrys = new ArrayList<StopCountry>();
		
		seats.add(new Seat("A1",false));
		seats.add(new Seat("B1",false));
		seats.add(new Seat("C1",false));
		seats.add(new Seat("A2",false));
		seats.add(new Seat("B2",false));
		seats.add(new Seat("C2",false));
		seats.add(new Seat("A3",false));
		seats.add(new Seat("B3",false));
		seats.add(new Seat("C3",false));
		
		//입국
		stopCountrys.add(new StopCountry("미국","","06:00"));
		stopCountrys.add(new StopCountry("영국","07:00","10:00"));
		stopCountrys.add(new StopCountry("홍콩","11:00","16:00"));
		stopCountrys.add(new StopCountry("대한민국","17:00",""));
		
		airplane = new Airplane("B707","미국","06:00","대한민국","17:00",11,"아시아나",stopCountrys,seats);
		airplanes.add(airplane);
		}
}
