package com.hw1.model.vo;

public class Employee extends Person {
	
	private int salary; // 급여
	private String dept; // 부서
	
	public Employee() {}

	public Employee(String name, int age, double height, double weight, int salary, String dept) {
		super(age, height, weight);
		this.name = name; // Person의 protected 필드
		this.salary = salary;
		this.dept = dept;
	}
	
	@Override
	public String information() {
		
		return super.information() + String.format(" / 급여 : %d / 부서 : %s", salary, dept);
	}
	
	
	
}
