package dev.spring.petclinic.pet.controller;

import dev.spring.petclinic.pet.dto.PetRequestDTO;
import dev.spring.petclinic.pet.dto.PetResponseDTO;
import dev.spring.petclinic.pet.service.PetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/owners/{ownerId}/pets")
@RequiredArgsConstructor
public class PetController {
	private final PetService petService;

	@PostMapping("/new")
	@Operation(
		summary = "새로운 반려동물 등록",
		description = "소유자의 ID와 반려동물 정보를 받아서 새로운 반려동물을 등록합니다."
	)
	public ResponseEntity<PetResponseDTO> addPet(        @Parameter(description = "소유자 ID", example = "1") @PathVariable Long ownerId,
	@RequestBody PetRequestDTO petRequestDTO) {

		PetResponseDTO petResponseDTO = petService.addPet(ownerId, petRequestDTO);
		return ResponseEntity.ok(petResponseDTO);
	}
}
