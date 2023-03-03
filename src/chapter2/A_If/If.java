package chapter2.A_If;


//if 구문
//조건(다이어그램 상에서 마름모)에 따라 실행시키고자 하는 로직(프로세스)이 다를 때 사용하는 구
public class If {

	public static void main(String[] args) {
		// 단순 if 문
		// 조건이 true일 때 실행할 코드를 지정하는 구문
		// 사용 방법 : if (조건) {조건이 true일 때 실행할 코드}
		int age = 12 ;
		
		if (age > 19) {
			System.out.println("성인입니다.");
		}
		
		//if 문의 경우 코드 블럭에 오는 실행할 코드가 하나의 구문이면
		//{}를 제거하고 사용가능
//		if (age > 19) System.out.println("성인입니다"); //이 형태로도 가능
		
		System.out.println("조건 검사 완료");
		
		//if - else 문
		// 조건이 true 일 경우와 false 일 경우를 실행되는 코드를 각각 지정한 구문
		// 사용 방법 : if(조건){true일때 실행할 코드}
		//			else {false일때 실행할 코드}
		if (age > 19) {
			System.out.println("성인입니다.");
		} else {
			System.out.println("미성년자입니다.");
		}
		
		System.out.println("조건 검사 완료");
		
		// if 문과 마찬가지로 else 문도 코드블럭에 오는 실행할 코드가 
		// 하나의 구문이면 {} 제거하고 사용 가능
//		if (age > 19) System.out.println("성인입니다.");
//		else System.out.println("미성년자입니다."); //이 형태로도 가능
	
		// 중첩 if 문 : 어쩔수 없는 경우를 제외하고는 잘 쓰지 않는게 좋다.
		// if 문 혹은 else 문의 코드 블럭 안에 if문을 작성
		if (age <= 19) {
			if (age < 8) System.out.println("미취학 아동입니다.");
			else System.out.println("청소년입니다.");
			} else {
			System.out.println("성인입니다.");
		}
		
		System.out.println("조건 검사 완료");
		
		if (age > 19) {
			System.out.println("성인입니다.");
		} else {
			if(age < 8) System.out.println("미취학 아동입니다.");
			else System.out.println("청소년 입니다.");
		}
		
//		if (age > 19) {
//			System.out.println("성인입니다.");
//		} else /*이렇게 되면 이게 else if문이 되버린다*/
//	    if(age < 8) System.out.println("미취학 아동입니다.");
//		else System.out.println("청소년 입니다.");
		
		//if - else if - else 문
		//중첩 if문의 응용
		//else 문의 코드블럭에 오는 코드가 한줄일때 {}을 제거 할 수 있음을 이용
		
		if(age > 19) {
			System.out.println("성인입니다.");
		} else if (age < 8) {
			System.out.println("미취학 아동입니다.");
		} else {
			System.out.println("청소년입니다.");
		}
		
//		if(age > 19) System.out.println("성인입니다.");
//		else if (age < 8) System.out.println("미취학 아동입니다.");
//		else System.out.println("청소년입니다."); //이것과 동일하다.

	}

}
		//if문이 검증을 요하는 구문이기 때문에 비정상을 빼는 과정
		//큰 가지로 정상이 흐르게 하고, if문으로 비정상이 빠지는 흐름으로 잡는다.