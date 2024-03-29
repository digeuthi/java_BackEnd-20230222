package airplaneReservation.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import airplaneReservation.entity.Seat;

public class PostReservationDto {

	private String airplaneNumber;
	private List<String> seats;
	
	public PostReservationDto(int numberOfPeople) { //열차번호 입력
		Scanner scanner = new Scanner(System.in);
		
		//입력받을 좌석 리스트 생성
		this.seats = new ArrayList<>();
		
		//2번 다이어그램 시작
		while(true) {
			System.out.println("탑승할 비행기 번호 : ");
			this.airplaneNumber = scanner.nextLine();
			
			//빈값이 아닌지?
			if(this.airplaneNumber.isBlank()) {
				System.out.println("비행기 번호를 입력하세요");
				continue;
			}
			break;
		}
		
		//2번 다이어그램 첫번째 반복문
		//입력에 대한 반복문이므로 Dto에서 진행
		while(this.seats.size() < numberOfPeople) {
			System.out.println("좌석 번호 : ");
			String seat = scanner.nextLine();
			if(seat.isBlank()) {
				System.out.println("좌석번호를 입력하세요");
				continue;
			}
			this.seats.add(seat);
		}
	}

	public PostReservationDto(String airplaneNumber, List<String> seats) {
		super();
		this.airplaneNumber = airplaneNumber;
		this.seats = seats;
	}

	public String getAirplaneNumber() {
		return airplaneNumber;
	}

	public List<String> getSeats() {
		return seats;
	}

	public void setAirplaneNumber(String airplaneNumber) {
		this.airplaneNumber = airplaneNumber;
	}

	public void setSeats(List<String> seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "PostReservationDto [airplaneNumber=" + airplaneNumber + ", seats=" + seats + "]";
	}
	
	public boolean isEqualAriplaneNumber(String airplaneNumber) {
		return this.airplaneNumber.equals(airplaneNumber);
	}
}
