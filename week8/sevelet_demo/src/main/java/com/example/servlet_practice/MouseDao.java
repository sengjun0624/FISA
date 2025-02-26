package com.example.servlet_practice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;

import com.example.servlet_practice.model.Mouse;
import com.example.sevelet_demo.step05_state_managing.step03_practice.DBConnectionUtil;

public class MouseDao {

	public int insertMouse(Mouse mouse) {
		String sql = "INSERT INTO mouse (name, country,address) VALUES (?, ?,?)";

		try (Connection con = DBConnectionUtil.getConnection();
			 PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, mouse.getName());
			pstmt.setString(2, mouse.getCountry());
			pstmt.setString(3, mouse.getAddress());
			int isSuccess = pstmt.executeUpdate(); // 성공 시 1 이상 반환
			if (isSuccess >= 1)
				System.out.println(mouse.getCountry() + mouse.getName() + "쥐 생성 성공!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<Mouse> getMouse() {
		String sql = "SELECT * FROM Mouse";

		List<Mouse> result = new ArrayList<>();

		try (Connection con = DBConnectionUtil.getConnection();
			 PreparedStatement pstmt = con.prepareStatement(sql)) {
			ResultSet rs = pstmt.executeQuery();


			while (rs.next()) {
				String name = rs.getString("name");
				String country = rs.getString("country");
				String address = rs.getString("address");
				Mouse mouse = new Mouse(name, country, address);

				//여기서 생성한 쥐를 리스트에 추가.
				result.add(mouse);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return result;
	}
}
