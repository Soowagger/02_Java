package edu.kh.expenseList.model.dao;

import java.util.List;
import java.util.Map;

import edu.kh.expenseList.model.dto.Expense;

// DAO 데이터 접근
public interface ExpenseListDAO {

	List<Expense> expListFullView();

	int expAdd(Expense exp) throws Exception;

	Expense expRemove(int index) throws Exception;

	List<Expense> expListViewByCategory();

	Expense expUpdateView(int index);

	int expUpdate(int index, String category, String method, int amount, String detail )throws Exception;

	Expense expMemo(int index);

	

	
	
}
