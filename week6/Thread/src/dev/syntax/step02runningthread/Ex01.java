package dev.syntax.step02runningthread;

public class Ex01 {
	public static void main(String[] args) {
		System.out.println("메인 쓰레드가 시작됨..");
		for (int i = 0; i < 2; i++) {
			Thread thread = new Thread(new MyRunnable());
			thread.start();
		}
		System.out.println("메인 쓰레드가 종료됨.");
	}
}

class MyRunnable implements Runnable {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + ":스레드 실행중..");
	}
}
