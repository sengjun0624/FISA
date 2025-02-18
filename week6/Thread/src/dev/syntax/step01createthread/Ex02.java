package dev.syntax.step01createthread;

// Thread 객체를 생성할 수 있는 방법 2번째
// Runnable 인터페이스를 개발자가 구현(implements)하여 스레드를 생성하는 방식
public class Ex02 {

	public static void main(String[] args) {
		// 4. 스레드 객체 생성
		SecondThread secondThread = new SecondThread();

		// 5. 실제 스레드를 실행하기 위해 Thread 타입의 스레드 객체를 생성해야함
		Thread thread = new Thread(secondThread);

		// 6. 스레드를 실행하기 위해서는 start()자체를 호출하는 것은 기존 방식과 동일함
		thread.start();
	}

}

// 1. Runnable 인터페이스를 구현한 클래스 작성a
class SecondThread implements Runnable {

	// 2. run() 메서드 오버라이딩
	@Override
	public void run() {
		// 3. 스레드에서 수행할 작업 내용 작성
		System.out.println("생성된 스레드 ID: " + Thread.currentThread().getId());
	}

}
