package dev.syntax.step03modifier;

public class Main {
	public static void main(String[] args) {
		Mouse jerry = new Mouse(5); // OK

		// jerry.age = 10; // Compile Error. "field Mouse.age is not visible"

		jerry.setAge(7); // OK
		jerry.printAge(); // OK, "7살"

		System.out.println(jerry.getAge()); // OK, 7
	}
}
