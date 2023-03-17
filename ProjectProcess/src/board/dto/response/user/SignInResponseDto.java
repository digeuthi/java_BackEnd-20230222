package board.dto.response.user;

import java.util.UUID;

import board.entity.User;

public class SignInResponseDto {

	
	//유저 정보 반환해줄거야..
	private String email;
//	private String password; 반환안할거니까 빼두기! 개인정보!
	private String nickname;
	private String phonNumber;
	private String address;
	private String addressDetail;
	private String profileImageUrl;
	private String token; //새로 추가 로그인시 증명할수 있는 증명 도구
	
	public SignInResponseDto() {}

	
	public SignInResponseDto(String email, String nickname, String phonNumber, String address, String addressDetail,
			String profileImageUrl, String token) {
		super();
		this.email = email;
		this.nickname = nickname;
		this.phonNumber = phonNumber;
		this.address = address;
		this.addressDetail = addressDetail;
		this.profileImageUrl = profileImageUrl;
		this.token = token;
	}

	public SignInResponseDto(User user) {
		//데이터 보관해둔 테이블에 조건 검사했으면 검증된 값을 가지고 인스턴스를 반환해주는 생성자..?
		this.email = user.getEmail();
//		private String password; 반환안할거니까 빼두기! 개인정보!
		this.nickname = user.getNickName();
		this.phonNumber = user.getPhonNumber();
		this.address = user.getAddress();
		this.addressDetail = user.getAddressDetail();
		this.profileImageUrl = user.getProfileImageUrl();
		this.token = UUID.randomUUID().toString();
	}
	
	public String getEmail() {
		return email;
	}

	public String getNickname() {
		return nickname;
	}

	public String getPhonNumber() {
		return phonNumber;
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

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setPhonNumber(String phonNumber) {
		this.phonNumber = phonNumber;
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
		return "SignInResponseDto [email=" + email + ", nickname=" + nickname + ", phonNumber=" + phonNumber
				+ ", address=" + address + ", addressDetail=" + addressDetail + ", profileImageUrl=" + profileImageUrl
				+ ", token=" + token + "]";
	}
	
	
	
}
