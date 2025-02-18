package dev.syntax.step02runningthread;

/**
 * 스레드 객체 생명주기 - NEW
 * 스레드 객체가 생성되었지만, 아직 실행은 되지 않은 상태
 */
public class Ex02 {

	public static void main(String[] args) {
		// 스레드 객체 생성
		Thread thread = new Thread(() -> {
			System.out.println("스레드ID: " + Thread.currentThread().getId());
		});

		// 스레드 객체의 상태 확인ㅁ
		System.out.println(thread.getState()); // NEW
		// 스레드를 실행시키는 thread.start()를 호출하지 않고 실행했기 때문에
		// 스레드 객체가 생성되었을 때의 상태를 확인할 수 있음
	}

}
