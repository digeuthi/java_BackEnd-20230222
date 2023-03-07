package chapter3.D_Constructor;

//생성자
// 인스턴스가 생성될때 호출되는 인스턴스 초기화 '메서드'
// 인스턴스 변수의 초기화 작업에 사용
// 인스턴스 생성 시에 실행되어야 할 작업을 작성하는 위치

//생성자의 조건
// 생성자의 이름은 해당 클래스 명과 같아야한다
// 생성자는 반환값이 없음!
class Circle {
	double radius; //인스턴스 변수
	double diameter;
	double circumference;
	double area;
	
	//null이나 0으로 초기화 시키고 싶지않으면 직접 생성자 만들면 된다
	
	//생성자 사용 방법
	//클래스명([파라미터[, ...]]){인스턴스 생성시 실행할 코드} //[]안에 있는건 와도 되고 아니여도 된다.
	Circle(double radius){ //파라미터가 없는 경우에도 쓸수 있고, 파라미터를 받아서 쓸수도 있다.
		System.out.println("Circle이 생성됩니다.");
		this.radius = radius; //클래스 기준으로 위에 만든 인스턴스 변수는 전역 변수이다
		//this는 해당 인스턴스를 지칭, 이 인스턴스의 radius를 따라라는뜻
		//this : 인스턴스 자신. this를 하지않으면 매개변수로 받는 radius를 인식하게 된다
		//인스턴스 변수를 지칭하고자 할때는 모든 경우에 다 this를 찍는게 좋다.(초기화 작업을 할때)
		//생성자만들때는 꼭 this 찍어주는게 좋다!
		this.diameter = 2 * radius;
		this.circumference = 3.14 * 2 * radius;
		this.area = 3.14 * radius * radius;
	}
	
	//생성자 쓸때는 오버로딩이 사용된다!
	// 생성자도 메서드이기 때문에 오버로딩을 적용해서
	// 매개변수에 따라 다른 작업을 수행하게 할 수 있다
	Circle(){
		//빈생성자 메서드
		System.out.println("빈 생성자 입니다.");
		this.radius = 10;
		this.diameter = 2 * this.radius;
		this.circumference = 3.14 * this.diameter;
		this.area = 3.14 * this.radius * this.radius;
	}
	
	//생성자를 이용한 인스턴스 복사
	Circle(Circle circle/*참조변수를 매개변수로 받아옴*/) {
		this.radius = circle.radius;
		this.diameter = circle.diameter;
		this.circumference = circle.circumference;
		this.area = circle.area; //하나하나 다 찍어주면 이렇게 복사가된다.
		//복사하고자 하는 인스턴스 변수를 받고자 하는 참조변수에 복사해준다.
	}
}

public class Constructor {

	public static void main(String[] args) {
		
		System.out.println("===생성자==="); //실행되는 위치 확인 위해 이런 코드 사용해서 콘솔에서 생성 위치 파악할수 있다
		Circle circle1 = new Circle()/*Circle()생성시 초기화 해주는 메서드*/; //인스턴스 생성
		//빈 생성자 메서드 사용
		Circle circle2 = new Circle(5);
		//매개변수 받아서 사용하는 메서드 사용
		System.out.println("===생성자===");
		
		//생성자를 만들어줬으므로 밑에 초기화는 주석처리
		//기본 생성자가 컴파일러에 의해 추가되는 경우는 클래스에 정의된 생성자가 하나도 없을 때 뿐!
//		System.out.println(circle1.radius); //초기화 되어있어서 사용가능
//		circle1.radius = 10; //인스턴스 변수 초기화 작업
//		circle1.diameter = 20;
//		circle1.circumference = 62.8;
//		circle1.area = 314;
		//참조변수의 경우 초기화를 하지 않으면 null값으로 된다 : 사용할 수 없음
		
		System.out.println(circle1.area);
		System.out.println(circle2.area);
		
		//double radius; //초기화 하지 않음
		//System.out.println(radius); 초기화 되지 않아 사용 못한다
	}

}
