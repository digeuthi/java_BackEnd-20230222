package chapter5.B_ApiClass;

import java.util.Random;

public class Lotto {

	public static void main(String[] args) {
		Random random = new Random();
		int[] lotto = new int[6];
		
		for(int i = 0 ; i < lotto.length ; i++) {
			//중복값 체크
			boolean same = false; //이걸 왜 불린으로 따로 검증해주는걸까
	
			int lottoNum = random.nextInt(45) + 1 ; //1~45까지의 수 출력
			
			for(int j = 0 ; j < i ; j++) {
				if(lotto[j]==lottoNum) {
					same = true;
				}
			}
			if(same) {
				--i;
				continue;
			}
			lotto[i] = lottoNum;
		}
		
		for(int lottoNumber : lotto) {
			System.out.print(lottoNumber + " ");
		}
		
		System.out.println();
		System.out.println("다른 로또");
		
		int[] lotto2 = new int[6];
		for (int i = 0; i < lotto2.length; i++) {
			lotto2[i] = random.nextInt(45) + 1; 
			// 중복번호 제거
			for(int j = 0; j < i; j++) {
				if(lotto2[i] == lotto2[j]) {
					i--;
					break;
				} 
			}
		} 
		for(int lottoNumber2 : lotto2) {
			System.out.print(lottoNumber2 + " ");
		}

	}

}
