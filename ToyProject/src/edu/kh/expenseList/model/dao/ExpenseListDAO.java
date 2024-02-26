package edu.kh.expenseList.model.dao;

import java.util.List;

import edu.kh.expenseList.model.dto.Expense;

// DAO 데이터 접근
public interface ExpenseListDAO {

	List<Expense> expListFullView();
	
}
