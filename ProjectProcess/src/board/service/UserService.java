package board.service;

import board.common.constant.ResponseMessage;
import board.dto.request.user.SignInDto;
import board.dto.request.user.SignUpDto;
import board.dto.response.ResponseDto;
import board.dto.response.user.SignInResponseDto;
import board.entity.User;
import board.repository.UserRepository;

public class UserService {

	private UserRepository userRepository;
	
	public UserService() {
		userRepository = new UserRepository();
	}
	
	public ResponseDto<Boolean>/*반환해주는 타입, 포멧만들어준 dto로!*/ signUp(SignUpDto dto) {
		
		String email = dto.getEmail();
		String password = dto.getPassword();
		String passwordCheck = dto.getPasswordCheck();
		
		//이메일 중복확인 
		//userTable에 있는 요소중에 동일한게 있는지 체크!!
		boolean hasEmail = userRepository.existsByEmail(email);
		if(hasEmail)
			return new ResponseDto<Boolean>(false, ResponseMessage.EXIST_EMAIL, false);
		//											인터페이스로 구현한 문구 가져옴
		//인터페이스 사용한 이유인듯 : 메시지 반환할 적에 영어로 적는게 좋다.인코딩 타입이 다르게 되면 깨질수도 있기때문에 영어로 작성하는게 좋다
		//비밀번호 같은지 확인 //컨트롤이 아니고 서비스에서 확인한다
		if(!password.equals(passwordCheck)) {
			System.out.println(ResponseMessage.PASSWORD_NOT_MATCH);
			return new ResponseDto<Boolean>(false, ResponseMessage.SUCCESS, false);
		}
		
		
		User user = new User(dto); //생성자 거칠적에 저런 포멧으로 들어가게 만들어준다 //유저 entity에 메서드 만들어줌
		userRepository.save(user);
		
		return new ResponseDto<Boolean>(true, "성공", true);
		
	}
	
	public ResponseDto<SignInResponseDto> signIn(SignInDto dto){
		
		SignInResponseDto data = null;
		return new ResponseDto<>(true, ResponseMessage.SUCCESS, data);
	}
	
}