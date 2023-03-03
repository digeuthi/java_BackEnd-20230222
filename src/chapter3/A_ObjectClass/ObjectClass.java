package chapter3.A_ObjectClass;


//class
//객체를 정의해 놓은것
//객체를 생성하는 기반
//객체를 정의하는 틀 또는 설계도

//클래스는 객체의 상태를 나타내는 필드와 객체의 행동을 나타내는 메서드로 구성됨
//필드 : 클래스에 포함된 변수 혹은 상수
//메서드 : 어떠한 특정 작업을 수행하기 위한 명령문의 집합

//object
//실제로 존재하는 모든 것들 (사람, 사물, 추상적인 개념 등등)
//클래스로 생성된 실체 

//클래스 생성된 각각의 객체는 독립적으로 존재함.
//같은 클래스로 생성된 객체라 하더라도 각각이 가지고 있는 '속성 값'은 다를 수 있다.(일반적으로 다름)
//속성은 같은데 그것에 대응하는 값은 다를수 있다

//클래스 선언 방법
//class 클래스명 { 속성1; 속성2; ...; 기능1; 기능2; ... }
//속성 : 변수, 특성, 필드, 상태
//기능 : 메서드, 함수, 행위 

//클래스 명은 UpperCamelCase 명명 규칙을 따름
class SmartPhone {
//속성	// 기종 
		String modelName;
		// 색상
		String color;
		// 메모리
		int memory;
		// 전화번호
		String telNumber;
		// 전원
		boolean power;
	
//기능	// 전화 걸기
		void call(String toTellNumber) {
			System.out.println(toTellNumber + "로 전화를 겁니다.");
		}
		// 영상 시청
		void showVideo() {
			System.out.println("영상을 시청합니다.");
		}
		// 메시지 보내기
		void sendMessage(String message, String toTelNumber) {
			System.out.println(toTelNumber + "로 " + message + "를 보냅니다.");
		}
		// 전원 켜고 끄기
		void setPower() {
			power = !power;
		}
}

public class ObjectClass {

	public static void main(String[] args) {
		// 인스턴스
		// 특정 클래스로 생성된 객체를 '인스턴스'라 함
		// 클래스로 객체를 생성하는 행위를 '인스턴스화'라고 함
				
		// 인스턴스 선언 방법
		// 클래스 참조변수명(인스턴스명) 
		SmartPhone iphone14; //저장하는 '공간'을 만든것
				
		// 인스턴스 생성 방법
		// 참조변수명 = new 클래스명(); //메모리 주소를 갖는다!
		iphone14 = new SmartPhone();
		SmartPhone iphone14Pro = new SmartPhone(); //같은 틀을 가졌으나 iphone14와 iphone14Pro는 다르다.
		//배열은 늘 같은 타입, 클래스는 다른 타입들이 섞여 있는것 // 구조체에 메소드까지 포함된게 클래스라고 한다
		
		System.out.println(iphone14);
		System.out.println(iphone14Pro); //메모리 주소가 출력된다.
				
		//인스턴스의 속성 접근 및 기능 사용
		//꼭 생성을 한다음에 사용해야 한다
		// 속성 접근 : 참조변수.멤버변수(속성);
		// 기능 사용 : 참조변수.메서드([매개변수[, ...]]); //[]안에 넣는건 필요하면 넣고, 안필요하면 안넣는것.
				
		iphone14.modelName = "IPHONE";
		iphone14.color = "black";
		iphone14.memory = 512;
		iphone14.telNumber = "010-1234-5678";
		iphone14.power = false;
				
		System.out.println(iphone14.modelName);
		System.out.println(iphone14.telNumber);
				
		System.out.println(iphone14Pro.modelName); // null //참조변수에서만 해당
		System.out.println(iphone14Pro.memory); // 0
		System.out.println(iphone14Pro.power); // false
		//iphone14Pro는 초기화하지 않았다.
		//iphone14Pro는 참조변수고 modelName은 변수 
		//기본 데이터 타입은 기본 메모리가 있다(int는 4byte) 아무것도 지정하지 않으면 처음 저장되는 값은 전부 : 0 (boolean도 전부 0이라 false로 나오는것)
		//String은 기본형 데이터 타입아니고 참조형. 특정한 위치를 바라보는데 그 위치를 지정하지 않음. 메모리 주소를 지정하지 않았다 : null 
				
		//SmartPhone galaxy = null; //아직 값을 지정하지 않겠다 / 메모리 공간만 할당. 메모리 주소가 없고 전체 공간만 있는상태
			
		iphone14.call("010-2222-2222"); //ctrl누르고 기능 누르면 기능에 들어갈수 있다.
		iphone14.showVideo();
		System.out.println(iphone14.power); //false
		iphone14.setPower();
		System.out.println(iphone14.power); //true
				
		iphone14Pro = iphone14; //iphone 명명 iPhone으로 바꾸기!
		iphone14Pro.telNumber = "010-9999-9999"; //같은걸 바라보게 되서 같은 애가 바뀌게 된다..?
		//바꿔도 안바뀌는건 for이랑 for each문이었고.. 메모리주소관련은 바뀐다고했던가
				
		// 객체 배열 (거의 쓰이지 않는다 중요 개념 설명용도)
		// 클래스명[] 객체배열명 = new 클래스명[길이];
		SmartPhone[] smartPhoneList = new SmartPhone[3];
				
		smartPhoneList[0] = iphone14;
		smartPhoneList[1] = iphone14Pro;
		smartPhoneList[2] = new SmartPhone(); //인스턴스 생성 , 주소가 들어가는 것
				
		///*1번*/SmartPhone smartPhone = new SmartPhone(); 
		for (int index = 0 ; index < smartPhoneList.length; index++) {
			/*2번*/SmartPhone smartPhone = new SmartPhone();
			smartPhone.telNumber = "010-1111-111" + index;
			smartPhoneList[index] = smartPhone;
		}
				
		for(SmartPhone phone : smartPhoneList) {
			System.out.println(phone.telNumber);
			//1번 위치에 있으면 모든 배열의 메모리 주소가 동일
			//2번 위치에 있으면 모든 배열의 메모리 주소 다름
			System.out.println(phone.telNumber);
			//1번 위치에 있으면 모든 배열의 값이 010-1111-1112
			//2번 위치에 있으면 010-1111-1110~010-1111-1112까지 출력
		}
				
		//클래스 : 구조체 + 메서드
	}

}
