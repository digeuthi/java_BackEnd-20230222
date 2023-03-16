package airplaneReservation.controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import airplaneReservation.dto.GetAirplaneListDto;
import airplaneReservation.service.ReservationService;

public class ReservationController {

	private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
	
	private ReservationService reservationService;
	
	public ReservationController() {
		this.reservationService = new ReservationService();
	} 
	
	public void reservation() {
		while(true) {
					
					GetAirplaneListDto dto = new GetAirplaneListDto();
					
					LocalTime departureTime = null;
					
					if(/*dto.getDepartureCountry().isBlank() || dto.getArrivalCountry().isBlank()||
							dto.getDepartureTime().isBlank()*/
							dto.isEmpty()) {
						System.out.println("모두 입력하세요.");
						continue;
					}
					
					try {
						departureTime.parse(dto.getDepartureTime(), dateTimeFormatter);
					}catch(Exception exception) {
						System.out.println("잘못된 시간입니다");
						continue;
					}
					
					if(dto.getNumberOfPeople() <= 0) {
						System.out.println("잘못된 인원입니다.");
						continue;
					}
					
					if(/*dto.getDepartureCountry().equals(dto.getArrivalCountry())*/
							dto.isEqualsCountry()) {
						System.out.println("출발국가와 도착국가가 동일합니다.");
					}
				
					System.out.println(dto.toString());
				}
	}
	
}
