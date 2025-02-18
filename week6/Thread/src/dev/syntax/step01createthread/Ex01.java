package dev.syntax.step01createthread;

public class Ex01 {
	public static void main(String[] args) {
		FirstThread firstThread = new FirstThread();
		System.out.println(firstThread);
		firstThread.start();

	}
}

class FirstThread extends Thread {
	@Override
	public void run() {
		System.out.println("생성된 쓰레드 ID:" + currentThread().getId());
	}
}
