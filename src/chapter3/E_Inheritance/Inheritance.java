package chapter3.E_Inheritance;

// 상속
// 기존 클래스를 재사용해서 새로운 클래스를 작성하는것
// 코드의 재사용성을 높이고, 코드의 중복을 제거 -> 생산성이 향상, 유지보수성이 향상

// 사용방법 :
// class 클래스명 extends 조상클래스명 {...}
// 다양한 직업(자식클래스)을 가진 사람(조상클래스)..?

class Human{ //사람 클래스 //모든 클래스는 object/*최상위 조상클래스*/를 상속받고 있다. 
	String name; //인스턴스
	int age;
	String telNumber;
	String country;
	
	/*생성자만들면서 초기화 같이하기*/Human() { /*생성자 만들기*/} //기본 생성자
	Human(String name, int age) { //따로 만들 생성자
		this.name = name;
		this.age = age;
		this.telNumber = "010-1111-2222";
		this.country = "Korea";
	}
	
	//메서드
	void eat(String food){
		System.out.println(this.name/*인스턴스가 먹는다를 하기위함*/ + "가 " + food + "를 먹습니다.");
	}
}

//Developer 클래스는 Human의 속성과 기능을 모두 사용가능
class Developer extends/*상속 시 사용*/ Human{//직업 클래스에 사람클래스를 받아옴
	String position; //인스턴스
	String language;
	
	Developer(){} //기본 생성자
	Developer(String name, int age, String position, String language){
		//super : 부모 클래스를 지칭
		//super() : 부모 클래스의 생성자를 지칭
		//this() : 본인 인스턴스의 생성자 지칭??
		super(name, age); //부모 생성자를 지칭
		this.position = position;
		this.language = language;
		
	}
	
	//메서드
	void develope() {
		System.out.println(super/*정확한 위치를 표시해줘야한다*/.name + "가 "+ this.language + "로 " + this.position + "개발을 합니다.");
	}					//this.name으로 해도 같은결과가 나오긴한다
}

public class Inheritance {

	public static void main(String[] args) {
		Developer developer1 = new Developer()/*기본생성자*/; //인스턴스 생성
		developer1.name = "Jhon doe";
		developer1.position ="Back end";
		developer1.language = "java";
	
		developer1.eat("사과");
		developer1.develope();
		
		Developer developer2 = new Developer("Michle", 29, "Front end","Javascript");
		
		developer2.eat("바나나");
		developer2.develope();
		
		
	}

}
