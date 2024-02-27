package edu.kh.expenseList.model.service;

import java.time.LocalDateTime;
import java.util.Map;

import edu.kh.expenseList.model.dto.Expense;

// Service 비지니스 로직
public interface ExpenseListService {
	
	Map<String, Object> expListFullView();

	String dateFormat(LocalDateTime expDate);

	int expAdd(String category, String method, int price, String detail) throws Exception;

	Expense expRemove(int index) throws Exception;

	void expListViewByCategory();

	String expDetailView(int index);

	

	
	
}
