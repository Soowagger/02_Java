package edu.kh.oop.basic;

public class Account {
	
	
	private String name;
	private String accountNumber;
	private long balance;
	private String password;

/*
	- deposit(amount) : 전달받은 금액을 잔액에 누적한 후, 현재 잔액을 콘솔에 출력
	- withdraw(pw, amount) : 비밀번호와 출금할 금액을 전달 받아와, 조건에 맞으면 잔액에서 차감 후 현재 잔액 출력
	1) 비밀번호와 일치하지 않으면 "비밀번호 불일치" 출력
	2) 출금할 금액이 잔액보다 크면 "잔액 부족" 출력
*/	
	
	public void deposit(long amount) {
		balance += amount;
		System.out.println(name + "의 현재 잔액 : " + balance + "원");		
	}
	
	
	public void withdraw(String pw, long amount) {
		if(!password.equals(pw)) {
			System.out.println("비밀번호 불일치");
			return; // 메서드 종료 -> 호출한 곳으로 돌아감
		}  
			
		if(amount > balance) {
			System.out.println("잔액 부족");
			return;
		} 
		
		balance -= amount;
		
		System.out.printf("%s 계좌에서 %d원 출금\n", accountNumber, amount);
		System.out.println(name + "의 현재 잔액 : " + balance + "원");
	}
	
	
	
	// getter / setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	
}
