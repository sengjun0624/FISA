package dev.syntax.step03threadapi;

public class Ex02SleepWithMultiThread {

	public static void main(String[] args) {
		Thread thread1 = new Thread(() -> {
			try {
				Thread.sleep(1000);
				System.out.println("스레드 1이 깨어났습니다.");

			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		});

		Thread thread2 = new Thread(() -> {
			try {

				Thread.sleep(2000);
				System.out.println("스레드 2가 깨어났습니다.");

			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		});

		thread1.start();
		thread2.start();

		System.out.println("main 스레드 종료");
	}

}
