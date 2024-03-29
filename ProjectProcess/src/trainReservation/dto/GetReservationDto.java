package trainReservation.dto;

import java.util.Scanner;

public class GetReservationDto {

	
	private String reservationNumber;
	
	public GetReservationDto() {
		
		Scanner scanner = new Scanner(System.in);
		
		//빈생성자에 controller 받아오기
		System.out.println("예약 번호 : ");
		this.reservationNumber = scanner.nextLine();
	}

	public GetReservationDto(String reservationNumber) {
//		super();
		this.reservationNumber = reservationNumber;
	} //인스턴스변수 초기화

	public String getReservationNumber() {
		return reservationNumber;
	}

	public void setReservationNumber(String reservationNumber) {
		this.reservationNumber = reservationNumber;
	} //인스턴스 변수 초기화 -> 생성자도 초기화 하는데 setter필요한가?
		//필요하겠지.. 다른거랑 통일성의 문제도 있고 생성자는 인스턴스 생성 만들때 필요한거고 
		//setter는 생성이 되고 나서 쓸수 있다

	@Override
	public String toString() {
		return "GetReservationDto [reservationNumber=" + reservationNumber + "]";
	}
	
	
}
