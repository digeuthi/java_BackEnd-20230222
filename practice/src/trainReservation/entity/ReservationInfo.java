package trainReservation.entity;

import java.util.List;
import java.util.UUID;

//예약번호
//열차번호
//좌석번호 리스트
//출발역
//출발 시간
//도착역
//도착시간
//총 금액
public class ReservationInfo {

	private String reservationNumber;
	private String trainNumber;
	private List<String> seats;
	private String departureStation;
	private String departureTime;
	private String arrivalStation;
	private String arrivalTime;
	private int totalCost;
	
	public ReservationInfo() {}

	public ReservationInfo(String trainNumber, List<String> seats, String departureStation,
			String departureTime, String arrivalStation, String arrivalTime, int totalCost) {
		super();
		this.reservationNumber = UUID.randomUUID().toString();
		this.trainNumber = trainNumber;
		this.seats = seats;
		this.departureStation = departureStation;
		this.departureTime = departureTime;
		this.arrivalStation = arrivalStation;
		this.arrivalTime = arrivalTime;
		this.totalCost = totalCost;
	}

	public String getReservationNumber() {
		return reservationNumber;
	}

	public String getTrainNumber() {
		return trainNumber;
	}

	public List<String> getSeats() {
		return seats;
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

	public int getTotalCost() {
		return totalCost;
	}

	public void setReservationNumber(String reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
	}

	public void setSeats(List<String> seats) {
		this.seats = seats;
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

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	@Override
	public String toString() {
		return "ReservationInfo [reservationNumber=" + reservationNumber + ", trainNumber=" + trainNumber + ", seats="
				+ seats + ", departureStation=" + departureStation + ", departureTime=" + departureTime
				+ ", arrivalStation=" + arrivalStation + ", arrivalTime=" + arrivalTime + ", totalCost=" + totalCost
				+ "]";
	}
	
	
	
}
