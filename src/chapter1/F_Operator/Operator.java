package chapter1.F_Operator;


//연산자
//산술연산자, 대입연산자, 비교연산자, 논리연산자, 삼항연산자
public class Operator {

	public static void main(String[] args) {
		//산술 연산자 //자바는 모든 기준이 위에서 아래로, 좌에서 우로 진행하기 때문에 좌항이 기준이다.
		
		//덧셈 연산자 : +
		//좌항에 우항을 더한 값은 반환한다 
		int addResult = 8 + 3;
		System.out.println(addResult);
		
		//뺄셈 연산자 : -
		//좌항에 우항을 뺀 값을 반환 
		int minusResult = 8 -3 ;
		System.out.println(minusResult);
		
		//곱셈 연산자 : *
		//좌항에 우항을 곱한 값을 반환
		int multiResult = 8 * 3 ;
		System.out.println(multiResult);
		
		//나눗셈 연산자 : / (나눈셈 연산자 영어 틀렸음, 강사님이 그냥 넘어감)
		//좌항에 우항을 나눈 값을 반환 , 몫을 반환하는게 X (int 타입으로 진행시 정수만을 반환하는거지 실수가 사라지는게 아니다)
		float float1 = 2.6666F;
		int number1 = (int) float1;
		System.out.println(number1);
		
		int remainderResult = 8 / 3 ; //int 타입이므로 정수형태로 출력
		System.out.println(remainderResult);
		
		double remainderResult2 = 8.0 / 3.0 ;
		System.out.println(remainderResult2); //double 타입으로 연산시 실수로 출력된다.
		
		//나머지 연산자 : %
		//좌항에 우항을 나눈 나머지를 반환
		int remainderResult3 = 8 % 3;
		System.out.println(remainderResult3);
		
		//정수와 정수를 연산하면 정수가 반환됨
		//실수와 정수를 연산하면 실수가 반환됨
		//실수와 실수를 연산하면 실수가 반환됨
		//결과를 받을적에 받아주는 타입이 어떻게 진행되는지 생각해서 지정해야한다
		
			//계산 해보기 
			System.out.println("실수와 정수의 계산 값 결과는?");
			double double1 = 8.0 / 3 ;
			System.out.println(double1);
		
		//☆증감연산자 : '변수' 자신을 1증가 혹은 감소 시키는 연산자
		
		//증가 연산자 : ++
		//연산자의 좌항 혹은 우항의 값을 1 증가 시킴 (피연산자가 하나뿐이다)
		int integer1 = 10;
		++integer1; //증가시키는게 먼저 그 다음에 integer1읽기
		System.out.println(integer1);
		
		integer1++; //integer1을 읽고 나서 증가
		System.out.println(integer1);
		
		System.out.println("---------------");
		integer1 = 0;
		System.out.println(integer1);
		System.out.println(++integer1);
		
		System.out.println(integer1);
		System.out.println(integer1++); //integer1이 '읽힌' 다음 증가라서 다음에 integer1을 읽을때 +1이 되게 된다.
		
		System.out.println(integer1);
		
//		final int NUMBER = 0 ;
//		NUMBER++; //상수는 증감 연산을 할 수 없다.
//		0++; //리터럴 상수도 증감 연산을 할 수 없다.
		
		//감소 연산자 : --
		//연산자의 좌항 혹은 우항에 값을 1 감소 시킴
		int integer2 = 10 ;
		--integer2 ;
		integer2--;
		
		System.out.println("---------------");
		int number2 = 8;
		int number3 = 3;
		int sampleNumber = number2 / number3++ ; //sampleNumber = 4, number2 = 8 number3 = 4가 된다 (한줄 읽히고 난 다음) ☆
		//int sampleNumber = number2 / --number3 ; //sampleNumber = 4, number2 = 8 number3 = 2가 된다 (한줄 읽히고 난 다음)
		
		// 대입 연산자 
		// 좌항에 우항을 (누적)대입
		// 좌항의 변수에 좌항 변수와 우항을 연산한 결과를 대입
		
		// = : 좌항에 우항을 대입
		int number4 = 10;
		// += : 좌항에 우항을 더한 값을 좌항에 대입
		number4 += 3; // number4 = 13
		System.out.println(number4);
		// -= : 좌항에 우항을 뺀 값을 좌항에 대입
		number4 -= 6;
		System.out.println(number4); // number4 = 7
		// *= : 좌항에 우항을 곱한 값을 좌항에 대입
		number4 *= 3;
		System.out.println(number4); // number4 = 21
		// /= : 좌항에 우항을 나눈 값을 좌항에 대입
		number4 /= 5; // int 나누기 int = 정수부만 남게된다
		System.out.println(number4);
		// %= : 좌항에 우항을 나눈 나머지를 좌항에 대입
		number4 %= 3; 
		System.out.println(number4); // number4 = 1
		
		//대입 연산자의 좌항에는 무조건 변수만 지정할 수 있다. (상수는 바뀔수 없으므로)
		// (number4 %= 3;) => (number4 = number3 % 3); 단 역순은 성립하지 않는다 삼단논법 조심!
		
		//비교 연산자
		//좌항을 우항과 비교한 결과를 논리(true, false)값으로 반환
		
		// ==
		//좌항이 우항과 같다면, true 아니면 false 반환
		boolean boolean1 = 10 == 12 ;
		System.out.println(boolean1);
		// !=
		//좌항이 우항과 다르다면, true 아니면 false 반환
		boolean boolean2 = 10 != 11 ;
		System.out.println(boolean2);
		// >(greatThen), >=
		// 좌항이 우항보다 크면 true, 아니면 false 반환
		// 좌항이 우항보다 크거나 같으면 true, 아니면 false 반환
		boolean boolean3 = 10 > 10 ;
		boolean boolean4 = 10 >= 10 ;
		System.out.println(boolean3);
		System.out.println(boolean4);
		// <(lessThen), <=
		// 좌항이 우항보다 작으면 true, 아니면 false 반환
		// 좌항이 우항보다 작거나 같으면 true, 아니면 false 반환
		boolean boolean5 = 8 < 10 ;
		boolean boolean6 = 8 <= 10 ;
		System.out.println(boolean5);
		System.out.println(boolean6);
		
		//논리 연산자
		//논리 값을 연산하는 연산자 : 좌항과 우항 모두에 논리값이 와야한다.
		
		// && : AND 연산
		// 좌항과 우항이 모두 true일때 true, 아니면 false 반환 // T&&T의 경우에만 true 나머지는 false
		int number5 = 8;
		int number6 = 3;
		boolean boolean7 = (number5 > number6) /*논리값이 와야한다*/ && true/*논리값이 와야한다*/;
		
		// || : OR 연산
		// 좌항과 우항이 중 하나라도 true 이면 true, 아니면 false // F||F의 경우에만 false 나머지는 true
		boolean boolean8 = false/*논리값이 와야한다*/ || false/*논리값이 와야한다*/ ; //false 출력
		
		//연산의 우선순위가 빠르더라도 ()로 묶어주면 보기 편하고 결과 출력값을 한눈에 볼수 있다
		
		boolean boolean9 = (number5 > number6) && (number6 > number5); //false
		//boolean boolean9 =  (number6 > number5) && (number5 > number6); //false
		
		boolean boolean10 =  (number6 > number5)/*이 부분에서 읽을때 false이므로 이 뒤는 읽지 않는다!*/ && (number5++ > number6);
		System.out.println(number5); //8로 출력된다
		
		// && 연산자는 모두 T가 아닌 경우에 모두 F가 반환되므로 코드를 읽는 과정에서 첫번째 논리가 F인 경우 뒤는 읽지 않고 바로 F로 출력하게 된다.
		
		boolean boolean11 = 
				(number5 > number6)/*이 부분에서 읽을때 true가 되므로 이 뒤는 읽지 않는다*/ || (number6 > ++number5);
		System.out.println(number5); //8로 출력된다
		
		// || 연산자는 모두 F가 아닌 경우에 모두 T가 반환되므로 코드를 읽는 과정에서 첫번째 논리가 T인 경우 뒤는 읽지 않고 바로 T로 출력하게 된다.
		
		// ! : NOT 연산
		// 논리값의 부정을 반환
		boolean boolean12 = !(number5 > number6);
		System.out.println(boolean12);
		
		//삼항 연산자
		// '조건에 따라' 다른 결과를 반환하는 연산자
		// 조건(연산결과가 논리인 값) ? 참일때 결과 : 거짓일때 결과 ;
		
		String string1 = number5 > number6 ? "3보다 큽니다." : "3보다 크지 않습니다." ;
		System.out.println(string1);
		
		String string2 
		= number5 > number6 ? "3보다 큽니다." :
		 number5 == number6 ? "3입니다" : "3보다 작습니다" ;

		//삼항연산자와 if문 값 같은 코드		
		//if(number5 > number6) {
		//	System.out.println("3보다 큽니다");
		//} else {
		//	if (number5 == number6) {
		//		System.out.println("3입니다.");
		//	} else {
		//		System.out.println("3보다 작습니다");
		//	}
		//}
		
	}

}
