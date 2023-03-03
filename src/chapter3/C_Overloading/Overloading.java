package chapter3.C_Overloading;

//오버로딩 
// 한 클래스 내에서 같은 이름으로 메서드를 여러개 정의하는 것
// 이미 같은 이름의 메서드가 존재한다 하더라도 매개변수의 타이봐 갯수각 다르면
// 같은 이름으로 정의 할 수 있음

//오버로딩의 조건
//메서드명이 같아야함
//매개변수 개수 혹은 타입이 달라야함
//반환 타입은 오버로딩에 영향을 미치지 않는다.
public class Overloading {

	//int + int = int
	int add(int x, int y) {
		return x + y;
	}
	
	double/*앞의 반환타입은 영향미치지 않는다*/ add(double x, int y) {
		return (int)x + y ;
	} //오버로딩이 되지 않는다면 매번 메서드의 이름을 다 다르게 지어줘야한다.
	//add만 알면 다 적용할 수있고, 부가적인 설명의 추가가 필요없다.
	
	//메서드명가 파라미터의 데이터 타입으로 판단한다!
	//double add(int x, int y)하면 중복으로 인식함
	//double add(int x1, int y1)으로 해도 중복으로 인식함
	
	//매개변수의 데이터 타입이 같고 매개변수의 이름이 다르다고 해도
		//오버로딩은 성립하지 않는다
	
	int add(int x, int y, int z) {
		return x + y + z; //데이터 타입이 같아도 파라미터의 갯수가 다르면 오버로딩 성립한다.
	}
	
	public static void main(String[] args) {
		

	}

}
