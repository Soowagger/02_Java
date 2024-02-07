package edu.kh.oop.basic;

import java.util.Scanner;

public class AccountRun {
	public static void main(String[] args) {
		
		Account a1 = new Account();
		
		
		
		a1.setName("홍길동");
		a1.setAccountNumber("123-1234-12345");
		a1.setBalance(100000);
		a1.setPassword("a1234");
		// ac.setAmount(10000);
		
		a1.deposit(20000);
		a1.withdraw("1234", 10000); // 비밀번호 불일치
		a1.withdraw("a1234", 2000000); // 잔액 부족
		a1.withdraw("a1234", 10000); // 잔액 부족
		
		System.out.println("========== 사용자 추가 ================");
		
		Account a2 = new Account();
		
		a2.setName("김길동");
		a2.setAccountNumber("777-7777-7777");
		a2.setBalance(1000);
		a2.setPassword("1111");
		
		a2.deposit(10000);
		a2.withdraw("2222", 1000);
		a2.withdraw("1111", 10000000);
		a2.withdraw("1111", 5000);
	}
}
