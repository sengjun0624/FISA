package dev.spring.petclinic.owner.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import dev.spring.petclinic.owner.dto.OwnerRequestDTO;
import dev.spring.petclinic.owner.dto.OwnerResponseDTO;
import dev.spring.petclinic.owner.model.Owner;
import dev.spring.petclinic.owner.repository.OwnerRepository;
import dev.spring.petclinic.pet.dto.PetResponseDTO;
import dev.spring.petclinic.pet.model.Pet;
import dev.spring.petclinic.pet.repository.PetRepository;
import dev.spring.petclinic.pet.service.PetService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OwnerService {

	private final OwnerRepository ownerRepository;

	private final PetService petService;

	public List<OwnerResponseDTO> getOwnersByLastName(String lastName) {
		return ownerRepository.findByLastNameContainingIgnoreCase(lastName).stream()
			.map(OwnerResponseDTO::of)
			.collect(Collectors.toList());
	}

	public OwnerResponseDTO findById(long id) {
		// 응답을 OwnerResponseDTO로 변환
		Owner owner = ownerRepository.findById(id)
			.orElseThrow(() -> new EntityNotFoundException("Owner not found with id: " + id));

		OwnerResponseDTO result = OwnerResponseDTO.of(owner);

		// 단방향 매핑
		result.setPets(petService.findPetsByOwnerId(id));
		return result;
	}

	public OwnerResponseDTO createOwner(OwnerRequestDTO requestDTO) {
		return OwnerResponseDTO.of(ownerRepository.save(OwnerRequestDTO.from(requestDTO)));
	}

	public OwnerResponseDTO updateOwner(Long id, OwnerRequestDTO ownerDTO) {
		// ownerDTO-> Owner로 변환  ownerRepository.findOwnerById에서 사용하기 위해
		Owner existingOwner = ownerRepository.findOwnerById(id);

		// 기존에 조회한 Owner 객체에 업데이트하려는 내용(ownerDTO)을 넣어줌.
		// Owner.java의 updateWith 메서드 참고
		existingOwner.updateWith(ownerDTO);

		// JPA를 사용해서 update 후 Owner 받아옴.
		Owner updateOwner = ownerRepository.save(existingOwner);

		// Owner -> OwnerResponseDTO로 변환
		return OwnerResponseDTO.of(updateOwner);
	}

	public Owner save(Owner owner) {
		return ownerRepository.save(owner);
	}
}
