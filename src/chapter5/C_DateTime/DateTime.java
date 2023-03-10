package chapter5.C_DateTime;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

// 날짜 및 시간
public class DateTime { //자바에 포함된 클래스 들이라서 전부 대문자로 표시

	public static void main(String[] args) {
		//System.currentTimeMillis()
		//현재시간을 long타입으로 0.001초 단위로 표현
		//기준 1970년 1월 1일 / 기준으로부터 얼마나 지났는지 표시
		long startTime = System.currentTimeMillis();
		System.out.println(startTime);
		
		for(int count = 0 ; count < 1000000000; count++) {
			count++;
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		
		//Date class 
		//날짜를 관리해주는 클래스
		//주로 날짜와 관련된 데이터타입을 취급할때 사용, 연산할때는 거의 쓰이지 않는다.
		//데이트 타입의 데이트를 저장할때 사용한다
		Date date = new Date();
		System.out.println(date);
		
		System.out.println(date.getMonth()); //지금 3월인데 2로나옴 : index개념으로 다뤄서 그렇다
		//값을 저장하는 용도로만 많이 사용한다
		date.setHours(10);
//		date.setHours(date.getHours() + 2); //로도 사용한다
		System.out.println(date);
		
		//요즘에 많이 쓰이는 방법
		Date now = Date.from(Instant.now());//타임객체를 date로 바꾸는 과정
		System.out.println(now); 
		//시간 추가 또는 바꾸려면 이 방식을 외워야한다..
		Date minusTwoHour = date.from(Instant.now().minus(2, ChronoUnit.HOURS));
		System.out.println(minusTwoHour);
		
		//SimpleDateFormat
		// Date타입의 참조변수를 지정한 포멧의 문자열로 변경해주는 클래스
		//y : 연, M : 월, d : 일, H : 시간, : m 분, s : 초
		SimpleDateFormat simpleDateFormat/*sdf로 적는 사람도 있음*/ = 
				new SimpleDateFormat("yyyy. MM. dd. HH:mm:ss");
		String formatedDate = simpleDateFormat.format(now);
		System.out.println(formatedDate);
		
		//Time Package
		//Date와 Calander 클래스의 단점 보완
		
			//LocalDate class
			//날짜를 관리해주는 class
			LocalDate localDate = LocalDate.now();
			System.out.println(localDate);
			/*요거*/LocalDate localDateOf = LocalDate.of(2022, 12, 25);
			System.out.println(localDateOf);
			
			//LocalTime class
			//시간을 관리해주는 class
			LocalTime localTime = LocalTime.now();
			System.out.println(localTime);
			/*요거*/LocalTime localTimeOf = LocalTime.of(12, 40);
			System.out.println(localTimeOf);
			
			//LocalDateTime class
			//날짜와 시간을 관리해주는 class
			LocalDateTime localDateTime = LocalDateTime.now();
			System.out.println(localDateTime);
			LocalDateTime localDateTimeOf = 
					LocalDateTime.of(localDateOf, localTimeOf); //요거 요거 받아옴
			System.out.println(localDateTimeOf);
			
			/**/
			//BigDecimal
			double a = 34.96753;
			double b = 45.65431;
			System.out.println(a + b);
			
			BigDecimal number = new BigDecimal(String.valueOf(a));
			BigDecimal number2 = new BigDecimal(String.valueOf(b));
			System.out.println(number.add(number2));
			/**/
			//백엔드는 날짜를 다루지 않는다. 대부분 프론트엔드에서 선택한 날짜 받아오거나 현재날짜 등록하는것 정도.
			
			//특정 날짜 혹은 시간 가져오기
			// .get***();
			int year = localDateTime.getYear();
			int month = localDateTime.getMonthValue();
			System.out.println(month); //3
			Month enumMonth = localDateTime.getMonth();
			System.out.println(enumMonth); //MARCH
			int dayOfYear = localDateTime.getDayOfYear();
			System.out.println(dayOfYear); //이번년도에서 몇번째 날인지 //69
			int dayOfMonth = localDateTime.getDayOfMonth();
			System.out.println(dayOfMonth); //월기준몇번째 날인지
			DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();
			System.out.println(dayOfWeek);
			
			boolean isLeapYear = localDate.isLeapYear(); //윤달 표시
			
			int hour = localDateTime.getHour();
			int minute = localDateTime.getMinute();
			int second = localDateTime.getSecond();
			int nano = localDateTime.getNano();
			
			//특정 날짜 및 시간 변경(직접변경, 더하기, 빼기)
			// 직접변경 : with***(int타입 데이터);
			// 더하기 - 빼기 : plus***(long 타입 데이터), minus***(long 타입 데이터);
			//date 2개 time 2개 해보기
			//localDateTime = localDateTime.withYear(2012); //직접변경
			localDateTime = localDateTime.withYear(2012).plusWeeks(4).minusHours(9);//더하기 빼기
			//localDateTime = localDateTime.withDayOfYear(1); //1월 1일 //직접변경
			localDateTime = localDateTime.withDayOfYear(1).plusMinutes(50).minusNanos(50000); //더하기 빼기
			/*localDateTime = 이 부분을 추가하니까 지정한 날짜로 밑에 출력이 됐는데 이거 안하면 현재시간으로 출력*/
			//왜지?
			
			//일정관리하는거 만들땐 필요하다
			
			//일반적으로 Date타입으로 저장해서 사용한다
			//데이트 타입을 연산시에 인스턴스 만들어주는게 좋다?
			Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
			Date datetime = Date.from(instant);
			System.out.println(datetime);
			
	}

}
