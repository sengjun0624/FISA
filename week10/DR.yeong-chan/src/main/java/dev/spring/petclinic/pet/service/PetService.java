package dev.spring.petclinic.pet.service;

import java.util.List;
import java.util.stream.Collectors;

import dev.spring.petclinic.owner.model.Owner;
import dev.spring.petclinic.owner.repository.OwnerRepository;
import dev.spring.petclinic.pet.dto.PetRequestDTO;
import dev.spring.petclinic.pet.dto.PetResponseDTO;
import dev.spring.petclinic.pet.model.Pet;
import dev.spring.petclinic.pet.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PetService {
	private final PetRepository petRepository;

	private final OwnerRepository ownerRepository; // Owner 조회를 위해 필요

	public PetResponseDTO addPet(Long ownerId, PetRequestDTO petRequestDTO) {
		// ownerId를 이용해 Owner 조회 (없으면 예외 발생)
		Owner owner = ownerRepository.findById(ownerId)
			.orElseThrow(() -> new RuntimeException("해당 ID의 소유자를 찾을 수 없습니다: " + ownerId));

		// PetRequestDTO를 Pet 엔티티로 변환
		Pet pet = PetRequestDTO.from(petRequestDTO);

		// Pet과 Owner 연결
		pet.setOwner(owner);

		// Pet 저장 후 DTO 변환하여 반환
		return PetResponseDTO.of(petRepository.save(pet));
	}
	public List<PetResponseDTO> findPetsByOwnerId(Long ownerId){
		return petRepository.findByOwner_Id(ownerId).stream()
			.map(PetResponseDTO::of)
			.collect(Collectors.toList());
	}
}
