package website.repository;

import java.util.ArrayList;
import java.util.List;

import website.entity.Board;

public class BoardRepository {

	public static int index = 0;
	private static List<Board> boardTable = new ArrayList<>();
	
	public Board save(Board board) {
		
		boolean isExist = false;
		
		for(int index = 0 ; index < boardTable.size() ; index++) {
			Board boardItem = boardTable.get(index);
			
			if(boardItem.getBoardNumber() == board.getBoardNumber()) {
				boardTable.set(index, board);
				isExist = true;
				break;
			}
		}
		if(!isExist) boardTable.add(board);
		return board;
	}
	
}
