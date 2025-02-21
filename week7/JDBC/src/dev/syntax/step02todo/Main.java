package dev.syntax.step02todo;

import java.util.List;

import dev.syntax.step02todo.data.TodoDAO;
import dev.syntax.step02todo.model.Todo;

public class Main {
	public static void main(String[] args) {
		TodoDAO todoDAO = new TodoDAO();
		List<Todo> all = todoDAO.findAll();
		for (Todo t : all) {
			System.out.println(t.toString());
		}

		Todo byId = todoDAO.findById(1);
		System.out.println(byId.toString());
	}
}
