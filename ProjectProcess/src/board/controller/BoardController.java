package board.controller;

import java.util.List;

import board.common.constant.HttpStatus;
import board.dto.request.board.PatchBoardDto;
import board.dto.request.board.PostBoardDto;
import board.dto.response.ResponseDto;
import board.dto.response.board.GetBoardListResponseDto;
import board.dto.response.board.GetBoardResponseDto;
import board.dto.response.board.PatchBoardResponseDto;
import board.dto.response.board.PostBoardResponseDto;
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
		//PostBoardDto에 메서드 생성 //Http 어쩌고에 UNAUTHORIZED 생성
		if(dto.auth()) {
			System.out.println(HttpStatus.UNAUTHORIZED);
			return; //로그인 인증 
		}
		if(dto.vaild()) {
			System.out.println(HttpStatus.BAD_REQUEST);
			return; //필수로 입력해야할 값이 입력되지 않았거나 타입이 맞지 않을때 출력
		}
		//?에 이 서비스의 결과가 기능을 반환해주는 걸 입력한다
		//PostBoardResponseDto 생성, 생성자에 board의 값을 가져오는 생성자 생성
		ResponseDto<PostBoardResponseDto> response = boardService.postBoard(dto);
		System.out.println(response.toString());
	}
	
	public void getBoardList() {
		ResponseDto<List<GetBoardListResponseDto>> response =
				boardService.getBoardList(); //GetBoardListResponseDto만들어주기
		System.out.println(response.toString());
	}
	
	public void getBoard(int boardNumber) {
		
		//입력 검증
		if(boardNumber <= 0) {
			System.out.println(HttpStatus.BAD_REQUEST);
			return;
		}    
		ResponseDto<GetBoardResponseDto> response = boardService.getBoard(boardNumber);
		System.out.println(response.toString());
	}
	
	//검증처리
	public void patchBoard(PatchBoardDto dto) {
		if(dto.auth()) {
			System.out.println(HttpStatus.UNAUTHORIZED);
			return;
		}
		if(dto.valid()) {
			System.out.println(HttpStatus.BAD_REQUEST);
			return;
		}
		
		ResponseDto<PatchBoardResponseDto> response =
				boardService.patchBoard(dto);
		System.out.println(response.toString());
	}
	
	
	
}
