package dev.syntax.step02todo.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	private static final Properties pro = new Properties();
	private static String USER_NAME;
	private static String PASSWORD;
	private static String DB_URL;
	private static String DATABASE;
	private static Connection connection;

	private static void getProperties() throws IOException {
		pro.load(new FileInputStream("src/resources/jdbc.properties"));
	}

	public static Connection getConnection() {
		try {
			getProperties();
			DB_URL = pro.getProperty("DB_URL");
			DATABASE = pro.getProperty("DATABASE");
			USER_NAME = pro.getProperty("USER_NAME");
			PASSWORD = pro.getProperty("PASSWORD");
			Connection connection = DriverManager.getConnection(DB_URL + DATABASE, USER_NAME, PASSWORD);

			System.out.println(DB_URL);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return connection;
	}

}
