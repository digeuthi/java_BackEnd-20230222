package airplaneReservation.entity;

public class StopCountry {

	private String countryName;
	private String departureTime;
	private String arrivalTime;
	
	public StopCountry() {}

	public StopCountry(String countryName, String arrivalTime, String departureTime) {
		super();
		this.countryName = countryName;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}

	public String getCountryName() {
		return countryName;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	@Override
	public String toString() {
		return "StopCountry [countryName=" + countryName + ", departureTime=" + departureTime + ", arrivalTime="
				+ arrivalTime + "]";
	}
	
	
}
