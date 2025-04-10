package dev.petclinic.service;


import dev.petclinic.model.Vet;
import dev.petclinic.model.VetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VetService {

	private final VetRepository vetRepository;

	public List<Vet> getVetList() {
		return vetRepository.findAll();
	}
}
