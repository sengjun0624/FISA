package dev.syntax.step02runningthread;


/**
 * 스레드 생명주기 - RUNNABLE
 *
 * RUNNABLE
 * 	- 실행 대기 상태(OS 스케줄러에 의해서 CPU 자원을 사용하길 기다리는 상태)
 *  - 실제 실행 중인 상태(RUNNING)
 * Java에서는 두 상태 모두 RUNNABLE로 통칭
 *
 * RUNNABLE 상태라는 표현이 애매하지만,
 * 스레드가 실행 중이거나 실행 가능한 상태 두 가지 모두를 의미
 * OS 스케줄러는 멀티 스레드로 동작하는 환경에서 일반적으로 각 스레드에게 고정된 시간을 할당해서
 * 실행 가능 상태(RUNNABLE)와 실행 중인 상태(RUNNING)를 오가도록 스케줄링
 *
 * 스레드가 실제로 실행 상태(RUNNING)으로 전환되려면 현재 스레드가 반드시 실행 대기 상태를 거쳐야함(RUNNABLE)
 */
public class Ex03 {

	public static void main(String[] args) {
		Thread thread = new Thread(() -> {
			System.out.println("스레드ID: " + Thread.currentThread().getId());
		});

		// 스레드 실행
		thread.start();

		// 스레드 객체의 상태 확인
		System.out.println(thread.getState());
	}

}
