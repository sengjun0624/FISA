package dev.spring.petclinic.pet.repository;

import dev.spring.petclinic.pet.controller.dto.PetRes;
import dev.spring.petclinic.pet.controller.dto.PetMapper;
import dev.spring.petclinic.pet.enums.PetType;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PetRepository {
	private final JdbcTemplate jdbcTemplate;

	public List<PetRes> findPetsByOwnerId(Long ownerId) {
		String sql = "SELECT id, name, birth_date, type_id FROM pets WHERE owner_id = ?";
		return jdbcTemplate.query(sql, new PetMapper(), ownerId);
	}

	public void save(Long ownerId, PetRes pet) {
		String sql = "INSERT INTO pets (owner_id, name, birth_date, type_id) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sql, ownerId, pet.getName(), pet.getBirthDate(), pet.getType());
	}

}
