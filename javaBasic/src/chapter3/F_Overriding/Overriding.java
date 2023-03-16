package chapter3.F_Overriding;


//오버라이딩
//조상 클래스로부터 상속받은 메서드의 내용을 변경하는 것
//상속받은 메서드를 자손클래스에 맞게 변경 시키고자 할때 오버라이딩을 사용

class Human { //조상클래스
	String name; //인스턴스
	
	void eat(String food) {
		System.out.println(this.name + "가 " + food + "를 먹습니다");
	}
}

class Developer extends Human { //자손클래스
	
	//Overloading
	void eat() { //이건 오버리딩된것, 같은 클래스에서 같은 이름의 메서드를 여러개 정의
	System.out.println(super.name + "가 절반만 먹습니다.");
}
	
	//먹는 작업은 같이 하나, 적게 먹는 작업 오버라이딩 적용
	//Overriding : 개발할 적에 제일 많이 쓴다. 틀을 따라서 뭔가 만들고자 할때 클래스를 상속받아 작업시 필수적으로 사용된다.
	//상속받은 메서드를 자식 클래스에 맞게 변경해서 사용하는것
	void eat(String food) {
		System.out.println(super.name + "가 " + food + "를 절반만 먹습니다.");
	}
	

}

public class Overriding {

	public static void main(String[] args) {
		Developer developer = new Developer(); //자식클래스 인스턴스 생성
		developer.name = "John doe";
		
		developer.eat("사과"); //오버라이딩한 결과가 출력된다
		developer.eat(); //오버리딩한 결과가 출력
		
		Human human = new Human(); //부모클래스의 인스턴스 생성
		human.name = "Michle";
		
		human.eat("바나나");
	}

}
