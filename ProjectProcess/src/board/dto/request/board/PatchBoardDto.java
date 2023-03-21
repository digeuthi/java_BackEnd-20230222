package board.dto.request.board;

public class PatchBoardDto {

	//게시물 수정 관련 dto
	private int boardNumber;//게시물번호
	private String title;
	private String content;
	private String boardImageUrl;
	//수정을 하려는 사람이 권한이 있는지 아닌지 판단을 해야한다. 이메일 요소 필요하다
	private String email;
	
	public PatchBoardDto () {}

	public PatchBoardDto(int boardNumber, String title, String content, String boardImageUrl, String email) {
		super();
		this.boardNumber = boardNumber;
		this.title = title;
		this.content = content;
		this.boardImageUrl = boardImageUrl;
		this.email = email;
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

	public String getEmail() {
		return email;
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

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "PatchBoardDto [boardNumber=" + boardNumber + ", title=" + title + ", content=" + content
				+ ", boardImageUrl=" + boardImageUrl + ", email=" + email + "]";
	}
	//검증할것 미리 지정
	public boolean valid() {
		boolean result = 
				this.boardNumber <= 0 ||
				this.title.isBlank()||
				this.content.isBlank();
		return result;
	}
	
	public boolean auth() {
		boolean result =
				this.email.isBlank();
		return result;
	}
	
}