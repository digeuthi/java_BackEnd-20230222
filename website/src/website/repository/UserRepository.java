package website.repository;

import java.util.ArrayList;
import java.util.List;

import website.entity.User;

public class UserRepository {

	private static List<User> userTable = new ArrayList<>();
	//이메일 구분자로 하기 위해서 사용하는것 같음.
	public User findByEmail(String email) {
		User result = null;
		
		for(User user : userTable) {
			if(user.getEmail().equals(email)) {
				result = user;
				break;
			}
		}
		return result;
	}
	
	public boolean existByEmail(String email) {
		boolean result = false;
		for(User user : userTable) {
			if(user.getEmail().equals(email)) {
				result = true;
				break;
			}
		}
		return result;
	}
	
	public User save(User user) {
		userTable.add(user);
		return user;
	}
}
