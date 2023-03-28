package website.entity;

//'이메일 주소'(구분요소)(문자열), 비밀번호(문자열), 비밀번호 확인(문자열), 닉네임(문자열), 핸드폰 번호(문자열), 
//주소(문자열), 상세주소(문자열), 프로필사진(파일객체쓸수도 있지만 이미지의 링크 주소를 넣는다, 문자열)
public class User {

	private String email;
	private String password;
	//private String passwordCheck;
	private String nickname;
	private String telNumber;
	private String address;
	private String addressDetail;
	private String profileImageUrl;
	
	public User() {}

	public User(String email, String password, String nickname, String telNumber, String address,
			String addressDetail, String profileImageUrl) {
		super();
		this.email = email;
		this.password = password;
		//this.passwordCheck = passwordCheck;
		this.nickname = nickname;
		this.telNumber = telNumber;
		this.address = address;
		this.addressDetail = addressDetail;
		this.profileImageUrl = profileImageUrl;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

//	public String getPasswordCheck() {
//		return passwordCheck;
//	}

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

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public void setPasswordCheck(String passwordCheck) {
//		this.passwordCheck = passwordCheck;
//	}

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

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", passwordCheck=" + ", nickname="
				+ nickname + ", telNumber=" + telNumber + ", address=" + address + ", addressDetail=" + addressDetail
				+ ", profileImageUrl=" + profileImageUrl + "]";
	}
	
	
}
