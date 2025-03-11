package dev.jpa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static junit.framework.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import dev.jpa.model.Book;

/**
 * 영속성 컨텍스트의 생명주기 동작 테스트
 */
public class Step06LifeCycleTest {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("step01_entity_lifecycle");

	EntityManager manager = factory.createEntityManager();

	EntityTransaction transaction = manager.getTransaction();


	@Test
	@DisplayName("persist()를 수행할 경우, 엔티티가 영속화되고, commit이 수행될 경우 DB에 저장된다.")
	void testPersist() {
		//given
		Book jpaBook = new Book("JPA", "anonymous");

		// when
		transaction.begin();
		manager.persist(jpaBook);
		transaction.commit();

		// then
		assertEquals(jpaBook, manager.find(Book.class, jpaBook.getId()));
	}

	@Test
	void 한번_영속화된_엔티티는_다시_조회시_DB가_아닌_영속성컨텍스트에서_조회된다() {
		// given
		int id = 1;
		Book foundBook = manager.find(Book.class, id);

		// 한 번 조회 후 다시 한 번 조회할 때 SELECT문을 날리는지 확인(Console에서 확인)
		// -> SELECT가 1번만 실행됨
		// when
		Book foundBookTwice = manager.find(Book.class, id);

		//then
		assertEquals(foundBook, foundBookTwice);
	}

	@Test
	void 엔티티의_값을_수정하고_commit하면_변경감지가_발생되어_UPDATE쿼리가_수행된다() {
		//given
		int id = 1;
		Book foundBook = manager.find(Book.class, id);
		//when&&then
		transaction.begin();
		foundBook.updateBookName("ABC"); // foundBook 엔티티의 도서이름 변경
		//    manager.persist(foundBook); // 다시 영속화(필요 없음)
		transaction.commit(); // flush() 수행 전 변경 감지(Dirty Checking)

	}

	@Test
	void 만약_엔티티를_detach할경우_필드의_값을_변경해도_UPDATE쿼리가_수행되지_않는다() {
		int id = 2;
		Book foundBook = manager.find(Book.class, id);

		transaction.begin();
		foundBook.updateBookName("ABC");
		manager.detach(foundBook); // foundBook 엔티티를 영속성 컨텍스트에서 분리(Detach)

		transaction.commit();
		// UPDATE 쿼리 수행 안된 것 확인

		Book foundBookTwice = manager.find(Book.class, id); // 영속성 컨텍스트에서 제거되었기 때문에 다시 SELECT가 수행됨
		System.out.println(foundBook == foundBookTwice);
		assertNotEquals(foundBook, foundBookTwice);
	}

	@Test
	void remove를_수행할경우_PC와_DB에서_데이터가_제거된다() {
		int id = 2; // DB에서 존재하는 레코드 중에서 실제로 삭제할 id값으로 지정 후 테스트할 것
		transaction.begin();

		Book jpaBook = manager.find(Book.class, id);
		manager.remove(jpaBook);

		transaction.commit();

		// DB에서 제거될 경우, 영속성 컨텍스트에서도 제거됨(remove() -> detach())

		// PC에 없기 때문에 SELECT를 한 번 더 수행했지만 레코드가 없기 때문에 foundBook은 null이 됨
		assertThrows(NullPointerException.class, () -> {
			Book foundBook = manager.find(Book.class, jpaBook.getId());
			foundBook.updateBookName("Effective Unit Testing");

			// PC에 남아있으면 SELECT를 수행하지 않기 때문에 기존에 있던 엔티티와 비교 시 true가 나올 것
			assertFalse(jpaBook == foundBook);
			assertNull(foundBook);

		});
	}

	@Test
	void 영속성컨텍스트를_초기화할경우_모든_엔티티가_제거됨() {
		// DB 내 레코드가 1개도 없을 경우 데이터 1건 저장 후 테스트 수행할 것
		int id = 4; // 테스트 당시 DB 내 레코드 id는 4

		Book book = manager.find(Book.class, id);

		manager.clear();

		Book bookTwice = manager.find(Book.class, id);

		assertFalse(book == bookTwice);
	}

}
