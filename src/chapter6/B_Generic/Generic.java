package chapter6.B_Generic;


//제너릭
// 다양한 타입을 다루는 메서드나 클래스에 컴파일 시 타입을 체크하는 기능
// 컴파일 시 타입을 체크하기때문에 유연하게 개발을 할 수 있음.

class GenericClass<D> { //E또는T많이 사용
	
	boolean status;
	String message;
//	Object data; //나중에 어떤 타입으로 받을지 알기가 어렵다
	D data; /*나중에 데이터 타입 지정하겠다*/
	//API 에 대한 결과를 전달해줄때 사용한다
	
	static <D> GenericClass<D> getInstance(boolean status, String message, D data){
		//static뒤에 <D> 안해주면 뒤에서 D를 받지 못한다
		GenericClass<D> instance = new GenericClass<>();
		instance.status = status;
		instance.message = message;
		instance.data = data;
		
		return instance;
		}
}

public class Generic {

	public static void main(String[] args) {
		GenericClass<Integer> generic1 = new GenericClass<>();
		GenericClass<String> generic2 = new GenericClass<>();
		GenericClass<?> generic3 = new GenericClass<>();
		
//		generic1.data = "sddfd"; //이건 int로 받으니까 문자열 받을수 없다!
		generic1.data = 50;
		generic2.data = "diq"; //왜 안받아질까.. 분명히 스트링으로 했는데 -> .data를 안넣었구맘!
//		generic3.data = "diq"; 얘는 그럼 왜 안돼..
		
		GenericClass<?> generic4 = GenericClass.getInstance(true, "message", "String");
	}

}
