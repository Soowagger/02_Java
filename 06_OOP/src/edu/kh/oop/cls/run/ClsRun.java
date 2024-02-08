package edu.kh.oop.cls.run;

import edu.kh.oop.cls.model.service.ClsService;

public class ClsRun {

	public static void main(String[] args) {
		
		ClsService service = new ClsService();
		// 매개변수 없는 생성자 -> 기본생성자
		// ClsService의 기본생성자가 명시적으로 
		// 작성되어 있진 않음
		// 문제 없이 사용 가능하다.
		// Why?
		// 컴파일러가 코드를 변역할 때
		// 클래스 내부에 생성자가 하나도 없다면
		// 자동으로 기본생성자를 추가해줌
		// (우리 눈엔 안보임)
		
//		service.ex1();
//		service.ex2();
//		service.ex3();
//		service.ex3();
		service.ex4();
	}

}
