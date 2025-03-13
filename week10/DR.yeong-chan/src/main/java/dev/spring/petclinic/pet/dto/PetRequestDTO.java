package dev.spring.petclinic.pet.dto;

import dev.spring.petclinic.pet.enums.PetType;
import dev.spring.petclinic.pet.model.Pet;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetRequestDTO {
	private String name;
	private LocalDate birthDate;
	private PetType type;

	public static Pet from(PetRequestDTO dto) {
		return Pet.builder()
			.name(dto.getName())
			.birthDate(dto.getBirthDate())
			.type(dto.getType())
			.build();
	}
}

