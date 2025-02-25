package com.example.sevelet_demo.step05_state_managing.step03_practice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {

	// 회원 정보를 DB에 저장하는 예시 메서드
	public int insertUser(String id, String password) {
		String sql = "INSERT INTO user (id, password) VALUES (?, ?)";

		try (Connection con = DBConnectionUtil.getConnection();
			 PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, id);
			pstmt.setString(2, password);

			return pstmt.executeUpdate(); // 성공 시 1 이상 반환

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
