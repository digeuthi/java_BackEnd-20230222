package trainReservation.dto;

import java.util.Scanner;

//DTO : data Transfer Object
//레이어 간 데이터를 전송할 때 사용하는 객체

public class GetTrainListDto {
	private String departureStation;
	private String arrivalStation;
	private String departureTime;
	private int numberOfPeople;
	
	//dto는 세터 게터 둘다 사용
	
	//기본생성자 메인어플리케이션에 입력하는 개념을 여기서 구현할수있다.
	public GetTrainListDto() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("출발역 : ");
		this.departureStation = scanner.nextLine();
		System.out.println("도착역 : ");
		this.arrivalStation = scanner.nextLine();
		System.out.println("출발시간 : ");
		this.departureTime = scanner.nextLine();
		System.out.println("인원 : ");
		this.numberOfPeople = scanner.nextInt();
	}

	public GetTrainListDto(String departureStation, String arrivalStation, String departureTime, int numberOfPeople) {
		super();
		this.departureStation = departureStation;
		this.arrivalStation = arrivalStation;
		this.departureTime = departureTime;
		this.numberOfPeople = numberOfPeople;
	}
	
	//get
	public String getDepartureStation() {
		return departureStation;
	}

	public String getArrivalStation() {
		return arrivalStation;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public int getNumberOfPeople() {
		return numberOfPeople;
	}

	//set
	public void setDepartureStation(String departureStation) {
		this.departureStation = departureStation;
	}

	public void setArrivalStation(String arrivalStation) {
		this.arrivalStation = arrivalStation;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	@Override
	public String toString() {
		return "GetTrainListDto [departureStation=" + departureStation + ", arrivalStation=" + arrivalStation
				+ ", departureTime=" + departureTime + ", numberOfPeople=" + numberOfPeople + "]";
	}
	
	public boolean isEmpty() {
		return this.departureStation.isBlank() || 
		this.arrivalStation.isBlank() ||
		this.departureTime.isBlank();
		
	}
	
	public boolean isEqualStation() {
		return this.departureStation.equals(arrivalStation);
	}
	
	public boolean isEqualsDepartureStation(String station) {
		return this.departureStation.equals(station);
	}
	
	public boolean isEqualsArrivalStation(String station) {
		return this.arrivalStation.equals(station);
	}
}
