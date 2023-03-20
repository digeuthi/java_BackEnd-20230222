package board.dto.response.board;

import java.util.ArrayList;
import java.util.List;

import board.entity.Board;

public class GetBoardListResponseDto {

	//하나의 요소값 넣어주기.. 최신 게시물화면이 가져와야할것
	//댓글수 좋아요수 조회수  .. 8개 가져와야함.
	
	private int boardNumber;
	private String writerProfileImageUrl;
	private String writerNickname;
	private String writerDate;
	private String title;
	private String content;
	private String boardImageUrl;
	private int commentCount;
	private int likeCount;
	private int viewCount;
	
	//화면에 보이는것만 데이터로 관리하면 되나? 기능상에 대한것도 봐야한다
	//게시물을 클릭하면 그게 뭔지 보여줘야하니까 게시글을 구분하는것도 구현해줘야한다
	//특정 게시물 정의해주는게 boardNumber !
	
	public GetBoardListResponseDto() {}

	public GetBoardListResponseDto(int boardNumber, String writerProfileImageUrl, String writerNickname,
			String writerDate, String title, String content, String boardImageUrl, int commentCount, int likeCount,
			int viewCount) {
		super();
		this.boardNumber = boardNumber;
		this.writerProfileImageUrl = writerProfileImageUrl;
		this.writerNickname = writerNickname;
		this.writerDate = writerDate;
		this.title = title;
		this.content = content;
		this.boardImageUrl = boardImageUrl;
		this.commentCount = commentCount;
		this.likeCount = likeCount;
		this.viewCount = viewCount;
	}

	public GetBoardListResponseDto(Board board) {
		this.boardNumber = board.getBoardNumber();
		this.writerProfileImageUrl = board.getWriterProfileImageUrl();
		this.writerNickname = board.getWriterNickname();
		this.writerDate = board.getWriteDate();
		this.title = board.getTitle();
		this.content = board.getContent();
		this.boardImageUrl = board.getBoardImageUrl();
		this.commentCount = board.getCommentList().size();
		this.likeCount = board.getLikeList().size();
		this.viewCount = board.getViewCount();
	}
	
	public int getBoardNumber() {
		return boardNumber;
	}

	public String getWriterProfileImageUrl() {
		return writerProfileImageUrl;
	}

	public String getWriterNickname() {
		return writerNickname;
	}

	public String getWriterDate() {
		return writerDate;
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

	public int getCommentCount() {
		return commentCount;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setBoardNumber(int boardNumber) {
		this.boardNumber = boardNumber;
	}

	public void setWriterProfileImageUrl(String writerProfileImageUrl) {
		this.writerProfileImageUrl = writerProfileImageUrl;
	}

	public void setWriterNickname(String writerNickname) {
		this.writerNickname = writerNickname;
	}

	public void setWriterDate(String writerDate) {
		this.writerDate = writerDate;
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

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	@Override
	public String toString() {
		return "GetBoardListResponseDto [boardNumber=" + boardNumber + ", writerProfileImageUrl="
				+ writerProfileImageUrl + ", writerNickname=" + writerNickname + ", writerDate=" + writerDate
				+ ", title=" + title + ", content=" + content + ", boardImageUrl=" + boardImageUrl + ", commentCount="
				+ commentCount + ", likeCount=" + likeCount + ", viewCount=" + viewCount + "]";
	}
	
	
	public static List<GetBoardListResponseDto> copyList(List<Board> boardList){
		List<GetBoardListResponseDto> result = new ArrayList<>();
		for(Board board : boardList) { //하나씩 꺼내오며 돌면서 
			GetBoardListResponseDto item = new GetBoardListResponseDto(board);
			//board에서 꺼내온 값을 item에 복사해서 집어넣기
			result.add(item);
		}
		return result;
		
	}
	
	
	
}
