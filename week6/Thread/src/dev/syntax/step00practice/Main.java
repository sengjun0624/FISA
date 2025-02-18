package dev.syntax.step00practice;

import static dev.syntax.step00practice.Main.*;

public class Main implements Runnable{
	private static Account account = new Account();

	public static void main(String[] args) {
		Thread thread1 = new Thread(new Main());
		Thread thread2 = new Thread(new Main());
		Thread thread3 = new Thread(new Main());

		thread1.start();
		thread2.start();
		thread3.start();
	}

	@Override
	public void run() {
		account.extract();

	}
}

