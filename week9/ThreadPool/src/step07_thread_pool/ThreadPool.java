package step07_thread_pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPool {
	private static BlockingQueue<Runnable> threadPool;

	public ThreadPool() {
		this.threadPool = new ArrayBlockingQueue<>(2);

		for (int i = 0; i < 2; i++) {
			new WorkerThread().start();
		}
	}

	public Runnable take() throws InterruptedException {
		return threadPool.take();
	}

	private static int a = 0;

	public void put(Runnable r) throws InterruptedException {
		threadPool.put(r);
		System.out.println(a++ + "번째 작업이 추가됨.");
	}

	private class WorkerThread extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					Runnable task = threadPool.take(); // 큐에서 작업 가져오기
					task.run(); // 실행
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
