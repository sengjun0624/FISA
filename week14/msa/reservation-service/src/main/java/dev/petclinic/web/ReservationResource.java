package dev.petclinic.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dev.petclinic.dto.ReservationRequest;
import dev.petclinic.model.Reservation;
import dev.petclinic.service.ReservationService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("/reservations")
@RestController
@RequiredArgsConstructor
public class ReservationResource {
	private final ReservationService reservationService;


	@GetMapping
	public ResponseEntity<Flux<Reservation>> getAllReservations( ) {
		return ResponseEntity.ok(reservationService.getAllReservations());
	}

	@PostMapping
	public ResponseEntity<Mono<Reservation>> submitReservation(@RequestBody ReservationRequest request) {
		return ResponseEntity.ok(reservationService.submitReservation(request));
	}
}
