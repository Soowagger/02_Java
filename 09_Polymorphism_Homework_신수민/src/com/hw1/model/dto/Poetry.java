package com.hw1.model.dto;

public class Poetry extends Book {
	
	private int numberOfPoeams; // 시 수

	
	public Poetry() {}
	
	public Poetry(String title, String author, int numberOfPoeams) {
		super(title, author);
		this.numberOfPoeams = numberOfPoeams;
	}

	public int getNumberOfPoeams() {
		return numberOfPoeams;
	}

	public void setNumberOfPoeams(int numberOfPoeams) {
		this.numberOfPoeams = numberOfPoeams;
	}

	@Override
	public void displayInfo() {
		System.out.printf("[시집] 제목 : %s / 저자 : %s / 시 수 : %d\n", getTitle(), getAuthor(), numberOfPoeams);
	}
}
