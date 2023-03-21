package trainReservation.entity;

import java.util.List;

public class Train {

	private String trainNumber;
	private String departureStation;
	private String departureTime;
	private String arrivalStation;
	private String arrivalTime;
	private int takeMinute;
	private String type;
	
	private List<StopStation> stopStations;
	private List<Seat> seats;
	
	public Train() {}

	public Train(String trainNumber, String departureStation, String departureTime, String arrivalStation,
			String arrivalTime, int takeMinute, String type, List<StopStation> stopStations, List<Seat> seats) {
		super();
		this.trainNumber = trainNumber;
		this.departureStation = departureStation;
		this.departureTime = departureTime;
		this.arrivalStation = arrivalStation;
		this.arrivalTime = arrivalTime;
		this.takeMinute = takeMinute;
		this.type = type;
		this.stopStations = stopStations;
		this.seats = seats;
	}

	public String getTrainNumber() {
		return trainNumber;
	}

	public String getDepartureStation() {
		return departureStation;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public String getArrivalStation() {
		return arrivalStation;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public int getTakeMinute() {
		return takeMinute;
	}

	public String getType() {
		return type;
	}

	public List<StopStation> getStopStations() {
		return stopStations;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
	}

	public void setDepartureStation(String departureStation) {
		this.departureStation = departureStation;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public void setArrivalStation(String arrivalStation) {
		this.arrivalStation = arrivalStation;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public void setTakeMinute(int takeMinute) {
		this.takeMinute = takeMinute;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setStopStations(List<StopStation> stopStations) {
		this.stopStations = stopStations;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "Train [trainNumber=" + trainNumber + ", departureStation=" + departureStation + ", departureTime="
				+ departureTime + ", arrivalStation=" + arrivalStation + ", arrivalTime=" + arrivalTime
				+ ", takeMinute=" + takeMinute + ", type=" + type + ", stopStations=" + stopStations + ", seats="
				+ seats + "]";
	}
	
	
	
}
