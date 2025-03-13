package dev.spring.petclinic.owner.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.spring.petclinic.owner.dto.OwnerRequestDTO;
import dev.spring.petclinic.owner.dto.OwnerResponseDTO;
import dev.spring.petclinic.owner.model.Owner;
import dev.spring.petclinic.owner.service.OwnerService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/owners")
@RequiredArgsConstructor
public class OwnerController {

	private final OwnerService ownerService;

	/**
	 * 검색 API
	 * @param lastName
	 * @return List<OwnerResponseDTO>
	 */
	@PostMapping("/find")
	public ResponseEntity<List<OwnerResponseDTO>> findOwners(@RequestParam(name = "lastName") String lastName) {
		List<OwnerResponseDTO> ownersByLastName = ownerService.getOwnersByLastName(lastName);
		return ResponseEntity.ok(ownersByLastName);
	}

	/**
	 * 오너 상세페이지
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<OwnerResponseDTO> getOwnersDetail(@PathVariable long id) {
		OwnerResponseDTO result = ownerService.findById(id);
		return ResponseEntity.ok(result);
	}

	/**
	 * 오너 생성
	 * @param requestDTO
	 * @return OwnerResponseDTO
	 */
	@PostMapping("/new")
	public ResponseEntity<OwnerResponseDTO> createOwner(@RequestBody OwnerRequestDTO requestDTO) {
		OwnerResponseDTO savedOwner = ownerService.createOwner(requestDTO);
		return ResponseEntity.ok(savedOwner);
	}

	/** 오너 수정하기
	 *
	 *
	 * @param
	 * @param
	 * @return
	 */
	@PostMapping("/edit")
	public OwnerResponseDTO updateOwner(@RequestParam Long id, @RequestBody OwnerRequestDTO requestDTO) {
		return ownerService.updateOwner(id, requestDTO);
	}

	// @PostMapping("/{id}/edit")
	// public Owner updateOwner(@PathVariable Long id, Owner owner) {
	// 	Owner updatedOwner = ownerService.updateOwner(id, owner);
	// 	return updatedOwner;
	// }

}
