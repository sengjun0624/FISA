package dev.petclinic.event;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.petclinic.dto.ReservationDispatchedMessage;
import dev.petclinic.service.ReservationService;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

/*
에약이 확정되면, 스케줄링 서비스 애플리케이션이 생성한 메시지를 이벤트 브로커에서 꺼내 소비하는 함수 구현
 */
@Configuration
@Slf4j
public class ReservationFunctions {
	@Bean
	public Consumer<Flux<ReservationDispatchedMessage>> dispatchReservation(ReservationService reservationService) {
		// 예약 확정 이벤트 처리
		return flux -> reservationService.consumeReservationDispatchedEvent(flux)
			.doOnNext(
				reservation -> log.info(" == 스케줄링 처리 완료 이벤트가 전송됨, id:{}", reservation.id()))
			.subscribe(); // 리액티브 스트림을 활성화 하기 위해선 subscribe 해야함.
	}

}
