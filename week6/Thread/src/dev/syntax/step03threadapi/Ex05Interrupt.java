package dev.syntax.step03threadapi;

public class Ex05Interrupt {
	public static void main(String[] args) throws InterruptedException{
		Thread worker = new Thread(() -> {
			try {
				System.out.println("worker 스레드 작업 대기");
				Thread.sleep(5000);
				System.out.println("worker 스레드 작업 완료");
			} catch (InterruptedException e) {
				System.out.println("인터럽트 감지, 스레드 종료");
			}
		});

		worker.start();

		//메인 스레드에서 worker 스레드에게 2초 후 인터럽트를 발생 시킴.
		Thread.sleep(2000);
		worker.interrupt();
	}
}
