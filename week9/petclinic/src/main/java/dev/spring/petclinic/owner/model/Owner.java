package dev.spring.petclinic.owner.model;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.spring.petclinic.pet.controller.dto.PetRes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Setter
public class Owner {
	private long id;

	private String lastName;

	private String firstName;

	private String address;

	private String city;

	private String telephone;

	private Boolean isNew;

	private List<PetRes> pets;

	public Owner updateWith(Owner newData) {
		return Owner.builder()
			.id(this.id) // 기존 ID 유지
			.firstName(newData.getFirstName() != null ? newData.getFirstName() : this.firstName)
			.lastName(newData.getLastName() != null ? newData.getLastName() : this.lastName)
			.address(newData.getAddress() != null ? newData.getAddress() : this.address)
			.city(newData.getCity() != null ? newData.getCity() : this.city)
			.telephone(newData.getTelephone() != null ? newData.getTelephone() : this.telephone)
			.isNew(false)
			.build();
	}


}
