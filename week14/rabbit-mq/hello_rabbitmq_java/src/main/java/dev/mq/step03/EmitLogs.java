package dev.mq.step03;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

/*
    작업(Task)을 작업 큐(Work queue)에 스케줄링하는 프로그램
    문자열값이 어떤 복잡한 작업이라고 가정할 때,
    ex. Hello...이라고 하면
    . 하나는 1초가 소요되는 작업이라고 가정

    따라서 Hello...는 3초가 걸리는 작업이라고 가정

    실행 인자값(args) 활용해서 Hello...과 같은 값 입력
 */
public class EmitLogs {


	private static final String EXCHANGE_NAME = "logs";

	public static void main(String[] args) throws IOException, TimeoutException {
		// 서버 연결
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		try (Connection connection = factory.newConnection();
			 Channel channel = connection.createChannel()) {

			String message = args.length < 1 ? "info: Hello World!" :
				String.join(" ", args);


			// Exchange 생성
			channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

			channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes("UTF-8"));
			System.out.println(" [x] Sent '" + message + "'");
		}

	}
}
