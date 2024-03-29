package board.service;

import java.util.List;

import board.common.constant.ResponseMessage;
import board.dto.request.board.PatchBoardDto;
import board.dto.request.board.PostBoardDto;
import board.dto.response.ResponseDto;
import board.dto.response.board.DeleteBoardResponseDto;
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
		//컨텐츠 입력하는것과 수정하는 것의 차이는 수정 검증이 들어가는 정도의 차이라 비슷하다!
		PatchBoardResponseDto data = null;
		
		//사용자 가져오기
		String email = dto.getEmail();
		int boardNumber = dto.getBoardNumber();
		User user = userRepository.findByEmail(email); //이메일 찾아옴
		if(user == null) return new ResponseDto<>(false,ResponseMessage.NOT_EXIST_USER, null);
		
		Board board = boardRepository.findByBoardNumber(boardNumber);
		if(board ==null) return new ResponseDto<>(false, ResponseMessage.NOT_EXIST_BOARD,null);
		
		if(!board.getWriterEmail().equals(email)) return new ResponseDto<>(false, ResponseMessage.NOT_PERMISSION ,null);
		
		//검증 다하고 나서 수정작업 //dto에 입력한 값들을 board에 대입하는 메서드 만들어줌
		board.patch(dto);
		boardRepository.save(board); //수정한 후에 다시 레포지토리에 저장해줌
		data = new PatchBoardResponseDto(board);
		
		return new ResponseDto<>(true, ResponseMessage.SUCCESS,data);
	}
	
	public ResponseDto<List<DeleteBoardResponseDto>> deleteBoard(int boardNumber, String email){
		
		//반환해줄것 만들기
		List<DeleteBoardResponseDto> data = null;
		
		//존재하는지, 해당유저가 존재하는지 검증
		//존재하면 그 게시물 작성자가 작성자 이메일과 동일하지 검증
		User user = userRepository.findByEmail(email);
		if(user == null) return new ResponseDto<>(false, ResponseMessage.NOT_EXIST_USER, null);
		
		Board board = boardRepository.findByBoardNumber(boardNumber);
		if(board == null) return new ResponseDto<>(false, ResponseMessage.NOT_EXIST_BOARD, null);
		if(!board.getWriterEmail().equals(email))return new ResponseDto<>(false, ResponseMessage.NOT_PERMISSION, null);
		
		boardRepository.deleteByBoardNumber(boardNumber); //삭제 진행
		
		List<Board> boardList = boardRepository.findBy();
		data = DeleteBoardResponseDto.copyList(boardList);
		return new ResponseDto<>(true, ResponseMessage.SUCCESS,data);
		
	}
}
