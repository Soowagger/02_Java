package com.hw2.run;

import com.hw2.model.dto.Employee;
import com.hw2.model.dto.Person;
import com.hw2.model.service.Company;
import com.hw2.model.service.ManagementSystem;
import com.hw2.model.service.Prison;

public class Run {
	public static void main(String[] args) {
		
		// Company의 생성자를 이용하여 10칸 짜리 Employee 객체배열 생성하는 Company 객체를
		// 생성하여 ManagementSystem 자료형의 company의 주소를 저장
		Company c1 = new Company(10);
		
		ManagementSystem ms1 = c1;
		
		
		
		// Prison의 생성자를 이용하여 10칸 짜리 Prisoner 객체배열 생성하는 Prison 객체를 생성하여
		// ManagementSystem 자료형의 prison에 주소를 저장
		Prison p1 = new Prison(10);
		ManagementSystem ms2 = p1;
		
		// 2명 정도 직원 새로 등록하기
		
		Person e1 = new Employee("EMP01", "유재석", "기획팀");
		Person e2 = new Employee("EMP02", "박명수", "개발팀");
		
		
		
		
		
		
	
	}
}
