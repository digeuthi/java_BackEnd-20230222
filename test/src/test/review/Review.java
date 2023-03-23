package test.review;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Review {

	class User{
		String email;
		String password;
		String name;
		String telNumber;
	}
	
	List<User> userList = new ArrayList<>();
	
	public static void main(String[] args) {
		
		String email = null;
		String password = null;
		String passwordCheck = null;
		String name = null;
		String telNumber = null;
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			
			email = scanner.nextLine();
			password = scanner.nextLine();
			passwordCheck = scanner.nextLine();
			name = scanner.nextLine();
			telNumber = scanner.nextLine();
			
			if(email.isBlank() || password.isBlank() || passwordCheck.isBlank() 
				|| name.isBlank() || telNumber.isBlank()) continue;
		
			boolean existEmail = false;
			for(User user : userList) {
				if(email.equals(email)) {
					existEmail = true;
				}
			}
			if(existEmail==false) continue;
			if(!password.equals(passwordCheck)) continue;
			break; // 코드를 다 돌고나서 조건에 맞게 다 끝나면 조건문 탈출해야한다
		}
		
		User user = new User();
		
		//유저정보 객체 리스트 저장
		user.email = email;
		user.password = password;
		user.name = name;
		user.telNumber = telNumber;
		
		userList.add(user);
		System.out.println(user.toString());
		
	}

}
