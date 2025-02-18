package dev.syntax.step04multithread;

/**
 * 스레드 2개 생성
 * 스레드 1은 true 10번 출력
 *
 * 스레드 2는 false를 10번 출력
 */
public class Main {
	public static void main(String[] args) {
		sequenceProcess();
	}

	private static void sequenceProcess() {
		new Thread(()->{
			for (int i = 0; i < 10; i++) {
				System.out.println(true);
			}
		}).start();
		new Thread(()->{
			for (int i = 0; i < 10; i++) {
				System.out.println(false);
			}
		}).start();
	}
}
