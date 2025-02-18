package dev.syntax.step00practice;

public class Account {
	int balance = 4000;

	public synchronized void extract() {
		if (balance <= 0) {
			System.out.println("잔액 부족.");
			return;
		}
		balance -= 2000;
		System.out.println("2000원 인출 현재 " + balance + "원 입니다.");
	}

	@Override
	public String toString() {
		return String.format("현재 잔액은 %d입니다.", balance);
	}
}
