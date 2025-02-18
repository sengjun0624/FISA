package dev.syntax.step01createthread;

public class Ex03 {
	public static void main(String[] args) {
		//Lamda로 써도 Runnable에대한 구현체가 만들어진다 왜??!
		// run method를 구현해서 넣은것임.
		Thread thread = new Thread(()->{
			System.out.println("생성된 스레드 ID: " + Thread.currentThread().getId());
		});
		thread.start();
	}
}
