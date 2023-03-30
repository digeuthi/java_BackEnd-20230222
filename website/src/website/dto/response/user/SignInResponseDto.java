package website.dto.response.user;

import java.util.UUID;

import website.entity.User;

public class SignInResponseDto {

	private String email;
	private String password;
	private String nickname;
	private String telNimber;
	private String address;
	private String addressDetail;
	private String profileImageUrl;
	private String token;
	
	public SignInResponseDto() {}

	public SignInResponseDto(String email, String password, String nickname, String telNimber, String address,
			String addressDetail, String profileImageUrl, String token) {
		super();
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.telNimber = telNimber;
		this.address = address;
		this.addressDetail = addressDetail;
		this.profileImageUrl = profileImageUrl;
		this.token = token;
	}
	
	public SignInResponseDto(User user) {
		this.email = user.getEmail();
		this.nickname = user.getNickname();
		this.address = user.getAddress();
		this.addressDetail = user.getAddressDetail();
		this.profileImageUrl = user.getProfileImageUrl();
		this.telNimber = user.getTelNumber();
		this.token = UUID.randomUUID().toString();
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getNickname() {
		return nickname;
	}

	public String getTelNimber() {
		return telNimber;
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

	public String getToken() {
		return token;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setTelNimber(String telNimber) {
		this.telNimber = telNimber;
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

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "SignInResponseDto [email=" + email + ", password=" + password + ", nickname=" + nickname
				+ ", telNimber=" + telNimber + ", address=" + address + ", addressDetail=" + addressDetail
				+ ", profileImageUrl=" + profileImageUrl + ", token=" + token + "]";
	}
	
	
}
