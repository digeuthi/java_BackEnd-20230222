package trainReservation.controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import trainReservation.dto.GetReservationDto;
import trainReservation.dto.GetTrainListDto;
import trainReservation.dto.PostReservationDto;
import trainReservation.entity.ReservationInfo;
import trainReservation.entity.Train;
import trainReservation.service.ReservationService;

//Controller class (계층)
// 사용자로부터 입력받는 기능 수행 / 입력받은 데이터를 검증 기능 담당 / 비즈니스 로직의 결과를 반환

public class ReservationController {
	
	private static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
	
	private ReservationService reservationService;
	
	private GetTrainListDto getTrainListDto;
	private GetReservationDto getReservationDto;
	private PostReservationDto postReservationDto; //어떤 함수에서도 사용할수 있도록 정의
	
	public ReservationController() {
		this.reservationService = new ReservationService();
	} 
	
	public void reservation() {
		//while 문 전체 복사해서 붙여오기
		while(true) {

			getTrainListDto = new GetTrainListDto(); //continue받으면 이 작업 다시 수행
			//변수명에 GetTrainListDto 적으면 원래는 안된다!
			
			LocalTime departureTime = null;
			
			if(getTrainListDto.isEmpty()) { 
				
				System.out.println("모두 입력하세요.");
				continue; 
			}
			
			try {
				departureTime = LocalTime.parse(getTrainListDto.getDepartureTime(), timeFormatter);
			} catch(Exception exception) {
				System.out.println("잘못된 시간입니다.");
				continue;
			}
			
			if(getTrainListDto.getNumberOfPeople() <= 0) {
				System.out.println("잘못된 인원입니다.");
				continue;
			}
						
			if(getTrainListDto.isEqualStation()) {
				System.out.println("출발역과 도착역이 같습니다.");
				continue;
			}
			
			List<Train> possibleTrains = reservationService.getPossibleTrainList(getTrainListDto, departureTime);
			
			System.out.println(possibleTrains.toString());
			
			//요기
			
			postReservation(); //호출, 기능단위로 분리해서 메서드 만들어놓는 과정
			break;
			
//			PostReservationDto postReservationDto = new PostReservationDto(GetTrainListDto.getNumberOfPeople());
			//사용자로부터 입력을 받아야한다.
			
		}
		
	}
	
	public void postReservation() {
		//밑에 코드를 없앨꺼다... //요기 부분에서 이동함
//		ReservationInfo reservationInfo = null;
		
		while(true) {
			
			postReservationDto = new PostReservationDto(getTrainListDto.getNumberOfPeople());
			
			ReservationInfo reservationInfo = reservationService.postReservation(postReservationDto, getTrainListDto);
			if(reservationInfo == null) continue;
			
			System.out.println(reservationInfo.toString());
			
			break;
					
		}
		
	}
	
	//3단계 과정 예약번호
	public void getReservation() {
		
		//입력받기
		//레이어와 레이어 사이에 받아올때 dto써서 받아옴 
		//데이터 예약번호 하나만 받아오려고 클래스를 받아오는건 유용한가? 클래스마다 구별해놓는게 구별하기 편하다.. ㅇㅇ.. 
		//예약번호를 잘못입력하거나 하는 상황이 발생하므로 getReservationDto를 생성!
		
		while(true) {
			
			getReservationDto = new GetReservationDto();
			//dto입력받아옴 맨 위에서
			
			//예약번호 빈값인지 확인
			String reservationNumber = getReservationDto.getReservationNumber();
			
			if(reservationNumber.isBlank()) {
				System.out.println("예약 번호를 입력하세요.");
				continue;
			}
			
			ReservationInfo reservationInfo = reservationService.getReservation(getReservationDto);
			//getReservation를 service에 생성
			
			
//			//외부에서 데이터를 받아올때 (인스턴스 생성해서) 그때 받아올때도 검증을 해줘야한다.
//			//결과가 늘 인스턴스가 생성되서 온다는 경우가 보장안된다 null로 올수도 있다.
//			//이때 예외가 터져버린다 null이 들어오는 경우를 생각해줘야한다
//			/*이거*/if(reservationInfo == null) {
//				System.out.println("해당 예약번호의 예약정보가 없습니다"); //여기서 끝내면 그대로 밑의 코드까지 돌게된다.
//				break; //break를 걸어줘야 밑의 코드까지 진행되지 않고 끝나게 된다
//			}
			
			//이거 두개가 사실상 같게 된다. 삼항 연산자 써서 지정해보기
			String message = 
					reservationInfo == null ? "해당하는 예약번호가 없습니다." /*에러메시지 반환*/: reservationInfo.toString()/*결과반환*/;
			
			/*이거*/System.out.println(/*reservationInfo.toString()*/message);
			break;
		}
		 
	}
	
}