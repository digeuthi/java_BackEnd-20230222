package website.service;

import website.dto.request.board.PostBoardDto;
import website.dto.response.ResponseDto;
import website.dto.response.board.PostBoardResponseDto;
import website.repository.BoardRepository;
import website.repository.UserRepository;

public class BoardService {

	private BoardRepository boardRepository;
	private UserRepository userRepository;
	
	public BoardService() {
		boardRepository = new BoardRepository();
		userRepository = new UserRepository();
	}
	
	public ResponseDto<PostBoardResponseDto> postBoard (PostBoardDto dto){
		
		PostBoardResponseDto data = null;
		
	}
}
