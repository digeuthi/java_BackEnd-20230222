package test.dto;

import java.util.Scanner;

public class GetUserListDto {
	private String email;
    private String password;
    private String passwordCheck;
    private String name;
    private String telNumber;
    
    public GetUserListDto() {
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.println("이메일 : ");
    	this.email = scanner.nextLine();
    	System.out.println("비밀번호 : ");
    	this.password = scanner.nextLine();
    	System.out.println("비밀번호 확인 : ");
    	this.passwordCheck = scanner.nextLine();
    	System.out.println("이름 : ");
    	this.name = scanner.nextLine();
    	System.out.println("전화번호 : ");
    	this.telNumber = scanner.nextLine();
    	
    }

	public GetUserListDto(String email, String password, String passwordCheck, String name, String telNumber) {
		super();
		this.email = email;
		this.password = password;
		this.passwordCheck = passwordCheck;
		this.name = name;
		this.telNumber = telNumber;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public String getName() {
		return name;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	@Override
	public String toString() {
		return "GetUserListDto [email=" + email + ", password=" + password + ", passwordCheck=" + passwordCheck
				+ ", name=" + name + ", telNumber=" + telNumber + "]";
	}
    
    
}
