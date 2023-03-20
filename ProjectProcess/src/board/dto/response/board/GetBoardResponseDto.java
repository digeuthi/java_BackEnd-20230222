package board.dto.response.board;

import java.util.List;

import board.entity.Board;
import board.entity.Comment;
import board.entity.Like;

public class GetBoardResponseDto {

	
	private int boardNumber;
	//필요한걸 전부 다 반환
	private String title;
	private String content;
	private String boardImageUrl;
	private String writerEmail;
	private String writerProfileImageUrl;
	private String writerNickname;
	private String writeDtae;
	private int likeCount;
	private List<Like> likeList;
	private int commentCount;
	private List<Comment> commentList; //화면상 필요한것 
	
	//보드 넘버에 대한 정보가 빠져있다. 그 회원의 수정 삭제를 해야 하는것이므로 그 게시글의 보드넘버가 필요하다
	//OCP 확장에는 개방적이고 수정에는 폐쇄적이어야한다. 클래스를 상속받는걸 만들어서 그 상속받은 클래스에
	//추가적으로 적용하게 된다.RsP 리스코프 치환원칙에 따라서 가능하게 된다.?
	
	//기능이필요한것 : 본인작성글만 더보기 아이콘있음 
	//누구 게시물인지에 대한 구분자가 필요! : writerEmail 추가해주기
	
	public GetBoardResponseDto() {}

	public GetBoardResponseDto(int boardNumber, String title, String content, String boardImageUrl, String writerEmail,
			String writerProfileImageUrl, String writerNickname, String writeDtae, int likeCount, List<Like> likeList,
			int commentCount, List<Comment> commentList) {
		super();
		this.boardNumber = boardNumber;
		this.title = title;
		this.content = content;
		this.boardImageUrl = boardImageUrl;
		this.writerEmail = writerEmail;
		this.writerProfileImageUrl = writerProfileImageUrl;
		this.writerNickname = writerNickname;
		this.writeDtae = writeDtae;
		this.likeCount = likeCount;
		this.likeList = likeList;
		this.commentCount = commentCount;
		this.commentList = commentList;
	}
	
	public GetBoardResponseDto(Board board) {
		this.boardNumber = board.getBoardNumber();
		this.title = board.getTitle();
		this.content = board.getContent();
		this.boardImageUrl = board.getBoardImageUrl();
		this.writerEmail = board.getWriterEmail();
		this.writerProfileImageUrl = board.getWriterProfileImageUrl();
		this.writerNickname = board.getWriterNickname();
		this.writeDtae = board.getWriteDate();
		this.likeCount = board.getLikeList().size();
		this.likeList = board.getLikeList();
		this.commentCount = board.getCommentList().size();
		this.commentList = board.getCommentList();
		
	}

	public int getBoardNumber() {
		return boardNumber;
	}

	public void setBoardNumber(int boardNumber) {
		this.boardNumber = boardNumber;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getBoardImageUrl() {
		return boardImageUrl;
	}

	public String getWriterEmail() {
		return writerEmail;
	}

	public String getWriterProfileImageUrl() {
		return writerProfileImageUrl;
	}

	public String getWriterNickname() {
		return writerNickname;
	}

	public String getWriteDtae() {
		return writeDtae;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public List<Like> getLikeList() {
		return likeList;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setBoardImageUrl(String boardImageUrl) {
		this.boardImageUrl = boardImageUrl;
	}

	public void setWriterEmail(String writerEmail) {
		this.writerEmail = writerEmail;
	}

	public void setWriterProfileImageUrl(String writerProfileImageUrl) {
		this.writerProfileImageUrl = writerProfileImageUrl;
	}

	public void setWriterNickname(String writerNickname) {
		this.writerNickname = writerNickname;
	}

	public void setWriteDtae(String writeDtae) {
		this.writeDtae = writeDtae;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public void setLikeList(List<Like> likeList) {
		this.likeList = likeList;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}



	@Override
	public String toString() {
		return "GetBoardResponseDto [boardNumber=" + boardNumber + ", title=" + title + ", content=" + content
				+ ", boardImageUrl=" + boardImageUrl + ", writerEmail=" + writerEmail + ", writerProfileImageUrl="
				+ writerProfileImageUrl + ", writerNickname=" + writerNickname + ", writeDtae=" + writeDtae
				+ ", likeCount=" + likeCount + ", likeList=" + likeList + ", commentCount=" + commentCount
				+ ", commentList=" + commentList + "]";
	}

	
	
}


