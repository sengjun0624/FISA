package dev.spring.petclinic.pet.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PetType {
	DOG(1, "Dog"),
	CAT(2, "Cat"),
	BIRD(3, "Bird"),
	FISH(4, "Fish");

	private final Integer id;
	private final String displayName;

}
