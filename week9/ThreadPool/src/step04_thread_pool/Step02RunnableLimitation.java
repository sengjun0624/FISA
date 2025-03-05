package step04_thread_pool;

/**
 * Runnalbe의 반환 타입이 void이기 때문에
 * 스레드의 작업 수행 결과값을 반환받으려면??
 * 스레드의 작업 수행 결과값을 반환받기 위해서는 별도의 변수가 필요(result라는 변수)
 * 디게 귀찮게 되어있다. 결과값 받으려면 조인걸어야하고 예외처리도 해야하고
 */
public class Step02RunnableLimitation {
	private static String result;

	public static void main(String[] args) {
		Runnable runnable = new Runnable() {
			public void run() {
				result = "Runnable 실행 결과";
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();

		try {
			thread.join();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(result);

	}
}
