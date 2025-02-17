package dev.syntax.step02runningthread;

/**
 * 스레드 생명주기 - Blocked(차단됨)
 *
 * 어떤 스레드가 현재 작업을 수행할 자격이 없을 때의 상태를 의미
 * 작업을 수행 중인 다른 스레드에 의해서 모니터 락(Monitor lock)이 걸려서
 * 자신이 수행 중이던 작업이 대기 상태로 전환되고,
 * 다른 스레드에 의해서 임계 영역(Critical section)에 접근하려고 할 때
 * Lock을 획득하기 위해 대기 중인 상태(BLOCKED)
 */
public class Ex04 {

	public static void main(String[] args) throws InterruptedException {
		// 3. 스레드 2개 생성
		Thread t1 = new Thread(new BlockedDemo());
		Thread t2 = new Thread(new BlockedDemo());

		// 4. 각각의 스레드 실행
		t1.start();
		t2.start();

		Thread.sleep(1000); // t2의 상태 확인을 확실하게 하기 위해 메인 스레드의 시간을 1초 정도 지연

		// 5. t2 스레드 객체의 현재 상태 확인
		System.out.println(t2.getState()); // ??
	}

}

// 1. BLOCKED 상태를 확인하기 위한 예시
class BlockedDemo implements Runnable {

	@Override
	public void run() {
		// 2. 스레드별 수행할 작업 내용 작성 부분
		criticalArea();
	}

	// 임계 영역(Critical section)  - 특정 시점에는 오직 하나의 스레드만 접근할 수 있는 영역
	// 공유된 리소스에 해당하는 criticalArea() 메서드 -> 메서드 내부 로직이 임계 영역
	// t2 스레드는 criticalArea() 메서드 앞에서 대기 중..(BLOCKED)
	public static synchronized void criticalArea() {
		// t1 스레드가 무한하게 사용 중..
		while(true) {

		}
	}
}










