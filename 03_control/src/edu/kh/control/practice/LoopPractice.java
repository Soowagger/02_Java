package edu.kh.control.practice;

import java.util.Scanner;

public class LoopPractice {
	
	Scanner sc = new Scanner(System.in);
	
	public void practice1() {
		// 사용자로부터 한 개의 값을 입력 받아 1부터 그 숫자까지의 숫자들을 모두 출력하세요.
		// 단, 입력한 수는 1보다 크거나 같아야 합니다.
		// 만일 1 미만의 숫자가 입력됐다면 “1 이상의 숫자를 입력해주세요“를 출력하세요.
		
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int input = sc.nextInt();
		
		if(input >= 1) {
			for(int i=1; i <= input; i++) {
				System.out.print(i + " ");
			}
			
		} else {
			System.out.println("1 이상의 숫자를 입력해주세요");
		}
	}

	public void practice2() {
		// 사용자로부터 한 개의 값을 입력 받아 1부터 그 숫자까지의 모든 숫자를 거꾸로 출력하세요.
		// 단, 입력한 수는 1보다 크거나 같아야 합니다.
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int input = sc.nextInt();
		
		if(input >= 1) {
			for(int i=input; i >= 1; i--) {
				System.out.print(i + " ");
			}
		} else {
			System.out.println("1 이상의 숫자를 입력해주세요");
		}
		
	}
	
	public void practice3() {
		// 1부터 사용자에게 입력 받은 수까지의 정수들의 합을 for문을 이용하여 출력하세요.
	}
	
	
}
