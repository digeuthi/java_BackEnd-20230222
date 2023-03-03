package chapter1.B_Constant;

//2. 상수 (데이터를 넣은 다음 밀봉한 상자 : 값을 선언하고 나면 변경 불가)
//변수와 마찬가지로 데이터를 보관할 수 있는 공간
//단, 상수는 한번 초기화하면 변경이 불가능
//일반적으로 값을 변경하면 안되는 데이터를 지정할 때나
//데이터의 이름을 부여하고 싶을 때 사용

//상수 또한 선언 후 초기화가 반드시 이루어져야 함

public class Constant {

public static void main(String[] args) {
	// 상수 선언 방법
	//final 데이터타입 상수명 = 데이터;
	
//	int age = 10; //수정이 되면 안되는 값. -> 여러 코드를 작성하다보면 실수로 agePercent 해야하는데 age만 적고변경이 되는 경우 생김 -> 이럴때 상수로 지정
//	int agePercent = 10;
//	age = agePercent * 10 ;
//	
//	int size = 1920 * 1080; //(모니터 해상도값을 익숙하게 알면 바로 받아들일수 있지만, 모르는 사람이 본 경우 모를수 있다 -> 이름을 지정해서 표현하면 모두 알수 있다.)
//	int width = 1920;
//	int height = 1080;
//	size = width * height;
	
	// 상수 선언 방법
	// final 데이터타입 상수명;
	final int NUMBER; //상수는 전부 대문자로 명명 UPPER_SNAKE_CASE / 노란 밑줄은 한번도 쓰이지 않아서 뜨는거임.
//	System.out.println(NUMBER); 실행이 안된다
	
	// 상수 초기화 방법
	// 상수명 = 데이터 ;
	NUMBER = 10;
	
	// 선언과 동시에 초기화 
	// final 데이터타입 상수명 = 데이터 ;
	final double /*실수 저장 데이터타입*/ PIE = 3.14;
	
	//상수는 한번 초기화 되면 변경 불가능
//	PIE = 3.1415; -> 변경하려고 하면 오류가 뜬다
	
	// 상수 명명 규칙
	// 1~3 변수와 동일
	// 4. java의 상수는 UPPER_SNAKE_CASE 명명 규칙을 사용
		// UPPER_SNAKE_CASE : 모든 문자를 대문자로 작성하고 띄어쓰기를 _로 표기
	final/*상수선언*/ int/*데이터 타입*/ WINDOW_WIDTH/*상수명*/ =/*오른쪽 값을 데이터에 대입하겠다*/ 1920/*1920이라는 리터럴상수*/;
	final int WINDOW_HEIGHT = 1080;
	
//	int x = 0;
//	int y = x + 10; //y x 는 변수, 10은 상수 데이터 그 자체 = 상수 
	
	int size = WINDOW_WIDTH * WINDOW_HEIGHT;
	
	// 리터럴 상수
	// 프로그래밍 언어에는 데이터를 담아두는 상수와 리터럴 상수가 존재
	// 리터럴 상수는 데이터 그 자체를 의미한다
}

} 