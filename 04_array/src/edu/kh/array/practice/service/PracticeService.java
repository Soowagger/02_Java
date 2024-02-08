package edu.kh.array.practice.service;

import java.util.Scanner;

public class PracticeService {
	
	Scanner sc = new Scanner(System.in);
	
	public void practice1() {
		//길이가 9인 배열을 선언 및 할당하고, 1부터 9까지의 값을 반복문을 이용하여
		// 순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
		// 짝수 번째 인덱스 값의 합을 출력하세요. (0 번째 인덱스는 짝수로 취급)
		
		// [실행 화면]
		// 1 2 3 4 5 6 7 8 9
		// 짝수 번째 인덱스 합 : 25
		int[] arr = new int[9];
		
		int sum = 0; // 합계 변수 지정
		String str = ""; // [1, 2, 3, 4, 5, 6, 7, 8, 9]을 문자열로 누적하기 위한 변수 지정
		
		System.out.printf(str);
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = i + 1;
			str += arr[i] + " ";
			
			if(i % 2 == 0) {
				sum += arr[i];
			}
		}
		
		System.out.printf("%s\n", str);
		System.out.println("짝수 번째 인덱스 합 : " + sum);
	}
	
	public void practice2() {
		// 길이가 9인 배열을 선언 및 할당하고, 9부터 1까지의 값을 반복문을 이용하여
		// 순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
		// 홀수 번째 인덱스 값의 합을 출력하세요. (0 번째 인덱스는 짝수로 취급)
		
		// [실행 화면]
		// 9 8 7 6 5 4 3 2 1
		// 홀수 번째 인덱스 합 : 20
		
		int[] arr = new int[9];
		
		int sum = 0;
		String str = "";
		
		for(int i=0; i < arr.length; i++) {
			arr[i] = arr.length - i; // arr[0] = 9-0
			str += arr[i] + " ";
			
			if(i % 2 == 1) {
				sum += arr[i];
			}
		}
		System.out.printf("%s\n", str);
		System.out.println("홀수 번째 인덱스 합 : " + sum);
	}
	
	public void practice3() {
		// 사용자에게 입력 받은 양의 정수만큼 배열 크기를 할당하고
		// 1부터 입력 받은 값까지 배열에 초기화한 후 출력하세요.
		
		// [실행 화면]
		// 양의 정수 : 5
		// 1 2 3 4 5
		System.out.print("양의 정수 : ");
		int input = sc.nextInt();
		String str = "";
		int[] arr = new int[input];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = i +1;
			str += arr[i] + " ";
		}
		
		System.out.print(str);
		
	}
	
	public void practice4() {
		// 정수 5개를 입력 받아 배열을 초기화 하고
		// 검색할 정수를 하나 입력 받아 배열에서 같은 수가 있는 인덱스를 찾아 출력.
		// 배열에 같은 수가 없을 경우 “일치하는 값이 존재하지 않습니다“ 출력
		
		/*
		[실행 화면 1]
		입력 0 : 5
		입력 1 : 8
		입력 2 : 9
		입력 3 : 10
		입력 4 : 4
		검색할 값 : 8
		인덱스 : 1
		
		[실행 화면 2]
		입력 0 : 5
		입력 1 : 8
		입력 2 : 9
		입력 3 : 10
		입력 4 : 4
		검색할 값 : 1
		일치하는 값이 존재하지 않습니다.
		*/
		
		int[] arr = new int[5];
		
		boolean flag = false;
		int result = 0;
		
		for(int i=0; i<arr.length; i++) {
			System.out.print("입력 " + i + " : ");
			arr[i] = sc.nextInt();
		}
		
		System.out.print("검색할 값 : ");
		int input = sc.nextInt();
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i]==input) {
				result = i;
				flag = true;
				
			} 
		}		
		
		if(flag) {
			System.out.println("인덱스 : " + result);		
		} else {
			System.out.println("일치하는 값이 존재하지 않습니다.");
		}

	}
	
	public void practice5() {
		// 문자열을 입력 받아 문자 하나하나를 배열에 넣고 검색할 문자가 문자열에 몇 개 들어가 있는지
		// 개수와 몇 번째 인덱스에 위치하는지 인덱스를 출력하세요.
		
		/*
		[실행 화면]
		문자열 : application
		문자 : i
		application에 i가 존재하는 위치(인덱스) : 4 8
		i 개수 : 2
		*/
		
		System.out.print("문자열 : ");
		String input = sc.nextLine();
		char[] arr = new char[input.length()];
		
		System.out.print("문자 : ");
		char ch = sc.next().charAt(0);
		
		boolean flag = false;
		int count = 0;
		String result = "";
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = input.charAt(i);
			
			if(arr[i]==ch) {
				flag = true;
				result += i + " ";
				count++;
			}
		}
		
		if(flag) {
			System.out.printf("%s에 %s가 존재하는 위치(인덱스) : %s\n",input, ch, result);
			System.out.println(ch + " 개수 : " + count);
		}
	}
	
	public void practice6() {
		/*
		사용자가 배열의 길이를 직접 입력하여 그 값만큼 정수형 배열을 선언 및 할당하고
		배열의 크기만큼 사용자가 직접 값을 입력하여 각각의 인덱스에 값을 초기화 하세요.
		그리고 배열 전체 값을 나열하고 각 인덱스에 저장된 값들의 합을 출력하세요.
		
		[실행 화면]
		정수 : 5
		배열 0번째 인덱스에 넣을 값 : 4
		배열 1번째 인덱스에 넣을 값 : -4
		배열 2번째 인덱스에 넣을 값 : 3
		배열 3번째 인덱스에 넣을 값 : -3
		배열 4번째 인덱스에 넣을 값 : 2
		4 -4 3 -3 2
		총 합 : 2
		*/
		
		System.out.print("정수 : ");
		int input = sc.nextInt();
		
		int[] arr = new int[input];
		int sum = 0;
		String str = "";
		
		for(int i=0; i<arr.length; i++) {
			System.out.printf("배열 %d번째 인덱스에 넣을 값 : ", i);
			arr[i] = sc.nextInt();
			str += arr[i] + " ";
			sum += arr[i];
		}
		
		System.out.println(str);
		System.out.println("총 합 : " + sum);
	}
	
	public void practice7() {
		/*
		주민등록번호 번호를 입력 받아 성별을 나타내는 숫자 이후부터 *로 가리고 출력하세요.
		[실행 화면]
		주민등록번호(-포함) : 123456-1234567
		123456-1******
		*/
		
		
		
		System.out.print("주민등록번호(-포함) : ");
		String input = sc.nextLine();
		
		char[] arr = new char[input.length()];
		char ch = '*';
		String result = ""; 
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = input.charAt(i);
		}
		
		for(int i=0; i<arr.length; i++) {
			
			if(i>7) {
				arr[i] = ch;
			}
			
			result += arr[i];
			
		}
		
		System.out.println(result);
	}
	
	public void practice8() {


		/*
		3이상인 홀수를 입력 받아 배열의 중간까지는 1부터 1씩 증가하여 오름차순으로 값을 넣고,
		중간 이후부터 끝까지는 1씩 감소하여 내림차순으로 값을 넣어 출력하세요.
		단, 입력한 정수가 홀수가 아니거나 3 미만일 경우 “다시 입력하세요”를 출력하고
		다시 정수를 받도록 하세요.
		
		[실행 화면]
		정수 : 4
		다시 입력하세요.
		정수 : -6
		다시 입력하세요.
		정수 : 5
		1, 2, 3, 2, 1
		*/
		
		// 0 1 2 3 4 
		
		// 못품 arr.lenght - i 이용해보기
		
		
		System.out.print("정수 : " );
		int input = sc.nextInt();
		
		while(input < 3 || input % 2 == 0) {
			System.out.println("다시 입력하세요");
			System.out.print("정수 : " );
			input = sc.nextInt();
		}

		int[] arr = new int[input];
		String str = "";
		

		
		for(int i=0; i<arr.length; i++) {
		
			arr[i] = i+1;
			
			if(i%2 > 1) {
				arr[i] = arr.length - i;		
			}
			str += arr[i];
			
		}
		
			
			
		System.out.println(str);
		 
		
		
		
	}
	
	public void practice9() {
		/*
		10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고,
		1~10 사이의 난수를 발생시켜 배열에 초기화한 후 출력하세요.
		
		[실행 화면]
		발생한 난수 : 9 7 6 2 5 10 7 2 9 6
		*/
		
		// 0.0 ~ 1.0
		// 0 ~ 10.0
		// 1 ~ 11
		
		int[] arr = new int[10];
		
		String str = "";
		
		for(int i=0; i<10; i++) {
			arr[i] = (int)(Math.random() * 10 + 1);
			
			str += arr[i] + " ";
		}
		
		System.out.println("발생한 난수 : " + str);
		
	}
	
	
}

