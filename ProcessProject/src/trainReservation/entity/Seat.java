package trainReservation.entity;

//남아있는 좌석 (class - 호차, 좌석번호, 좌석상태 ) (예약여부의 상태, 몇호차인지에 대한 상태 )
public class Seat/*단수형태 명사*/ {
	private int roomNumber;
	private String seatNumber;
	private boolean seatStatus;
	
	public Seat() {}
	//생성자
	public Seat(int roomNumber, String seatNumber, boolean seatStatus) {
		super();
		this.roomNumber = roomNumber;
		this.seatNumber = seatNumber;
		this.seatStatus = seatStatus;
	}
	//getter
	public int getRoomNumber() {
		return roomNumber;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public boolean isSeatStatus() { //불린형태라 is로 찍힘
		return seatStatus;
	}
	@Override
	public String toString() {
		return "Seat [roomNumber=" + roomNumber + ", seatNumber=" 
						+ seatNumber + ", seatStatus=" + seatStatus + "]";
	}
	

	
}
