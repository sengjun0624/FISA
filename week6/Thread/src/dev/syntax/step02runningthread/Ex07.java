package dev.syntax.step02runningthread;

/**
 * 스레드 생명주기 - Terminated
 *
 * 스레드가 자신의 작업을 모두 수행 후 정상적으로 종료되었거나,
 * 예외가 발생되어 비정상적으로 종료되었을 때의 상태
 */
/**
 * 스레드 생명주기 - Terminated
 *
 * 스레드가 자신의 작업을 모두 수행 후 정상적으로 종료되었거나,
 * 예외가 발생되어 비정상적으로 종료되었을 때의 상태
 */
public class Ex07 {

	public static void main(String[] args) throws InterruptedException {

		Thread t1 = new Thread(new TerminatedState());
		t1.start();
		Thread.sleep(1000);
		System.out.println(t1.getState());

		System.out.println(t1.isAlive()); // 스레드가 살아있는지 확인
	}
}

// 1. Terminated 상태 확인용 예시 스레드 클래스 생성
class TerminatedState implements Runnable {

	@Override
	public void run() {
		// No processing in this block
	}
}
