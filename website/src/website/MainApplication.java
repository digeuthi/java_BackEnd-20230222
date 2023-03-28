package website;

import java.util.Scanner;

import website.controller.UserController;
import website.dto.request.user.SignUpDto;

public class MainApplication {

	private static UserController userController = new UserController();
	
	private static final String SIGN_UP = "POST /sign-up";
	

	public static void main(String[] args) {
		
		while(true) {
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("URL End point : ");
			String endPoint = scanner.nextLine();
		switch(endPoint) {
		
		case SIGN_UP :
			SignUpDto signUpDto = new SignUpDto();
			
			System.out.print("이메일 주소 : ");
			signUpDto.setEmail(scanner.nextLine());
			System.out.println("비밀번호 : ");
			signUpDto.setPassword(scanner.nextLine());
			System.out.println("비밀번호 확인 : ");
			signUpDto.setPasswordChcek(scanner.nextLine());
			System.out.println("닉네임 : ");
			signUpDto.setNickname(scanner.nextLine());
			System.out.println("전화번호 : ");
			signUpDto.setTelNumber(scanner.nextLine());
			System.out.println("주소 : ");
			signUpDto.setAddress(scanner.nextLine());
			System.out.println("상세주소 : ");
			signUpDto.setAddressDetail(scanner.nextLine());
			
			userController.signUp(signUpDto);
			break;
		}
			
		}
	}


}
