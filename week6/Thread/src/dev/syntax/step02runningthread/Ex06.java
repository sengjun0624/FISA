package dev.syntax.step02runningthread;

/**
 * 스레드 생명주기 - Timed Waiting
 *
 * sleep()이나 timeout 매개변수가 있는 메서드를 호출할 때 timed waiting 상태가 됨
 * -> 일정 시간 동안 다른 스레드가 특정 작업을 수행하길 기다리는 상태일 때를 의미
 * 즉, 특정 스레드 하나가 CPU를 독차지하게 되는 상황에 대처하기 위해 활용
 */
public class Ex06 {

	public static void main(String[] args) throws InterruptedException {
		TimeWaitingDemo runnable = new TimeWaitingDemo();
		Thread t1 = new Thread(runnable);
		t1.start();

		Thread.sleep(1000);
		System.out.println(t1.getState());
	}
}

// 1. Timed Waiting 상태 확인용 예시 스레드 클래스 생성
class TimeWaitingDemo implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
	}
}
