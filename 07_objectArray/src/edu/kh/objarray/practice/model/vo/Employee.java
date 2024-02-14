package edu.kh.objarray.practice.model.vo;

public class Employee {
	
	private int num; // 시번
	private String name; // 이름
	private String dept; // 부서
	private String rank; // 직급
	private int salary; // 급여
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public Employee() {}
	
	public Employee(int num, String name, String dept, String rank, int salary) {
		
		this.num = num;
		this.name = name;
		this.dept = dept;
		this.rank = rank;
		this.salary = salary;
	}
	
	
	
	
	
	
	
}
