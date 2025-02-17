package dev.syntax.step02constructor;

public class Main {
	public static void main(String[] args) {
		Mouse mouse = new Mouse();
		System.out.println(mouse);
		System.out.println(mouse.age);

		mouse.age = 5;

		Mouse mouse1 = new Mouse(10);
		System.out.println(mouse1.age);

	}
}
