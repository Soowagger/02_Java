package com.hw4.model.dto;

import java.util.Objects;

public class Toy {
	
	private String name;
	private int price;
	private String color;
	private int age;
	private String day;
	private String material;
	
	public Toy() {}


	public Toy(String name, int price, String color, int age, String day,  String material) {
		super();
		this.name = name;
		this.price = price;
		this.color = color;
		this.age = age;
		this.day = day;
		this.material = material;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	

	@Override
	public String toString() {
		return String.format("이름 : %s / 가격 : %d / 색상 : %s / 사용가능연령 : %s / 제조년월일 : %s / 재료 : %s",
				name, price, color, age, day, material);
	}


	@Override
	public int hashCode() {
		return Objects.hash(age, color, day, material, name, price);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Toy other = (Toy) obj;
		return age == other.age && Objects.equals(color, other.color) && Objects.equals(day, other.day)
				&& Objects.equals(material, other.material) && Objects.equals(name, other.name) && price == other.price;
	}


	

	
	
	
	
}
