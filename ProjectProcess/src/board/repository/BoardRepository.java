package board.repository;

import java.util.ArrayList;
import java.util.List;

import board.entity.Board;

public class BoardRepository {

	public static int index = 0;
	
	private static List<Board> boardTable = new ArrayList<>();
	
	public Board save(Board board) {
		boardTable.add(board);
		return board;
	}
	
	public List<E> findBy(){
		
	}
}
