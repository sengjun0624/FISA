package commerce.mvc;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

/*
    사용자(api-client)로부터 배송 조회 요청을 받는 컨트롤러
 */
@Slf4j
@RequestMapping(path = "/mvc/delivery-info")
@RestController
public class CommerceController {
	private final RestTemplate restTemplate = new RestTemplate();
	private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
	@GetMapping("/{orderId}")
	public ResponseEntity<DeliveryInfo> getInfo(@PathVariable("orderId") int orderId) {
		log.info("요청 시작 시간 - : {}", LocalTime.now().format(TIME_FORMATTER));

		// delivery 서비스(외부 API)에게 배송 조회 요청을 전송
		// delivery 서비스의 URL 지정
		String url = "http://localhost:8090/mvc/delivery/" + orderId;

		// 해당 서비스에게 요청 전송
		DeliveryInfo deliveryInfo = restTemplate.getForObject(url, DeliveryInfo.class);

		// 결과를 응답 받으면 그대로 클라이언트에게 응답
		log.info("응답 완료 시간 - : {}", LocalTime.now().format(TIME_FORMATTER));
		return ResponseEntity.ok(deliveryInfo);
	}
}
