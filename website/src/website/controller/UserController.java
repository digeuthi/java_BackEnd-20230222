package website.controller;

import website.common.constant.HttpStatus;
import website.dto.request.user.SignInDto;
import website.dto.request.user.SignUpDto;
import website.dto.response.ResponseDto;
import website.dto.response.user.SignInResponseDto;
import website.service.UserService;

public class UserController {

	private UserService userService;
	
	public void signUp(SignUpDto dto) {
		
		if(dto.vaildate()) {
			System.out.println(HttpStatus.BAD_REQUEST);
			return;
		}
		
		ResponseDto<Boolean> response = userService.signUp(dto);
		System.out.println(response.toString());
	}
	
	public void signIn(SignInDto dto) {
		if(dto.valid()) {
			System.out.println(HttpStatus.BAD_REQUEST);
			return;
		}
		
		ResponseDto<SignInResponseDto> response = userService.signIn(dto);
		System.out.println(response.toString());
	}
	
}
