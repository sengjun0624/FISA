package dev.syntax.step02todo.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import cloud.DBUtil;
import dev.syntax.step02todo.model.Todo;

/**
 * DAO, Data Access Object
 * 실제 DB에 접근하는 역할을 수행하는 클래스
 */
public class TodoDAO {

	// JDK 7 이전 방식

	public List<Todo> findAll() {
		// 조회 SQL
		final String selectQuey = "SELECT * FROM todo";
		List<Todo> todos = new ArrayList<>();
		try (Connection connection = DBUtil.getConnection("src/resources/jdbc.properties");
			 Statement statement = connection.createStatement();
			 ResultSet resultSet = statement.executeQuery(selectQuey);) {
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				String description = resultSet.getString("description");

				// 날짜는 java.sql.da  te 패키지에서 제공하는 타입
				Date date = resultSet.getDate("due_date");
				LocalDate dueDate = date.toLocalDate();

				boolean isCompleted = resultSet.getBoolean("is_completed");

				// DB에서 받아온 데이터를 Todo 모델 객체로 바인딩
				todos.add(new Todo(id, title, description, dueDate, isCompleted));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return todos;
	}

	public Todo findById(int todoId) {

		final String selectQuery = "SELECT * FROM todo WHERE id = ?";

		// try() 소괄호 내부에 작성한 JDBC 객체들은 자동으로 자원이 반납됨(close()를 명시하지 않아도 됨)
		// JDBC 객체 이외에 자원 반납이 필요한 다른 클래스들도 동일하게 사용 가능
		// 조건, AutoCloseable 인터페이스를 상속받은 인터페이스들만 사용 가능

		try (Connection connection = DBUtil.getConnection("src/resources/jdbc.properties");
			 PreparedStatement statement = connection.prepareStatement(selectQuery);
		) {
			statement.setInt(1, todoId);
			try (
				ResultSet resultSet = statement.executeQuery();) {
				if (resultSet.next()) {
					int id = resultSet.getInt("id");
					String title = resultSet.getString("title");
					String description = resultSet.getString("description");
					Date date = resultSet.getDate("due_date");
					LocalDate dueDate = date.toLocalDate();
					boolean isCompleted = resultSet.getBoolean("is_completed");

					return new Todo(id, title, description, dueDate, isCompleted);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}






