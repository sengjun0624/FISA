package dev.spring.petclinic.pet.repository;

import dev.spring.petclinic.pet.controller.dto.PetRes;
import dev.spring.petclinic.pet.controller.dto.PetMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PetRepository {
	private final JdbcTemplate jdbcTemplate;

	public List<PetRes> findPetsByOwnerId(Long ownerId) {
		String sql = "SELECT id, name, birth_date, type FROM pets WHERE owner_id = ?";
		return jdbcTemplate.query(sql, new PetMapper(), ownerId);
	}
}
