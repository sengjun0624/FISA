package dev.spring.petclinic.pet.model;

import dev.spring.petclinic.owner.model.Owner;
import dev.spring.petclinic.pet.dto.PetResponseDTO;
import dev.spring.petclinic.pet.enums.PetType;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "pets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDate;

	@Enumerated(EnumType.STRING)
	private PetType type;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "owner_id" ,nullable = false) // Pet 테이블에 owner_id 컬럼 추가
	private Owner owner;

}
