package dev.spring.petclinic.pet.service;

import dev.spring.petclinic.pet.controller.dto.PetRes;
import dev.spring.petclinic.pet.enums.PetType;
import dev.spring.petclinic.pet.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {
	private final PetRepository petRepository;

	@Override
	public List<PetRes> getPetsByOwner(Long ownerId) {
		return petRepository.findPetsByOwnerId(ownerId);
	}

	@Override
	public void addPet(Long ownerId, PetRes pet) {
		petRepository.save(ownerId, pet);
	}


}
