package chapter2.D_While;
//while 반복문
//일반적으로 반복횟수가 지정되어 있지 않을 때 사용하는 반복문

public class While {

	public static void main(String[] args) {
		// while 문
		// 조건을 검사하고 해당 조건이 true일 경우 코드 블럭을 실행하는 반복문 (여기까진 if문과 유사)
		// if문의 반복문 형태
		// 반복 실행할 코드 블록이 종료되면 조건을 다시 검사하고
		// true면 반복, false면 탈출
		// 사용방법 : while (조건) { 실행할 코드 }
		
		int number = 0 ;
		
//		while(number < 20) { //while 문 내에서 조건의 변수가 변경이 일어나야 무한루프에 빠지지 않을수 있다
//			System.out.println(number);
//			// ☆ while문에서는 조건에 사용되는 변수가
//			// 필수로 실행코드 내에서 변경이 이루어 져야한다!
//			number++; //for문에서 index++하는것과 같다
//		}
		
		while(true) { //무한하게 돌리게된다.
			//continue : continue문을 만나면 코드블럭내에서 아래에 오는
			// '모든 코드를 무시'하고 다시 조건을 검사
			// 일반적으로 continue문은 조건문과 함께 사용된다.
			// ☆ while문에서는 ! 조건문의 코드 블럭 내에 해당 변수를 변경시켜주는 코드가 존재 해야한다.
			if ((number %2) == 0 /*number이 홀수인 경우..????? -> 짝수인경우의 조건으로 바꿔야 무한루프 안빠지게됨 */) { 
				//(number %2) == 1은 왜 무한루프에 빠지지?
				//(number %2) == 1의 경우 199일때 if 조건을 만족해서 number++가 되게 되고
				// 200은 이 if문 통과하고 36번 줄의 number++를 만나서 201이 된다. 그럼 if(number==200) break 가 될수없게되서 무한 루프!
				number++;
				continue;
			}
			System.out.println(number);
			number++;
			//break : 반복문의 코드 블럭을 강제로 졸료 시킬때 사용
			//일반적으로 break문은 조건문과 함께 사용된다.
			if(number==200) break;
		}
		
		// number = 200
		
		// do - while
		// 반복 실행할 코드를 무조건 한번 실행 한 후에 조건을 검사하는 반복문
		// 사용 방법  : do {실행할 코드} while (조건) ;
		
		do {
			System.out.println(number);
			number ++ ;
		} while (number < 200); //false 값
		System.out.println(number);
	}

}
