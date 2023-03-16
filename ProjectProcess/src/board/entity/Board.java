package board.entity;
//게시물

import java.util.List;

//'게시물 번호'(구분요소)(우리가 지정한거라 우리가 정하면된다. 정수형태), 
//이미지(문자열),'작성자 이메일'(구분요소)(문자열), 작성자 닉네임(문자열), 작성자 프로필사진(문자열), 
//작성일(datetype이 있는데 작성일만 다루고 효율을 위해 문자열로 받기 -> 대부분 보여주는 용도라 문자열), 
//제목(문자열), 내용(문자열), [댓글수(정수형태), 좋아요수(정수형태)], 조회수(정수형태)
//좋아요 리스트(좋아요한 사용자 프로필 사진(클래스따로), 좋아요한 사용자 닉네임(클래스따로))(리스트타입), 
//댓글 리스트 (작성자 프로필 사진, 작성자의 닉네임, 댓글 작성 지난 기간, 댓글 내용)(리스트타입)
public class Board {

	private int boardNumber;
	private String boardImageUrl;
	private String writerEmail;
	private String writerNickname;
	private String writerProfileImageUrl;
	private String writeDate;
	private String title;
	private String content;
	
	//댓글수와 좋아요수 정의하지 않고 관리할수 있나? ㅇㅇ..
	//리스트 넣게될때 필요하면 size반환하는걸로 만들자 
	
	private int viewCount;
	private List<Like> likeList;
	private List<Comment> commentList;
	
	
	public Board () {}


	public Board(int boardNumber, String boardImageUrl, String writerEmail, String writerNickname,
			String writerProfileImageUrl, String writeDate, String title, String content, int viewCount,
			List<Like> likeList, List<Comment> commentList) {
		super();
		this.boardNumber = boardNumber;
		this.boardImageUrl = boardImageUrl;
		this.writerEmail = writerEmail;
		this.writerNickname = writerNickname;
		this.writerProfileImageUrl = writerProfileImageUrl;
		this.writeDate = writeDate;
		this.title = title;
		this.content = content;
		this.viewCount = viewCount;
		this.likeList = likeList;
		this.commentList = commentList;
	}


	public int getBoardNumber() {
		return boardNumber;
	}


	public String getBoardImageUrl() {
		return boardImageUrl;
	}


	public String getWriterEmail() {
		return writerEmail;
	}


	public String getWriterNickname() {
		return writerNickname;
	}


	public String getWriterProfileImageUrl() {
		return writerProfileImageUrl;
	}


	public String getWriteDate() {
		return writeDate;
	}


	public String getTitle() {
		return title;
	}


	public String getContent() {
		return content;
	}


	public int getViewCount() {
		return viewCount;
	}


	public List<Like> getLikeList() {
		return likeList;
	}


	public List<Comment> getCommentList() {
		return commentList;
	}


	public void setBoardNumber(int boardNumber) {
		this.boardNumber = boardNumber;
	}


	public void setBoardImageUrl(String boardImageUrl) {
		this.boardImageUrl = boardImageUrl;
	}


	public void setWriterEmail(String writerEmail) {
		this.writerEmail = writerEmail;
	}


	public void setWriterNickname(String writerNickname) {
		this.writerNickname = writerNickname;
	}


	public void setWriterProfileImageUrl(String writerProfileImageUrl) {
		this.writerProfileImageUrl = writerProfileImageUrl;
	}


	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}


	public void setLikeList(List<Like> likeList) {
		this.likeList = likeList;
	}


	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}


	@Override
	public String toString() {
		return "Board [boardNumber=" + boardNumber + ", boardImageUrl=" + boardImageUrl + ", writerEmail=" + writerEmail
				+ ", writerNickname=" + writerNickname + ", writerProfileImageUrl=" + writerProfileImageUrl
				+ ", writeDate=" + writeDate + ", title=" + title + ", content=" + content + ", viewCount=" + viewCount
				+ ", likeList=" + likeList + ", commentList=" + commentList + "]";
	}
	
	
}
