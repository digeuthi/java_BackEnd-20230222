package test.service;

import java.util.ArrayList;
import java.util.List;

import test.dto.GetUserListDto;
import test.entity.User;
import test.entity.UserInfo;
import test.repository.UserRepository;

public class UserService {

	private UserRepository userRepository;
	private UserInfo userInfo;
	
	
	public List<User> getUserList(GetUserListDto dto){
		
		List<User> userList = userRepository.getUserList(dto);
		
		return userList;
	}
}

