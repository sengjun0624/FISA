package dev.mq.steo01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Sender - 메시지 발행자 (Publisher)
 *
 * 퍼블리셔는 RabbitMq와 연결, 메시지를 전송하는 처리 수행
 * 컨슈머는 메시지 큐로부터 퍼블리셔가 적재한 메시지를 소비하는 처리 수행
 */
public class Sender {
	private static final String QUEUE_NAME = "hello";

	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");

		// RabbitMQ 서버(5672)와 커넥션 연결 수행
		Connection connection = factory.newConnection();
		// 채녈 생성
		Channel channel = connection.createChannel();

		// 큐 생성
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);

		String messgae = "Hell World!";

		// Publish
		channel
			.basicPublish("", QUEUE_NAME, null, messgae.getBytes(StandardCharsets.UTF_8));
		System.out.println(" [Publisher] Sent = " + messgae);
	}
}
