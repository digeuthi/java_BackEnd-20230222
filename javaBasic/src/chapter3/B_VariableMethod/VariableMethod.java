package chapter3.B_VariableMethod;


//클래스에서의 변수
//인스턴스 변수: 각각의 인스턴스마다 고유하게 가지고 있어야하는 속성을 지정할때 사용
//클래스 변수 : 해당 클래스로 만들어진 모든 인스턴스가 동일하게 가지고 있어야하는 속성을 지정할때 사용
//지역 변수 : 메서드 내에서 선언된 변수(인스턴스변수와 클래스 변수는 전역변수)

class GalaxyPhone{
	//인스턴스 변수 : 인스턴스마다 고유하게 가지고 있는 속성
	//인스턴스 변수는 꼭 인스턴스 생성 후에 사용가능!
	String model;
	String owner;
	String telNumber;
	//클래스 변수(static변수): 해당 클래스로 생성된 모든 인스턴스가 동일하게 가지고 있는 속성
	// static 데이터 타입 변수명;
	// 클래스 변수는 인스턴스 생성없이 클래스로 사용이 가능(인스턴스로도 사용가능<<이게 무슨 말이지)
	static String maker = "SAMSUNG";/*인스턴스 변수와 표시도 다르게 나타남*/
	//클래스 변수는 만들때부터 초기화해주는게 제일 좋다.
}
class MoniterSize{
	//final int HEIGHT = 1080; //인스턴스변수 ->인스턴스를 생성해야한다!
	//이렇게 하면 사용할때마다 인스턴스 생성해줘야한다.
	//생성안하고 바로 사용할수 있게하려면 클래스 변수로 생성해주면 된다
	static final int HEIGHT = 1080; //클래스 변수로 생성!
	//final int WIDTH = 1920;
	static final int WIDTH = 1920;
	//특정한 값을 지정해놓고 외부에서 사용할 때 제일 많이쓰이는 형태
}

public class VariableMethod {
	
	//VariableMethod 클래스의 전역변수
	int number = 10;
	
	public static void/*반환타입이 없다*/ main(String[] args)/*선언부*/ { //메인메서드
		
		//main 메서드의 지역변수
		double decimal = 10.0;
		
		int size = MoniterSize.HEIGHT * MoniterSize.WIDTH;
		
		GalaxyPhone myS23 = new GalaxyPhone(); //인스턴스
		myS23.model = "S23";
		myS23.owner = "서지훈";
		myS23.telNumber = "010-1111-1111";
		
		GalaxyPhone myS22 = new GalaxyPhone(); //인스턴스
		myS22.model = "S22";
		myS22.owner = "김다혜";
		myS22.telNumber = "010-2222-2222";
		
		System.out/*static변수?*/.println(myS23.telNumber);
		System.out.println(myS22.telNumber);
		
		myS23.maker = "SAMSUNG";
		
		System.out.println(myS23.maker);
		System.out.println(myS22.maker); 
		//클래스 변수를 인스턴스 변수로 접근해서 노란줄의 경고가 뜬다
		//S23의 maker만 바꿨는데 둘다 메이커가 삼성으로 되어있다.
		//같은 곳을 바라보고 있으므로 하나가 바뀌면 같이 바뀐다
		//클래스 변수는 독립적인 저장공간을 확보하고 있고, 그곳의 메모리 주소를 바라보게 된다.
		System.out.println(GalaxyPhone.maker);
	}

}
