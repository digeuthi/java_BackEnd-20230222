package trainReservation.entity;

public class StopStation {

	private String departureTime;
	private String arrivalTime;
	private String stationName;
	
	public StopStation () {}

	public StopStation(String dapartureTime, String arrivalTime, String stationName) {
		super();
		this.departureTime = dapartureTime;
		this.arrivalTime = arrivalTime;
		this.stationName = stationName;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public String getStationName() {
		return stationName;
	}

	public void setDapartureTime(String dapartureTime) {
		this.departureTime = dapartureTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	@Override
	public String toString() {
		return "StopStation [dapartureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", stationName="
				+ stationName + "]";
	}
	
	
}
