package trainReservation.controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import trainReservation.dto.GetTrainListDto;
import trainReservation.dto.PostReservationDto;
import trainReservation.entity.ReservationInfo;
import trainReservation.entity.Train;
import trainReservation.service.ReservationService;

public class ReservationController {

	private static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
	
	private ReservationService reservationService;
	private GetTrainListDto getTrainListDto;
	private PostReservationDto postReservationDto;
	
	public ReservationController() {
		this.reservationService = new ReservationService();
	}
	
	public void reservation() {
		
		LocalTime departureTime = null;
		
		while(true) {
			getTrainListDto = new GetTrainListDto();
			
			if(getTrainListDto.isEmpty()) {
				System.out.println("모두 입력하세요.");
				continue;
			}
			
			try {
				departureTime = LocalTime.parse(getTrainListDto.getDepartureTime(), timeFormatter);
				
			}catch(Exception exception) {
				System.out.println("잘못된 시간입니다");
				continue;
			}
			
			if(getTrainListDto.getNumberOfPeople() <= 0) {
				System.out.println("잘못된 인원입니다");
				continue;
			}
			
			if(getTrainListDto.isEqualStation()) {
				System.out.println("출발역과 도착역이 같습니다");
				continue;
			}
			
			List<Train> possibleTrains = reservationService.getPossibleTrainList(getTrainListDto, departureTime);
			
			System.out.println(possibleTrains.toString());
			
			break;
		}
	}
	
	public void postReservation() {
		
		while(true) {
			
			postReservationDto = new PostReservationDto(getTrainListDto.getNumberOfPeople());
			
			ReservationInfo reservationInfo = reservationService.postReservation(postReservationDto, getTrainListDto);
			if(reservationInfo == null) continue;
			
			System.out.println(reservationInfo.toString());
			
			break;
		}
	}
	
	public void getReservation() {
		
	}
}
