package dev.spring.petclinic.owner.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dev.spring.petclinic.owner.controller.dto.OwnersRes;
import dev.spring.petclinic.owner.service.OwnerService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/owner")
@RequiredArgsConstructor
public class OwnerController {

	private final OwnerService ownerService;

	@GetMapping("")
	public String getOwnersInfo(@RequestParam(name = "lastName", required = false) String lastName ,Model model){


		List<OwnersRes> owners = ownerService.getOwnersInfo(lastName);
		model.addAttribute("owners",owners);
		return "owners";
	}

	@GetMapping("/{id}")
	public String getOwnersDetail(@PathVariable long id, Model model) {
		OwnersRes owner = ownerService.getOwnerDetail(id);
		model.addAttribute("owner",owner)
		return "ownerDetails";
	}

	@GetMapping("/{id}/edit")
	public String getOwnerEditView(@PathVariable long id){
		return
	}
}
