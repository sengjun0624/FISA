package step02_custom_implement;

import java.util.LinkedList;
import java.util.Queue;

public class DataQueue {
	private final Queue<Message> queue = new LinkedList<>();
	private final int capacity; // 최대 큐 크기 제한

	public DataQueue(int capacity) {
		this.capacity = capacity;
	}

	// 생산자가 큐에 메시지를 적재
	public synchronized void add(Message message) {
		while (queue.size() >= capacity) { // 큐가 가득 차 있으면 대기
			try {
				System.out.println("Producer 대기 (큐가 가득 참)");
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}

		queue.add(message);
		notify(); // 대기 중인 Consumer 스레드들에게 알림
	}

	// 소비자가 큐에서 메시지를 꺼내 소비
	public synchronized Message poll() {
		while (queue.isEmpty()) { // 큐가 비어 있으면 대기
			try {
				System.out.println("Consumer 대기 (큐가 비어있음)");
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}

		Message poppedMessage = queue.poll();
		notify(); // 생산자를 깨워서 새 메시지를 추가하도록 함
		return poppedMessage;
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}
}
