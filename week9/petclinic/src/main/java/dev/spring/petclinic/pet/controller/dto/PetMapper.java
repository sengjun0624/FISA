package dev.spring.petclinic.pet.controller.dto;

import dev.spring.petclinic.pet.enums.PetType;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PetMapper implements RowMapper<PetRes> {
	@Override
	public PetRes mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new PetRes(
			rs.getLong("id"),
			rs.getString("name"),
			rs.getDate("birth_date").toLocalDate(),
			rs.getInt("type_id")  // 정수를 enum으로 변환
		);
	}
}
