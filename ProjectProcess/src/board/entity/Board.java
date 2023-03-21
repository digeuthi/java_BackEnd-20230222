package board.entity;
//게시물

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import board.dto.request.board.PatchBoardDto;
import board.dto.request.board.PostBoardDto;
import board.repository.BoardRepository;

//'게시물 번호'(구분요소)(우리가 지정한거라 우리가 정하면된다. 정수형태), 
//이미지(문자열),'작성자 이메일'(구분요소)(문자열), 작성자 닉네임(문자열), 작성자 프로필사진(문자열), 
//작성일(datetype이 있는데 작성일만 다루고 효율을 위해 문자열로 받기 -> 대부분 보여주는 용도라 문자열), 
//제목(문자열), 내용(문자열), [댓글수(정수형태), 좋아요수(정수형태)], 조회수(정수형태)
//좋아요 리스트(좋아요한 사용자 프로필 사진(클래스따로), 좋아요한 사용자 닉네임(클래스따로))(리스트타입), 
//댓글 리스트 (작성자 프로필 사진, 작성자의 닉네임, 댓글 작성 지난 기간, 댓글 내용)(리스트타입)
public class Board {

	private int boardNumber; //사용자가 지정하는게 아니고 순차적으로 DB에 저장
	private String boardImageUrl; //사용자 입력 , 받아도 되고 아니어도 되게
	private String writerEmail; //작성자를 프로그램은 모른다. 이때 토큰이 넘어가게한다 로그인 한 사용자만 쓸수있게
	private String writerNickname; //writerEmail만 받으면 저장하고 있는 리스트 테이블에서 조건 검색하면 write관련해 다 나온다
	private String writerProfileImageUrl;
	private String writeDate; //우리가 지정
	private String title; //사용자 입력
	private String content; //사용자 입력 -> BoardApplication에 적용? POST_BOARD
	
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

	public Board(PostBoardDto dto, User user) {
		Date now = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd");
		
		this.boardNumber = ++BoardRepository.index; //보드 번호는 BoardRepository에서 만든다
		this.boardImageUrl = dto.getBoardImageUrl();
		this.writerEmail = user.getEmail();
		this.writerNickname = user.getNickName();
		this.writerProfileImageUrl = user.getProfileImageUrl();
		this.writeDate = simpleDateFormat.format(now);//생성하는 날짜 지정
		this.title = dto.getTitle();
		this.content = dto.getContent();
		this.viewCount = 0;
		this.likeList = new ArrayList<>(); //처음 글 생성하면 빈 리스트가 되므로
		this.commentList = new ArrayList<>();
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
	
	//조회수 증가 메서드 
	public void increasedViewCount() {
		this.viewCount++;
		
	}
	
	//수정하는 메서드
	public void patch(PatchBoardDto dto) {
		this.title = dto.getTitle();
		this.content = dto.getContent();
		this.boardImageUrl = dto.getBoardImageUrl();
	}
	
}
