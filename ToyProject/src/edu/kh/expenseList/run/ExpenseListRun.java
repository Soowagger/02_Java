package edu.kh.expenseList.run;

import edu.kh.expenseList.view.ExpenseListView;

public class ExpenseListRun {
	
	public static void main(String[] args) {
		
		System.out.println("***[프로그램 실행]***");
		
		// 프로젝트 흐름
		// Run <-> View <-> Service <-> DAO <-> File
		ExpenseListView view = new ExpenseListView();
		view.StartView();
		
	}
}
