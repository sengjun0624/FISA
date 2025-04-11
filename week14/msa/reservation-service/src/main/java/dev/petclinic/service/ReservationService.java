package dev.petclinic.service;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import dev.petclinic.dto.ReservationAcceptedMessage;
import dev.petclinic.dto.ReservationRequest;
import dev.petclinic.dto.VetAvailability;
import dev.petclinic.model.Reservation;
import dev.petclinic.model.ReservationRepository;
import dev.petclinic.model.ReservationStatus;
import dev.petclinic.web.VetAvailabilityClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReservationService {
	private final ReservationRepository reservationRepository;
	private final VetAvailabilityClient vetClient;

	// Before MQ
	private final StreamBridge streamBridge;
	// After MQ
	private final StreamBridge streamBridge2;
	public Flux<Reservation> getAllReservations() {
		return reservationRepository.findAll();
	}

	public Mono<Reservation> submitReservation(ReservationRequest request) {
		Mono<VetAvailability> vetAvailability = vetClient.getVetAvailabilityById(request.vetId());

		Mono<Reservation> reservationMono = vetAvailability
			.map(vet -> buildAcceptReservation(vet, request))
			.flatMap(reservationRepository::save)
			.doOnNext(reservation -> publishReservationAcceptedEvent(reservation))
			.doOnSubscribe(subscription -> System.out.println("예약 프로세스에 대하 구독이 시작됨"));

		return reservationMono;
	}

	private static Reservation buildAcceptReservation(VetAvailability vet, ReservationRequest reservationRequest) {
		return Reservation.of(
			reservationRequest.ownerId(),
			reservationRequest.petId(),
			reservationRequest.vetId(),
			reservationRequest.reservationDate(),
			ReservationStatus.PENDING);
	}

	// 퍼블리셔(예약 서비스) 로직 구현 - 예약이 접수되면 브로커(RabbitMQ)에 예약 접수 메시지 전송
	private void publishReservationAcceptedEvent(Reservation reservation) {
		log.info(" == Reservation Accepted(Pending) 이벤트가 호출됨, id: {}", reservation.id());

		// 예약이 접수되었다는 이벤트 객체 생성
		var reservationAcceptedMessage = new ReservationAcceptedMessage(reservation.id());
		log.info(" == 예약 접수 이벤트가 전송됨, id: {}", reservation.id());

		// 큐에 적재
		boolean result // 메시지를 acceptReservation-out-0에 명시적으로 전송
			= streamBridge.send("acceptReservation-out-0", reservationAcceptedMessage);
		log.info("적재 결과, {}", result);

	}
}
