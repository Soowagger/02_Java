package edu.kh.op.practice;

import java.util.Scanner;

public class OperatorPractice {
	
	
	public void practice1(){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("인원 수 : ");
		int input1 = sc.nextInt();
		
		System.out.print("사탕 개수 : ");
		int input2 = sc.nextInt();
		
		System.out.println();
		
		System.out.printf("1인당 사탕 개수 : %d\n", input2 / input1);
		System.out.printf("남는 사탕 개수 : %d\n", input2 % input1);
	}
	
	
	public void practice2(){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String inputName = sc.next();
		
		System.out.print("학년(정수만) : ");
		int inputGrade = sc.nextInt();
		
		System.out.print("반(정수만) : ");
		int inputClass = sc.nextInt();
		
		System.out.print("번호(정수만) : ");
		int inputNum = sc.nextInt();
		
		System.out.print("성별(남학생/여학생) : ");
		String inputGender = sc.next();
		
		System.out.print("성적(소수점 아래 둘째 자리까지) : ");
		double inputScore = sc.nextDouble();
		
		System.out.println();
		
		System.out.printf("%d학년 %d반 %d번 %s %s의 성적은 %.2f이다."
				,inputGrade, inputClass, inputNum, inputName, inputGender, inputScore);

	}
	
	public void practice3(){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 : ");
		int input1 = sc.nextInt();

		System.out.print("영어 : ");
		int input2 = sc.nextInt();
		
		System.out.print("수학 : ");
		int input3 = sc.nextInt();
		
		System.out.println();
		
		System.out.printf("합계 : %d\n", input1 + input2 + input3);
		System.out.printf("평균 : %.1f", (double)(input1 + input2 + input3)/3);		
		
		/* -----------강사님 풀이 다른 점-------------------

		int sum = input1 + input2 + input3; // 합계
		double avg = sum / 3.0; // 평균
				
		System.out.println("합계 : " + sum);
		System.out.printf("평균 : %.1f\n", avg);
					
		** 추가 문제 ** 
		
		세 과목의 점수가 각각 40점 이상이면서, 평균이 60점 이상일 때 합격
		아니면 불합격을 출력
		
		boolean result = (input1 >= 40) && (input2 >= 40) && (input3 >= 40) && (avg >= 60);
		System.out.println(result ? "합격": "불합격");
		
		*/
		
		
		
		
		
		
		
	}
}
