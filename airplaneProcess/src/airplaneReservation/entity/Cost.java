package airplaneReservation.entity;

public class Cost {
	
	private String departureCountry;
	private String arrivalCountry;
	private int amount;
	
	public Cost() {}

	public Cost(String departureCountry, String arrivalCountry, int amount) {
		super();
		this.departureCountry = departureCountry;
		this.arrivalCountry = arrivalCountry;
		this.amount = amount;
	}

	public String getDepartureCountry() {
		return departureCountry;
	}

	public String getArrivalCountry() {
		return arrivalCountry;
	}

	public int getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "Cost [departureCountry=" + departureCountry + ", arrivalCountry=" + arrivalCountry + ", amount="
				+ amount + "]";
	}
	
	
}
