package trainReservation;

import java.util.Scanner;

import trainReservation.controller.ReservationController;

public class MainApplication {
	
//	private static ReservationController reservationsController = new ReservationController();
//	//Entity에 있는 자료 ctrl + space 해서 import 해주면 오류 안뜸
//	private static List<Train> trains = new ArrayList<Train>(); 
//	private static List<Cost> costs = new ArrayList<Cost>(); 
//	
//	//이거 시간 설정한다고 만든거 같은데...
//	private static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
//	
	private static ReservationController reservationController = new  ReservationController();
	
	public static void main(String[] args) { //메인 메서드에서 쓸거니까 static으로
		
		
		while(true) {
			
			Scanner scanner = new Scanner(System.in);
			
			String endPoint = scanner.nextLine();
			
			//원하는걸 돌리도록 만들어줌
			if(endPoint.equals("POST /reservation")) {
				reservationController.reservation();
			}
			
			if(endPoint.equals("GET /reservation")) {
				reservationController.getReservation();
				//break; 이거 넣으면 실행종료 되는데.. 이거 안넣으면 계속실행이 뜨네..
			}
			
		} //실행되는동안 예약정보 반환할수 있도록 넣어줌
		
		
		
													 
	}
}
