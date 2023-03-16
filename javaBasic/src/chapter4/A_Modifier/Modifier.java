package chapter4.A_Modifier;

import chapter4.A_AccessModifier.Example4;

// 제어자
// 클래스, 변수 혹은 메서드의 선언부에서 사용되는 부가적 의미를 추가해주는 키워드

// 접근 제어자 : public, protect, default, private
// 기타 제어자 : static, abstract, final 

//접근 제어자 : 하나의 대상에 여러개의 제어자를 종합해서 사용할 수 있음
//단, 접근 제어자는 한 선언에 대하여 한번만 사용할 수 있음.
//제어자의 순서는 무관. 


//static 제어자
	// 해당 제어자가 포함되어 있는 선언문은 클래스 단위로 사용가능하도록 함
	// 멤버 변수, 멤버 메서드에서 사용가능
/*private*/ class Example1{
	
	static int number1; //바로 클래스로 사용가능하다? 인스턴스 생성없이? //스태틱변수로 만들어서 그런가
	static void function1() {}
}

//final 제어자
	// 해당 제어자가 포함되어 있는 선언문은 변경이 불가능하도록 함.
	// 클래스, 변수, 메서드에서 사용가능
//클래스 선언문에 final이 포함되면 해당 클래스를 상속하지 못한다.
/*final*/ class Example2{
	//메서드 선언문에 final이 포함되면 해당 메서드를 오버라이드하지 못한다.
	final void function2() {
		//변수 선언문에 final이 포함되면 초기화한 후 해당 변수의 값을 변경하지 못한다.
		final int NUMBER2 = 10;
//		NUMBER2 = 12;
	}
}

//class Exmaple2_1 extends Example2{ //상속받을수 없다는 오류가 뜬다
//	void function2() {} //오버라이드 하지 못한다는 오류가 뜬다 (클래스의 final은 지우고 적용)
//}

//abstract 제어자
// 해당 제어자가 포함되어 있는 선언문은 선언만 되어 있고 구현은 되어있지 않음을 나타낸다
//클래스, 메서드에서 사용가능

//클래스 선언문에 abstract가 포함되어 있으면 해당 클래스는 
//구현되지 않은 메서드를 포함하고 있음을 의미한다.
abstract class/*추상클래스*/ Example3{
	//메서드 선언문에 abstract가 포함되어 있으면 해당 메서드는 구현되지 않았음을 의미한다.
	abstract void function3()/*구현부작성안하고 끝*/;
}

public class Modifier {

	public/*접근제어자*/ static void main(String[] args) {
		Example4 example4 = new Example4(); //chapter4.A_AccessModifier의 Example4가져온것
		example4.number4 = 10;
		example4.function4();
		
//		Example1을 private로 선언시 사용불가하다
		Example1 example1 = new Example1();
		example1.number1 = 10;
		
	}

}
