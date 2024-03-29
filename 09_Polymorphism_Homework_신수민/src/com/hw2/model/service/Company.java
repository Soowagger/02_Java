package com.hw2.model.service;

import com.hw2.model.dto.Employee;
import com.hw2.model.dto.Person;

public class Company implements ManagementSystem {
	
	private Employee[] employees; // 전체 직원 저장용
	
	private int employeeCount; // 직원수
	
	public Company(int size) {
				
		employees = new Employee[size];
		employeeCount = 0;
	}
	
	
	public Employee[] getEmployees() {
		return employees;
	}

	public void setEmployees(Employee[] employees) {
		this.employees = employees;
	}

	public int getEmployeeCount() {
		return employeeCount;
	}

	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}
	

	@Override
	public void addPerson(Person person) {
		
		if(employees.length > employeeCount) {
				
			employees[employeeCount] = (Employee)person;
			
			System.out.println("직원이 추가되었습니다 - " + employees[employeeCount].getInfo());
			
			employeeCount++;
		
		} else {
			System.out.println("인원이 모두 충원되었습니다.");
		}
		
	}

	@Override
	public void removePerson(String id) {
		
		for(int i = 0; i < employees.length; i++) {
			
			if(employees[i].getId().equals(id)) {
				
				System.out.println("직원이 삭제되었습니다 - " + employees[i].getInfo());
				
				employees[i] = null;
				
				break;
			} 
			
			
		}
		
		
	}

	@Override
	public void displayAllPersons() {
		
		System.out.println("전체 직원 명단 : ");
		
		for( Employee emp : employees) {
			
			if(emp == null) continue;
			
			System.out.println(emp.getInfo());			
		}
		
	}
}
