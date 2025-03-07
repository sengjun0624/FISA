package dev.spring.petclinic.owner.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dev.spring.petclinic.owner.controller.dto.OwnerMapper;
import dev.spring.petclinic.owner.controller.dto.OwnersRes;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class OwnerRepository {

	private final JdbcTemplate jdbcTemplate;
	private final OwnerMapper ownerMapper;

	public List<OwnersRes> findAll(){
		String sql = "SELECT * FROM owners";
		return jdbcTemplate.query(sql, new OwnerMapper());
	}

	public OwnersRes findOwnerById(long id) {
		String sql = "SELECT * FROM owners where id = ?";
		jdbcTemplate.queryForObject(sql, id);
	}
}
