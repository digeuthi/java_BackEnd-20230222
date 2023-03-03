package chapter1.D_IO;

import java.util.Scanner;

//Input Output (입출력)
//입력은 공부할때만 쓰이고 실제로는 작업을 안한다 
//입력시 Scanner를 쓰는데 이게 좀 힘들다.

//console을 통해서 개발자로부터 입력을 받을때 (화면 GUI에 입력하는것 아님) Scanner 객체를 사용함.
//console로 데이터를 출력할땐 System 객체를 사용함
public class IO {

	public static void main(String[] args) {
		// 출력 (console에)
		//System.out.println(출력하고자 하는 변수 혹은 상수);
		// sysout 단축키로 바로 작성 가능
		String comment = "이것은 변수에 저장된 문자열입니다.";
		System.out.println("이것을 리터럴 상수 문자열입니다.");
		System.out.println(comment);
		
		//System.out.println(변수 혹은 상수);
		//변수 혹은 상수 자리에 어떤 데이터타입이 와도 됨
		float float1 = 1.111111113333F; //float은 소수점 6번째자리까지만 맞고 뒤로는 오차발생 (반올림하는듯)
		System.out.println(float1);
		
		// 입력
		// Scanner 클래스를 사용 (참조형 데이터 타입 : 메모리 주소를 가진다)
		
		//컴퓨터는 전체를 볼수 없고 첫번째의 메모리 주소를 본다.
		
		// Scanner scanner = new Scanner(System.in);
		Scanner scanner = new Scanner(System.in); //import java.util.Scanner; 하면 사용가능
		//System.out.println(scanner);
		
		//Scanner 객체의 .next**();기능(메서드)을 사용해서 입력을 받을 수 있다.
//		int inputInteger = /*사용자로부터 입력받아 사용*/ scanner.nextInt();
//		System.out.println("입력 받은 값: ");
//		System.out.println(inputInteger);
		
		String inputString = scanner.nextLine();
		System.out.println("입력한 문자열: ");
		System.out.println(inputString);
		
		
		//인덱스는 한칸 자체가 아니고 그 사이의 경계
	}

}
