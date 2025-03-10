
package dev.spring.petclinic.owner.controller.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import dev.spring.petclinic.owner.model.Owner;

@Component
public class OwnerMapper implements RowMapper<Owner> {
	@Override
	public Owner mapRow(ResultSet rs, int rowNum) throws SQLException {
		return Owner.builder()
			.id(rs.getLong("id"))
			.firstName(rs.getString("first_name"))
			.lastName(rs.getString("last_name"))
			.address(rs.getString("address"))
			.city(rs.getString("city"))
			.telephone(rs.getString("telephone"))
			.isNew(false) // 🔹 DB에서 가져온 데이터이므로 항상 false
			.build();
	}
}
