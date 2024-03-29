package reservation.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import reservation.entity.Seat;

//2단계 과정
public class PostReservationDto {

	private String trainNumber;
	private List<String> seats;
	
	public PostReservationDto(int numberOfPeople) {
	
	Scanner scanner = new Scanner(System.in);
	this.seats = new ArrayList<>(); //입력받을 열차 리스트 생성
	
	//빈값이 아닌지 확인
	while(true) {
		System.out.println("탑승할 열차 번호 : ");
		this.trainNumber = scanner.nextLine();
		
		if(this.trainNumber.isBlank()) {
			System.out.println("열차번호를 입력하세요");
			continue;
		}
		break;
		}
	
	//좌석값 입력확인
	while(this.seats.size() < numberOfPeople ) {
		System.out.println("좌석 번호 : ");
		String seat = scanner.nextLine();
		
		if(seat.isBlank()) {
			System.out.println("좌석 번호를 입력하세요");
			continue;
		}
		this.seats.add(seat); //입력받은 값을 리스트에 저장
	}
	
	
	
	}

	public PostReservationDto(String trainNumber, List<String> seats) {
		super();
		this.trainNumber = trainNumber;
		this.seats = seats;
	}

	public String getTrainNumber() {
		return trainNumber;
	}

	public List<String> getSeats() {
		return seats;
	}

	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
	}

	public void setSeats(List<String> seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "PostReservationDto [trainNumber=" + trainNumber + ", seats=" + seats + "]";
	}
	
	public boolean isEqualTrainNumber(String trainNumber) {
		return this.trainNumber.equals(trainNumber);
	}
}
