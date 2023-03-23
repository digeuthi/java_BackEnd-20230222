package test.entity;

public class UserInfo {

	private String email;
	private String password;
	private String name;
	private String telNumber;
	
	public UserInfo() {}

	public UserInfo(String email, String password, String name, String telNumber) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.telNumber = telNumber;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getTelNumber() {
		return telNumber;
	}

	@Override
	public String toString() {
		return "UserInfo [email=" + email + ", password=" + password + ", name=" + name + ", telNumber=" + telNumber
				+ "]";
	}
	
	
}
