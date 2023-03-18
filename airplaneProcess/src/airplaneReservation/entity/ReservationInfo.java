package airplaneReservation.entity;

import java.util.List;

//예약번호 -> 선언까지만 해주고 초기화를 안해준다.
//열차번호
//좌석번호 리스트
//출발역
//출발 시간
//도착역
//도착시간
//총 금액
public class ReservationInfo {

	private String reservationNumber;
	private String airplaneNumber;
	private List<String> seats;
	private String departureCountry;
	private String departureTime;
	private String arrivalCountry;
	private String arrivalTime;
	private int totalCount;
	
	public ReservationInfo() {}

	public ReservationInfo(String airplaneNumber, List<String> seats, String departureCountry, String departureTime,
			String arrivalCountry, String arrivalTime, int totalCount) {
		super();
		this.airplaneNumber = airplaneNumber;
		this.seats = seats;
		this.departureCountry = departureCountry;
		this.departureTime = departureTime;
		this.arrivalCountry = arrivalCountry;
		this.arrivalTime = arrivalTime;
		this.totalCount = totalCount;
	}

	public String getReservationNumber() {
		return reservationNumber;
	}

	public String getAirplaneNumber() {
		return airplaneNumber;
	}

	public List<String> getSeats() {
		return seats;
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

	public int getTotalCount() {
		return totalCount;
	}

	@Override
	public String toString() {
		return "ReservationInfo [reservationNumber=" + reservationNumber + ", airplaneNumber=" + airplaneNumber
				+ ", seats=" + seats + ", departureCountry=" + departureCountry + ", departureTime=" + departureTime
				+ ", arrivalCountry=" + arrivalCountry + ", arrivalTime=" + arrivalTime + ", totalCount=" + totalCount
				+ "]";
	}
	
	
}


