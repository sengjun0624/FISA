package dev.spring.petclinic.pet.service;

import dev.spring.petclinic.pet.controller.dto.PetRes;
import dev.spring.petclinic.pet.enums.PetType;
import java.util.List;
import java.util.Optional;

public interface PetService {
	List<PetRes> getPetsByOwner(Long ownerId);
	void addPet(Long ownerId, PetRes pet);

}
