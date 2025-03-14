package dev.spring.petclinic.pet.dto;


import dev.spring.petclinic.pet.enums.PetType;
import dev.spring.petclinic.pet.model.Pet;
import lombok.*;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetResponseDTO {
	private Long id;
	private String name;
	private LocalDate birthDate;
	@Enumerated(EnumType.STRING)
	private PetType type;
	public static PetResponseDTO of(Pet pet) {
		return PetResponseDTO.builder()
			.id(pet.getId())
			.name(pet.getName())
			.birthDate(pet.getBirthDate())
			.type(pet.getType())
			.build();
	}
}
