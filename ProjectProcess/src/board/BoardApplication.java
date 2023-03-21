package board;

import java.util.Scanner;

import board.common.constant.HttpStatus;
import board.controller.BoardController;
import board.controller.UserController;
import board.dto.request.board.PatchBoardDto;
import board.dto.request.board.PostBoardDto;
import board.dto.request.user.SignInDto;
import board.dto.request.user.SignUpDto;

public class BoardApplication {

	private static UserController userController = new UserController();
	private static BoardController boardController = new BoardController();
	
	
	private static final String SIGN_UP = "POST /sign-up";
	private static final String SIGN_IN ="POST /sign-in";
	
	private static final String POST_BOARD = "POST /board";
	
	private static final String GET_BOARD_LIST = "GET /board/list"; //게시물 리스트형태로 불러오기
	private static final String GET_BOARD = "GET /board"; //게시물하나 불러오기
	
	private static final String PATCH_BOARD ="PATH /board";
	
	private static final String DELETE_BOARD = "DELETE /board";
	
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
				boardController.postBoard(postBoardDto);
				break;
				
			case GET_BOARD_LIST :
				//전체 리스트를 받아올거다.. 
				//아무것도 입력받을 필요없이 보여주면 된다?
				boardController.getBoardList();
				
				break;
				
				//특정한 하나의 게시물 받아오기
			case GET_BOARD :
				//사용자가 선택해서 가져온것이므로 특정한 게시물의 번호를 넘겨줘야 같이 전달해줄수 있다.
				//get 과 delete는 dto를 만들지 않고 바로 가져온다
				
				//사용자로부터 입력을 받아온다. 외부에서 내부로 데이터가 넘어오는것
				//근데 우리는 정수로 받아온다. 정수를 받는 메서드를 만들었고 nextInt라는 메서드는
				//반환타입이 integer로 지정되어있다 그래서 우리가 컴파일 상에는 아무런 문제가 없다 
				//사람이 무조건 정수로만 입력을 하지는 않는다? 외부에서 들어오는건 정수로 무조건 들어오지않을수있다
				//예외적 상황! 예외처리 try catch 사용!
				
				int boardNumber = 0;
				
				try {
					System.out.print("게시물 번호 : ");
					boardNumber = scanner.nextInt();
				}catch(Exception exception) {
					exception.printStackTrace(); //콘솔에  빨간줄 그이게 표시
					continue;
				}
				
				boardController.getBoard(boardNumber); //boardNumber에 빨간줄 그인 이유는? 
														//try문 안에 지역변수로 있어서 빨간줄! case문쪽으로 빼면 된다.
				break;
				
			case PATCH_BOARD: //게시물 수정
				
				//Scanner scanner = new Scanner(System.in);
				//이거 밑에 뭐.. 간단한 메서드로 옮긴다는데 어떻게 한단건지 모르겟군 //어떤 기능을 명시해놓고 따로 빼주는게 좋은 코드..!
				PatchBoardDto patchBoardDto = new PatchBoardDto(); //이거 위치 여기 맞나 확인하자
				try {
					System.out.print("게시물 번호 : ");
					String patchNumberString = scanner.nextLine(); //스위치에서 보드넘버 중복뜸
					patchBoardDto.setBoardNumber(Integer.parseInt(patchNumberString)); //문자열을 숫자 정수로 바꿔줌
													//일반적 정수형태가 아니라 문자열로 들어와서 예외가 터질수있다.
					System.out.print("제목 : "); //아마 에러가 뜰것..? nextInt다음 문자열 오면 에러가 된다 -> 수정
					patchBoardDto.setTitle(scanner.nextLine());
					System.out.print("내용 : ");
					patchBoardDto.setContent(scanner.nextLine());
					System.out.print("이미지 : ");
					patchBoardDto.setBoardImageUrl(scanner.nextLine());
					System.out.print("이메일 : ");
					patchBoardDto.setEmail(scanner.nextLine());
				} catch(Exception exception) {
					System.out.println(HttpStatus.NOT_FOUND);
					continue;
				}
				
				boardController.patchBoard(patchBoardDto); //patchBoard만들어주러 가기 컨트롤러에!
				
				break;
				
			case DELETE_BOARD:
				
				int deleteBoardNumber = 0;
				String deleteEmail = null;
				
				try {
					System.out.print("게시물 번호 : ");
					deleteBoardNumber= Integer.parseInt(scanner.nextLine());
					System.out.print("이메일 : ");
					deleteEmail = scanner.nextLine();
				}
				catch(Exception exception) {
					exception.printStackTrace();
					continue;
				}
				
				boardController.deleteBoard(deleteBoardNumber, deleteEmail);
				break;
			
			default : System.out.println(HttpStatus.NOT_FOUND);
					
			}
			
		}
	}
	
//	private static void patchBoard() { //메서드 따로 만들어서 
//		PatchBoardDto patchBoardDto = new PatchBoardDto(); //이거 위치 여기 맞나 확인하자
//		try {
//			System.out.print("게시물 번호 : ");
//			String patchNumberString = scanner.nextLine(); //스위치에서 보드넘버 중복뜸
//			patchBoardDto.setBoardNumber(Integer.parseInt(patchNumberString)); //문자열을 숫자 정수로 바꿔줌
//											//일반적 정수형태가 아니라 문자열로 들어와서 예외가 터질수있다.
//			System.out.print("제목 : "); //아마 에러가 뜰것..? nextInt다음 문자열 오면 에러가 된다 -> 수정
//			patchBoardDto.setTitle(scanner.nextLine());
//			System.out.print("내용 : ");
//			patchBoardDto.setContent(scanner.nextLine());
//			System.out.print("이미지 : ");
//			patchBoardDto.setBoardImageUrl(scanner.nextLine());
//			System.out.print("이메일 : ");
//			patchBoardDto.setEmail(scanner.nextLine());
//		} catch(Exception exception) {
//			System.out.println(HttpStatus.NOT_FOUND);
//			continue;
//		}
//		
//		boardController.patchBoard(patchBoardDto); //patchBoard만들어주러 가기 컨트롤러에!
//	}

}
