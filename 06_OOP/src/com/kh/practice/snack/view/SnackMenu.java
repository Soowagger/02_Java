package com.kh.practice.snack.view;

import java.util.Scanner;

import com.kh.practice.snack.controller.SnackController;

public class SnackMenu {

	// 사용자가 Snack 객체에 데이터를 저장할 수 있도록 값을 받고
	// 저장한 값을 출력하는 메소드
	Scanner sc = new Scanner(System.in);
	SnackController scr = new SnackController();
	
	public void menu() {
		System.out.println("스낵류를 입력하세요");
		System.out.print("종류 : ");
		String kind = sc.next();
		
		System.out.print("이름 : ");
		String name = sc.next();
	
		System.out.print("맛 : ");
		String flavor = sc.next();
		
		System.out.print("개수 : ");
		int numOf = sc.nextInt();
				
		System.out.print("가격 : ");
		int price = sc.nextInt();
		
		
		
		scr.saveData(kind, name, flavor, numOf, price);
		
		System.out.println();
		
		System.out.print("저장한 정보를 확인하시겠습니까?(y/n) : ");
		char input = sc.next().charAt(0);
		
		
		
		if(input == 'y') {
			//System.out.printf("%s(%s - %s) %d개 %d원", kind, name, flavor, numOf, price);
			System.out.printf(scr.confirmData());
		} else {
			return;
		}
		
	
		
	}
	
	
}
