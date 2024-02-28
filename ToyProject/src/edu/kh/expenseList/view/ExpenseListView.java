package edu.kh.expenseList.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import edu.kh.expenseList.model.dto.Expense;
import edu.kh.expenseList.model.service.ExpenseListService;
import edu.kh.expenseList.model.service.ExpenseListServiceImpl;

// View 입출력
public class ExpenseListView {
	
	// 필드
	private ExpenseListService service = null;	// Service
	private BufferedReader br = null; 
	
	// 기본 생성자
	public ExpenseListView() {
		
		try {
			// 부모타입 참조변수 = 자식 객체
			service = new ExpenseListServiceImpl(); // 다형성 업캐스팅
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
				case 2 : expListViewByCategory(); break;
				case 3 : expAdd(); break;
				case 4 : expRemove(); break;
				case 5 : expUpdate(); break;
				case 6 : expMemo(); break;
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
		System.out.println("2. Expense List View By Category & Total Amount");
		System.out.println("3. Expense Add");
		System.out.println("4. Expense Remove");
		System.out.println("5. Expense Update");
		System.out.println("6. Expense Memo(Detail) View");
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
		System.out.printf("%-3s %10s       %10s      %s       %s\n", "인덱스", "등록일", "결제 수단","지출 유형" ,"금액");
		System.out.println("--------------------------------------------------------------------");
		
		for(int i=0; i < expList.size(); i++) {
		
			String category = expList.get(i).getCategory();
			
			String method = expList.get(i).getMethod();
			
			String expDate = service.dateFormat(expList.get(i).getExpDate());
			
			int amount = expList.get(i).getAmount();
			
			System.out.printf("[%3d]  %20s      (%2s)         %3s  %10d원\n", i, expDate, method, category, amount);
		}
		
	}
	
	
	/**
	 * 2. 카테고리별 보기
	 */
	public void expListViewByCategory() {
		System.out.println("\n************[2.Expense List View By Category]************");
		
		service.expListViewByCategory();
		
	}
	
	
	/**
	 * 3. 지출 추가
	 */
	public void expAdd() throws Exception {
		System.out.println("\n************[3.Expense Add]************");
		
		System.out.println("**[지출 유형 예시 : 생활비 / 석식비 / 교통비 / 여가비...]**\n");
		System.out.print("1. 지출 유형 입력 : ");
		String category = br.readLine();
		
		System.out.print("2. 결제 수단 입력(신용 / 체크 / 현금) : ");
		String method = br.readLine();
		
		System.out.print("3. 지출 금액 입력 : ");
		int price = Integer.parseInt(br.readLine());	
		
		System.out.print("4. 지출 상세 / 메모 입력 : ");
		String detail = br.readLine();
		
		int index = service.expAdd(category, method, price, detail);
		
		if(index == 0) {
			System.out.println("!!! 추가에 실패하셨습니다. !!!");
			return;
		}
		
		System.out.println("[" + index + "]번 인덱스에 정상적으로 추가되었습니다.");
		
		
	}
	
	
	/**
	 * 4. 지출 내역 제거
	 */
	public void expRemove() throws Exception {
		System.out.println("\n************[4.Expense Remove]************");
		System.out.print("삭제할 지출 내역의 인덱스 번호 : ");
		int index = Integer.parseInt(br.readLine());
		
		Expense exp = service.expRemove(index);
			
		if(exp == null) System.out.printf("Error : [%s] 해당 인덱스가 존재하지 않습니다!", index);
		else System.out.printf("**[삭제가 완료 되었습니다.]**\n삭제된 목록 - 지출 상세 : %s / 결제 수단 : (%s) / 금액 : %d원\n", exp.getDetail(), exp.getMethod(), exp.getAmount());
	}
	
	
	/**
	 * 5. 지출 내역 수정
	 */
	public void expUpdate() throws Exception {
		System.out.println("\n************[5.Expense Update]************");
		
		System.out.print("Select index to update >> ");
		int index = Integer.parseInt(br.readLine());
		
		String expDetail = service.expUpdateView(index);
		
		if(expDetail == null) {
			System.out.println("[Error] : 해당 인덱스가 존재하지 않습니다.");
			return;
		} 
		
		System.out.println(expDetail);
		
		System.out.println("--------------------------------------------------------------------\n");
		
		System.out.print("1. 수정할 결제 수단 : ");
		String method = br.readLine();
		
		System.out.print("2. 수정할 지출 유형 : ");
		String category = br.readLine();
		
		System.out.print("3. 수정할 금액 : ");
		int amount = Integer.parseInt(br.readLine());
		
		System.out.print("4. 수정할 지출 상세 / 메모  : ");
		String detail = br.readLine();
		
		int result = service.expUpdate(index, category, method, amount, detail);
		
		if(result == 1) {
			System.out.println("[성공] 정상적으로 수정되었습니다.");
		} else if (result == -1) {
			System.out.println("[실패] 수정이 정상 진행되지 않았습니다.");
		}
	}
	
	
	/**
	 * 6. 상세, 메모 보기
	 */
	public void expMemo() throws Exception {
		
		System.out.println("\n************[6.Expense Memo(Detail) View]************");
		
		System.out.print("Index number >> ");
		int index = Integer.parseInt(br.readLine());
		
		String expMemo = service.expMemo(index);
		
		if(expMemo == null) {
			System.out.println("[Error] : 해당 인덱스가 존재하지 않습니다.");
			return;
		}
		
		System.out.println(expMemo); 
		
	}
	
	
}

