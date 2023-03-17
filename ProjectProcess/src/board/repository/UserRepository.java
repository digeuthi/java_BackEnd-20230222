package board.repository;
//저장소

import java.util.ArrayList;
import java.util.List;

import board.entity.User;

public class UserRepository {

	private static List<User> userTable = new ArrayList<>();
	//받은 dto를 유저 entity를 받아서 거친다음에 usertable에 저장되게 한다??
	
	public boolean existsByEmail(String email) {
		boolean result = false;
		for(User user : userTable) {
			//돌면서 하나씩 검색
			if(user.getEmail().equals(email)) {
				result = true;
				break;
			}
		}
		return result;
	}
	
	public User/*반환 클래스*/ save(User user) {
		userTable.add(user);
		return user;
		
	}
}