package website.controller;

import website.dto.request.user.SignUpDto;

public class UserController {

	public void signUp(SignUpDto dto) {
		
		if(dto.vaildate()) {
			System.out.println("400 Bad Request");
			return;
		}
	}
	
}
