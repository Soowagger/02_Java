package edu.kh.oop.practice.model.service;

import edu.kh.oop.practice.model.vo.Book;

public class BookService {
	
	public void practice() {
		/*
		    기본 생성자, 매개변수 생성자
			를 이용하여 2개의 Book 객체
			생성 후 필드 정보 출력.
			setter 메소드를 이용하여
			첫 번째 객체 값 수정 후
			필드 정보 출력
			getter 메소드를 이용하여
			할인율을 적용한 책 가격 출력
		 */
		
		Book b1 = new Book();
		
		
		
		Book b2 = new Book("자바의 정석", 30000, 0.2, "남궁성");
		
		System.out.println(b1);
		System.out.println(b2);
		
		System.out.println("===============================");
		System.out.println("수정된 결과 확인");
				
		b1.setTitle("C언어");
		b1.setPrice(30000);
		b1.setDiscountRate(0.1);
		b1.setAuthor("홍길동");
		
		System.out.println(b1);
		
		System.out.println("===============================");
		
		System.out.println("도서명 = " + b1.getTitle());
		System.out.printf("할인된 가격 = %.0f원\n", b1.getPrice() - b1.getPrice() * b1.getDiscountRate());
		System.out.println("도서명 = " + b2.getTitle());
		System.out.printf("할인된 가격 = %.0f원\n", b2.getPrice() - b2.getPrice() * b2.getDiscountRate());
		
	}
	

}
