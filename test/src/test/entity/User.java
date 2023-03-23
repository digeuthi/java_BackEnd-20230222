package test.entity;

public class User {

	private String email;
    private String password;
    private String passwordCheck;
    private String name;
    private String telNumber;
	
    public User(String email, String password, String passwordCheck, String name, String telNumber) {
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

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", passwordCheck=" + passwordCheck + ", name=" + name
				+ ", telNumber=" + telNumber + "]";
	}
    
    
}
