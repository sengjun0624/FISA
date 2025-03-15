package dev.spring.petclinic.owner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.spring.petclinic.owner.dto.OwnerResponseDTO;
import dev.spring.petclinic.owner.model.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
	List<Owner> findByLastNameContainingIgnoreCase(String lastName);
	Owner findOwnerById(long id);

}

