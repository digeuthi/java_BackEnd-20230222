package reservation.entity;

public class Cost {

	//출발역, 도착역, 금액
	private String departureStation;
	private String arrivalStation;
	private int amount;
	
	public Cost() {}

	public Cost(String departureStation, String arrivalStation, int amount) {
		super();
		this.departureStation = departureStation;
		this.arrivalStation = arrivalStation;
		this.amount = amount;
	}

	public String getDepartureStation() {
		return departureStation;
	}

	public String getArrivalStation() {
		return arrivalStation;
	}

	public int getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "Cost [departureStation=" + departureStation + ", arrivalStation=" + arrivalStation + ", amount="
				+ amount + "]";
	}
	
	
}
