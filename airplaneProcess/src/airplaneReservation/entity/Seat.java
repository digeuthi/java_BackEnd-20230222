package airplaneReservation.entity;

public class Seat {

	private String seatNumber;
	private boolean seatStatus;
	
	public Seat() {}

	public Seat(String seatNumber, boolean seatStatus) {
		super();
		this.seatNumber = seatNumber;
		this.seatStatus = seatStatus;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public boolean isSeatStatus() {
		return seatStatus;
	}

	@Override
	public String toString() {
		return "Seat [seatNumber=" + seatNumber + ", seatStatus=" + seatStatus + "]";
	}
	
	
}