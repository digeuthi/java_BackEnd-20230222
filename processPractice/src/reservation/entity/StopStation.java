package reservation.entity;

public class StopStation {

	//역 이름, 도착시간, 출발시간
	private String stationName;
	private String arrivalTime;
	private String departureTime;

	public StopStation() {}

	public StopStation(String stationName, String arrivalTime, String departurtTime) {
		super();
		this.stationName = stationName;
		this.arrivalTime = arrivalTime;
		this.departureTime = departurtTime;
	}

	public String getStationName() {
		return stationName;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	@Override
	public String toString() {
		return "StopStation [stationName=" + stationName + ", arrivalTime=" + arrivalTime + ", departurtTime="
				+ departureTime + "]";
	}
	
	
}