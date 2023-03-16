package Example;

import java.util.Scanner;

class SignUpDto{
	String userId;
	String userPassword;
	String userPasswordCheck;
	String userName;
	
	//사용자 입력층이 있고 데이터가 저장하는 층이 있는데 그 층들을 Dto..?
}

//회원가입 프로세스 구현
// 모든 프로세스 첫번째 모두 입력되었는지!☆
// 아이디 중복 확인
// 비밀번호가 동일한지 
// (비밀번호 패턴확인) 지금은 어려워서 안함.

public class SignUp {
	
	// 입력
	// 아이디, 비밀번호, 비밀번호 확인, 이름
	
	public static void main(String[] args) {
		//3번의 아이디 중복체크를 위한 미리 만들어두는 아이디 (모두 변수로 설정해도 좋지만 관리에 용이하게 스트링 배열로 만들기)
		String[] idList = {"qwer" , "asdf", "zxcv"}; //다차원 배열, 문자열은 기본데이터 타입아니다. 
		
		// 1. 사용자로부터 아이디, 패스워드, 패스워드 확인, 이름을 입력 받음
		// 변수 명명할때 꼭 명명 규칙 따르기! lowerCamelCase 사용하기
		Scanner scanner = new Scanner(System.in);
		
		SignUpDto dto = new SignUpDto();
		
		
//		System.out.println("아이디 : ");
//		String userId = scanner.nextLine();
//		System.out.println("패스워드 : ");
//		String userPassword = scanner.nextLine();
//		System.out.println("패스워드 확인 : ");
//		String userPasswordCheck = scanner.nextLine();
//		System.out.println("이름 : ");
//		String userName = scanner.nextLine();
		
		//클래스 사용시
		System.out.println("아이디 : ");
		dto.userId = scanner.nextLine();
		
		System.out.println("패스워드 : ");
		dto.userPassword = scanner.nextLine();
		
		System.out.println("패스워드 확인 : ");
		dto.userPasswordCheck = scanner.nextLine();
		
		System.out.println("이름 : ");
		dto.userName = scanner.nextLine();
		
//		System.out.println(userId + userPassword + userPasswordCheck + userName);
		
		// 2. 모두 입력받았는지 검증
		// String.isBlank() : 문자열이 비었거나, 띄어쓰기만으로 구성됐을때 true 반환, 아니면 false
		// **.isEmpty는 공백도 입력된걸로 인식한다.
		
//		if (userId.isBlank() || userPassword.isBlank() || 
//				userPasswordCheck.isBlank() || userName.isBlank()) { //변수들중 하나라도 비면 F로 해야하니까 or연산자로!
//			System.out.println("모두 입력하세요.");
//			return; 
//		}
		
		//클래스 사용시
		if (dto.userId.isBlank() || dto.userPassword.isBlank() || 
				dto.userPasswordCheck.isBlank() || dto.userName.isBlank()) { //변수들중 하나라도 비면 F로 해야하니까 or연산자로!
			System.out.println("모두 입력하세요.");
			return; 
		}
		
		// 3. 아이디 중복 체크 (선행적으로 이미 존재하는 아이디가 있어야한다!)
		// (실제로 이렇게 하진 않음.) for문이랑 for each문으로 비교
		// for문 배열 접근할때 많이 쓴다
		
		// 3-1 일반 for문 사용 //직접접근
		// 반복문 돌면서 값을 바꿔야한다면 for문 사용해야한다.
//		for (int index = 0 ; index < idList.length ; index++) {
//			if(userId.equals(idList[index])) { //idList[i].equals(userId)와 읽는게 조금 다르다 -> 뭐지
//				System.out.println("중복되는 아이디 입니다.");
//				return;
//			}
//		}
		
		// 3-2  for each 문 사용 //복사 
		// 단순 읽기만 하고 변경하지 않는다면 for each문이 더 깔끔.
	
//		for (String id : idList) {
//			if(userId.equals(id)) {
//				System.out.println("중복되는 아이디 입니다.");
//				return; //이걸 안하면 끝 안나고 밑에읽어지게 된다 // '중복되는 아이디입니다. 성공' 이렇게 출력됨!
//			}
//		}
		
		//클래스 사용시
		for (String id : idList) {
			if(dto.userId.equals(id)) {
				System.out.println("중복되는 아이디 입니다.");
				return; //이걸 안하면 끝 안나고 밑에읽어지게 된다 // '중복되는 아이디입니다. 성공' 이렇게 출력됨!
			}
		}
		
		// 4. 비밀번호 확인
//		if (!userPassword.equals(userPasswordCheck)) { //비정상을 if문 안에 들어오게 해야한다!
//			System.out.println("비밀번호가 서로 다릅니다.");
//			return;
//		}
//		System.out.println("성공");
		
		//클래스 사용시
		if (!dto.userPassword.equals(dto.userPasswordCheck)) { //비정상을 if문 안에 들어오게 해야한다!
			System.out.println("비밀번호가 서로 다릅니다.");
			return;
		}
		System.out.println("성공");
		
		//다른 타입의 변수를 하나로 묶어서 관리 : 클래스 (객체지향 언어 자바의 기본)
	}
	// 결과
	// 성공, 실패 (모두 입력하지 않았을때, 아이디가 중복 될 때, 비밀번호가 서로 다를때)
}
