package test.controller;

import test.dto.GetUserListDto;
import test.repository.UserRepository;
import test.service.UserService;

public class UserController {

	private UserService userService;
	private GetUserListDto getUserListDto;
	private UserRepository userRepository;
	
	public void user() {
		
		while(true) {
			getUserListDto = new GetUserListDto();
			
			if(getUserListDto.getEmail().isBlank()||
					getUserListDto.getName().isBlank()||
					getUserListDto.getPassword().isBlank()||
					getUserListDto.getPasswordCheck().isBlank()||
					getUserListDto.getTelNumber().isBlank()) { 
				
				System.out.println("모두 입력하세요.");
				continue; 
			}
			
			if(userRepository.existsByEmail(getUserListDto.getEmail())) {
				System.out.println("이미 존재하는 이메일 입니다");
				continue;
			}
			
			if(!getUserListDto.getPassword().equals(getUserListDto.getPasswordCheck())) {
				System.out.println("비밀번호가 같지 않습니다");
				continue;
			}
		}
	}
}
