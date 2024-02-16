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
		if(employeeCount==0) {
				
				employees[0] = new Employee(person.getId(),person.getName(), );
				employees[1] = new Employee("EMP02", "박명수", "개발팀");
		
		
			for(Employee emp : employees) {
				
				if(emp == null) {
					System.out.println("인원이 모두 충원되었습니다.");break;
				}
				System.out.println(emp.getInfo());	
			}
		}
	}

	@Override
	public void removePerson() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayAllPersons() {
		// TODO Auto-generated method stub
		
	}
}
