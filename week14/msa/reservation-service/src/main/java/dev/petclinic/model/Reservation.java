package dev.petclinic.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

// Record 불변 객체 셍상
// dto를 귀찮으니 all Args  같은거 제공
@Table(name = "reservations")
public record Reservation (
	@Id
	Long id,

	Long ownerId,
	Long petId,
	Long vetId,
	LocalDate reservationDate,
	ReservationStatus status
) {
	public static Reservation of(Long ownerId, Long petId, Long vetId, LocalDate reservationDate, ReservationStatus status) {
		return new Reservation(null, ownerId, petId, vetId, reservationDate, status);
	}
}
