package chapter4.D_Interface;

//인터페이스
//추상클래스보다 추상화정도가 높은 존재
//기능을 구현할 적에 인터페이스를 구현해놓고 작성 시스템 설계에 많이 쓰인다.
// 추상 클래스와 다르게 일반 메서드와 일반 멤버변수를 가질 수 없다!!!

//사용방법:
//interface 인터페이스명{ }
interface ExampleInterface{
	//변수를 사용할 때는 public static final 형태로만 사용할 수 있다.
	public static final int NUMBER = 10 ; //무조건 초기화도 같이 해줘야 한다. static써서?
	
	//메서드를 사용 할 때는 public abstract로 선언해야 함
	//인터페이스 내의 메서드는 추상메서드이기때문에 구현부 없이 사용할수 있다! -> 스프링할때 쓰게된다
	public abstract void method1();
	public void method2(); //메서드의 경우 abstract을 빼도 인식은 된다.
	/*private 은 올 수 없다*/ void method3();
} 

//인터페이스 간의 상속
//인터페이스의 경우 ,를 써서 다중 상속이 가능

//다이아몬드 문제가 뭔데 
//인터페이스는 클래스와 개념자체가 다르다
//구현이 되어있냐 아니냐의 차이에 따라서 상속이 되고 안되고를 결정하게 된다.(클래스와 인터페이스의 차이)
//자바에서는 다중상속을 허용하지 않는데 인터페이스에서는 허용한다
//구현이 다른 위치에서 되니까 충돌 할게 없으니 다중상속을 허용하는건가?
//인터페이스는 필드가 포함되어 있지않으므로 상태의 다중상속을 가능하게한다
interface SubExampleInterface extends ExampleInterface{
	
}

//인터페이스 구현
// 인터페이스도 추상 메서드를 포함하고 있기 때문에 
// 해당 메서드를 구현하는 클래스를 통해서 인스턴스를 만들어 줘야한다.
// 인터페이스를 클래스로 구현할 때는 implements 키워드를 사용한다
class Implement implements ExampleInterface{ //Implement란 클래스로 인터페이스 구현 가능

	@Override //Implement빨간줄 떠서 add 어쩌구 누르면 밑에 다 뜬다
	public void method1() {
		System.out.println("메서드1");
		
	}

	@Override
	public void method2() {
		System.out.println("메서드2");
		
	}

	@Override
	public void method3() {
		System.out.println("메서드3");
		
	}
	
}

public class Interface {

	public static void main(String[] args) {
		//인터페이스 자체로 인스턴스를 생성 할 수 없음
		//ExampleInterface exampleInterface = new ExampleInterface(); 이렇게는 쓸수 없다
		ExampleInterface exampleInterface = new Implement(); //클래스 만들어서 구현 했으므로 사용가능
	}

}
