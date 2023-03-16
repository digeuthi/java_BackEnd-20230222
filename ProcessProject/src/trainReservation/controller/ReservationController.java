package trainReservation.controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import trainReservation.dto.GetTrainListDto;
import trainReservation.dto.PostReservationDto;
import trainReservation.entity.Train;
import trainReservation.service.ReservationService;

//Controller class (계층)
// 사용자로부터 입력받는 기능 수행 / 입력받은 데이터를 검증 기능 담당 / 비즈니스 로직의 결과를 반환

public class ReservationController {
	
	private static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
	
	private ReservationService reservationService;
	
	public ReservationController() {
		this.reservationService = new ReservationService();
	} 
	
	public void reservation() {
		//while 문 전체 복사해서 붙여오기
		while(true) {

			GetTrainListDto GetTrainListDto = new GetTrainListDto(); //continue받으면 이 작업 다시 수행
			//변수명에 GetTrainListDto 적으면 원래는 안된다!
			
			LocalTime departureTime = null;
			
			if(GetTrainListDto.isEmpty()) { 
				
				System.out.println("모두 입력하세요.");
				continue; 
			}
			
			try {
				departureTime = LocalTime.parse(GetTrainListDto.getDepartureTime(), timeFormatter);
			} catch(Exception exception) {
				System.out.println("잘못된 시간입니다.");
				continue;
			}
			
			if(GetTrainListDto.getNumberOfPeople() <= 0) {
				System.out.println("잘못된 인원입니다.");
				continue;
			}
						
			if(GetTrainListDto.isEqualStation()) {
				System.out.println("출발역과 도착역이 같습니다.");
				continue;
			}
			
			List<Train> possibleTrains = reservationService.getPossibleTrainList(GetTrainListDto, departureTime);
			
			System.out.println(possibleTrains.toString());
			
			
			
			PostReservationDto postReservationDto = new PostReservationDto(GetTrainListDto.getNumberOfPeople());
			//사용자로부터 입력을 받아야한다.
			
		}
	}
}

