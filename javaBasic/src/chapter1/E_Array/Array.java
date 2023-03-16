package chapter1.E_Array;

//배열 
//'같은 타입'의 변수가 나열된 형태
//배열은 '생성'해서 사용함 -> 생성해서 사용하는 변수 : 참조 변수 (String)
//new 연산자로 생성 할 수 있음
//배열은 실제 데이터가 저장되는 것이 아니라 
//데이터 배열이 저장된 첫번째 메모리 주소가 저장되는것.

public class Array {

	public static void main(String[] args) {
		//String string1 = new String(); // String는 자주 사용하는 것이므로 매번 이런 식의 작성 안해도 된다.
		//동일한 그룹의 데이터를 변수로만 선언해서 사용할 때
		int score1, score2, score3, score4, score5;
		score1 = 90;
		score2 = 100;
		score3 = 70; //그냥 변수로만 쓰게되면 이렇게 선언하고 초기화해줘야한다.
		//위 방식의 문제점
		// 관리가 어려움, 특정 조건에 따른 데이터를 가져오기 힘듦
		
		//배열 (메모리주소가 들어가있는것)
		// 동일한 타입이면서 동일한 그룹의 변수들을 묶어서 관리해주는 형태
		// 선언 방법 : 데이터타입[] 배열명;
		int[] scores ; //배열명은 복수형태로 쓰거나, 뒤에 List를 붙여서 명명
		// 생성 방법 : 배열명 = new 데이터타입[배열의 길이];
		scores = new int[5];
		System.out.println(scores); //메모리주소는 값이 바뀌더라도 주소는 변하지 않는다. 참조변수는 실제 주소가 들어있다.
		//초기화 방법 : 배열명[인덱스번호] = 데이터;
		//인덱스는 0번 부터 시작한다.
		scores[0] = 90;
		scores[1] = 100;
		scores[2] = 70;
		scores[3] = 80;
		scores[4] = 75;
		
		// 선언과 동시에 생성 및 초기화
		// 1. 데이터타입[] 배열명 = new 데이터타입[]{요소};
		int[] scoreList = new int[/*여기서는 배열 길이 지정하지 않는다*/] {90, 100, 95}; //객체지향 언어에서는 대부분 new를 배열선언이나 클래스를 객체로 만들때 사용한다
		System.out.println(scoreList.length);
		// 2. 데이터타입[] 배열명 = {요소1, 요소2, ...};
		char[] string = { 'h', 'e', 'l', 'l', 'o' };
		System.out.println(string);
		
		string[0] = 'k';
		System.out.println(string[0]);
		
		//다차원배열
		//배열 안에도 기본 데이터타입이 아닌, 주소를 포함하는 참조형 데이터타입도 들어갈수 있다.
		//선언방법 : 데이터타입[][] 배열명;
		//생성 방법 : 배열명 = new 데이터타입[첫번째 배열길이][두번째 배열길이];
		// 성언과 동시에 초기화
		// 1. 데이터타입[][] 배열명 = new 데이터타이[][] {{요소11,..},{요소22,...},...};
		// 2. 데이터타입[][] 배열명 = {{요소11, ...},{요소22,...},...};
		
		//scoreList = {90, 100, 95}
		int[] extraScoreList = scoreList;
		System.out.println(extraScoreList);
		System.out.println(scoreList); //둘의 메모리주소는 동일하게 나온다
		//배열은 같은 방향성을 가지고 같은것을 바라보는 개념. 그래서 그게 바뀌면.. 같이 바뀌게 된다? ->객체 할때 다시 설명
		//배열복사 -> 한 배열을 바꾸더라도 다른 배열은 바뀌지 않는다
		
		extraScoreList[0] = 70; 
		
		System.out.println(scoreList[0]);
	}

}
