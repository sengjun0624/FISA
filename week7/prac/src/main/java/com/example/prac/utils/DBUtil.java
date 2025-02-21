package com.example.prac.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String URL = "jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC";
	private static final String USER = "root";  // 🚨 MySQL 사용자 이름 설정
	private static final String PASSWORD = "Tmdwns0624@";  // 🚨 비밀번호 설정

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("MySQL Driver Not Found!", e);
		}
	}
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
