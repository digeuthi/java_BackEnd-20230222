package board.entity;

import board.dto.request.user.SignUpDto;

//회원
//'이메일 주소'(구분요소)(문자열), 비밀번호(문자열), 비밀번호 확인(문자열), 닉네임(문자열), 핸드폰 번호(문자열), 
//주소(문자열), 상세주소(문자열), 프로필사진(파일객체쓸수도 있지만 이미지의 링크 주소를 넣는다, 문자열) -> 클래스 만들어주기
public class User {

	private String email;
	private String password;
//	private String passwordCheck;
	private String nickname;
	private String phonNumber;
	private String address;
	private String addressDetail;
	private String profileImageUrl;
	//보관하고 관리할 용도로 계속 쓰일 값들
	//관리할 필요없는것 : 검증을 위한 용도 passwordCheck -> 빼기
	
	public User() {}
	public User(String email, String password, String nickname, String phonNumber, String address, String addressDetail,
			String profileImageUrl) {
		super();
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.phonNumber = phonNumber;
		this.address = address;
		this.addressDetail = addressDetail;
		this.profileImageUrl = profileImageUrl;
	}
	
	public User(SignUpDto dto) {
		this.email = dto.getEmail();
		this.password = dto.getPassword();
		this.nickname=dto.getNickname();
		this.phonNumber =dto.getPhoneNumber();
		this.address = dto.getAddress();
		this.addressDetail = dto.getAddressDetail();
	}
	
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getNickName() {
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
	
	//실제로는 entity에서는 setter 쓰지 말자고 하는편
	//인스턴스 수정 작업이 발생하지 않는 행위에 대해서는 setter 사용안하는데
	//우리는 DB가 없어서 수정하는 작업이 필요하기때문에 setter 쓴다
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setNickName(String nickName) {
		this.nickname = nickName;
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
	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", nickName=" + nickname + ", phonNumber="
				+ phonNumber + ", address=" + address + ", addressDetail=" + addressDetail + ", profileImageUrl="
				+ profileImageUrl + "]";
	}
	
	
}