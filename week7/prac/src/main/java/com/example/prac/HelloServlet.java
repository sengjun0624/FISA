package com.example.prac;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.prac.utils.DBUtil;

@WebServlet("/todos")  // 🚀 http://localhost:8080/sevelet/users 실행 시 데이터 조회
public class HelloServlet extends HttpServlet {

	public HelloServlet() {
		System.out.println("true = " + true);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		System.out.println("todo");
		// response.setContentType("text/html;charset=UTF-8");
		// PrintWriter out = response.getWriter();
		//
		// try (Connection conn = DBUtil.getConnection()) {
		// 	String sql = "SELECT id FROM todo";
		// 	PreparedStatement pstmt = conn.prepareStatement(sql);
		// 	ResultSet rs = pstmt.executeQuery();
		//
		// 	out.println("<html><body><h2>User List</h2><ul>");
		// 	while (rs.next()) {
		// 		out.println("<li>" + rs.getInt("id") + ": " + "</li>");
		// 	}
		// 	out.println("</ul></body></html>");
		//
		// } catch (SQLException e) {
		// 	e.printStackTrace();
		// 	out.println("<p>Error connecting to database: " + e.getMessage() + "</p>");
		// }
	}
}
