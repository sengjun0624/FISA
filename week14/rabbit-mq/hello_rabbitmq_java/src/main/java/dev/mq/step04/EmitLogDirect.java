package dev.mq.step04;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/*
    작업(Task)을 작업 큐(Work queue)에 스케줄링하는 프로그램
    문자열값이 어떤 복잡한 작업이라고 가정할 때,
    ex. Hello...이라고 하면
    . 하나는 1초가 소요되는 작업이라고 가정

    따라서 Hello...는 3초가 걸리는 작업이라고 가정

    실행 인자값(args) 활용해서 Hello...과 같은 값 입력
 */
public class EmitLogDirect {



	private static final String EXCHANGE_NAME = "direct_logs";

	public static void main(String[] argv) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");

		try (Connection connection = factory.newConnection();
			 Channel channel = connection.createChannel()) {
			// fan-out아닌 direct로 routing key로 사용
			channel.exchangeDeclare(EXCHANGE_NAME, "direct");

			//argv로 주어지는 로그 레벨 가져오기
			String severity = getSeverity(argv);
			//argv로 주어지는 메시지 가져오기
			String message = getMessage(argv);

			// 로그 레벨에 맞는 메시지 publish
			channel.basicPublish(EXCHANGE_NAME, severity, null, message.getBytes("UTF-8"));
			System.out.println(" [x] Sent '" + severity + "':'" + message + "'");
		}
	}
	private static String getSeverity(String[] strings) {
		if (strings.length < 1) return "info"; // 기본값은 info
		return strings[0]; // 첫 번째 인자를 로그 레벨로 간주
	}

	private static String getMessage(String[] strings) {
		if (strings.length < 2) return "Hello World";
		return String.join(" ", Arrays.copyOfRange(strings, 1, strings.length));
	}

}
