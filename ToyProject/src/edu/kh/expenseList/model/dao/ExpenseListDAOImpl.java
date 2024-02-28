package edu.kh.expenseList.model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
			
			expList.add(new Expense("중식비", "신용", 10000, "중식 비용 결제", LocalDateTime.now()));
			expList.add(new Expense("교통비", "체크", 1500, "지하철 비용 결제", LocalDateTime.now()));
			expList.add(new Expense("미용비", "현금", 80000, "파마 비용 결제", LocalDateTime.now()));
			
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
	
	/**
	 * CRUD 수행 시 파일 저장 메서드 생성
	 */
	public void saveFile() throws Exception {
		
		try {
			
			fos = new FileOutputStream(FILE_PATH);
			oos = new ObjectOutputStream(fos); 
			oos.writeObject(expList);
			
		} finally {
			if(oos != null) oos.close();
		}
		
	}
	
	
	/**
	 * 1. 전체 보기
	 */
	@Override
	public List<Expense> expListFullView() {
		
		return expList;
	}

	
	/**
	 * 2. 카테고리별 보기
	 */
	@Override
	public List<Expense> expListViewByCategory() {
		
		return expList;
	}
	
	
	/**
	 * 3. 추가
	 */
	@Override
	public int expAdd(Expense exp) throws Exception  {
		if(expList.add(exp)) {
			
			saveFile();
			
			return expList.size() -1; // 마지막 인덱스
		}
		
		return 0;
	}

	
	/**
	 * 4. 삭제
	 * @throws Exception 
	 */
	@Override
	public Expense expRemove(int index) throws Exception {
		
		Expense exp = null;
				
		for(int i=0; i < expList.size(); i++) {
			
			if(i == index) {
				exp = expList.remove(index);
			}				
		}
		
		saveFile();
		
		return exp;
	}
	
	
	/**
	 * 수정을 위한 디테일 뷰
	 */
	@Override
	public Expense expUpdateView(int index) {
		
		if(index < 0 || index >= expList.size()) { 
			return null;
		}

		return expList.get(index);
	}

	
	/**
	 * 5. 수정
	 */
	@Override
	public int expUpdate(int index, String category, String method, int amount, String detail) throws Exception {
		
		// 객체 생성
		Expense exp = new Expense(category, method, amount, detail, 
								expList.get(index).getExpDate());
		
		Expense update = expList.set(index, exp);
		
		if(update == null) {
			return -1;
		} else {
			saveFile();
			return 1;
			
		} 
	}
	
	
	/**
	 * 6. 메모 view
	 */
	@Override
	public Expense expMemo(int index) {
		
		if(index < 0 || index >= expList.size()) { 
			return null;
		}

		return expList.get(index);
	}

}
