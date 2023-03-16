package chapter2.C_For;

//for 반복문
//규칙이 있는 작업을 반복하는 '제어문'
//일반적으로 반복 '횟수'가 정해져 있을 때 사용하는 반복문
//(배열의 '길이'만큼 사용) 반복할 길이가 정해져있지 않고 조건만 반복시 while 사용

public class For {

	public static void main(String[] args) {
		// 반복문을 사용하는 이유
		// 길이가 5인 int 타입의 배열(intArray5)을 선언 및 생성
		int[] intArray5 /*배열 선언*/ = new int[5]; /*배열 생성*/
		//intArray5의 각 인덱스를 1~5까지 값을 초기화 //배열명[인덱스값] = 할당 값 ;
		intArray5[0] = 1;
		intArray5[1] = 2;
		intArray5[2] = 3;
		intArray5[3] = 4;
		intArray5[4] = 5;
		
		//코드가 중복되는걸 최소화 해주는게 좋다!
		
		//for 반복문
		// 특정한 변수가 증감하며 조건에 부합하는 동안 반복하는 반복문
		// 사용방법 :
		// for(변수 선언 혹은 초기화 ; 조건 ; 증감식){ 실행할 코드 }
		
		// 변수 선언 혹은 초기화 : 반복문을 위해 사용할 변수를 선언 혹은 초기화
		// 조건 : 반복을 계속하기 위한 조건, 해당 조건이 true이면 반복, false면 탈출(종료)
		// 실행할 코드 : 조건이 true일 때 실행할 코드
		
		for (int index = 0/*시작값*/ /*실행a*/ ; index < 5/*조건*/ /*실행b*/ ; index++/*실행할 코드가 끝난다음 실행*//*실행c*/) { 
			/*보통 i는 index를 나타낸다*/
			//실행할 코드 /*실행d*/ 실행순서는 a b d c b d c b d c ... 순서
			// 1. index = 0 / 1
			intArray5[index] = index + 1;
			// 1. index = 1 / 2
//			intArray5[index] = index + 1;
//			// 1. index = 2 / 3
//			intArray5[index] = index + 1;
//			intArray5[index] = index + 1;
//			intArray5[index] = index + 1;
		}
		
		// for문의 경우 코드블럭에 오는 실행할 코드가 한 구문이면
		// {}를 제거할 수 있다.
		for (int index = 0 ; index < 5 ; index++) 
			intArray5[index] = index + 1;
		
		//별찍기 하지말래.. 왜! 열심히 했는데요
		
		// foreach 반복문
		// '배열'의 요소값을 직접 '읽고자' 할 때 배열을 반복하면서
		// 요소를 하나씩 '복사'해서 사욜할 수 있음
		// 실제 저장된 메모리 주소의 값이 변경되는게 아니라 복사된 값을 사용하는 것
		// 사용 방법 : for (배열 '요소'의 데이터타입 변수명 : 접근(사용)할 배열) { 실행할 코드 }
		
//		System.out.println(intArray5); /*메모리 주소값 출력*/
//		System.out.println(intArray5[0]); //요소 값을 출력할때는 이렇게! 
//		System.out.println(intArray5[1]);
//		System.out.println(intArray5[2]);
//		System.out.println(intArray5[3]);
//		System.out.println(intArray5[4]); //처음과 끝, 어떤 규칙으로 변하고 있는지 찾아주기
		
		System.out.println("=== 일반 for문 ===");
		
		for (int index = 0 ; index < 5 /*<=4 도 가능*/ /*5의 의미는 배열의 길이*/; index++) {
			System.out.println(intArray5[index]); 
			intArray5[index] = 10; //직접 배열의 값을 바꾸는 것
		}
		
		for (int index = 0 ; index < intArray5.length /*배열의 길이*/ ; index++) {
			System.out.println(intArray5[index]); 
			//intArray5[index] = 10;
		}
		
		//배열의 요소를 꺼내오면서 사용하기 위해서 간단한 코드를 적기위한 방법 -> foreach
		
//		for(int number : intArray5) {
//			System.out.println(number); 
//		}
		
		//for(int number : intArray5) System.out.println(number); 
		
		System.out.println("=== foreach 문 ===");
		
		for (int index = 0 ; index < intArray5.length ; index++) 
			intArray5[index] = index +1;
		
//		for (int index = 0 ; index < intArray5.length /*배열의 길이*/ ; index++) {
//			System.out.println(intArray5[index]); 
//			intArray5[index] = 10;
//		}
		
		for(int number : intArray5) {
			System.out.println(number);
			number = 10;
		}
		
		for(int number : intArray5) System.out.println(number); //위의 식에서 number를 10으로 바꿨지만 변하지 않는다..?
		//foreach는 배열의 값을 복사해서 접근하기때문에 변수의 값을 바꾸어도 기존 메모리 장소에 저장된 배열의 값에는 영향주지 않는단건가
		
		
		//for문과 foreach문의 차이 다시!
	}

}