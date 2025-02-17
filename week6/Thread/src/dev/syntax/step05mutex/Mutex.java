package dev.syntax.step05mutex;

/**
 * 상호 배제 기법(Mutex)을 synchronized를 활용하여 구현한 의사 코드 클래스
 */
public class Mutex {

	// 특정 스레드가 lock을 획득했는지 여부를 확인하기 위한 flag 변수
	private boolean lock = false;

	// 특정 스레드가 lock을 획득하는 메서드
	public synchronized void acquired() {
		// TODO: lock을 획득하는 처리 로직

		// 스레드 2가 2번째로 접근했을 경우, 현재 다른 스레드가 lock을 사용 중인지 확인
		while (lock) {
			try {
				wait(); // 사용 중일 경우, 스레드를 대기 상태로 전환(wait())
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// 만약 스레드1이 가장 먼저 접근했을 경우, lock을 획득하면 됨
		this.lock = true;
	}

	// 특정 스레드가 획득했던 lock을 해제(반납)하는 메서드
	public synchronized void release() {
		// TODO: lock을 해제하는 처리 로직
		this.lock = false; // lock 해제(반납)
		this.notify(); // t1 스레드가 t2 스레드에게 알림(t2 스레드가 RUNNABLE 상태로 전환됨)
	}

}
