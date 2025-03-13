package dev.spring.petclinic.pet.service;

import java.util.List;
import java.util.stream.Collectors;

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

	@Transactional
	public PetResponseDTO addPet(Long ownerId, Long petId, PetRequestDTO petRequestDTO) {
		// 요청 DTO를 Entity로 변환. (정적 팩토리 메서드 활용)
		// Save후 생성된 Pet -> PetResponseDTO로 변환 ((정적 팩토리 메서드 활용))
		Pet from = PetRequestDTO.from(petRequestDTO);
		return PetResponseDTO.of(petRepository.save(from));
	}

	public List<PetResponseDTO> findPetsByOwnerId(Long ownerId){
		return petRepository.findByOwner_Id(ownerId).stream()
			.map(PetResponseDTO::of)
			.collect(Collectors.toList());
	}
}
