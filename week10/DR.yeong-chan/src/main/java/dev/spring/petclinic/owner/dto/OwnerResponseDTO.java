package dev.spring.petclinic.owner.dto;

import java.util.ArrayList;
import java.util.List;

import dev.spring.petclinic.owner.model.Owner;
import dev.spring.petclinic.pet.dto.PetResponseDTO;
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
public class OwnerResponseDTO {

	private Long id;
	private String lastName;
	private String firstName;
	private String address;
	private String city;
	private String telephone;
	private List<PetResponseDTO> pets = new ArrayList<>();

	public static OwnerResponseDTO of(Owner owner) {
		return OwnerResponseDTO.builder()
			.id(owner.getId())
			.firstName(owner.getFirstName())
			.lastName(owner.getLastName())
			.address(owner.getAddress())
			.city(owner.getCity())
			.telephone(owner.getTelephone())
			// null인 경우 응답할때 빈 리스트로 대체
			.pets(new ArrayList<>())
			.build();
	}

}
