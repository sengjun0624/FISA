package dev.syntax.step02runningthread;

public class Ex05 implements Runnable {
	public static Thread t1;

	@Override
	public void run() {
		System.out.println("t1의 남은 작업 시작");
		// T1
		Thread t2 = new Thread(new WaitingDemo());
		t2.start();

		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("t1의 스레드가 남은 작업 수행 후 종료");
	}

	public static void main(String[] args) {
		t1 = new Thread(new Ex05());
		t1.start();

	}
}

class WaitingDemo implements Runnable {
	@Override
	public void run() {
		//T2
		System.out.println("t2 start");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("t1의 작업상태: "+Ex05.t1.getState());
		System.out.println("t2 end");

	}
}
