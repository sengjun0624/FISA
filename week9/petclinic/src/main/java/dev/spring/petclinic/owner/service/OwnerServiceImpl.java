package dev.spring.petclinic.owner.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import dev.spring.petclinic.owner.model.Owner;
import dev.spring.petclinic.owner.repository.OwnerRepository;
import dev.spring.petclinic.pet.controller.dto.PetRes;
import dev.spring.petclinic.pet.repository.PetRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {

	private final OwnerRepository ownerRepository;
	private final PetRepository petRepository;

	@Override
	public List<Owner> getOwnersInfo(String lastName) {
		return ownerRepository.findByLastName(lastName);
	}

	@Override
	public Owner findById(long id) {
		Owner owner = ownerRepository.findOwnerById(id)
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Owner not found"));

		// 🔹 해당 Owner의 pets 조회
		List<PetRes> pets = petRepository.findPetsByOwnerId(id);

		// 🔹 Owner 객체에 pets 추가 (Builder 패턴 활용)
		return owner.toBuilder().pets(pets).build();
	}

	@Override
	public Owner updateOwner(long id, Owner newOwnerData) {
		Owner owner = findById(id);

		Owner updatedOwner = owner.updateWith(newOwnerData);

		return ownerRepository.update(updatedOwner); // 저장 후 수정된 Owner 반환
	}
	@Override
	public Owner save(Owner owner) {
		return ownerRepository.save(owner);
	}

}
