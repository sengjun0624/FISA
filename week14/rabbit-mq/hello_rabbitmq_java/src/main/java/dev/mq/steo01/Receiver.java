package dev.mq.steo01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

/**
 * Receiver - 메시지 소비자 (Consumer)행
 *
 */
public class Receiver {
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
		System.out.println(" [Receiver] Waiting ... ");

		DeliverCallback deliverCallback = (consumerTag, delivery) -> {
			String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
			System.out.println("[Receiver] 메시지를 받음: " + message);
		};

		channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {});
	}
}
