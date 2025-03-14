package dev.spring.petclinic.owner.model;

import dev.spring.petclinic.owner.dto.OwnerRequestDTO;
import dev.spring.petclinic.owner.dto.OwnerResponseDTO;
import dev.spring.petclinic.pet.model.Pet;
import lombok.*;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "owners")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String lastName;
	private String firstName;
	private String address;
	private String city;
	private String telephone;

	public void updateWith(OwnerRequestDTO dto) {
		if (dto.getFirstName() != null) this.firstName = dto.getFirstName();
		if (dto.getLastName() != null) this.lastName = dto.getLastName();
		if (dto.getAddress() != null) this.address = dto.getAddress();
		if (dto.getCity() != null) this.city = dto.getCity();
		if (dto.getTelephone() != null) this.telephone = dto.getTelephone();
	}

}
