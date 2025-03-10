package dev.spring.petclinic.owner.service;

import java.util.List;
import java.util.Optional;

import dev.spring.petclinic.owner.model.Owner;

public interface OwnerService {

	List<Owner> getOwnersInfo(String lastName);
	Owner findById(long id);
	public Owner save(Owner owner);
	Owner updateOwner(long id, Owner owner);
}
