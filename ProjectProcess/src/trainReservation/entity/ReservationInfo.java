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
	private String tarinNumber;
	private List<String> seats;
	private String departureStation;
	private String departureTime;
	private String arrivalStation;
	private String arrivalTime;
	private int totalCost;
	
	public ReservationInfo() {}

	public ReservationInfo(String tarinNumber, List<String> seats, String departureStation,
			String departureTime, String arrivalStation, String arrivalTime, int totalCost) {
		//reservationNumber을 안쓰니까 인자값으로 안넣었다! 클래스 선언까지만 해주고 초기화를 안해줘서 그런것
		this.reservationNumber = /*난수생성*/ UUID.randomUUID().toString();
		this.tarinNumber = tarinNumber;
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

	public String getTarinNumber() {
		return tarinNumber;
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

	@Override
	public String toString() {
		return "ReservationInfo [reservationNumber=" + reservationNumber + ", tarinNumber=" + tarinNumber + ", seats="
				+ seats + ", departureStation=" + departureStation + ", departureTime=" + departureTime
				+ ", arrivalStation=" + arrivalStation + ", arrivalTime=" + arrivalTime + ", totalCost=" + totalCost
				+ "]";
	}
	
	
	//toString
}