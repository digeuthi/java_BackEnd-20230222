package chapter1.A_Variable;
//주석처리 해당설명 적고자 할때  한줄 주석 //부분 뒤에 주석처리
		/* 공간주석 부분주석 이 범위 안의 내용을 주석으로 인식*/
		/*
		 * 여러줄 주석 /*하고 엔터치면 이클립스에서 여러줄 주석으로 입력받음
		 */

//주석 단축키 ctrl + /

//코드를 작성하고 나면 반드시 저장!!!!!! ctrl + s 필수 필수

//1. 변수 (열려있는 상자)
//모든 프로그래밍 언어는 데이터를 보관할수 있는 변수가 존재
//데이터를 담을 수 있는 열려있는 상자

//변수는 반드시 선언 후 초기화 해야 사용이 가능
//선언 : 사용할 변수를 만드는 행위 
//초기화 : reset의 개념 아님. 변수에 초기 데이터를 저장하는 행위

public class Variable {
	//main 메서드 : 실행 시 실행되는 메서드
	// { } : 코드 블럭 - 여러줄의 코드를 하나로 묶어주는 역할
	public static void main(String[] args) {
		//변수 선언 방법
				// 데이터타입(상자 종류 선택) 변수명(상자의 이름 설정, 변수명을 지을때 직관적으로 알아볼수 있어야한다.) ;(코드끝남을 알려주기)
				// int n ; <<이런 식으로 변수 설정하면 나만 알 수 있기때문에 안된다!
				int numberVariable ; //변수는 소문자로 시작을 한다.
				
//				System.out.println(numberVariable);
				
				// 변수 초기화 방법
				// 변수명 = 데이터;
				numberVariable = 10; // 여기서 =은 왼쪽에 오른쪽을 대입한다는 뜻. 동등하다의 뜻 아니다.
				System.out.println(numberVariable);
				
				// 선언과 동시에 초기화
				// 데이터타입 변수명 = 데이터 ;
//				char characterVariable = 'a';
				
//				int number1 = 10 , number2 = 20 ; //동일한 타입의 경우 하나로 묶을수 있다 가능은 하나 실제로는 잘 쓰진 않는다.
				
				//변수 명명 규칙
				// 1. 첫자리가 숫자가 올 수 없다.
//					ex) int 1number ;
				// 2. 특수문자를 연산자로 쓰지 않는 특수문자만 사용가능 -> $나 _ 정도 특수문자 안쓰는게 제일 좋다
				// 3. 같은 코드 블럭 내에 이미 선언한 변수명은 사용 불가능
					// 1~3은 컴파일러가 오류를 내기때문에 사용 안하는 것
				// 4. (개발자들 내 암묵적 규칙) java의 변수는 lowerCamelCase 명명 규칙을 사용
					// 	lowerCamelCase
					// 	첫 문자는 소문자로 시작하고, 띄어쓰기는 제거, 다음에 오는 문자를 대문자로 작성
					// Class 명명에서는 UpperCamelCase로 사용
				

	}

}