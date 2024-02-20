package com.hw3.model.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.hw3.model.dto.Book;

public class BookService {
	
	public BookService() {
		books.add( new Book(1111, "세이노의 가르침", "세이노", 6480, "데이원") );
		books.add( new Book(2222, "문과남자의 과학공부", "유시민", 15750, "돌베개") );
		books.add( new Book(3333, "역행자", "자청", 17550, "웅진지식하우스") );
		books.add( new Book(4444, "꿀벌의 예언", "베르나르 베르베르", 15120, "열린책들") );
		books.add( new Book(5555, "도둑맞은 집중력", "요한 하리", 16920, "어크로스") );
		books.add( new Book(6666, "노인과 바다", "어니스트 헤밍웨이", 18000, "민음사") );
	}
	
	Scanner sc = new Scanner(System.in);
	
	List<Book> books = new ArrayList<Book>();
	
	List<Book> favoriteBooks = new ArrayList<Book>();
	
	
	
	public void displayMenu() {
		
		int menuNum = 0;
		
		
		do {
			System.out.println("\n===도서 목록 프로그램===\n");
			System.out.println("1. 도서 등록\n");
			System.out.println("2. 도서 조회\n");
			System.out.println("3. 도서 수정\n");
			System.out.println("4. 도서 삭제\n");
			System.out.println("5. 즐겨찾기 추가\n");
			System.out.println("6. 즐겨찾기 삭제\n");
			System.out.println("7. 즐겨찾기 조회\n");
			System.out.println("8. 추천도서 뽑기\n");
			System.out.println("0. 프로그램 종료\n");
			
			try {
				System.out.print("메뉴를 입력하세요 : ");
				menuNum = sc.nextInt();
				System.out.println();
			
				switch(menuNum) {
				case 1 : System.out.println(addBook()); break;
				case 2 : selectBook(); break;
				case 3 : updateBook(); break;
				case 4 : System.out.println(removeBook());  break;
				case 5 : addFavorites(); break;
				case 6 : System.out.println(removeFavorites()); break;
				case 7 : selectFavorites(); break;
				case 8 : recommendBook(); break;
				case 0 : System.out.println("프로그램 종료.."); break;
				default : System.out.println("메뉴에 작성된 번호만 입력하세요!");
				}
			} catch(InputMismatchException e) {
				System.out.println("입력 형식이 유효하지 않습니다. 다시 입력하세요!");
				sc.nextLine();
				menuNum = -1;
			} 
			
		} while(menuNum != 0);
		
	}
	
	public String addBook() throws InputMismatchException { // case 1
		
		System.out.println("======도서 등록======\n");
		
		System.out.print("도서 번호 : ");
		int number = sc.nextInt();
		sc.nextLine();
		
		System.out.print("\n도서 제목 : ");
		String title = sc.nextLine();
		
		System.out.print("\n도서 저자 : ");
		String author = sc.nextLine();
		
		System.out.print("\n도서 가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		
		System.out.print("\n도서 출판사 : ");
		String publisher = sc.nextLine();
		
		if(books.add(new Book(number, title, author, price, publisher))) {
			return "\n등록 완료";
		} else {
			return "등록 실패";
		}
		
	}
	
	public void selectBook() {
		
		for( Book bk : books) {
			
			System.out.println(bk);
			
		}
		
	}
	
	public void updateBook() {
		
		System.out.print("수정할 도서 번호를 입력하세요 : ");
		int input = sc.nextInt();
		
		System.out.println();
		
		int menuNum = 0;
		int index = 0;
		boolean flag = false;
		
		for(Book bk : books) {
		
			if(bk.getNumber() == input) {
				index = books.indexOf(bk);
				flag = true;
			}
		}
		
		if(!flag) {
			
			System.out.println("잘못입력하셨습니다");
			return;
		} 
		
		do {
			System.out.println("1. 도서명\n");
			System.out.println("2. 도서 저자\n");
			System.out.println("3. 도서 가격\n");
			System.out.println("4. 도서 출판사\n");
			System.out.println("0. 수정 종료\n");
			
			System.out.print("어떤 정보를 수정하시겠습니까? ");
			menuNum = sc.nextInt();
			sc.nextLine();
			
			switch(menuNum) {
			case 1 : 
				System.out.println("\n=====도서명 수정=====\n");
				System.out.print("수정할 도서명을 입력하세요 : ");
				String title = sc.nextLine();
				
				books.get(index).setTitle(title);
				
				System.out.println("\n수정 완료\n");
				
				break;
			case 2 : 
				System.out.println("\n=====도서 저자 수정=====\n");
				System.out.print("수정할 도서 저자를 입력하세요 : ");
				String author = sc.nextLine();
				
				books.get(index).setAuthor(author);
				
				System.out.println("\n수정 완료\n");
				
				break;
			case 3 : 
				System.out.println("\n=====도서 가격 수정=====\n");
				
				System.out.print("수정할 가격을 입력하세요 : ");
				int price = sc.nextInt();						
				books.get(index).setPrice(price); 
				
				System.out.println("\n수정 완료\n");
				
				break;
			case 4 :
				System.out.println("\n=====도서 출판사 수정=====\n");
				System.out.print("수정할 도서 출판사를 입력하세요 : ");
				String publisher = sc.nextLine();
				
				books.get(index).setPublisher(publisher);
				
				System.out.println("\n수정 완료\n");
				break;
			}
			
			} while(menuNum != 0);
	}
	
	
	public String removeBook() {
		
		System.out.print("삭제할 도서 번호를 입력하세요 : ");
		int input = sc.nextInt();
		
		System.out.println();
		
		int index = 0;
		boolean flag = false;
		
		for(Book bk : books) {
		
			if(bk.getNumber() == input) {
				index = books.indexOf(bk);
				flag = true;
				break;
			} 
			
		} 
		
		if(!flag) {
			
			return "잘못입력하셨습니다";
		} 
		
		System.out.print("정말 삭제하시겠습니까? (Y/N) : ");
		char ch = sc.next().toUpperCase().charAt(0);
		
		if(ch == 'Y') {
			Book temp = books.remove(index);
			
			return "\n'"+ temp.getTitle() + "' 도서가 삭제되었습니다.";
		
		} else {
			return "\n" + "삭제 실패";
		}
		
		
		
	}
	
	public void addFavorites() {
		
		System.out.print("즐겨찾기에 추가할 도서 번호를 입력하세요. : ");
		
		int input = sc.nextInt();
		
		System.out.println();
		
		int index = 0;
		boolean flag = false;
		
		for(Book bk : books) {
		
			if(bk.getNumber() == input) {
				index = books.indexOf(bk);
				flag = true;
			}
		}
		
		if(!flag) {
			
			System.out.println("잘못 입력하셨습니다.");
			return;
		} 
		
		
		if(favoriteBooks.add(books.get(index))) {
			
			System.out.println("즐겨찾기 등록 완료!");
		} else {
			System.out.println("즐겨찾기 등록 실패ㅠㅠ");
		}
			
		
	}
	
	public String removeFavorites() {
		
		System.out.print("즐겨찾기에서 삭제할 도서 번호를 입력하세요. : ");
		
		int input = sc.nextInt();
		boolean flag = false;
		
		System.out.println();
		
		int index = 0;
		
		for(Book bk : favoriteBooks) {
		
			if(bk.getNumber() == input) {
				index = favoriteBooks.indexOf(bk);
				flag = true;
			}
		}
		if(!flag) {
			return "잘못 입력하셨습니다.";
		}
		
		
		System.out.print("정말 삭제하시겠습니까? (Y/N) : ");
		char ch = sc.next().toUpperCase().charAt(0);
		
		if(ch == 'Y') {
			Book temp = favoriteBooks.remove(index);
			
			return "\n'"+ temp.getTitle() + "' 도서가 삭제되었습니다.";
		
		} else {
			return "\n" + "삭제 실패";
		}
		
	}
	
	public void selectFavorites() {
		
		for( Book bk : favoriteBooks) {
			
			System.out.println(bk);
			
		}
	}
	
	public void recommendBook() {
		int random = (int)(Math.random() * favoriteBooks.size());
		
		System.out.println(favoriteBooks.get(random));
	}

}


