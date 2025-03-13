package dev.spring.petclinic.pet.controller;

import dev.spring.petclinic.pet.dto.PetRequestDTO;
import dev.spring.petclinic.pet.dto.PetResponseDTO;
import dev.spring.petclinic.pet.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/owners/{ownerId}/pets")
@RequiredArgsConstructor
public class PetController {
	private final PetService petService;

	// 🔹 POST /owners/{ownerId}/pets/{petId}/edit → 특정 Pet 정보 수정
	@PostMapping("/{petId}/edit")
	public ResponseEntity<PetResponseDTO> addPet(
		@PathVariable Long ownerId,
		@PathVariable Long petId,
		@RequestBody PetRequestDTO petRequestDTO
	) {
		// PetResponseDTO를 return하게 만들고. 그값을 받아서 ResponseEntity.ok() <- 여기에 넣으면됨.
		PetResponseDTO updatedPet = petService.addPet(ownerId, petId, petRequestDTO);
		return ResponseEntity.ok(updatedPet);
	}
}
