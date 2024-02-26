package edu.kh.expenseList.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import edu.kh.expenseList.model.dto.Expense;
import edu.kh.expenseList.model.service.ExpenseListService;
import edu.kh.expenseList.model.service.ExpenseListServiceImpl;

// View 입출력
/**
 * 
 */
public class ExpenseListView {
	
	// 필드
	private ExpenseListService service = null;	// Service
	private BufferedReader br = null; 
	private Scanner sc = new Scanner(System.in); // br, sc 골고루 사용
	
	// 기본 생성자
	public ExpenseListView() {
		
		try {
			
			service = new ExpenseListServiceImpl();
			br = new BufferedReader(new InputStreamReader(System.in));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 시작 화면
	 */
	public void StartView() {
		
		int menuNum = 0;
		
		do {
			
			try {
				menuNum = selectMenu();
				
				switch(menuNum) {
				case 1 : expListFullView(); break;
				case 2 : /* expListViewByCategory();*/ break;
				case 3 : /* expAdd(); */ break;
				case 4 : /* expRemve(); */ break;
				case 5 : /* expUpdate(); */ break;
				case 6 : /* expSum(); */ break;
				case 0 : System.out.println("### 프로그램이 종료되었습니다. ###"); break;
				default : System.out.println("!!! 메뉴에 작성된 번호만 입력해주세요!!!");
				}
				
				System.out.println("====================================================================");
				
			} catch (NumberFormatException e) {
				System.out.println("!!! 숫자만 입력해 주세요 !!!");
				menuNum = -1; // 종료 방지
			} catch (IOException e) {
				System.out.println("!!! 입/출력 예외 발생 !!!");
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} while(menuNum != 0);

	}
	
	/** 메뉴 출력 및 선택
	 * @return 선택한 메뉴 번호 int형 반환
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public int selectMenu() throws NumberFormatException, IOException {
		
		System.out.println("\n********* Expense List *********\n");
		
		System.out.println("1. Expense List Full View");
		System.out.println("2. Expense List View By Category");
		System.out.println("3. Expense Add");
		System.out.println("4. Expense Remove");
		System.out.println("5. Expense Update");
		System.out.println("6. Expense Total Amount");
		System.out.println("0. EXIT");
		
		System.out.print("Select Menu Number ==> ");
		
		int input = Integer.parseInt(br.readLine());
		System.out.println();
		
		return input;
		
	}
	
	
	/** 
	 * 1. 전체보기 기능
	 */
	public void expListFullView() {
		
		System.out.println("\n************[1.Expense List Full View]************");
		
		// 5만원 이상 지출 건수 얻어오기
		Map<String, Object> map = service.expListFullView();
		
		// 반환 Map 해체
		List<Expense> expList= (List<Expense>)map.get("expList");
		int overCount = (int)map.get("overCount");
		
		System.out.printf("[ 5만원 이상 건 수 / 전체 지출 건 수 : %d / %d ]\n"
				, overCount, expList.size());
		System.out.println("--------------------------------------------------------------------");
		System.out.printf("%-3s %10s       %10s    %s      %s\n", "인덱스", "등록일", "결제 수단","지출 유형" ,"금액");
		System.out.println("--------------------------------------------------------------------");
		
		for(int i=0; i < expList.size(); i++) {
		
			String category = expList.get(i).getCategory();
			
			String method = expList.get(i).getMethod();
			
			String expDate = service.dateFormat(expList.get(i).getExpDate());
			
			int amount = expList.get(i).getAmount();
			
			System.out.printf("[%3d]  %20s      (%s)  %8s        %d원\n", i, expDate, method, category, amount);
		}
		
	}
	
	public void expListViewByCategory() {}
	public void expAdd() {}
	public void expRemve() {}
	public void expUpdate() {}
	public void expSum() {}
	
}

