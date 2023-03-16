package Example;
import java.util.Scanner;

//로그인 프로세스 구현
public class SignIn {
	
	// 입력
	// 아이디, 비밀번호
	public static void main(String[] args) {
		final String ID = "qwer1234" ; //상수는 대문자로!
		final String PASSWORD = "qwer1234" ; 
		
		//1. 사용자로부터 아이디와 비밀번호 입력받음
		Scanner scanner = new Scanner(System.in);
		System.out.println("아이디와 비밀번호를 입력하세요.");
		String userId = scanner.nextLine();
		String userPassword = scanner.nextLine();
		
		//2. ☆모두 입력 여부 확인 , 입력 안되었다면 모두 입력하라고 출력 (아이디와 비밀번호 입력했는지 검증)
		// userId 와 userPassword 변수가 비었는지 확인
		// 문자열에서 값이 비었는지 확인하는 기능(메서드)이 존재
		// string(변수).isEmpty() : 비었으면 true, 아니면 false
//		if (userId.isEmpty()) { //큰 흐름에서 벗어나는게 if에서 실행되게 하면 깔끔
//			System.out.println("모두 입력하세요.");
//			//코드블럭내의 코드를 종료시키려면 break, 함수 스레드 자체를 종료는 return -> 클래스할때 설명
//			return;
//		} 
//		if(userPassword.isEmpty()) {
//			System.out.println("모두 입력하세요.");
//			return;
//		}
		//입력을 검증하는건 프로세스가 하나! 그리고 코드가 중복되는걸 피해야한다.->논리연산자 사용해서 하나로 만들기 &&는 곱하기연산, ||는 더하기연산
		if(userId.isEmpty() || userPassword.isEmpty()) { //같은 라인에 있다면 or로 묶어주기(세로정렬에서)
			System.out.println("모두 입력하세요.");
			return;
		}
		
//		if(userId.isEmpty()) { 
//			if(userPassword.isEmpty()) {
//			System.out.println("모두 입력하세요.");
//			return;
//		} ->이런식의 조건은 같은 라인의 조건이 아니기때문에 and로 묶어서 표현해야 한다.
		
		//변수에 저장한다 = 메모리 공간에 저장
		
		// 3. 사용가 입력값과 저장된 값이 같은지 '검증'(if로 해야된다) //저장소 값과 실제 입력값 비교
		// string.equals(비교대상) : 같으면 true, 다르면 false
		if(userId.equals(ID)/*== ID*/ && userPassword.equals(PASSWORD)) { // ==의 경우 기본 데이터타입에서 사용, String은 기본 데이터 타입이아니다! 
			//==말고 equals 사용.
			System.out.println("성공");
		} //정상결과를 if안에 넣으면 안된다! 프로세스상으로는 실패..!!
		  //비정상이 빠져나가는 루트로 if문에 엮여야한다.
		
		if(!userId.equals(ID) || !userPassword.equals(PASSWORD)) { //비정상경로를 하려면 전부 부정을 하면된다.
			System.out.println("로그인 정보가 일치하지 않습니다.");
			return; //메인 메소드가 종료가 된다. //void 반환타입인 경우 return하면 바로 종료지만
			//void타입이 아닌경우 반드시 return 반환값표시!
		}
		
		System.out.println("성공"); 		

	}
	// 결과
	// 성공, 실패(모두 입력하지 않았을 때, 정보가 일치하지 않을 때)
	
	// 로그인 실패할 적에 로그인 정보가 일치하지 않습니다.라고 요즘에는 뜬다
	// 옛날에는 아이디가 일치하지 않습니다 / 비밀번호가 일치하지 않습니다라고 떴는데 요즘은 바뀜.	

}
