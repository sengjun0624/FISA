package dev.spring.petclinic.owner.dto;

import dev.spring.petclinic.owner.model.Owner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OwnerRequestDTO {

	private String lastName;
	private String firstName;
	private String address;
	private String city;
	private String telephone;
	private List<PetRequestDTO> pets;

	public static Owner from(OwnerRequestDTO dto) {
		return Owner.builder()
			.firstName(dto.getFirstName())
			.lastName(dto.getLastName())
			.address(dto.getAddress())
			.city(dto.getCity())
			.telephone(dto.getTelephone())
			.
			.build();
	}
}
