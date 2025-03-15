package dev.spring.petclinic.pet.dto;

import dev.spring.petclinic.pet.enums.PetType;
import dev.spring.petclinic.pet.model.Pet;
import lombok.*;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetRequestDTO {

	@Schema(description = "반려동물 이름", example = "Leo")
	@NotBlank(message = "반려동물 이름을 입력해야 합니다.")
	private String name;

	@Schema(description = "반려동물 생년월일", example = "2020-05-15")
	@NotNull(message = "반려동물 생년월일을 입력해야 합니다.")
	@Past(message = "반려동물의 생년월일은 과거 날짜여야 합니다.")
	private LocalDate birthDate;

	@Schema(description = "반려동물 타입 (DOG, CAT, BIRD, FISH)", example = "DOG")
	@NotNull(message = "반려동물 타입을 선택해야 합니다.")
	private PetType type;
	public static Pet from(PetRequestDTO dto) {
		return Pet.builder()
			.name(dto.getName())
			.birthDate(dto.getBirthDate())
			.type(dto.getType())
			.build();
	}
}

