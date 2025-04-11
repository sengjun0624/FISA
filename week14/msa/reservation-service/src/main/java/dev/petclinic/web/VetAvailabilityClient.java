package dev.petclinic.web;

/*
MSA간 통신 과정에서 사용되는 클래스인 웹 클라이언트 Wrapper 클래스
수의사 서비스 전용 요청 클라
 */

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import dev.petclinic.dto.VetAvailability;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class VetAvailabilityClient {
	private static final String VETS_ROOT_API = "/vets/";

	private final WebClient webClient;

	/**
	 * Vet이 진료가 가능한 날짜를 조회하는 API vet-service에 요청을 보내는 함수
	 * @param id
	 * @return
	 */
	public Mono<VetAvailability> getVetAvailabilityById(Long id) {
		return webClient
			.get() // GET 요청
			.uri(VETS_ROOT_API + id) // 요청 URL은 vets/{vetId}
			.retrieve() // 요청을 보낸 후 응답을 받음
			.bodyToMono(VetAvailability.class); // 받은 객체를 Mono<VetAvailability>로 변환

		// TODO: 복원력(Resilience) 향상
			// 방법1. 커넥션 타임아웃(Timeout) 지정, 원격 서비스에 요청을 전송하고 응답을 받기까지 기다릴 수 있는 제한 시간 설정
			// 방법2. 재시도(Retry) 횟수 및 시간 지정
			// ex. 재시도를 시스템이 응답할 때까지 쉬지 않고 수행할 경우? 서버에 부하가 올 수 있음
				// 지수 백오프(exponential backoff) 전략 활용
					// 재시도 횟수가 늘어남에 따라 응답을 하기까지 지연되는 시간도 서서히 늘리는 것
					// (서비스가 회복되고 응답할 수 있는 시간을 주기 위함)
					// 방식 - 각 재시도 요청마다 지연 시간이 요청을 시도한 횟수의 100ms(초기 백오프값)을 곱한 값으로 계산되도록 적용
	}
}
