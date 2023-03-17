package board;

import java.util.Scanner;

import board.controller.UserController;
import board.dto.request.user.SignUpDto;

public class BoardApplication {

	private static UserController userController = new UserController();
	
	
	public static void main(String[] args) {
		
		while(true) { //true로 둬서 꺼지지 않게
			
			Scanner scanner = new Scanner(System.in);
			System.out.print("URL End point : ");
			String endPoint = scanner.nextLine();
			
			switch(endPoint) {
			
			case "Post /sign-up" :
				SignUpDto dto = new SignUpDto();
				System.out.print("이메일 주소 : ");
				dto.setEmail(scanner.nextLine());
				System.out.println("비밀번호 : ");
				dto.setPassword(scanner.nextLine());
				System.out.println("비밀번호 확인 : ");
				dto.setPasswordCheck(scanner.nextLine());
				System.out.println("닉네임 : ");
				dto.setNickname(scanner.nextLine());
				System.out.println("전화번호 : ");
				dto.setPhoneNumber(scanner.nextLine());
				System.out.println("주소 : ");
				dto.setAddress(scanner.nextLine());
				System.out.println("상세주소 : ");
				dto.setAddressDetail(scanner.nextLine());
				
//				//잘 받아왔는지 확인
//				System.out.println(dto.toString());
				
				userController.signUp(/*데이터*/dto);
				break; //케이스 종료 시키기
			default : System.out.println("404 Not Found");
					
			}
			
		}
	}

}
