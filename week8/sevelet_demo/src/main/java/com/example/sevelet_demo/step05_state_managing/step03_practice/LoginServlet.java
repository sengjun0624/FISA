package com.example.sevelet_demo.step05_state_managing.step03_practice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/practice-login")
public class LoginServlet extends HttpServlet {
	static final String DB_URL = "jdbc:mysql://localhost/testdb";
	static final String USER = "root";
	static final String PASS = "Tmdwns0624@";
	static final String QUERY = "SELECT id, password FROM user WHERE id = ?";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		String id = req.getParameter("id");
		String password = req.getParameter("password");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 기존에 로그인되어 있는지 확인
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("id") != null) {
			resp.sendRedirect("authenticated.html"); // 이미 로그인 된 경우 별도의 페이지로 이동
			return;
		}

		boolean loginSuccess = false;
		try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
			 PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {

			preparedStatement.setString(1, id);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					String dbId = resultSet.getString("id");
					String dbPassword = resultSet.getString("password");

					if (id.equals(dbId) && password.equals(dbPassword)) {
						loginSuccess = true;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// 오류 발생 시 오류 페이지로 리다이렉트
			resp.sendRedirect("index.html");
			return;
		}

		if (loginSuccess) {
			// 로그인 성공 시 새 세션 생성 및 id 저장
			session = req.getSession(true);
			session.setAttribute("id", id);
			resp.sendRedirect("authenticated.html");
			return;
		} else {
			// 로그인 실패 시 로그인 페이지 또는 실패 안내 페이지로 이동
			resp.sendRedirect("index.html");
			return;
		}
	}
}
