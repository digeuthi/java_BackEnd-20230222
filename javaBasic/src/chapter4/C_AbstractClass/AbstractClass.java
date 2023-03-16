package chapter4.C_AbstractClass;


//추상 클래스
//추상 메서드가 포함되어 있는 클래스
//추상클래스로 인스턴스를 생성할 수 없다!

//사용방법:
// abstract class 클래스명 {}
abstract class Abstract{ //추상클래스
	int number1;
	
	//void method1() {}
	//추상메서드 
	//선언부만 작성이 되어있고 구현부는 작성되어 있지 않은 메서드
	//해당 클래스를 상속받은 자손클래스에서 구현을 필수로 요구함!
	
	//사용방법:
	//abstract 반환타입 메서드명(매개변수); '{}'쓰지않는다!
	abstract void method1(); //추상메서드로 만들어줌.
}

class SubClass extends Abstract{
	void method1() { //method1 오버라이드
		System.out.println("구현!");
	}
}

public class AbstractClass {

	public static void main(String[] args) {
		//Abstract abstract1 = new Abstract(); //인스턴스화 할수없다고 뜬다. < 추상클래스로 되어있기때문에
		Abstract abstract1 = new SubClass(); //상속받아서 메서드 구현했기때문에 이제 참조변수로 받아서 사용할수있게됐다.
		//SubClass(자손클래스)은 Abstract(부모클래스)을 상속받아서 참조변수로 받아와 인스턴스 생성이 가능하다
	}

}
