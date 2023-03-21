package trainReservation.entity;

public class Cost {

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

	public void setDepartureStation(String departureStation) {
		this.departureStation = departureStation;
	}

	public void setArrivalStation(String arrivalStation) {
		this.arrivalStation = arrivalStation;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Cost [departureStation=" + departureStation + ", arrivalStation=" + arrivalStation + ", amount="
				+ amount + "]";
	}
	
	
}
