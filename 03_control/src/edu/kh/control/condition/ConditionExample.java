package edu.kh.control.condition;

import java.util.Scanner;

public class ConditionExample { // 기능 제공용 클래스
	
	Scanner sc = new Scanner(System.in);
	// AS-IS 메서드마다 지역변수로 선언했었음
	// TO-BE 필드에 전역변수에 선언하여 코드 최소화 가능 
		
	public void ex1() {
		
		// 1. if문
		// 조건식이 true일 때만 내부 코드 수행
		/*
		 * [작성법]
		 * if(조건식) {
		 * 		조건식이 true일 때 수행할 코드
		 * }
		 */
		
		// 입력받은 정수가 양수인지 검사
		// 양수라면 "양수입니다" 출력
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		if(input > 0) {
			System.out.println("양수입니다");
		}
		
		if(input <= 0) {
			System.out.println("양수가 아니다");
		}
	}
	
	public void ex2() {
		
		// 2. if-else문
		// 조건식 결과가 true면 if문 수행,
		// false면 else 구문이 수행됨
		
		/*
		 * [작성법]
		 * if(조건식) {
		 *		조건식이 true일 때 수행될 코드
		 * } else {
		 *		조건식이 false일 때 수행될 코드 
		 * }
		 */
		
		// 홀짝 검사
		// 입력받은 정수값이 홀수이면 "홀수입니다"출력
		// 0이면 "0입니다"
		// 짝수이면 "짝수입니다"출력
		// else if 사용 X, 중첩 if문 사용하기
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		if(input % 2 != 0) {
			System.out.println("홀수입니다");
		} else { // 짝수 또는 0입력 시 수행
			
			if(input == 0) {
				System.out.println("0입니다.");
			} else {
				System.out.println("짝수입니다");
			}
		}		
	}

	
	public void ex3() {
		// 양수, 음수, 0판별
		// 3. if(조건식) - else if(조건식) - else
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		if(input > 0) {
			System.out.println("양수입니다");
		} else if(input < 0) { // 바로 위에있는 if문이 만족되지 않은 경우 수행
			System.out.println("음수입니다");
		} else {
			System.out.println("0입니다");
		}
	}
	
	public void ex4() {
		// 달(month)을 입력받아 해당 달에 맞는 계절 출력
		// 단, 겨울일 때 온도가 -15도 이하 "한파 경보", -12도 이하 "한파 주의보"
		// 여름일때 온도가 35도 이상 "폭염 경보", 33도 이상 "폭염 주의보"
		// 1 ~ 12월 사이가 아닐 땐 "해당하는 계절이 없습니다" 출력
		// 1, 2, 12 : 겨울
		// 3 ~ 5 : 봄
		// 6 ~ 8 : 여름
		// 9 ~ 11 : 가을
		
		System.out.print("달 입력 : ");
		int month = sc.nextInt();
		
		String season; // 아래 조건문 수행 결과를 저장할 변수 선언
	
		
		if(month == 1 || month == 2 || month == 12) {
			season = "겨울";
			
			System.out.print("온도 입력 : ");
			int temp = sc.nextInt();
			
			if(temp <= -15) {
				season += " 한파 경보";
				// 겨울
				// season = season + "한파 경보";
				// "겨울 한파 경보"
			} else if(temp <= -12) {
				season += " 한파 주의보";
			}
		} else if (month >= 3 && month <= 5) {
			season = "봄";
		} else if (month >= 6 && month <= 8) {
			season = "여름";
			
			System.out.print("온도 입력 : ");
			int temp = sc.nextInt();
			
			if(temp >= 35) {
				season += " 폭염 경보";
			} else if(temp >= 33) {
				season += " 폭염 주의보";
			}
			
		} else if (month >= 9 && month <= 11) {
			season = "가을";
		} else {
			season = "해당하는 계절이 없습니다.";
		}
		
		System.out.println(season);		
		
	}

	
	public void ex5() {
		// 나이를 입력 받아
		// 13세 이하면 "어린이 입니다."
		// 13세 초과 19세 이하면 : "청소년 입니다."
		// 19세 초과 시 : "성인 입니다". 출력
		
		System.out.print("나이 입력 : ");
		int input = sc.nextInt();
		
		if(input <= 13) {
			System.out.println("어린이입니다");
		} else if(input > 19) {
			System.out.println("성인입니다");
		} else {
			System.out.println("청소년입니다");
		}
	}
	
	public void ex6() {
		// 점수(100점 만점)를 입력 받아
		// 90점 이상 : A
		// 80점 이상 90점 미만 : B
		// 70점 이상 80점 미만 : C
		// 60점 이상 70점 미만 : D
		// 60점 미만 : F
		// 0점 미만, 100 초과 : "잘못 입력하셨습니다"
	
		/* -- 내 풀이 --
		System.out.print("점수(100점 만점) 입력 : ");
		int input = sc.nextInt();
		
		if(input >= 0 && input <= 100) {
			if(input >= 90) {
				System.out.println("A");
			} else if(input >= 80 && input < 90) {
				System.out.println("B");
			} else if(input >= 70 && input < 80) {
				System.out.println("C");
			} else if(input >= 60 && input < 70) {
				System.out.println("D");
			} else {
				System.out.println("F");
			}
		} else {
			System.out.println("잘못 입력하셨습니다");
		}
		*/
		
		// 강사님 풀이
		System.out.print("점수(100점 만점) 입력 : ");
		int score = sc.nextInt();
		
		String result;
		
		if(score < 0 || score > 100) {
			result = "잘못 입력하셨습니다";
		} else if(score >= 90) {
			result = "A";
		} else if(score >= 80) {
			result = "B";
		} else if(score >= 70) {
			result = "C";
		} else if(score >= 60) {
			result = "D";
		} else {
			result = "F";
		}
		
		System.out.println(result);
	}
	
	
	
	public void ex7() {
		// 놀이기구 탑승 제한 검사
		// 나이가 12세 이상, 키 140.0cm 이상 일 경우에만 "탑승 가능"
		// 나이가 12미만인 경우 : "적정 연령이 아닙니다."
		// 키가 140.0cm 미만 : "적정 키가 아닙니다."
		// 나이를 0세 미만, 100세 초과 시 : "잘못 입력 하셨습니다."
		
		/* -- 내 풀이 --
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		
		if(age >= 0 && age <= 100) {
			if(age >= 12) {
				System.out.print("키 입력 : ");
				double height = sc.nextDouble();
				
				if(height >= 140.0) {
					System.out.println("탑승 가능");
				} else {
					System.out.println("적정 키가 아닙니다");
				}
			} else {
				System.out.println("적정 연령이 아닙니다");
			}
		} else {
			System.out.println("잘못 입력하셨습니다");
		}
	
		*/
		
		// -- 강사님 풀이 -- 
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		
		String result;
		
		if(age < 0 || age > 100) {
			result = "잘못 입력하셨습니다.";
		} else {
			System.out.print("키 입력 : ");
			double height = sc.nextDouble();
			
			if(age < 12 ) {
				result = "적정 연령이 아닙니다.";
			} else if(height < 140.0) {
				result = "적정 키가 아닙니다";
			} else {
				result = "탑승 가능";
			}
		}
		System.out.println(result);
	}
		
	public void ex8() {
		// 놀이기구 탑승 제한 검사 프로그램
		// 조건 - 나이 : 12세 이상
		// - 키 : 140.0cm 이상
		// 나이를 0~100세 사이로 입력하지 않은 경우 : "나이를 잘못 입력 하셨습니다."
		// 키를 0~250.0cm 사이로 입력하지 않은 경우 : "키를 잘못 입력 하셨습니다."
		// -> 입력이 되자 마자 검사를 진행하여 잘못된 경우 프로그램 종료
		// 나이 O , 키 X : "나이는 적절하나, 키가 적절치 않음";
		// 나이 X , 키 O : "키는 적절하나, 나이는 적절치 않음";
		// 나이 X , 키 X : "나이와 키 모두 적절치 않음";
		// 나이 O , 키 O : "탑승 가능"
		
		
		/* -- 내 풀이 --
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		
		System.out.print("키 입력 : ");
		double height = sc.nextDouble();
		
		
		boolean age1 = age >= 12;
		boolean height1 = height >= 140.0;
		
	
		if(age < 0 || age > 100) {
			System.out.println("나이를 잘못 입력하셨습니다.");
		} else if(height < 0 || height > 250.0) {
			System.out.println("키를 잘못 입력하셨습니다.");
		} else {
			
			if(age1 == true && height1 == false) {
				System.out.println("나이는 적절하나, 키가 적절치 않음");
			} else if(age1 == false && height1 == true) {
				System.out.println("키는 적절하나, 나이가 적절치 않음");
			} else if(age1 == false && height1 == false) {
				System.out.println("나이와 키 모두 적절치 않음");
			} else {
				System.out.println("탑승 가능");
			}
		}
		*/
		
		// -- 강사님 풀이 --
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		
		String result;
		
		if(age < 0 || age > 100) {
			result = "나이를 잘못 입력했어요";
			
		} else {
			System.out.print("키 입력 : ");
			double height = sc.nextDouble();
			
			if(height < 0 || height > 250) {
				result = "키를 잘못 입력했어요";
			} else { 
				
				if(age < 12 && height >= 140.0) { // 나이 X, 키 O
					result ="키는 적절하나, 나이가 적절치 않음";
				} else if(age >= 12 && height <= 140.0) { // 나이 O, 키 X
					result = "나이는 적절하나, 키가 적절치 않음";
				} else if(age <= 12 && height <= 140.0) { // 나이 X, 키 X
					result = "나이와 키 모두 적절치 않음";
				} else {
					result = "탑승 가능";
				}
			}
		}
		
		System.out.println(result);
	}
	
}
