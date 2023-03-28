package website.entity;
//좋아요한 사용자 프로필사진(문자열), 좋아요한 사용자 닉네임(문자열) ,좋아요한 사용자 이메일(문자열)
public class Like {

	private String userProfileImageUrl;
	private String userNickname;
	private String userEmail;
	
	public Like() {}

	public Like(String userProfileImageUrl, String userNickname, String userEmail) {
		super();
		this.userProfileImageUrl = userProfileImageUrl;
		this.userNickname = userNickname;
		this.userEmail = userEmail;
	}

	public String getUserProfileImageUrl() {
		return userProfileImageUrl;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserProfileImageUrl(String userProfileImageUrl) {
		this.userProfileImageUrl = userProfileImageUrl;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "Like [userProfileImageUrl=" + userProfileImageUrl + ", userNickname=" + userNickname + ", userEmail="
				+ userEmail + "]";
	}
	
	
}
