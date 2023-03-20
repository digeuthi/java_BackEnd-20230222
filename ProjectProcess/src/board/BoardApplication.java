package board;

import java.util.Scanner;

import board.common.constant.HttpStatus;
import board.controller.BoardController;
import board.controller.UserController;
import board.dto.request.board.PostBoardDto;
import board.dto.request.user.SignInDto;
import board.dto.request.user.SignUpDto;

public class BoardApplication {

	private static UserController userController = new UserController();
	private static BoardController boardController = new BoardController();
	
	
	private static final String SIGN_UP = "POST /sign-up";
	private static final String SIGN_IN ="POST /sign-in";
	private static final String POST_BOARD = "POST /board";
	
	public static void main(String[] args) {
		
		while(true) { //true로 둬서 꺼지지 않게
			
			Scanner scanner = new Scanner(System.in);
			System.out.print("URL End point : ");
			String endPoint = scanner.nextLine();
			
			switch(endPoint) {
			
			case SIGN_UP :
				
				SignUpDto signUpDto = new SignUpDto();
				System.out.print("이메일 주소 : ");
				signUpDto.setEmail(scanner.nextLine());
				System.out.println("비밀번호 : ");
				signUpDto.setPassword(scanner.nextLine());
				System.out.println("비밀번호 확인 : ");
				signUpDto.setPasswordCheck(scanner.nextLine());
				System.out.println("닉네임 : ");
				signUpDto.setNickname(scanner.nextLine());
				System.out.println("전화번호 : ");
				signUpDto.setPhoneNumber(scanner.nextLine());
				System.out.println("주소 : ");
				signUpDto.setAddress(scanner.nextLine());
				System.out.println("상세주소 : ");
				signUpDto.setAddressDetail(scanner.nextLine());
				
//				//잘 받아왔는지 확인
//				System.out.println(dto.toString());
				
				userController.signUp(/*데이터*/signUpDto);
				break; //케이스 종료 시키기
			
			
			//로그인 
			case SIGN_IN : 
				//dto에서 검증받은 값 가져오기 
				SignInDto signInDto = new SignInDto(); //스위치문 안이라서 dto가 변수이름 중복 적용 안된다
				System.out.print("이메일 주소 : ");
				signInDto.setEmail(scanner.nextLine());
				System.out.print("비밀번호 : ");
				signInDto.setPassword(scanner.nextLine());
				
//				System.out.println(signInDto.toString());
				
				userController.singIn(signInDto); //signIn만들어주기..컨트롤러에 만들어줌
				break;
				
			case POST_BOARD: //PostBoardDto생성후 입력받게함
				PostBoardDto postBoardDto = new PostBoardDto();
				System.out.print("제목 : ");
				postBoardDto.setTitle(scanner.nextLine());
				System.out.print("내용 : ");
				postBoardDto.setContent(scanner.nextLine());
				System.out.print("이미지 : ");
				postBoardDto.setBoardImageUrl(scanner.nextLine());
				System.out.print("작성자 이메일 : ");
				postBoardDto.setWriterEmail(scanner.nextLine());
				
				//입력받은후 컨트롤러에 넘겨서 검증
				
				
			default : System.out.println(HttpStatus.NOT_FOUND);
					
			}
			
		}
	}

}
