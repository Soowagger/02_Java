package edu.kh.expenseList.model.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

// DTO 값 전달 - Transfer Object

public class Expense implements Serializable{ // 직렬화
	
	private String category; // 식비, 교통비 등
	private String method; // 결제 수단
	private int amount; // 지출 금액
	private String detail; // 지출 상세
	private LocalDateTime expDate; // 지출 날짜
	
	public Expense() {}

	public Expense(String category, String method, int amount, String detail, LocalDateTime expDate) {
		super();
		this.category = category;
		this.method = method;
		this.amount = amount;
		this.detail = detail;
		this.expDate = expDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public LocalDateTime getExpDate() {
		return expDate;
	}

	public void setExpDate(LocalDateTime expDate) {
		this.expDate = expDate;
	}

	@Override
	public String toString() {
		return "Expense [category=" + category + ", method=" + method + ", amount=" + amount + ", detail=" + detail
				+ ", expDate=" + expDate + "]";
	}
	
}
