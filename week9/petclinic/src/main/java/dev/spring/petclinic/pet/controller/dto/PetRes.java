package dev.spring.petclinic.pet.controller.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import dev.spring.petclinic.pet.enums.PetType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PetRes {
	private Long id;
	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDate;

	private Integer type;
}

