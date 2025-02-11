package dev.syntax.step03modifier;

// Mouse.java
public class Mouse {
	private int age;

	public Mouse(int age) {
		this.age = age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void printAge() {
		// 자신의 클래스 내에서는 private 변수 age에 접근 가능
		System.out.println(age + "살");
	}
}
