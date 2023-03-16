package airplaneReservation.service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import airplaneReservation.dto.GetAirplaneListDto;
import airplaneReservation.entity.Airplane;
import airplaneReservation.entity.Cost;
import airplaneReservation.entity.Seat;
import airplaneReservation.entity.StopCountry;

public class ReservationService {

	private static List<Airplane> airplanes = new ArrayList<Airplane>();
	private static List<Cost> costs = new ArrayList<Cost>();
	
	private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
	
	public void ReservationService() {
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
			
			String stopCountryName = stopCountrys.get(stopCountryIndex).getCountryName();
			
			if(!airplane.getDepartureCountry().equals(stopCountryName)) {
				continue;
			}
			
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
		
		boolean isPossibleSeats = false;
		
		for(int stopCountryIndex = 0 ; stopCountryIndex < stopCountrys.size() ; stopCountryIndex++) {
			
			String countryName = stopCountrys.get(stopCountryIndex).getCountryName();
			
			if(!airplane.getArrivalCountry().equals(countryName)){
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
		
		possibleAirplanes.add(airplane);
	}
	return possibleAirplanes;
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
