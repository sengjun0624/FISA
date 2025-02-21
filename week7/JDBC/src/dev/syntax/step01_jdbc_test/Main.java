package dev.syntax.step01_jdbc_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	// 1. DBMS에 접근하기 위한 설정값
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "Tmdwns0624@";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/";
	private static final String DATABASE = "testdb";
	private static Connection connection;
	private static Statement statement;

	public static void main(String[] args) {
		try {
			connection = DriverManager.getConnection(DB_URL + DATABASE, USER_NAME, PASSWORD);
			statement = connection.createStatement();
			String sql = "DROP TABLE favorite_food";

			boolean resultSet = statement.execute(sql);

			// while (rs.next()) {
			// 	// Retrieve by column name
			// 	System.out.print("ID: " + rs.getInt("person_id"));
			// 	System.out.print(", eye_golor: " + rs.getString("eye_color"));
			// 	System.out.print(", First: " + rs.getString("first_name"));
			// 	System.out.println(", Last: " + rs.getString("last_name"));
			// }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
}
