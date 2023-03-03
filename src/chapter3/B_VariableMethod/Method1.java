package chapter3.B_VariableMethod;

import java.lang.*; //이거하면 미리 만들어진 메서드 사용가능

//메서드
//특정 작업을 수행하는 일련의 문장들을 하나로 묶은것
//작업을 미리 작성해둔 것
// 메서드에 넣을 값과 반환값만 알면 된다.(Black Box구조)

//메서드의 장점
// 1. 높은 재사용성 (클래스도 높은 재사용성, 변수에 있어서 속성값 저장하는쪽 관련)
		//한번 만들어 놓은 메서드를 반복해서 사용 가능
// 2. 중복 코드 제거 : 반복적으로 나타나는 문장들을 메서드로 만들어서 사용하면 
//				  코드의 중복을 제거할 수 있고 수정이 발생하면 하나의 코드만 수정하면 된다.
// 3. ☆ 프로그램을 구조화 : 작업 단위로 여러개의 메서드에 담아서 프로그램을 구조화 할 수 있다

// if문 사용과 메서드 사용을 어떻게 하느냐에 따라서 개발 잘하냐 못하냐를 판단

//특정한 기능에 이름을 붙여놓는것 : 메서드로 구현

// 파라미터가 있는 메서드는 반드시 파라미터 범위 등과 같은 검증!!을 먼저 해줘야한다.

class HigherMathematics { //변수 선언할때 파파고로 번역해서 표현하는 경우 많다
	
	static final double PIE = 3.14; //전역변수 : 이렇게 지정하면 밑에 전부 다 쓸수 있다. 
	//static으로 선언해두면 인스턴스와 스태틱에서 다 사용가능하다.? 클래식으로도 접근가능.?
	
	//클래스 변수와 마찬가지로 메서드에 static을 포함하게 되면
	//클래스 메서드로 사용할 수 있음. (즉 클래스로 접근할 수 있다)
	
	static double getTriangleSize(double underside, double height) {
		//입력을 받은 모든 메서드는 검증을 먼저 해야한다!!
		//검증 : 밑변과 높이는 무조건 양수여야한다!
		if (!(underside > 0) || !(height > 0)) {
			System.out.println("밑변과 높이는 양수여야 합니다.");
			return 0;
		}
		double size = 0.5 * underside * height;
		height = 12; //메서드 내에서 바꿔도 호출시에는 바뀌지 않는다? 영향없다?
		return size;
	}
	
	static double getCircleSize(double radius) { 
		
		/*검증*/if (radius <=0) {
			System.out.println("반지름은 양수여야합니다.");
			return 0;
		}
		//final double PIE = 3.14; //지역변수 :매번 써야하고 블록을 벗어나면 적용되지 않는다
		//static으로 선언해서 인스턴트 생성안해도 되니까 non static인 PIE 쓸수없다고 빨간줄뜬다
		//그래서 final double PIE = 3.14;도 static으로 바꿔준다.
		double size = PIE * radius * radius ;
		return size;
	}
	
	static double getCircumFerence(double radius) {
		
		/*검증*/if (radius <=0) {
			System.out.println("반지름은 양수여야합니다.");
			return 0;
		}
		
		//final double PIE = 3.14; //지역변수 :매번 써야하고 블록을 벗어나면 적용되지 않는다
		double circumference = PIE * 2 * radius;
		return circumference;
	}
}


public class Method1 {

	//메서드의 선언부 
	// [접근제어자 기타제어자] 반환타입 메서드명 ([매개변수/*외부로부터 데이터 받고자 할때*/[, ...]]) 
	public static void/*반환타입*/ main(String[] args) 
	
	//메서드의 구현부
	//실제 프로그램의 절차를 작성하는 부분
	//return 데이터; 로 결과를 반환시켜줌
	// (반환타입이 void이면 return;으로 메서드를 종료시킴)
	{
		//메서드 쓰려면 인스턴스 생성해야한다! 매번 쓸때마다 불러와야한다 ->번거롭다
		// 메서드 작성시 static을 붙이면 인스턴스 생성없이 클래스로 불러올수 있다!
		//HigherMathematics math = new HigherMathematics(); //static 선언 안했을때 인스턴스 생성
		
		//double size = math.getTriangleSize(10, 10); //매개변수의 데이터 타입과 같아야한다.
		/*메서드에 static으로 생성해서 인스턴스 생성없이도 바로 사용가능*/
		int height = 10 ; //메서드 호출, 호출 시 인자로 전달한 값이 메서드의 매개변수에 각각 복사됨
		//그래서 원본 메서드 내에서 12로 바꿔도 적용되지 않는다!?
		//double size = HigherMathematics.getTriangleSize(10, height);
		double size = HigherMathematics.getTriangleSize(10, 10);
		System.out.println(size);
		//double circleSize = math.getCircleSize(5);
		double circleSize = HigherMathematics.getCircleSize(5);
		System.out.println(circleSize);
		
	
	}

}
