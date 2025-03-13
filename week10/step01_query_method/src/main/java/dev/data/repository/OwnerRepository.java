package dev.data.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import dev.data.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
	public List<Owner>findAllByCity(String city);
	List<Owner> findAllByCityOrderByLastNameAsc(String city);

	boolean existsByFirstName(String firstName);

	long countByCity(String city);

	List<Owner> findAllByLastNameAndCity(String lastName, String city);

	List<Owner> findAllByFirstNameStartingWith(String firstNamePrefix);
	List<Owner> findAll(Sort sort);
	Page<Owner> findAll(Pageable page);
}
