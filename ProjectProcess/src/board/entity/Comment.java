package board.entity;
//댓글

import java.util.Date;

//작성자 프로필 사진(문자열), 작성자의 닉네임(문자열), 댓글 작성 지난 기간 날짜및 시간(시간 연산 결과, 작성 시간 및 분, Date 날짜형태로!), 댓글 내용(문자열)
public class Comment {

	private String writerProfileImageUrl;
	private String writerNickname;
	private Date writeDatetime;
	private String content;
	
	public Comment() {}

	public Comment(String writerProfileImageUrl, String writerNickname, Date writeDatetime, String content) {
		super();
		this.writerProfileImageUrl = writerProfileImageUrl;
		this.writerNickname = writerNickname;
		this.writeDatetime = writeDatetime;
		this.content = content;
	}

	public String getWriterProfileImageUrl() {
		return writerProfileImageUrl;
	}

	public String getWriterNickname() {
		return writerNickname;
	}

	public Date getWriteDatetime() {
		return writeDatetime;
	}

	public String getContent() {
		return content;
	}

	public void setWriterProfileImageUrl(String writerProfileImageUrl) {
		this.writerProfileImageUrl = writerProfileImageUrl;
	}

	public void setWriterNickname(String writerNickname) {
		this.writerNickname = writerNickname;
	}

	public void setWriteDatetime(Date writeDatetime) {
		this.writeDatetime = writeDatetime;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Comment [writerProfileImageUrl=" + writerProfileImageUrl + ", writerNickname=" + writerNickname
				+ ", writeDatetime=" + writeDatetime + ", content=" + content + "]";
	}
	
	
	
}
