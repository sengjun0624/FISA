package dev.syntax.step02todo.model;

import java.time.LocalDate;

public class Todo {
	private int id;
	private String title; // 할 일 제목
	private String description; // 할 일 내용
	private LocalDate dueDate; // 할 일 마감기간
	private boolean isCompleted; // 진행 여부

	public Todo(int id, String title, String description, LocalDate dueDate, boolean isCompleted) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.isCompleted = isCompleted;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", title=" + title + ", description=" + description + ", dueDate=" + dueDate
			+ ", isCompleted=" + isCompleted + "]";
	}

}
