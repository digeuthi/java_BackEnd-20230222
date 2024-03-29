package board.dto.response.board;

import java.util.List;

import board.entity.Board;
import board.entity.Comment;
import board.entity.Like;

public class PatchBoardResponseDto {

	//수정후 반환에 대한 dto
	//get을 한 작업이 아닐적에 반환을 뭘 해줄지 생각을 해봐야 한다.
	//쓰기 수정하기 삭제하기 이 작업은 작업의 성공여부만 반환하면된다 : 딱 기능만 수행하고자 할때
	//이때 다른 작업이 이어지게 될 적에 반환을 이어지는쪽으로 반환할지가 중요.
	//기능만 수행시 : 아주 명확. 메서드의 기능이 명확해진다. 성공 실패 여부만 반환해준다. 좀더 유연하게 작업을 할수 있게 된다.
	//수정을 하고나서 다시 원래 화면으로 돌아가겠다고 수정한 화면의 리스트만 가져오면 되서 간단해지지만 프론트의 경우 일이 많이 어려워진다.
	//다음 단계 생각하고 반환 시 : 프론트 엔드가 편하다. / 단점은 특정 패치보드메서드가 하나만 수행을 하기에는 의존되어있게 된다. 수정이 복잡해짐
	//오픈 API라면 그 기능에대한것만 반환해주면 되고, 특정 제품을 위한거라면 두번째것이 더 편하게 된다. 우리는 두번째 방법으로 진행
	//GetBoardResponseDto의 인스턴스 값 다 가져온다. 수정된 화면 자체를 반환해줘야하니까
	
	private int boardNumber;
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
	private List<Comment> commentList;
	
	public PatchBoardResponseDto() {}

	public PatchBoardResponseDto(int boardNumber, String title, String content, String boardImageUrl,
			String writerEmail, String writerProfileImageUrl, String writerNickname, String writeDtae, int likeCount,
			List<Like> likeList, int commentCount, List<Comment> commentList) {
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
	
	public PatchBoardResponseDto(Board board) { //getBoardResponseDto의 다른 생성자 하나 그대로 가져옴
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

	public void setBoardNumber(int boardNumber) {
		this.boardNumber = boardNumber;
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
		return "PatchBoardResponseDto [boardNumber=" + boardNumber + ", title=" + title + ", content=" + content
				+ ", boardImageUrl=" + boardImageUrl + ", writerEmail=" + writerEmail + ", writerProfileImageUrl="
				+ writerProfileImageUrl + ", writerNickname=" + writerNickname + ", writeDtae=" + writeDtae
				+ ", likeCount=" + likeCount + ", likeList=" + likeList + ", commentCount=" + commentCount
				+ ", commentList=" + commentList + "]";
	}
	
	
	
}
