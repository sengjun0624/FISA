package dev.spring.petclinic.pet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.spring.petclinic.pet.controller.dto.PetRes;
import dev.spring.petclinic.pet.repository.PetRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {
	private final PetRepository petRepository;

	@Override
	public List<PetRes> getPetsByOwner(Long ownerId) {
		return null;
	}
}

