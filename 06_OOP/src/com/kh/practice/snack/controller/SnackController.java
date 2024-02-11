package com.kh.practice.snack.controller;

import com.kh.practice.snack.model.vo.Snack;

public class SnackController {

	
	Snack s = new Snack();
	
	// 기본 생성자
	public SnackController() {
		
	}
	
	
	
	public String saveData(String kind, String name, String flavor,
			int numOf, int price) { 
		// 데이터를 setter를 이용해 저장하고 저장완료 되었다는 결과를 반환하는 메소드
		
		s.setKind(kind);
		s.setName(name);
		s.setFlavor(flavor);
		s.setNumOf(numOf);
		s.setPrice(price);
				
		
		System.out.print("저장 완료되었습니다.");

		return confirmData();
		
	}
	
	public String confirmData() { // 저장된 데이터를 반환하는 메소드
		return s.information();
	}
}
