package edu.kh.expenseList.model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import edu.kh.expenseList.model.dto.Expense;

public class ExpenseListDAOImpl implements ExpenseListDAO {
	
	// 필드
	private final String FILE_PATH = "/io_toyProject/ExpenseList.dat";
	
	// IO 스트림
	private FileOutputStream fos = null; // 객체 출력 기반
	private ObjectOutputStream oos = null;  // 객체 출력 보조
	
	private FileInputStream fis = null; // 객체 입력 기반
	private ObjectInputStream ois = null; // 객체 입력 보조
	
	
	private List<Expense> expList = null;
	
	// 기본 생성자
	public ExpenseListDAOImpl() throws Exception {
		
		// 중복 검사
		File file = new File(FILE_PATH);
		
		
		if(file.exists()) { // 존재
		
			try {
				
				fis = new FileInputStream(FILE_PATH); // 기반
				ois = new ObjectInputStream(fis); // 보조
				
				expList = (ArrayList<Expense>) ois.readObject();
				// 이 expList를 이용해 Service에서 활용
				
			} finally {
				if(ois != null) ois.close();
			}
			
			
		} else { // 존재 X
			File directory = new File("/io_toyProject");
			if(!directory.exists()) {
				directory.mkdir();
			}
			
			expList = new ArrayList<Expense>();
			
			expList.add(new Expense("식비", "신용", 10000, "중식 비용 결제", LocalDateTime.now()));
			expList.add(new Expense("교통비", "체크", 1500, "지하철 비용 결제", LocalDateTime.now()));
			expList.add(new Expense("미용", "현금", 80000, "파마 비용 결제", LocalDateTime.now()));
			
			try { // View 기본 생성자에 모두 던져버림, catch X 
				
				// 기반, 보조 생성
				fos = new FileOutputStream(FILE_PATH); // 17번 절대경로(자동 생성) - 폴더 X
				oos = new ObjectOutputStream(fos); 
				
				oos.writeObject(expList); // 출력
				
			} finally {
				if(oos != null) oos.close();
			}
			
			
			System.out.println("+++ ExpenseList.dat 파일 생성 완료! +++");
			
		}
		
		
	}
	
	@Override
	public List<Expense> expListFullView() {
		
		return expList;
	}
	
}
