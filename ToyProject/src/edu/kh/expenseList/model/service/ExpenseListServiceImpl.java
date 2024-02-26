package edu.kh.expenseList.model.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kh.expenseList.model.dao.ExpenseListDAO;
import edu.kh.expenseList.model.dao.ExpenseListDAOImpl;
import edu.kh.expenseList.model.dto.Expense;

public class ExpenseListServiceImpl implements ExpenseListService {
	
	// 필드
	private ExpenseListDAO dao = null; // DAO
	
	
	// 기본 생성자
	public ExpenseListServiceImpl() throws Exception {
		dao = new ExpenseListDAOImpl(); // 객체 생성
	}

	
	@Override
	public Map<String, Object> expListFullView() {
		
		List<Expense> expList = dao.expListFullView();
		
		// 5만원 이상 지출 건수 카운트
		int overCount = 0;
		
		for(Expense exp : expList) {
			
			if(exp.getAmount() >= 50000) {
				overCount++;
			}
		}
		
		// Map = extList, count
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("expList", expList);
		map.put("overCount", overCount);
		
		return map;
	}


	@Override
	public String dateFormat(LocalDateTime expDate) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		String formatDate = expDate.format(formatter);
		
		return formatDate;
	}
	
	
}
