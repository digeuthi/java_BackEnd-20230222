package website.service;

import website.common.constant.ResponseMessage;
import website.dto.request.user.SignUpDto;
import website.dto.response.ResponseDto;
import website.entity.User;
import website.repository.UserRepository;

public class UserService {

	private UserRepository userRepository;
	
	public UserService() {
		userRepository = new UserRepository();
	}

	public ResponseDto<Boolean> signUp(SignUpDto dto){
		
		String email = dto.getEmail();
		String password = dto.getPassword();
		String passwordCheck = dto.getPasswordChcek();
		
		boolean hasEmail = userRepository.existByEmail(email);
		if(hasEmail)
			return new ResponseDto<Boolean>(false, ResponseMessage.EXIST_EMAIL, false);
		
		if(!password.equals(passwordCheck)) {
			System.out.println(ResponseMessage.PASSWORD_NOT_MATCH);
			return new ResponseDto<Boolean>(false, ResponseMessage.SUCCESS, false);
		}
		
		User user = new User(dto);
		userRepository.save(user);
		
		return new ResponseDto(true, "성공", true);
		
	}
}
