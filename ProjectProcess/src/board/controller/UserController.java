package board.controller;

import board.common.constant.HttpStatus;
import board.dto.request.user.SignInDto;
import board.dto.request.user.SignUpDto;
import board.dto.response.ResponseDto;
import board.dto.response.user.SignInResponseDto;
import board.service.UserService;

//검증처리
public class UserController {
	//입력은 메인에서 받고 컨트롤에서 검증한걸 메인으로 넘겨준다..?
	//회원가입 기능 접점 구현
	//dto만든 다음 컨트롤로 가져옴.
	
	private UserService userService;
	
	public UserController() {
		userService = new UserService();//이거 뒤에 뭐야 못적었다구요 이게 맞다
	}
	
	public void signUp(SignUpDto dto) {
		
		//입력을 여기서 받는다? 메인에서 입력받아서 컨트롤러에 저장해줌
		
		if(dto.validate()) { //입력에 대한 검증처리
			//dto의 validate를 참이면
			System.out.println(HttpStatus.BAD_REQUEST); //dto에 선언된 모든 필수값을 받지 못했을때 400이라는 코드를 준다
//			System.out.println("모든 값을 입력하세요");
			return;
		}
		//비밀번호 같은지 다른지 체크는 컨트롤러에서는 안한다 -> 서비스에서한단 이야긴가 ㅇㅇ
		//비밀번호가 다르면 회원가입을 시키지 않겠다 정한건 우리가 정한거고 비즈니스 로직에 해당함
		//입력값에서 두 값을 비교하는 행위가 비즈니스 로직을 위해 필요한거지 돌리기 위해 필요한 검증은 아니다..

		ResponseDto<Boolean> response = userService.signUp(dto);
		System.out.println(response.toString());
	}
	
	public void singIn(SignInDto dto) {
		if(dto.validate()) {
			//빈값이 하나라도 있다
			System.out.println(HttpStatus.BAD_REQUEST);
			return;
		}
		ResponseDto<SignInResponseDto> response = userService.signIn(dto); //아직 안만들어진 signIn
		//<?> 해두면 다 받을수 있지만 선생님 굉장히 싫어함 그럴거면 제너릭 쓰지마라..
		//signIn을 서비스에 만들어둠
		System.out.println(response.toString());
	}
}
