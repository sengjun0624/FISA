package dev.syntax.step10practice;

/**
 * 클래스 Summary
 1. 학생(Student) 클래스

 1-1. 속성 Summary
 이름 - String name
 잔액 - int balance;

 1-2. 역할 Summary
 버스 탑승 - takeBus(Bus bus)

 잔액 확인 - printInfo()
 출력 형식: "name 님의 남은 잔액은 balance 입니다."
 */
public class Student {
	private String name;
	private int balance;

	public void printInfo() {
		System.out.println(name + " 님의 남은 잔액은 " + balance + "입니다.");
	}

	public void take(Vehicle vehicle) {
		if (balance < 1500) {
			System.out.println("잔액 부족");
			return;
		}
		balance -= 1500;
		vehicle.take(1500);
		System.out.println("결제 완료");
	}

	public Student(String name, int balance) {
		this.name = name;
		this.balance = balance;
	}
}
