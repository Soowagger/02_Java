package com.hw1.run;

import java.lang.reflect.Array;
import java.util.Arrays;

import com.hw1.model.vo.Employee;

public class Run {
	public static void main(String[] args) {
		// 객체배열을 크기 3으로 할당한 뒤 3개의 생성자를 각각 이용하여 객체 생성 후 출력 
		Employee[] emp = new Employee[3];
		
		emp[0] = new Employee();
		emp[1] = new Employee(1, "홍길동", 19, 'M', "01022223333", "서울 잠실");
		emp[2] = new Employee(2, "강말순", "교육부", "강사", 20, 'F', 1000000, 0.01, "01011112222", "서울 마곡");
		
		for(int i=0; i<3; i++) {
			System.out.printf("emp[%d] : %d, %s, %s, %s, %d, %s, %d, %.2f, %s, %s\n",
					i, emp[i].getEmpNo(), emp[i].getEmpName(), emp[i].getDept(), emp[i].getJob(),emp[i].getAge(),
					emp[i].getGender(), emp[i].getSalary(), emp[i].getBonusPoint(), emp[i].getPhone(), emp[i].getAddress());
			
		}
		
		System.out.println("========================================================================");
		
		
		// 3개의 객체 중 값이 없는 필드에 각각 값을 넣은뒤 출력
		emp[0] = new Employee(0, "김말똥", "영업부", "팀장", 30, 'M', 3000000, 0.2, "01055559999", "전라도 광주");
		emp[1] = new Employee(1, "홍길동", "기획부", "부장", 19, 'M', 4000000, 0.3, "01022223333", "서울 잠실");
		for(int i=0; i<2; i++) {
			System.out.printf("emp[%d] : %d, %s, %s, %s, %d, %s, %d, %.1f, %s, %s\n",
					i, emp[i].getEmpNo(), emp[i].getEmpName(), emp[i].getDept(), emp[i].getJob(),emp[i].getAge(),
					emp[i].getGender(), emp[i].getSalary(), emp[i].getBonusPoint(), emp[i].getPhone(), emp[i].getAddress());
		
		}
		
		System.out.println("========================================================================");
		
		
		// 직원 각각의 보너스가 적용된 1년 연봉을 계산하여 출력
		// 연봉 = (급여 + (급여 * 보너스포인트)) * 12
		System.out.println(emp[0].infomation());
		System.out.println(emp[1].infomation());
		System.out.println(emp[2].infomation());
		
		System.out.println("========================================================================");
	
		// 3명의 직원의 연봉 평균을 구하여 출력
		int sum = 0;
		int avg = 0;
		
		for(int i=0; i<3; i++) {
			sum += (int)(emp[i].getSalary() + (emp[i].getSalary() * emp[i].getBonusPoint()))*12;
			avg = sum/3;
		}
		
		System.out.println("직원들의 연봉의 평균 : " + avg + "원");
	}
}
