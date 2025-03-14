package dev.spring.petclinic.owner.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dev.spring.petclinic.owner.dto.OwnerRequestDTO;
import dev.spring.petclinic.owner.dto.OwnerResponseDTO;
import dev.spring.petclinic.owner.service.OwnerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/owners")
@RequiredArgsConstructor
@Tag(name = "Owner API", description = "반려동물 소유자 관리 API")
public class OwnerController {

	private final OwnerService ownerService;

	@PostMapping("/find")
	@Operation(summary = "소유자 검색", description = "소유자의 성(lastName)으로 소유자 목록을 검색합니다.")
	public ResponseEntity<List<OwnerResponseDTO>> findOwners(
			@Parameter(description = "소유자의 성 (lastName)", example = "Franklin") @RequestParam(name = "lastName") String lastName) {
		List<OwnerResponseDTO> ownersByLastName = ownerService.getOwnersByLastName(lastName);
		return ResponseEntity.ok(ownersByLastName);
	}

	@GetMapping("/{id}")
	@Operation(summary = "소유자 상세 조회", description = "ID를 이용하여 특정 소유자의 상세 정보를 조회합니다.")
	public ResponseEntity<OwnerResponseDTO> getOwnersDetail(
			@Parameter(description = "소유자 ID", example = "1") @PathVariable long id) {
		OwnerResponseDTO result = ownerService.findById(id);
		return ResponseEntity.ok(result);
	}

	@PostMapping("/new")
	@Operation(summary = "새로운 소유자 등록", description = "새로운 소유자를 등록합니다.")
	public ResponseEntity<OwnerResponseDTO> createOwner(
			@RequestBody OwnerRequestDTO requestDTO) {
		OwnerResponseDTO savedOwner = ownerService.createOwner(requestDTO);
		return ResponseEntity.ok(savedOwner);
	}

	@PostMapping("/edit")
	@Operation(summary = "소유자 정보 수정", description = "기존 소유자의 정보를 수정합니다.")
	public OwnerResponseDTO updateOwner(
			@Parameter(description = "소유자 ID", example = "1") @RequestParam Long id,
			@RequestBody OwnerRequestDTO requestDTO) {
		return ownerService.updateOwner(id, requestDTO);
	}
}
