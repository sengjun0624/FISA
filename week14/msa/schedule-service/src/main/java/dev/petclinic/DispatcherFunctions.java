package dev.petclinic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

import reactor.core.publisher.Flux;

/*
    스케줄링 서비스의 동작 흐름
    스케줄링 서비스는 예약이 접수되었다는 큐를 구독하고 있음
    해당 큐에는 예약이 접수되었다는 이벤트 객체가 적재되어 있음(ReservationAcceptedMessage)

    큐에 이벤트가 적재되면 MQ는 스케줄링 서비스에게 push
    스케줄링 서비스는 예약 접수 이벤트를 가지고 스케줄링을 처리하기 위해 다음의 동작을 수행함

    함수는 입출력이 있음
    1. schedule() 호출
        schedule()는 입력값으로 ReservationAcceptedMessage를 받음
        반환값으로 예약 ID인 Long타입을 반환

    2. confirm() 호출
        schedule()에 의해 호출되면서 schedule() 함수의 반환값으로 받은 Long 타입을
        자신의 입력값으로 전달받음

        반환값으로는 예약 스케줄링이 완료되었다는 이벤트 객체를 의미하는
        Flux<ReservationDispatchedMessage>를 반환
 */


// 서버리스로 동작할 함수 및 로직 작성
@Configuration
public class DispatcherFunctions {

	private static final Logger log = LoggerFactory.getLogger(DispatcherFunctions.class);

	// Function<외부에서 들어오는 입력값 파라미터, 반환값>
	@Bean
	public Function<ReservationAcceptedMessage, Long> schedule() {
		return reservationAcceptedMessage -> {
			log.info("예약 ID: {} 가 스케줄링 처리됨");

			// 스케줄링 로직 처리..

			// schedule()의 반환값은 예약 접수 ID(Long 타입)
			return reservationAcceptedMessage.reservationId();
		};
	}
	// schedule() 함수 다음으로 동작하는 함수, 스케줄링 처리 확정 로직을 수행한다고 가정
	@Bean
	public Function<Flux<Long>, Flux<ReservationDispatchedMessage>> confirm() {
		return reservationFlux ->
			reservationFlux.map(reservationId -> {
				log.info("예약 ID: {} 가 확정 처리됨", reservationId);

				// 스케줄링 처리 확정 로직 처리..

				// 스케줄링이 완료되었다는 이벤트 객체를 반환
				return new ReservationDispatchedMessage(reservationId);
			});
	}


}
