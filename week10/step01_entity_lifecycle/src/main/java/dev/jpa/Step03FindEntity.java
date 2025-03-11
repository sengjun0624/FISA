package dev.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dev.jpa.model.Book;

public class Step03FindEntity {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("step01_entity_lifecycle");

		EntityManager manager = factory.createEntityManager();

		EntityTransaction transaction = manager.getTransaction();

		//SELECT를 사용하여 조회를 수행할 때는 manager.find();를 활용
		Book book = manager.find(Book.class, 1);
		System.out.println("book = " + book);
	}
}
