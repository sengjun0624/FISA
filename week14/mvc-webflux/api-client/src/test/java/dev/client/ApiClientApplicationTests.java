package dev.client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.time.Instant;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class ApiClientApplicationTests {
	private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

	private static final String MVC_BASE_URL = "http://localhost:8080/mvc/delivery-info/";


	private final HttpClient httpClient

	@Test
	void MVC_요청() throws Exception {
		Instant now = Instant.now();

		for (int orderId : ORDER_IDS) {
			HttpRequest.newBuilder()
				.uri(new URI(MVC_BASE_URL + orderId))
				.GET()
				.build();
		}
		Instant end = Instant.now();
		log.info("[동기 요청 종료] 총 소요 시간: {}ms ", Duration

	}

}
