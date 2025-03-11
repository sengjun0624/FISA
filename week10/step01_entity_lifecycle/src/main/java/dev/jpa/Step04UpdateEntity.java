package dev.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dev.jpa.model.Book;

public class Step04UpdateEntity {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("step01_entity_lifecycle");

		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		//Update를 하려면 어떤 행을 업데이트할 것인지 확인해야하기 때문에 조회를 먼저 해야함.
		Book book = manager.find(Book.class, 1);

		try {
			transaction.begin();
			// Book 데이터 수정
			book.updateBookName("수정된 책 이름");

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
