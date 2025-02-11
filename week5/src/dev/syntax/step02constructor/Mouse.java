package dev.syntax.step02constructor;

public class Mouse {
	String name;

	int age;

	public Mouse() {
		System.out.println("Mouse() called");
	}

	public Mouse(int age) {
		this.age = age;
	}
}
