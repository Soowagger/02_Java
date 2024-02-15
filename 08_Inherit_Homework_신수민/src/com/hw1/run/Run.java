package com.hw1.run;

import java.util.Scanner;

import com.hw1.model.vo.Employee;
import com.hw1.model.vo.Student;

public class Run {
	
	public static void main(String[] args) {
		
		
		// 3명의 학생 정보를 기록할 수 있게 객체 배열을 할당
		
		
		Student[] stdArr = new Student[3];
		
		// 사용데이터를 참고하여 3명의 학생 정보 초기화
		stdArr[0] = new Student("홍길동", 20, 178.2, 70.0, 1, "정보시스템공학과");
		stdArr[1] = new Student("김말똥", 21, 187.3, 80.0, 2, "경영학과");
		stdArr[2] = new Student("강개순", 23, 167.0, 45.0, 4, "정보통신공학과");
		
		// 학생 정보 모두 출력
		/*
		for(int i=0; i < stdArr.length; i++) {
			System.out.println(stdArr[i].information());
		}
		*/ 
		// 향상된 for문으로 대체
		for( Student std : stdArr) {
			System.out.println(std.information());
		}
		
		System.out.println("=============================================");
		

		
		// 최대 10명의 사원 정보를 기록할 수 있게 배열을 할당
		Employee[] empArr = new Employee[10];
		
		
		
		// 사원들의 정보를 키보드로 계속 입력 받고 --> while(true) 무한 반복문을 통해
		// 계속 추가할 것인지 물어보고, 대소문자 상관없이 'y'이면 계속 객체 추가
		// 한 명씩 추가될 때마다 카운트함	
		Scanner sc = new Scanner(System.in);
		
		int count = 0;
		
		boolean flag = true;
		
		while(true) {
						
			System.out.printf("이름 입력 : ");
			String name = sc.next();
			
			System.out.print("나이 입력 : ");
			int age = sc.nextInt();
			
			System.out.print("신장 입력 : ");
			double height = sc.nextDouble();
			
			System.out.print("몸무게 입력 : ");
			double weight = sc.nextDouble();
			
			System.out.print("급여 입력 : ");
			int salary = sc.nextInt();
			
			System.out.print("부서 입력 : ");
			String dept = sc.next();
			
			empArr[count] = new Employee(name, age, height, weight, salary, dept);	
			count++;
							
			System.out.print("계속 추가하시겠습니까? (y/n) : ");
			String str = sc.next().toUpperCase();

			if(str.equals("N")) {
				break;
			}
			
		}
		
		
		// 2명 정도의 사원 정보를 입력 받아 객체 배열에 저장
		// 현재 기록된 사원들의 정보를 모두 출력		
		System.out.println("=========================================");
		
		/*
		for(int i=0; i < count; i++) {
			System.out.println(empArr[i].information());
		}
		*/		 
		// 향상된 for문으로 대체 시 에러 발생
		for(Employee emp : empArr) {
			
			if(emp == null) break; // NullPointerException 방지
			
			System.out.println(emp.information());
		}
		// 10칸으로 만들어 놨기 때문에 2명만 입력받고 출력 시 
		// 8칸이 null로 존재하기 때문에 에러 발생
		
	}
}
