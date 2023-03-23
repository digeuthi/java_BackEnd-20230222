package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import test.controller.UserController;
import test.dto.GetUserListDto;

class User {

	private String email;
    private String password;
    private String passwordCheck;
    private String name;
    private String telNumber;
	
}


public class MainApplication {

	private static test.controller.UserController userController = new test.controller.UserController();
	private static List<User> users = new ArrayList<>();
	private GetUserListDto getUserListDto;

	public static void main(String[] args) {
		
		userController.user();
		System.out.println();
		
	}

}
