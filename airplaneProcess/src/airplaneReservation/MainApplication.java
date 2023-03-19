package airplaneReservation;

import java.util.Scanner;

import airplaneReservation.controller.ReservationController;
import airplaneReservation.controller.*;
public class MainApplication {
	
//	private static List<Airplane> airplanes = new ArrayList<Airplane>();
//	private static List<Cost> costs = new ArrayList<Cost>();
	
//	private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
	
	private static ReservationController reservationController = new  ReservationController();
	
	public static void main(String[] args) {
		
		
		while(true) {
			Scanner scanner = new Scanner(System.in);
			
			String endPoint = scanner.nextLine();
			
			if(endPoint.equals("POST /reservation")) {
				reservationController.reservation();
			}
			if(endPoint.equals("GET /reservation")) {
				reservationController.getReservation();
			}
		}
		//reservationController.reservation();
	
	}
}

