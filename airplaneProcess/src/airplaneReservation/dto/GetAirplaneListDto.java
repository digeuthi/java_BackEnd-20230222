package airplaneReservation.dto;

import java.util.Scanner;

public class GetAirplaneListDto {

	private String departureCountry;
	private String arrivalCountry;
	private String departureTime;
	private int numberOfPeople;
	
	public GetAirplaneListDto() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("출발 국가 : ");
		this.departureCountry = scanner.nextLine();
		System.out.println("도착 국가 : ");
		this.arrivalCountry = scanner.nextLine();
		System.out.println("출발 시간 : ");
		this.departureTime = scanner.nextLine();
		System.out.println("인원 : ");
		this.numberOfPeople = scanner.nextInt();
	}

	public GetAirplaneListDto(String departureCountry, String arrivalCountry, String departureTime,
			int numberOfPeople) {
		super();
		this.departureCountry = departureCountry;
		this.arrivalCountry = arrivalCountry;
		this.departureTime = departureTime;
		this.numberOfPeople = numberOfPeople;
	}

	public String getDepartureCountry() {
		return departureCountry;
	}

	public String getArrivalCountry() {
		return arrivalCountry;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public int getNumberOfPeople() {
		return numberOfPeople;
	}

	public void setDepartureCountry(String departureCountry) {
		this.departureCountry = departureCountry;
	}

	public void setArrivalCountry(String arrivalCountry) {
		this.arrivalCountry = arrivalCountry;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	@Override
	public String toString() {
		return "GetAirplaneListDto [departureCountry=" + departureCountry + ", arrivalCountry=" + arrivalCountry
				+ ", departureTime=" + departureTime + ", numberOfPeople=" + numberOfPeople + "]";
	}
	
	public boolean isEmpty() {
		return this.departureCountry.isBlank() ||
				this.arrivalCountry.isBlank() ||
				this.departureTime.isBlank();
	}
	
	public boolean isEqualsCountry() {
		return this.departureCountry.equals(arrivalCountry);
	}
	
	public boolean isEqualDepartureCountry(String country) {
		return this.departureCountry.equals(country);
	}
	
	public boolean isEqualArrivalCountry(String country) {
		return this.arrivalCountry.equals(country);
	}
}
