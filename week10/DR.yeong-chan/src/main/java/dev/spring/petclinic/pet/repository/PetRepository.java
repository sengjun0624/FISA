package dev.spring.petclinic.pet.repository;

import dev.spring.petclinic.pet.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PetRepository extends JpaRepository<Pet, Long> {

	List<Pet> findByOwner_Id(Long ownerId);
}
