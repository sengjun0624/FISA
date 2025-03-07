package dev.spring.petclinic.owner.service;

import java.util.List;

import dev.spring.petclinic.owner.controller.dto.OwnersRes;

public interface OwnerService {

	List<OwnersRes> getOwnersInfo(String lastName);
	OwnersRes getOwnerDetail(long id);
}
