package airplaneReservation;

import airplaneReservation.controller.ReservationController;

public class MainApplication {
	
//	private static List<Airplane> airplanes = new ArrayList<Airplane>();
//	private static List<Cost> costs = new ArrayList<Cost>();
	
//	private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
	
	private static ReservationController reservationController = new  ReservationController();
	
	public static void main(String[] args) {
		
		reservationController.reservation();
	
	}
}

