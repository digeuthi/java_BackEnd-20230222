package board.entity;
//좋아요

//좋아요한 사용자 프로필사진(문자열), 좋아요한 사용자 닉네임(문자열) ,좋아요한 사용자 이메일(문자열)
public class Like {

	private String userEmail;
	private String userProfileImageUrl;
	private String userNickname;
	
	public Like() {} //오버로드

	public Like(String userEmail, String userProfileImageUrl, String userNickName) { //오버로드
		super();
		this.userEmail = userEmail;
		this.userProfileImageUrl = userProfileImageUrl;
		this.userNickname = userNickName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public String getUserProfileImageUrl() {
		return userProfileImageUrl;
	}

	public String getUserNickName() {
		return userNickname;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public void setUserProfileImageUrl(String userProfileImageUrl) {
		this.userProfileImageUrl = userProfileImageUrl;
	}

	public void setUserNickName(String userNickName) {
		this.userNickname = userNickName;
	}

	@Override //재정의 / 오버로드는 과적재!
	public String toString() {
		return "Like [userEmail=" + userEmail + ", userProfileImageUrl=" + userProfileImageUrl + ", userNickName="
				+ userNickname + "]";
	}
	
	
}
