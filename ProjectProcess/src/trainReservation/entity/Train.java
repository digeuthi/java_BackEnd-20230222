package trainReservation.entity;

import java.util.List;
//기차 정보 Entity class
public class Train {

	private String trainNumber; //열차번호
	private String departureStation;
	private String departureTime; //출발시간
	private String arrivalStation;
	private String arrivalTime; //도착시간
	private int takeMinute; //걸리는 시간
	private String type; //열차 종류
	
	//하나의 클래스에 다른 클래스가 엮여있는것 : 관계가 있다.
	private List<StopStation> stopStations; //정차역 
	private List<Seat> seats; //남아있는 좌석
	
	public Train() {}

	public Train(String trainNumber, String departureStation, String departureTime, String arrivalStation,
			String arrivalTime, int takeMinute, String type, List<StopStation> stopStations, List<Seat> seats) {
//		super();
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

	@Override
	public String toString() {
		return "Train [trainNumber=" + trainNumber + ", departureStation=" + departureStation + ", departureTime="
				+ departureTime + ", arrivalStation=" + arrivalStation + ", arrivalTime=" + arrivalTime
				+ ", takeMinute=" + takeMinute + ", type=" + type + ", stopStations=" + stopStations + ", seats="
				+ seats + "]";
	}

}
