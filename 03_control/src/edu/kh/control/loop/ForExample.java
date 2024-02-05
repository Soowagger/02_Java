package edu.kh.control.loop;

import java.util.Scanner;

public class ForExample { // 제공용 클래스
	
	/* for 문
	 	- 끝이 정해져 있는(횟수가 지정되어 있는) 반복문
	 	
	 [작성법]
	 	for(초기식; 조건식; 증감식) {
	 		조건식이 true라면 반복 수행할 코드
	 	}	
	 	
	 	- 초기식 : for문을 제어하는 용도의 변수 선언
	 	
	 	- 조건식 : for문의 반복 여부를 지정하는 식
	 			보통 초기식에 사용된 변수를 이용하여 조건식을 작성함
	 			
	 	- 증감식 : 초기식에 사용된 변수를
	 			for문이 끝날 때 마다 증가 또는 감소시켜
	 			조건식의 결과를 변하게 하는 식
	 */
	
	public void ex1() {
		
		for(int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
	}
	
	public void ex2() {
		// 1부터 입력받은 수까지 1씩 증가하며 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력 번호 : ");
		int input = sc.nextInt();
		
		for(int i=1; i <= input ; i++) {
			
			System.out.println(i);
		}
	}
	
	
	public void ex3() {
		// 영어 알파벳 A부터 Z까지 한줄로 출력
		// ABCDEFG ~ Z

		for(int i = 'A'; i <= 'Z'; i++ ) {
			System.out.print((char)i); // 강제 형변환
		}
	
		System.out.println("\n==========================");
		
		for(char i = 'A'; i <= 'Z'; i++) {
			System.out.print(i);
		}
	}
	
	
	public void ex4() {
		// 정수 5개를 입력받아서 합계 구하기
		
		// ex)
		// 입력 1 : 10
		// 입력 2 : 20
		// 입력 3 : 30
		// 입력 4 : 40
		// 입력 5 : 50
		// 합계 : 150
				
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		
		for(int i = 1; i <= 5; i++) {
		
			System.out.print("입력 " + i + " : ");
			int input = sc.nextInt();
				
			sum += input;	
		}
		
		System.out.println("합계 : " + sum);		
	}
	
	
	public void ex5() {
		// 1부터 20까지 1씩 증가하면서 출력
		// 단, 입력받은 수의 배수는 양쪽에 () 표시
		
		// ex)
		// 괄호를 표시할 배수 : 3
		// 1 2 (3) 4 5 (6) 7 .. 20
		Scanner sc = new Scanner(System.in);
		
		System.out.print("괄호를 표시할 배수 : ");
		int num = sc.nextInt();
		
		for(int i=1; i <= 20; i++) {
					
			if(i % num == 0) {
				System.out.print("(" + i + ") ");
			} else {
				System.out.print(i + " ");
			}
		}
	}
	
	
	public void ex6() {
		// [구구단 출력]
		// 2 ~ 9 사이 수를 하나 입력받아
		// 해당 단을 출력
		// 단, 입력받은 수가 2~9 사이 숫자가 아니면
		// "잘못 입력하셨습니다" 출력
		
		/* ex)
		  단 입력 : 5
		  5 X 1 = 5
		  5 X 2 = 10
		  5 X 3 = 15
		  5 X 4 = 20
		  ...
		 */
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("단 입력 : ");
		int dan = sc.nextInt();
		
		if(dan >= 2 && dan <= 9) { // 2~9단
			
			for(int i = 1; i <= 9; i++) {
				System.out.printf("%d X %d = %d\n", dan, i, dan*i);
			}			
			
		} else {
			System.out.println("잘못 입력하셨습니다");
		}
		

	}
	
	public void ex7() {
		
		// 구구단 모두 출력하기
		
		for(int i = 2; i <= 9; i++) { // 2 ~ 9단까지 차례대로 증가
			
			for(int j = 1; j <= 9; j++) { // 각 단에 곱해질 수 1~9까지 증가
			
				System.out.printf("%d X %d = %2d  ", i, j, i * j );
			
			}
			System.out.println();
		}
		
		
		System.out.println("역순출력=========================");		
		
		// 구구단 역순 출력
		// 9단 -> 2단까지 역방향
		// 곱해지는 수는 1 -> 9 정방향
		
		for(int i = 9; i >= 2; i--) { // 단 9 -> 2 역방향
						
			for(int j = 1; j <= 9; j++) {
			
				System.out.printf("%d X %d = %2d  ", i, j, i * j );
			}
			
			System.out.println();
		}	
	}
	
	
	public void ex8() {
		
		// 숫자 세기 count
		
		// 1 ~ 20까지 1씩 증가하면서
		// 입력받은 수의 배수의 총 개수 출력
		// 입력받은 수의 배수의 합계 출력
		
		
		// 배수 입력 : 3 
		// 3 6 9 12 15 18 : 6개
		// 3의 배수 합계 : 63
		Scanner sc = new Scanner(System.in);
		
		int count = 0; // n의 배수의 개수를 세기 위한 변수
		int sum = 0; // n의 배수의 합계를 구하기 위한 변수
		String result = ""; 
		
		
		System.out.print("배수 입력 : ");
		int input = sc.nextInt();
		
		for(int i = 1; i <= 20; i++) {
			
			if( i % input == 0) {
				result += i + " ";
				count++;
				sum += i;
			} 
		}
		
		System.out.printf("%s: %d개\n", result, count);
		System.out.printf("%d의 배수 합계 : %d", input, sum);
		
		
	}
	
	
}
