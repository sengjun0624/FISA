package dev.spring.petclinic.pet.service;

import java.util.List;

import dev.spring.petclinic.pet.controller.dto.PetRes;

public interface PetService {
	List<PetRes> getPetsByOwner(Long ownerId);
}
