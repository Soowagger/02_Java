package com.hw3.controller;

import java.util.Scanner;

import com.hw3.model.vo.Product;


public class ProductController {
	
	private Product[] pro = null;
	
	public static int count = 0;
		
	Scanner sc = new Scanner(System.in);
	
	{
		pro = new Product[10];
	}
	
	// 메서드
	public void mainMenu() {
		/*
	 	do~while 문을 이용하여
		반복적으로 메뉴화면 출력
		각 버튼 선택 시 각각의 메소드 호출
		 */
		int menuNum = 0;
		
		do {
			System.out.println("===== 제품 관리 메뉴 =====");
			System.out.println("1. 제품 정보 추가");
			System.out.println("2. 제품 전체 조회");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("번호 입력 : ");
			menuNum = sc.nextInt();
			
			switch(menuNum) {
			case 1 : productInput(); break;
			case 2 : productPrint(); break;
			case 0 : System.out.println("프로그램 종료.."); break;
			default : System.out.println("잘못 입력하셨습니다.");
			}
			
		}while(menuNum != 0);
		
		
		
		
	}
	
	public void productInput() {
		/*
	 	새로운 제품 정보 기록을 위해
		키보드로 정보들을 입력 받아
		객체를 생성하고 현재 카운트
		인덱스에 주소 저장
		 */
				
		System.out.print("제품 번호 입력 : ");
		int pId = sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("제품명 입력 : ");
		String pName = sc.nextLine();
		
		System.out.print("제품 가격 입력 : ");
		int price = sc.nextInt();
		
		System.out.print("제품 세금 입력 : ");
		double tax = sc.nextDouble();		
		
		
		pro[count] = new Product(pId, pName, price, tax);
		
		

	}
		
	public void productPrint() {
		
		
		for(int i=0; i < count; i++) {
			System.out.println(pro[i].information());
		}
		
	}
	
	
}
