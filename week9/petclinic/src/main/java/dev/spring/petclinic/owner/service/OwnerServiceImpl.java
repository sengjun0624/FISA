package dev.spring.petclinic.owner.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.spring.petclinic.owner.controller.dto.OwnersRes;
import dev.spring.petclinic.owner.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService{

	private final OwnerRepository ownerRepository;


	@Override
	public List<OwnersRes> getOwnersInfo(String lastName) {
		if (lastName == null || lastName.isEmpty()) {
			return ownerRepository.findAll();
		}


		return ownerRepository.findByLastName(lastName);

	}

	@Override
	public OwnersRes getOwnerDetail(long id) {
		return ownerRepository.findOwnerById(id);
	}

}
