package chapter5.D_EtcClass;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;

// Timer - TimerTask
//특정 작업을 지연시킬때 사용
//TimerTask 클래스를 상속받아서 run 메서드를 구현

class Delay extends TimerTask/*abstract으로 구성*/{

	@Override
	public void run() {
		//지연시킬 메서드 작성
		System.out.println("지연!");
	}
	
}

public class EtcClass {

	public static void main(String[] args) {
		
		//Timer 클래스의 인스턴스로 TimerTask 구현체를 실행
		Timer timer = new Timer(true); //객체 생성하고 원하는시간 파라미터로 작성
		Delay delay = new Delay();
		timer.schedule(delay, 500); //500은 5초
		
//		//지연걸어주기?
//		for(int index = 0 ; index < 100000000; index++) {
//			int a = 10;
//			int b = 20;
//			a += b;
//			b -= a;
//		}
		
		System.out.println("완료");
		
		try {
		Thread.sleep(1000);}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		//BigDecimal
		//정확한 소수점 연산을 하기 위한 클래스
		double double1 = 9.45112548855;
		double double2 = 1.35224458811;
		System.out.println(double1 + double2);
		
		BigDecimal bigDecimal1 = new BigDecimal(String.valueOf(double1)); //안에 문자열을 넣어줘야한다
		BigDecimal bigDecimal2 = new BigDecimal(String.valueOf(double2));
		System.out.println(bigDecimal1.add(bigDecimal2));
		
		//DecimalFormat
		//일정형식으로 데이터 출력해주는 클래스
		DecimalFormat decimalFormat = new DecimalFormat("$###,###,###.00");
		System.out.println(decimalFormat.format(10_000_000)); //문자열로 출력
	}

}
