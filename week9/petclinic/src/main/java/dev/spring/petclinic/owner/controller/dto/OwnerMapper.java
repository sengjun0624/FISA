package dev.spring.petclinic.owner.controller.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.tree.RowMapper;

import org.springframework.stereotype.Component;

@Component
public class OwnerMapper implements RowMapper<OwnersRes> {

	@Override
	public OwnersRes mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new OwnersRes(
			rs.getLong("id"),
			rs.getString("lastName"),
			rs.getString("firstName"),
			rs.getString("address"),
			rs.getString("city"),  // 추가된 필드
			rs.getString("telephone")       // 추가된 필드
		);
	}


}
