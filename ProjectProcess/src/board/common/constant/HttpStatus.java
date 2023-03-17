package board.common.constant;

public interface HttpStatus {

	//인터페이스는 기본적으로 추상 메서드만 쓸수있다
		//변수를 담는 공간을 만들어줄수 있다 구현부로는 쓰지못하지만
		//상수를 선언해주려면 public static final 대문자 !
		public static final String BAD_REQUEST = "400 Bad Request";
		public static final String NOT_FOUND = "404 Not Found";
	
}