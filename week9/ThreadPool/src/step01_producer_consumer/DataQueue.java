package step01_producer_consumer;

import java.util.LinkedList;
import java.util.Queue;

public class DataQueue {
	private final Queue<Message> queue = new LinkedList<>();

	// 생산자가 큐에 메시지를 적재
	public void add(Message message) {
		queue.add(message);
	}

	// 소비자가 큐에서 메시지를 꺼내 소비
	public Message poll() {
		// 현재 큐 상태 확인용 코드 추가
		System.out.print(String.format("  현재 큐 상태: %s%n", queue.toString()));
		Message poppedMessage = queue.poll();
		return poppedMessage;
	}

}
