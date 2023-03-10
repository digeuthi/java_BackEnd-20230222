package Example.Exchange;

import java.util.Scanner;

// 환전기 어플리케이션
// Input : 금액, 넣을 화폐, 바꿀 화폐
// Output : 금액, 바뀐 화폐
public class ExchangeApplication {
	
	//화폐단위 따로 관리해주기, 관리하는 화폐 배열로 만들어줌
	private static String[] managedCurrencies = {
			"KRW", "USD", "JPY"
	};
	
	//원화 달러 엔화만 환전 가능하게함, 가능한 경우의 수 6, 6개짜리 배열 만들기
	private static ExchangeRate[] exchangeRates = { //가져와서 바로 초기화 해주는건가? //인스턴스
		// 원화 - 달러
		new ExchangeRate("KRW","USD", 1000 / 1318.80),
		// 원화 - 엔
		new ExchangeRate("KRW","JPY", 1000 / 960.35),
		// 달러 - 원화
		new ExchangeRate("USD", "KRW", 1318.80 / 1000),
		// 달러 - 엔
		new ExchangeRate("USD", "JPY", 1318.80 / 0.96035),
		// 엔 - 원화
		new ExchangeRate("JPY", "KRW", 960.35 / 1000),
		// 엔 - 달러
		new ExchangeRate("JPY", "USD", 0.96035 / 1318.80)
	};
	
	
	public static void main(String[] args) { //인스턴스 변수 가져와서 쓸수없다
		//ExchangeRate exchangeRate = new ExchangeRate();
		//ExchangeRate에 private를 해놨기때문에 사용할 수없게된다.
		
		//입력받기
		Scanner scanner = new Scanner(System.in);
		
		//try문 안에서 각 변수 설정해주면 지역변수로 인식해서
		//그 밑에서 변수를 받을수 없게 되므로 이렇게 따로 빼서 전역 변수로 설정
		String exchangingCurrency = null;
		String exchangedCurrency = null;
		int amount = 0;
		
		//0309일자에 try catch문 추가
		try {
			System.out.println("넣을 화폐 : ");
			exchangingCurrency = scanner.nextLine(); //넣을 화폐 단위 
			
			System.out.println("바꿀 화폐 : ");
			exchangedCurrency = scanner.nextLine(); // 바꿀 화폐 단위 
			
			System.out.println("금액 : ");
			amount = scanner.nextInt(); // 돈
			
		}catch(Exception exception) {
			//exception.printStackTrace(); //이렇게 하면 오류로 콘솔에 출력된다.
			System.out.println("입력값의 타입이 맞지않습니다.");
			return;
		}
		
		
		
		//입력값 확인
		System.out.println(exchangingCurrency + " " + exchangedCurrency + " " + amount);
		
		
		//입력 검증
		// 모두 입력했는지
		if(exchangingCurrency.isBlank() || exchangedCurrency.isBlank()){
			System.out.println("모두 입력해 주세요.");
			return; //메서드 종료
		}
		
		//입력한 화폐가 동일 할때
		if(exchangingCurrency.equals(exchangedCurrency)) {
			System.out.println("동일한 화폐로 환전할 수 없습니다");
			return;
		}
		
		// 유효한 금액이 아닐 때 (금액이 양수가 아닐때)
		if(amount <= 0) {
			System.out.println("유효한 금액이 아닙니다");
			return;
		}
		
		// 관리하고 있는 화폐단위가 아닐 때 : 저장공간 휘발성 메모리에 있다
		// 맨위에 저장한 managedCurrencies에 저장 -> SQL문으로 처리하면 더 쉽게할수 있다.(90 ~ 105 한줄로 처리됨)
//		if(!exchangingCurrency.equals("KRW") || !exchangedCurrency.equals("KRW")) {
//			//이렇게 다 하나하나 조건에 넣으려면 하드하다.. 나중에 수정도 어려워진다
//			//우리가 관리하는 화폐단위를 따로 관리해주면 좋다 -> 맨위에 배열만들어서 묶어서 관리
//		}
		//☆배열을 읽을 용도로만 쓰려면 foreach 형태가 더 좋다
		//실제로 수정을 하거나 입력을 하려는 경우 일반 for문을 사용해야 한다
		
			
//			밑에 오류떠서 주석처리
		//if(
//					!exchangingCurrency.equals(exchangedCurrency)|| 
//					!exchangedCurrency.equals(exchangingCurrency)
//					){
//				System.out.println("유효하지 않은 화폐 단위입니다.");
//				return;
//			}
//		}
		
		boolean hasExchanging = false;
		boolean hasExchanged = false;
		
		for(String managedCurrency : managedCurrencies) {
			if( exchangingCurrency.equals(managedCurrency) ) {
				hasExchanging = true;
			}
			if(exchangedCurrency.equals(exchangedCurrency)) {//왜 둘다 ed ed 비교일까
				hasExchanged = true;
			}
		}
		
		if(!(hasExchanging && hasExchanged)) {
			System.out.println("유효하지 않은 화폐단위입니다.");
			return;
		}
		
		
		//정상 프로세스
		//휘발성 메모리로 저장해놓은 것을 가져와서 작업
		//데이터 베이스에 저장을 해두면 코드가 훨씬 단순해지고 한줄로 끝난다.
		double resultAmount = amount;
		
//		for(ExchangeRate exchangeRate : exchangeRates) {
//			if(exchangingCurrency.equals(exchangeRate.getExchangingCurrency())) {
//				if(exchangedCurrency.equals(exchangeRate.getExchangedCurrency())) {
//					
//				}
//			}
//		} //이런식의 구조를 피라미드 구조라고 하는데 이렇게 되면 복잡하고 보기가 어려워진다.
		  //if문 두개를 합쳐서 한번에 보이게 하는 구조로 하는게 한눈에 보기 더 좋다
		
		for(ExchangeRate exchangeRate : exchangeRates) {
			boolean /*☆*/isSame = exchangingCurrency.equals(exchangeRate.getExchangingCurrency())&& 
					exchangedCurrency.equals(exchangeRate.getExchangedCurrency()); //구문깔끔하게
			if(isSame)
			{
					resultAmount *= exchangeRate.getExchangeRate();
					break; //break 넣는 이유..?
				}
			}
		
		//정상 출력하기
		System.out.println(exchangedCurrency + " : " + resultAmount);
	}

}
