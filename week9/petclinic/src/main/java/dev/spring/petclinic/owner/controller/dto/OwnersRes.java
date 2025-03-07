package dev.spring.petclinic.owner.controller.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OwnersRes {
	private long id;

	private String lastName;

	private String firstName;

	private String address;

	private String city;

	private String telephone;
}
