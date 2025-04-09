package dev.mq.step04;

import java.util.Arrays;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;


public class EmitLogTopic {



	private static final String EXCHANGE_NAME = "topic_logs";

	public static void main(String[] argv) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		try (Connection connection = factory.newConnection();
			 Channel channel = connection.createChannel()) {

			channel.exchangeDeclare(EXCHANGE_NAME, "topic");

			String routingKey = getRouting(argv);
			String message = getMessage(argv);

			channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes("UTF-8"));
			System.out.println(" [x] Sent '" + routingKey + "':'" + message + "'");
		}
	}

	private static String getRouting(String[] strings) {
		if (strings.length < 1) return "#"; // 기본값은 #
		return strings[0]; // 첫 번째 인자를 Topic 간주
	}

	private static String getMessage(String[] strings) {
		if (strings.length < 2) return "Hello World";
		return String.join(" ", Arrays.copyOfRange(strings, 1, strings.length));
	}

}
