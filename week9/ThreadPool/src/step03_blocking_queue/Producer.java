package step03_blocking_queue;

import static step02_custom_implement.utils.ThreadUtil.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Producer implements Runnable {

	// DataQueue를 필드로 작성 << 왜? 생산한 데이터를 DataQueue에 적재해야 하기 때문
	private final DataQueue dataQueue;

	// 근데 왜 필드로 작성해야 생산한 데아터가 Data Quque에 적재되는 걸까?
	// 답: (생성자 안쓴다면) produce() 메소드에서 DataQueue.queue에 직접 접근할 수 없기 때문에 필드로 작성해야 함

	public Producer(DataQueue dataQueue) {
		this.dataQueue = dataQueue;
	}

	// 프로듀서 스레드가 작업할 내용(run() 내부에 작성)
	@Override
	public void run() {
		produce();
	}

	// 데이터 생산 작업
	public void produce() {
		for (int i = 0; i < 5; i++) {
			Message message = produceMessage();

			// 생산한 메세지를 큐(DataQueue.queue)에 적재
			dataQueue.add(message);

			// 현실성을 위해 랜덤 시간동안 지연
			sleep((long) (Math.random() * 100));
		}
	}

	private Message produceMessage() {
		Message message = new Message(generateUniqueString());

		System.out.println(String.format("[%s] 메시지 생산: %s%n", Thread.currentThread().getName(), message.getData()));

		return message;
	}

	private String generateUniqueString() {
		// 현재 시간으로부터 고유한 문자열 생성
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		String timePart = sdf.format(new Date());

		// 뒤에 1~2개의 랜덤 대문자 알파벳 추가
		Random rand = new Random();
		int randomLength = rand.nextInt(2) + 1;
		StringBuilder randomChars = new StringBuilder();

		for (int i = 0; i < randomLength; i++) {
			char randomChar = (char) ('A' + rand.nextInt(26)); // A-Z 범위의 대문자 랜덤 선택
			randomChars.append(randomChar);
		}

		return timePart + "-" + randomChars.toString(); // ex. "093410-AB"
	}

}
