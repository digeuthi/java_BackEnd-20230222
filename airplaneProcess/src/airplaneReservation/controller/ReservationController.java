package airplaneReservation.controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import airplaneReservation.dto.GetAirplaneListDto;
import airplaneReservation.dto.GetReservationDto;
import airplaneReservation.dto.PostReservationDto;
import airplaneReservation.entity.Airplane;
import airplaneReservation.entity.ReservationInfo;
import airplaneReservation.service.ReservationService;

public class ReservationController {

	private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
	
	private ReservationService reservationService;
	
	private GetReservationDto getReservationDto;
	private GetAirplaneListDto getAirplaneListDto;
	private PostReservationDto postReservationDto;
	
	public ReservationController() {
		this.reservationService = new ReservationService();
	} 
	
	public void reservation() {
		while(true) {
					
					getAirplaneListDto = new GetAirplaneListDto();
					
					LocalTime departureTime = null;
					
					if(/*dto.getDepartureCountry().isBlank() || dto.getArrivalCountry().isBlank()||
							dto.getDepartureTime().isBlank()*/
							getAirplaneListDto.isEmpty()) {
						System.out.println("모두 입력하세요.");
						continue;
					}
					
					try {
						departureTime.parse(getAirplaneListDto.getDepartureTime(), dateTimeFormatter);
					}catch(Exception exception) {
						System.out.println("잘못된 시간입니다");
						continue;
					}
					
					if(getAirplaneListDto.getNumberOfPeople() <= 0) {
						System.out.println("잘못된 인원입니다.");
						continue;
					}
					
					if(/*dto.getDepartureCountry().equals(dto.getArrivalCountry())*/
							getAirplaneListDto.isEqualsCountry()) {
						System.out.println("출발국가와 도착국가가 동일합니다.");
					}
				
					List<Airplane> possibleAirplanes = reservationService.getPossibleAirplaneList(getAirplaneListDto, departureTime);
					
					System.out.println(possibleAirplanes.toString());
					
					
					
				}
		
	}
	
	public void getReservation() {
		
		//3단계 예약 번호가 빈값이 아닌지 ?
		while(true) {
		//입력받은 예약번호 가져오기
			getReservationDto = new GetReservationDto();
			
			String reservationNumber = getReservationDto.getReservationNumber();
			
			if(reservationNumber.isBlank()) {
				System.out.println("예약 번호를 입력하세요");
				continue;
			}
			
			//이 다음 과정은 service에서 진행
			
			//외부에서 데이터를 받아올때 (인스턴스 생성해서) 그때 받아올때도 검증을 해줘야한다.
//			//결과가 늘 인스턴스가 생성되서 온다는 경우가 보장안된다 null로 올수도 있다.
//			//이때 예외가 터져버린다 null이 들어오는 경우를 생각해줘야한다
			
			ReservationInfo reservationInfo = reservationService.getReservation(getReservationDto);
			
			if(reservationInfo == null) {
				System.out.println("해당 예약번호의 예약정보가 없습니다");
				break;
			}
			
			System.out.println(reservationInfo.toString());
			break;
			
		}
	}
}
