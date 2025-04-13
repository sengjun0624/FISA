package dev.petclinic.dto;

import java.time.LocalDate;

import org.springframework.data.relational.core.mapping.Table;

public record ReservationRequest (
	Long ownerId,
	Long petId,
	Long vetId,
	LocalDate reservationDate
) {}
