package website.dto.request.user;
////어떤 인풋을 받을지 이메일, 비밀번호, 비밀번호 확인, 닉네임, 전화번호, 주소, 주소 상세
public class SignUpDto {

	private String email;
	private String password;
	private String passwordChcek;
	private String nickname;
	private String telNumber;
	private String address;
	private String addressDetail;
	
	public SignUpDto() {}

	public SignUpDto(String email, String password, String passwordChcek, String nickname, String telNumber,
			String address, String addressDetail) {
		super();
		this.email = email;
		this.password = password;
		this.passwordChcek = passwordChcek;
		this.nickname = nickname;
		this.telNumber = telNumber;
		this.address = address;
		this.addressDetail = addressDetail;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getPasswordChcek() {
		return passwordChcek;
	}

	public String getNickname() {
		return nickname;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public String getAddress() {
		return address;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPasswordChcek(String passwordChcek) {
		this.passwordChcek = passwordChcek;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	@Override
	public String toString() {
		return "SignUpDto [email=" + email + ", password=" + password + ", passwordChcek=" + passwordChcek
				+ ", nickname=" + nickname + ", telNumber=" + telNumber + ", address=" + address + ", addressDetail="
				+ addressDetail + "]";
	}
	
	public boolean vaildate() {
		boolean result = 
				this.email.isBlank()||
				this.password.isBlank()||
				this.passwordChcek.isBlank()||
				this.nickname.isBlank()||
				this.address.isBlank()||
				this.addressDetail.isBlank()||
				this.telNumber.isBlank();
		return result;
	}
}
