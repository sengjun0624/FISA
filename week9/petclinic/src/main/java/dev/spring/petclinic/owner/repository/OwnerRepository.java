package dev.spring.petclinic.owner.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// import dev.spring.petclinic.owner.controller.dto.OwnerMapper;
import dev.spring.petclinic.owner.controller.mapper.OwnerMapper;
import dev.spring.petclinic.owner.model.Owner;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class OwnerRepository {

	private final JdbcTemplate jdbcTemplate;

	private final OwnerMapper ownerMapper;

	public List<Owner> findByLastName(String query) {
		String sql = "SELECT * FROM owners WHERE last_name like ?";
		return jdbcTemplate.query(sql, ownerMapper, "%" + query + "%");
	}

	public Optional<Owner> findOwnerById(Long id) {
		String sql = "SELECT * FROM owners WHERE id = ?";

		try {
			return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new OwnerMapper(), id));
		} catch (EmptyResultDataAccessException e) {
			return Optional.empty();  // 존재하지 않는 경우 빈 Optional 반환
		}
	}

	public Owner update(Owner owner) {
		String updateSql = "UPDATE owners SET first_name = ?, last_name = ?, address = ?, city = ?, telephone = ? WHERE id = ?";
		jdbcTemplate.update(updateSql,
			owner.getFirstName(),
			owner.getLastName(),
			owner.getAddress(),
			owner.getCity(),
			owner.getTelephone(),
			owner.getId());
		return owner;
	}
	public Owner save(Owner owner) {
		String sql = "INSERT INTO owners (first_name, last_name, address, city, telephone) VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, owner.getFirstName(), owner.getLastName(), owner.getAddress(), owner.getCity(), owner.getTelephone());

		// 🔹 저장된 Owner의 ID 가져오기
		Long id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Long.class);
		return owner.toBuilder().id(id).isNew(false).build();
	}

}
