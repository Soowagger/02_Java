package edu.kh.array2.practice;

import java.util.Arrays;

public class Array2Practice {

	public void practice1() {
		/*
		 3행 3열짜리 문자열 배열을 선언 및 할당하고
		인덱스 0행 0열부터 2행 2열까지 차례대로 접근하여 “(0, 0)”과 같은 형식으로 저장 후 출력하세요.
		
		[실행 화면]
		(0, 0)(0, 1)(0, 2)
		(1, 0)(1, 1)(1, 2)
		(2, 0)(2, 1)(2, 2)
		 */
		String [][] arr = new String[3][3];
		String str = "";
		
		for(int row=0; row < arr.length; row++) {
			
			for(int col=0; col < arr[row].length; col++) {
				arr[row][col] = "(" + row + ", " + col + ")";
				
			}

		}
		for (int row = 0; row < arr.length; row++) {
            
			for (int col = 0; col < arr[row].length; col++) {
				System.out.print(arr[row][col] + "");
			}
            System.out.println(); // 행이 끝날 때마다 개행
        }
	}
	
	public void practice2() {
		/*
		4행 4열짜리 정수형 배열을 선언 및 할당하고
		1) 1 ~ 16까지 값을 차례대로 저장하세요.
		2) 저장된 값들을 차례대로 출력하세요.

		[실행 화면]
		1 2 3 4
		5 6 7 8
		9 10 11 12
		13 14 15 16
		*/
		
		int arr[][] = new int[4][4];
		int num = 1;
		
		for(int row = 0; row < arr.length; row++) {
			
			for(int col = 0; col < arr[row].length; col++) {
				arr[row][col] = num;
				num += 1;
				System.out.print(arr[row][col] + " ");
			}
			
			System.out.println();
		
		}
	}
	
	public void practice3() {
		/*
		4행 4열짜리 정수형 배열을 선언 및 할당하고
		1) 16 ~ 1과 같이 값을 거꾸로 저장하세요.
		2) 저장된 값들을 차례대로 출력하세요.

		[실행 화면]
		16 15 14 13
		12 11 10 9
		8 7 6 5
		4 3 2 1
		*/
		int arr[][] = new int[4][4];
		int num = 16;
		
		for(int row = 0; row < arr.length; row++) {
			
			for(int col = 0; col < arr[row].length; col++) {
				arr[row][col] = num;
				num -= 1;
				System.out.print(arr[row][col] + " ");
			}
			
			System.out.println();
		
		}
	}
	
	public void practice4() {
		/*
		4행 4열 2차원 배열을 생성하여 0행 0열부터 2행 2열까지는 1~10까지의 임의의 정수 값 저장 후
		아래의 내용처럼 처리하세요.
		[실행 화면]
		9 3 7 19
		3 6 9 18
		6 10 10 26
		18 19 26 63
		*/
		
		int arr[][] = new int[4][4];
		int rowLast = arr.length-1;
		int colLast = arr[0].length-1;
		
		for(int row = 0; row < arr.length; row++) {
						
			for(int col = 0; col < arr[row].length; col++) {
				
											
	            arr[row][col] = (int)(Math.random() * 10 + 1);			
				
	            arr[row][3] += arr[row][col];
	            arr[3][col] += arr[row][col];    
			}
	
		}
		
		for(int row=0; row < arr.length; row++) {
			for(int col=0; col < arr[row].length; col++) {
				System.out.printf("%3d ", arr[row][col]);
				
				if(row == rowLast || col == colLast) {
					arr[rowLast][colLast] += arr[row][col];
				}
				
			}
		
			System.out.println();
		
		}
		
		
	}
	
	


	
}
