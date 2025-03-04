package step03_blocking_queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class DataQueue {
	private final BlockingQueue<Message> queue = new ArrayBlockingQueue<>(5);

	// 생산자가 큐에 메시지를 적재
	public void add(Message message) {
		try {
			queue.put(message);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// 소비자가 큐에서 메시지를 꺼내 소비
	public Message poll() {
		Message poppedMessage = null;
		try {
			poppedMessage = queue.take();
			return poppedMessage;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return poppedMessage;
	}
}
