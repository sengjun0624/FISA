package step02_custom_implement;

import static step02_custom_implement.utils.ThreadUtil.*;

public class Consumer implements Runnable {
	private final DataQueue dataQueue;

	public Consumer(DataQueue dataQueue) {
		super();
		this.dataQueue = dataQueue;
	}

	@Override
	public void run() {
		consume();
	}

	public void consume() {
		for (int i = 0; i < 5; i++) {

			Message message = dataQueue.poll();
			consumeMessage(message); // 메시지 소비

			// 현실성을 위해 랜덤 시간동안 지연
			sleep((long) (Math.random() * 100));
		}
	}

	// message가 null이 아닌지 확인하고 소비하도록 작성하여 nullpointer는 방지됨
	private void consumeMessage(Message message) {
		if (message != null) {
			System.out.println(String.format("[%s] 메시지 소비: %s%n",
				Thread.currentThread().getName(), message.getData()));
		}
	}
}
