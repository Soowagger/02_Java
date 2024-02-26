package edu.kh.expenseList.model.service;

import java.time.LocalDateTime;
import java.util.Map;

// Service 비지니스 로직
public interface ExpenseListService {
	
	Map<String, Object> expListFullView();

	String dateFormat(LocalDateTime expDate);
	
}
