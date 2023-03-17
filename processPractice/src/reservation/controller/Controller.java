package reservation.controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import reservation.dto.GetTrainListDto;
import reservation.entity.ReservationInfo;
import reservation.entity.Train;
import reservation.service.Service;
import trainReservation.dto.PostReservationDto;
import trainReservation.service.ReservationService;

public class Controller<PostReservationDto>{
	
	private static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
	
	private Service reservationService;
	private PostReservationDto postReservationDto;
	
	public Controller() {
		this.reservationService = new Service();
	} 
	
	public void reservation() {
			while(true) {
				
				GetTrainListDto getTrainListDto = new GetTrainListDto();
				
				LocalTime departureTime = null;
				
				if(getTrainListDto.isEmpty()) {
					System.out.println("모두 입력하세요.");
					continue;
				}
				
				try {
					departureTime = LocalTime.parse(getTrainListDto.getDepartureTime(), timeFormatter);
				}catch (Exception exception){
					System.out.println("잘못된 시간입니다.");
					continue;
				}
				
				if(getTrainListDto.getNumberOfPeople()<=0) {
					System.out.println("잘못된 인원입니다.");
					continue;
				}
				
				if(getTrainListDto.getDepartureStation().equals(getTrainListDto.getArrivalStation())) {
					System.out.println("출발역과 도착역이 같습니다.");
					continue;
				}
				
				List<Train> possibleTrains = reservationService.getPossibleTrainList(getTrainListDto, departureTime);
				
				System.out.println(getTrainListDto.toString());
				
				while(true) {
					postReservationDto = new PostReservationDto(getTrainListDto.getNumberOfPeople());
					ReservationInfo = reservationService.postReservation(postReservationDto, getTrainListDto);
					if(reservationInfo == null) continue;
					break;
				}
				
				ReservationInfo reservationInfo = null;
	}
	}
}
