package website.service;

import website.repository.UserRepository;

public class UserService {

	private UserRepository userRepository;
	
	public UserService() {
		userRepository = new UserRepository();
	}
}
