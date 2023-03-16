package airplaneReservation.entity;

import java.util.List;

public class Airplane {
	
	private String airplaneNumber; //비행기번호
	private String departureCountry;
	private String departureTime; //출발시간
	private String arrivalCountry;
	private String arrivalTime; //도착시간
	private int takeHour; //걸리는 시간
	private String type; //항공 종류
	
	private List<StopCountry> stopCountrys;
	private List<Seat> seats;
	
	public Airplane() {}

	public Airplane(String airplaneNumber, String departureCountry, String departureTime, String arrivalCountry,
			String arrivalTime, int takeHour, String type, List<StopCountry> stopCountrys, List<Seat> seats) {
		super();
		this.airplaneNumber = airplaneNumber;
		this.departureCountry = departureCountry;
		this.departureTime = departureTime;
		this.arrivalCountry = arrivalCountry;
		this.arrivalTime = arrivalTime;
		this.takeHour = takeHour;
		this.type = type;
		this.stopCountrys = stopCountrys;
		this.seats = seats;
	}

	public String getAirplaneNumber() {
		return airplaneNumber;
	}

	public String getDepartureCountry() {
		return departureCountry;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public String getArrivalCountry() {
		return arrivalCountry;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public int getTakeHour() {
		return takeHour;
	}

	public String getType() {
		return type;
	}

	public List<StopCountry> getStopCountrys() {
		return stopCountrys;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	@Override
	public String toString() {
		return "Airplane [airplaneNumber=" + airplaneNumber + ", departureCountry=" + departureCountry
				+ ", departureTime=" + departureTime + ", arrivalCountry=" + arrivalCountry + ", arrivalTime="
				+ arrivalTime + ", takeHour=" + takeHour + ", type=" + type + ", stopCountrys=" + stopCountrys
				+ ", seats=" + seats + "]";
	}
	
	
}
