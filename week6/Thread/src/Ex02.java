public class Ex02 {
	private static SecondThread secondThr;

	public static void main(String[] args) {
		SecondThread secondThread = new SecondThread();

		new Thread()
		secondThread.run();

	}

}

class SecondThread implements Runnable {
	@Override
	public void run() {
		System.out.println("생성된 쓰레드 ID:" + Thread.currentThread().getId());
	}
}
