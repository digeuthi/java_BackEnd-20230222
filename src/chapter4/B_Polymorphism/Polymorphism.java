package chapter4.B_Polymorphism;

//다형성
// 조상클래스 타입의 참조변수로 자손클래스의 인스턴스를 참조할수 있도록 하는 것
// 참조변수의 형변환

class SuperClass{//부모 클래스
	int number1;
	int number2;
	
	//생성자 만들기
	SuperClass(int number1, int number2){
		this.number1 = number1;
		this.number2 = number2; //인스턴스와 매개변수 이름 같을때 구분 this!
	}
	//기본 생성자를 만들었으면 밑에 자손 클래스의 기본생성자를 만들지 않아도 되고
	//기본 생성자 말고 값을 넣는 생성자를 만들었기때문에 밑에 자손 클래스에 오류가 뜨게된다(따로 자손 클래스도 생성자 만들어줘야한다)
	
	void method1() {}
	void method2() {}
}
class SubClass1 extends SuperClass{ //자손 클래스
	int number3;
	
	SubClass1(int number1,int number2, int number3){ //생성자
		super(number1, number2);
		this.number3 = number3;
	}
	
	void method3() {}
}
class SubClass2 extends SuperClass{//자손 클래스2
	int number4;
	
	SubClass2(int number1,int number2){ //생성자
		super(number1, number2);
	} //인스턴스(number4)랑 메서드(method4) 선언했는데 아까 수업할때 주석처리하고 지운 다음에 적용을 안한듯..?
	
	void method4() {}
	
	//오버라이드 //SuperClass의 method1을 받아와서 수정함.
	void method1() {
		System.out.println("Override!");
	}
}

public class Polymorphism {

	public static void main(String[] args) {
		
		SuperClass superClass = new SuperClass/*참조변수?*/(1, 2); //인스턴스 생성 / 참조변수 뭐라했지?
		SubClass1 subClass1 = new SubClass1(11, 22, 33);
		SubClass2 subClass2 = new SubClass2(111, 222);

		//자손타입 -> 조상타입 (Up casting) : 자동 형변환 가능
		SuperClass super1 = subClass1; //자손이 부모를 다 표현할수 있기때문에 자동 형변환
		//바라볼수 있는 범위가 달라지는거다..????????
		//super1을 subClass1을 바라보게 만들었다.
		SuperClass super2 = subClass2;
		//super2을 subClass2을 바라보게 만들었다.
		
		System.out.println(subClass1.number3); //33
		System.out.println(subClass1); //다 같은 주소
		System.out.println(super1); //다 같은 주소
		
		
		// 참조변수의 형 변환을 한다고 하더라도 인스턴스가 가지고 있는 데이터에는
		// 아무런 영향을 미치지 않는다.
		// 단지 인스턴스의 사용 '범위'를 조절하는것.
		SubClass1 sub1 = (SubClass1) super1;
		//sub1을 super1(subClass1을 보고있음)을 바라보게 만들었다
		// 그래서 subClass1, super1, sub1 전부 같은 곳을 바라보고 있다.
		
		System.out.println(sub1.number3); //33
		System.out.println(sub1); //다 같은 주소
		
		super2.method1(); //실제 인스턴스 값이 나온다.?
		//SuperClass의 method1을 SubClass2에서 오버라이드한것을
		//상속받아서 사용한것인데 이 실제 인스턴스 값은 변하지 않았단것을 나타낸다..?
		
		//조상타입 -> 자손타입 (Down casting) : 자동 형변환 불가능
//		SubClass1 sub1 = superClass; //타입미스매치 오류뜬다
//		SubClass2 sub2 = superClass; //타입미스매치 오류뜬다 //SubClass2를 다 지워도 받을수 없다
		
//		SubClass1 sub1 = (SubClass1)superClass; //명시적 형변환 //이거 오류떠서 주석처리함
//		SubClass2 sub2 = (SubClass2)superClass; 
		
		
	}

}
