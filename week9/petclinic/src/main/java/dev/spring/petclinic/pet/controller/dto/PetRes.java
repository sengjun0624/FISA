package dev.spring.petclinic.pet.controller.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PetRes {
	private Long id;
	private String name;
	private LocalDate birthDate;
	private String type;
}
