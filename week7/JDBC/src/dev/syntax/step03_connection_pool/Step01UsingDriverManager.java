package dev.syntax.step03_connection_pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 */
public class Step01UsingDriverManager {

	public static void main(String[] args) throws SQLException {
		final String URL = "jdbc:mysql://localhost:3306/";
		final String DATABASE_NAME = "testdb";
		final String USER = "root";
		final String PASSWORD = "Tmdwns0624@";

		DataSource dataSource = new DriverManagerDataSource(URL + DATABASE_NAME, USER, PASSWORD);



		Connection connection1 = dataSource.getConnection();
		Connection connection2 = dataSource.getConnection();

		System.out.println("Connection: " + connection1);
		System.out.println("Connection: " + connection2);

		while (true) {

		}
	}

}
