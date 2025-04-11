package dev.petclinic.service;

import dev.petclinic.model.Vet;
import dev.petclinic.model.VetAvailability;
import dev.petclinic.model.VetAvailabilityRepository;
import dev.petclinic.model.VetRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VetService {

	private final VetRepository vetRepository;
	private final VetAvailabilityRepository vetAvailabilityRepository;

	public List<Vet> getVetList() {
		return vetRepository.findAll();
	}

	public VetAvailability getVetById(@PathVariable Long vetId) {
		return vetAvailabilityRepository.findByVetId(vetId);
	}

	// 수의사 ID로 해당 수의사의 진료 가능한 요일 조회
}
