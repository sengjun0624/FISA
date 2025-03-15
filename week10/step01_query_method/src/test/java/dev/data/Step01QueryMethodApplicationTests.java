package dev.data;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import dev.data.model.Owner;
import dev.data.repository.OwnerRepository;

@SpringBootTest
class Step01QueryMethodApplicationTests {

	@Autowired
	private OwnerRepository ownerRepository;

	@Test
	void findAllOwner() {
		ownerRepository.findAll().forEach(System.out::println);
	}

	@Test
	void findAllByCity() {
		List<Owner> owners = ownerRepository.findAllByCity("Madison");
		assertThat(owners).hasSize(4);
	}

	@Test
	@DisplayName("City에 해당하는 모든 Owner를 조회하되, last_name을 기준으로 오름차순 정렬하여 조회")
	void test2() {
		List<Owner> owners = ownerRepository.findAllByCityOrderByLastNameAsc("Madison");

		assertThat(owners)
			.extracting(Owner::getLastName)
			.isSorted();
	}

	@Test
	@DisplayName("first_name에 해당하는 Owner가 존재하는지 확인")
	void test3() {
		boolean exists = ownerRepository.existsByFirstName("George");
		assertThat(exists).isTrue();
	}

	@Test
	@DisplayName("City에 해당하는 Owner의 숫자 조회")
	void test4() {
		long count = ownerRepository.countByCity("Madison");
		assertThat(count).isEqualTo(4);
	}

	@Test
	@DisplayName("last_name이 'LEE'이고, city가 'Incheon'인 Owner 조회(And 조건)")
	void test5() {
		List<Owner> owners = ownerRepository.findAllByLastNameAndCity("LEE", "Incheon");
		assertThat(owners).isNotEmpty();
	}

	@Test
	@DisplayName("first_name이 'Da'으로 시작하는 owner 조회")
	void test6() {
		List<Owner> owners = ownerRepository.findAllByFirstNameStartingWith("Da");
		assertThat(owners).isNotEmpty();
	}

	@Test
	@DisplayName("firstName 기준으로 오름차순 정렬 후, 리스트의 첫 번째 요소를 통해 정렬 여부 확인")
	void pagingTestwithSorting() {
/*		// given
		String expected = "Betty";

		// when
		List<Owner> owners = ownerRepository.findAll(Sort.by(Sort.Direction.ASC, "firstName"));
		String firstName = owners.get(0).getFirstName();
		System.out.println("firstName = " + firstName);

		// then
		assertThat(firstName).isEqualTo(expected);*/
		Pageable pageable = PageRequest.of(0, 5, Sort.by(Sort.Order.asc("firstName")));

		Condition<Owner> sortedFirstOwnerCondition = new Condition<Owner> () {
			@Override
			public boolean matches(Owner owner) {
				// Condition을 활용하면 원하는 조건을 코드 레벨에서 작성 가능
				return owner.getId() == 2 && owner.getLastName().equals("Davis");
			}
		};

		assertThat(ownerRepository.findAll(pageable))
			.first()
			.has(sortedFirstOwnerCondition);
	}

	@Test
	@DisplayName("firstName 기준으로 내림차순 정렬, city 기준 오름차순 정렬 후, 리스트의 첫 번째 요소를 통해 정렬 여부 확인")
	void pagingTestWithSorting2() {

		Pageable pageable = PageRequest.of(0, 5, Sort.by("firstName").descending().and(Sort.by("city")));

		Condition<Owner> sortedFirstOwnerCondition = new Condition<Owner>() {
			@Override
			public boolean matches(Owner owner) {
				return owner.getId() == 5 && owner.getLastName().equals("McTavish");
			}
		};

		assertThat(ownerRepository.findAll(pageable)).first().has(sortedFirstOwnerCondition);
	}

	@Test
	@DisplayName("Paging 테스트 기본")
	void pagingTestBasic(){
		Pageable pageable = PageRequest.of(0, 6);

		Page<Owner> owners = ownerRepository.findAll(pageable);

		assertThat(owners).hasSize(6);

		Pageable next = pageable.next();
		Page<Owner> all = ownerRepository.findAll(next);

		assertThat(all).hasSize(5);
		assertThat(next.getPageNumber()).isEqualTo(1);
	}
}
