package trainReservation.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PostReservationDto {

	//레이어와 레이어 사이를 이동시킬때 dto 사용
	//열차번호, 입력받을 저장리스트 이 dto에 저장
	//절차적인걸 객체지향적으로 바꿔주다보면 흐름을 잘 판단해서 확인...
	
	//2단계 과정
	private String trainNumber;
	private List<String> seats;
	
	public PostReservationDto(int numberOfPeople) { //열차번호 입력
		Scanner scanner = new Scanner(System.in);
		
		this.seats = new ArrayList<>();
		
		while(true) {
			System.out.println("탑승할 열차 번호 : ");
			this.trainNumber = scanner.nextLine();
			
			if(this.trainNumber.isBlank()) {
				System.out.println("열차 번호를 입력하세요");
				continue;
			} 
			break;
		}
		
		//좌석을 입력을 받으려면 몇 번 받을지에 대한 값이 필요하다 
		//생성자로부터 매개변수로 받아오기
		while(this.seats.size() < numberOfPeople) {
			System.out.println("좌석 번호 : ");
			String seat = scanner.nextLine();
			if(seat.isBlank()) {
				System.out.println("좌석번호를 입력하세요");
				continue;
			}
			this.seats.add(seat); //아마도 에러가 날것. -> this.seats = new ArrayList<>(); 추가함 
		} //2번 다이어그램 첫번째 반복문 완성 -> 이후는 비즈니스 로직에 해당 Service 에 작업해야한다
		
	}

	public PostReservationDto(String trainNumber, List<String> seats) {
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
	
	
	
	
}
