package board.service;

import java.util.List;

import board.common.constant.ResponseMessage;
import board.dto.request.board.PatchBoardDto;
import board.dto.request.board.PostBoardDto;
import board.dto.response.ResponseDto;
import board.dto.response.board.GetBoardListResponseDto;
import board.dto.response.board.GetBoardResponseDto;
import board.dto.response.board.PatchBoardResponseDto;
import board.dto.response.board.PostBoardResponseDto;
import board.entity.Board;
import board.entity.User;
import board.repository.BoardRepository;
import board.repository.UserRepository;

public class BoardService {
	
	private BoardRepository boardRepository;
	private UserRepository userRepository;
	public BoardService() {
		boardRepository = new BoardRepository();
		userRepository = new UserRepository();
	}
	
	public ResponseDto<PostBoardResponseDto> postBoard(PostBoardDto dto){
		
		PostBoardResponseDto data = null; //반환할 것 미리 만들어둠
		
		String email = dto.getWriterEmail(); //사용자로부터 입력받은 이메일 가져오기
		User user = userRepository.findByEmail(email);/*유저 레포지토리에서 받아옴*/ 
		if(user == null) return new ResponseDto<>(false, ResponseMessage.NOT_EXIST_USER, null);
		
		Board board = new Board(dto, user);
		boardRepository.save(board); //boardRepository에 save만들기
		
		data = new PostBoardResponseDto(board);
		return new ResponseDto<>(true, ResponseMessage.SUCCESS, data);
	}
	
	public ResponseDto<List<GetBoardListResponseDto>> getBoardList(){
		
		List<GetBoardListResponseDto> data = null;
		//검증없이 바로 전달
		List<Board> boardList = boardRepository/*접근할수 있는거 만들기*/.findBy();
		
		//List<Board>이걸 List<GetBoardListResponseDto>로 바꿔줘야한다
		//GetBoardListResponseDto에 구현
		data = GetBoardListResponseDto.copyList(boardList);
		return new ResponseDto<>(true, ResponseMessage.SUCCESS, data);
	}
	
	public ResponseDto<GetBoardResponseDto> getBoard(int boardNumber){
		
		GetBoardResponseDto data = null;
		
		Board board = boardRepository.findByBoardNumber(boardNumber);
		if(board == null) return new ResponseDto<>(false, ResponseMessage.NOT_EXIST_BOARD, null);
		
		//조회수 보면 올라가는것
		//board.setViewCount(board.getViewCount() + 1 );
		board.increasedViewCount();//위에꺼 깔끔하게 정리
		boardRepository.save(board);
		
		data = new GetBoardResponseDto(board);
		return new ResponseDto<>(true, ResponseMessage.SUCCESS, data);
	}
	
	//메서드 선언
	public ResponseDto<PatchBoardResponseDto> patchBoard(PatchBoardDto dto){
		
		PatchBoardResponseDto data = null;
		
		return new ResponseDto<>(true, ResponseMessage.SUCCESS,data);
	}
}
