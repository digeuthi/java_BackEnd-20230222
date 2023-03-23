package test.repository;

import java.util.ArrayList;
import java.util.List;

import test.dto.GetUserListDto;
import test.entity.User;

public class UserRepository {

	private static List<User> userTable = new ArrayList<>();
	
	public boolean existsByEmail(String email) {
		boolean result = false;
		for(User user : userTable) {
			
			if(user.getEmail().equals(email)) {
				result = true;
				break;
			}
		}
		return result;
	}
	
	public List<User> getUserList(GetUserListDto dto) {
		
		return ;
	}
}
