package dev.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dev.jpa.model.Book;

public class Step02DoPersist {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("step01_entity_lifecycle");

		EntityManager manager = factory.createEntityManager();

		EntityTransaction transaction = manager.getTransaction();

		// Book이라는 클래스 생성 후 DB에 저장


		try {
			transaction.begin();
			Book book = new Book("JPA", "무명");
			// book을 DB에 저장하기 위해서는 JDBC 방식에서는 PreparedStatement, ResultSet 등을 활용했었음
			// JPA에서는 book이라는 인스턴스를 JPA의 API를 활용하여 저장할 수 있음
			// Book이라는 클래스가 DB에 Book이라는 이름의 테이블로 영속화된다고 하면, 첫 번째 레코드가 추가된다는 것

			manager.persist(book);
			transaction.commit();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
