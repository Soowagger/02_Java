package edu.kh.expenseList.model.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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

	@Override
	public void expListViewByCategory() {
		
		List<Expense> expList = dao.expListViewByCategory();
		
		Map<String, List<Expense>> map = new HashMap<String, List<Expense>>();
		
		for(Expense exp : expList) {
			String category = exp.getCategory();
			map.putIfAbsent(category, new ArrayList<>());
			
			map.get(category).add(exp);
		}
		
		for(Entry<String, List<Expense>> entry : map.entrySet()) {
			
			String category = entry.getKey();
			List<Expense> exp = entry.getValue();
			
			System.out.printf("\n\n[지출 유형 : %s]\n", category);
			System.out.println("--------------------------------------------------------------------");
			System.out.printf("%-3s %10s       %10s    %s      %s\n", "인덱스", "등록일", "결제 수단","지출 유형" ,"금액");
			System.out.println("--------------------------------------------------------------------");
			int index = 1;
			
			for(Expense e : exp) {
				System.out.printf("[%3d]  %20s      (%s)  %8s        %d원\n", index, dateFormat(e.getExpDate()), e.getMethod(), category, e.getAmount());
				index++;
			}
		}
		
	}

	@Override
	public int expAdd(String category, String method, int price, String detail) throws Exception {
		
		// 객체 생성
		Expense exp = new Expense(category, method, price, detail, LocalDateTime.now());
		
		// 객체 전달 후 결과값 얻어오기
		int index = dao.expAdd(exp);
	
		return index;
	}


	@Override
	public Expense expRemove(int index) throws Exception {
		
		Expense exp = dao.expRemove(index);
		
		return exp;
	}


	
	@Override
	public String expDetailView(int index) {
		
		Expense exp = dao.expDetailView(index);
		
		if(exp == null) return null;
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("\n=======================[Before the update]==========================\n");
		sb.append("--------------------------------------------------------------------\n");
		sb.append(String.format("%-3s %10s       %10s    %s      %s\n", "인덱스", "등록일", "결제 수단","지출 유형" ,"금액"));
		sb.append("--------------------------------------------------------------------\n");
		sb.append(String.format("[%3d]  %20s      (%s)  %8s        %d원\n", index, dateFormat(exp.getExpDate()), exp.getMethod(), exp.getCategory(), exp.getAmount()));
		
		return sb.toString();
	}







	


	
	
	
}
