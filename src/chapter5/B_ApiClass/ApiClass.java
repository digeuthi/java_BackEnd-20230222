package chapter5.B_ApiClass;

import java.util.Random;
import java.util.Scanner;

//API class
// Java 자체에서 제공해주는 개발에 도움을 주는 각종 라이브러리
public class ApiClass {

	public static void main(String[] args) {
		
		//Object Class
		// 모든 class의 조상 class
		Object object = new Scanner(System.in);
		object = new int[10]; //모든걸 다 받을 수 있다.
		
		//String class
		// 문자열 처리에 대한 메서드가 정의되어 있는 클래스
//		char[] string = {'a', 'b', 'c', 'd'};
		String string = " This is string contents ";
			//.concat()은 +로 대체가능
			//.substring(시작인덱스, 종료인덱스);
			String subString = string.substring(6, 8);
			System.out.println(subString);
			
			//.length();
			//문자열 길이 가져오는 메서드
			
			//.toUpperCase();
			//모든 문자를 대문자로 교체
			String upperCase = string.toUpperCase();
			//.toLowerCase();
			//모든 문자를 소문자로 교체
			String lowerCase = string.toLowerCase();
			
			System.out.println(upperCase);
			System.out.println(lowerCase);
			
			//.indexOf(문자열);
			//해당하는 문자열이 존재한다면 그 위치의 첫번째 인덱스 번호를 반환
			//해당하는 문자열이 존재하지 않으면 -1 반환
			int stringIndex = string.indexOf("is");
			System.out.println(stringIndex); //존재하지 않는 문자를 검색하면 -1이 뜬다
			
			//.trim();
			//문자열의 앞뒤 공백 제서
			String trimString = string.trim();
			System.out.println(trimString);
			
			//.replaceAll(변환할 문자열, 변환될 문자열);
			// 특정 문자열을 지정한 문자열로 변경
			String replacsString = string.replaceAll("is", "are");
			System.out.println(replacsString);
			
		//Wrapper class
		//기본형 데이터 타입을 참조형 데이터 타입으로 다루기 위한 클래스 (왜 참조형으로 다루려고하지)
			//참조형 클래스에 기본형 클래스 넣을수 없어서 사용한다?
		//int -> Integer
		//double -> Double
		//...
		
		Integer integer = 10;
		int number = integer;
		
			//문자열 -> 숫자
			String numberString = "110";
			number = Integer.parseInt(numberString);
			System.out.println(number);
			
			//숫자 -> 문자열
			numberString = Integer.toString(550);
			System.out.println(numberString);
			
		//Random class
		// 무작위의 값을 얻고자 할때 유용한 클래스
		Random random = new Random();
			//.nextInt() : 무작위의 int형 정수
			//.nextLong() : 무작위의 long형 정수
			//.nextInt(최대값) : 최대값보다 작은 int형 정수 //양수만 나옴
			int randomNumber = random.nextInt(3);
			System.out.println(randomNumber);
			
			//로또번호 생성기 만들기 : 중복된 값이 없어야한다.
			//배열만 쓰게 되면 중복을 제거하거나 정렬할때도 로직을 짜줘야한다.
			int[] lotto = new int[6];
			for(int index = 0 ; index < lotto.length ; index++) {
				
				//중복값제거 ->어떻게 이해를..?!(89~102구간)
				boolean equal = false;
				
				int lottoNumber = random.nextInt(45) + 1; //0~44가 1~45가된다
				
				for(int subIndex = 0 ; subIndex < index ; subIndex++) {
					//lottoNumber안에는 1부터 45값이 들어가 있으므로
					//index = 1, subIndex = 0인 경우 밑의 if문이 안돌아간다.
					if(lotto[subIndex]==lottoNumber) { 
						//continue;
						//맨처음에 continue; 적었었는데 이렇게 되면 이 코드블럭내에서
						//continue가 돌게된다.->중복값나옴
//						System.out.println(lotto[subIndex] + " " + lotto[index]);
						equal = true;
					}
				}
				
				if(equal) {
					--index;
					continue;
				}
				
//				lotto[index] = random.nextInt(45) + 1; //0~44가 1~45가된다
				lotto[index] = lottoNumber;
			}
			
			for(int lottoNumber : lotto) {
				System.out.print(lottoNumber + " ");
			}
			
			
		
	}

}
