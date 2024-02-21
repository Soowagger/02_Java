package com.hw4.model.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.hw4.model.dto.Toy;

public class ToyFactory {
	/* 프로젝트 목표
	 * 
	1. 장난감의 정보를 효과적으로 관리하고 출력할 수 있는 클래스를 구현.
	2. 사용자로부터 입력을 받고, 입력에 따라 적절한 동작을 수행하는 메서드를
		작성
	3. 컬렉션을 활용하여 장난감 정보를 저장하고 관리
	4. 장난감의 제조일에 따라 정렬하고, 연령별로 사용 가능한 장난감을 출력하는
		기능을 구현
	 */
	
	
	/* 프로젝트 기능
	 * 
 	1. 전체 장난감 조회하기: 공장에 있는 모든 장난감의 정보를 출력
	2. 새로운 장난감 만들기: 새로운 장난감을 추가하고, 사용자가 입력한 정보로
	객체를 생성
	3. 장난감 삭제하기: 공장에서 장난감을 삭제
	4. 장난감 제조일 순으로 조회하기: 장난감을 제조일에 따라 정렬하여 출력
	5. 연령별 사용 가능한 장난감 리스트 조회하기: 사용 가능한 연령을 입력받고,
	해당하는 장난감을 출력
	6. 재료 추가: 새로운 재료를 등록하고, 장난감에 해당 재료를 추가
	7. 재료 제거: 등록된 재료를 삭제하고, 해당하는 재료를 사용하는 장난감에서
	제거
	 */
	
	Scanner sc = new Scanner(System.in);
	
	private Set<Toy> toyList = new HashSet<Toy>();
	private Map<Integer, String> material = new HashMap<Integer, String>();
	
	public ToyFactory() {
		
		
		
		material.put(1, "면직물");
		material.put(2, "플라스틱");
		material.put(3, "유리");
		material.put(4, "고무");
		
		
		
		String m1 = material.get(1) + ", " + material.get(4);
		String m2 = material.get(1) + ", " + material.get(2); 
		String m3 = material.get(1) + ", " + material.get(2); 
		String m4 = material.get(1) + ", " + material.get(2); 
		String m5 = material.get(1) + ", " + material.get(2) + ", " + material.get(4);  
		
		
		toyList.add( new Toy("마미롱레그", 36000, "분홍색", 8, "19950805", m1));
		toyList.add( new Toy("허기워기", 12000, "파란색", 5, "19940312", m2) );
		toyList.add( new Toy("키시미시", 15000, "분홍색", 5, "19940505", m3) );
		toyList.add( new Toy("캣냅", 27000, "보라색", 8, "19940505", m4) );
		toyList.add( new Toy("파피", 57000, "빨간색", 12, "19931225", m5) );
						
	}
	
	


	public Map<Integer, String> getMaterial() {
		return material;
	}


	public void setMaterial(Map<Integer, String> material) {
		this.material = material;
	}







	public void displayMenu() {
		
		int menuNum = 0;
		
		do {
			System.out.println("<<플레이타임 공장>>");
			System.out.println("1. 전체 장난감 조회하기");
			System.out.println("2. 새로운 장난감 만들기");
			System.out.println("3. 장난감 삭제하기");
			System.out.println("4. 장난감 제조일 순으로 조회하기");
			System.out.println("5. 연령별 사용 가능한 장난감 리스트 조회하기");
			System.out.println("6. 재료 추가");
			System.out.println("7. 재료 제거");
			
			System.out.print("선택 : ");
			menuNum = sc.nextInt();
			
			switch(menuNum) {
			case 1 : selectToy(); break;
			case 2 : addToy(); break;
			case 3 : removeToy(); break;
			case 4 : /*selectAlign()*/ break;
			case 5 : /*selectAge*/ break;
			case 6 : /*addMaterial()*/ break;
			case 7 : /*removeMaterial()*/ break;
			case 0 : System.out.println("프로그램 종료.."); break;
			}
			
			
		} while(menuNum != 0);
		
		
	}
	
	public void selectToy() {
		System.out.println("<전체 장난감 목록>");
		
		List<Toy> arrList = new ArrayList<Toy>(toyList);
		
		
		for(int i = 0; i< arrList.size(); i++) {
			
			System.out.println( (i+1) + ". " + arrList.get(i) );
		}
			
	}


	public void addToy() {
		System.out.println("<새로운 장난감 추가>");
		
		System.out.print("장난감 이름 : ");
		String name = sc.next();
		
		System.out.print("사용 가능 연령 : ");
		int age = sc.nextInt();
		
		System.out.print("가격 : ");
		int price = sc.nextInt();
		
		System.out.print("색상 : ");
		String color = sc.next();
		
		System.out.print("제조일(YYYYMMDD 형식) : ");
		String day = sc.next();
		
		String input = "q";
		
		
		String result = "";
		
			for(int i=0; i < material.size(); i++) {
				
				System.out.print("재료를 입력하세요(종료하려면 'q' 입력) : ");
				input = sc.next();
				
				if (input.equals("q")) {
		            break; // 'q' 입력 시 반복문 종료
		        }
				
				
				if(i == 0) {
				
					switch(input) {
					case "면직물" : result = material.get(1); break;
					case "플라스틱" : result = material.get(2); break;
					case "유리" : result = material.get(3); break;
					case "고무" : result = material.get(4); break; 
					} 
				
				} else {
					switch(input) {
					case "면직물" : result += ", " + material.get(1); break;
					case "플라스틱" : result += ", " + material.get(2); break;
					case "유리" : result += ", " + material.get(3); break;
					case "고무" : result += ", " + material.get(4); break;
					} 
				}
				
		} 	
		
		if(toyList.add(new Toy(name, price, color, age, day, result))) {
			System.out.println("새로운 장난감이 추가되었습니다.");
		}
		
		
	}
	
	
	
	public void removeToy() {
		System.out.print("삭제할 장난감의 이름을 입력하세요 : ");
		String input = sc.next();
		
		List<Toy> arrList = new ArrayList<Toy>(toyList);
		
		for(int i = 0; i< arrList.size(); i++) {
			
			if(arrList.get(i).getName().equals(input)) {
				System.out.println(arrList.remove(i));
				
			}
		}
		
		
	}
	public void selectAlign() {}
	public void selectAge() {}
	public void addMaterial() {}
	public void removeMaterial() {}
	
}
