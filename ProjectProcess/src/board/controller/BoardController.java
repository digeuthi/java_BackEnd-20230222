package board.controller;

import board.dto.request.board.PostBoardDto;
import board.service.BoardService;

public class BoardController {

	private BoardService boardService;
	
	
	public BoardController() {
		boardService = new BoardService();
		
	}
	//게시물 입력받은것 검증
	public void postBoard(PostBoardDto dto) {
		//두가지의 검증 , 제목하고 내용은 필수로 입력받고
		//이미지는 필수까지는 아니다! 누가 작성했는지도 반드시 입력!
		//게시물을 작성하는 행위는 로그인이 되어있는 사람만 작성하게 함 : 인증 및 인가
		//제목 내용에 대한 검증, 로그인하고 하는지 검증
		//PostBoardDto에 메서드 생성
	}
	
}
