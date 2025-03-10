package dev.spring.petclinic.owner.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import dev.spring.petclinic.owner.model.Owner;
import dev.spring.petclinic.owner.service.OwnerService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/owners")
@RequiredArgsConstructor
public class OwnerController {

	private final OwnerService ownerService;

	@GetMapping("/find")
	public String showFindOwnersForm(Model model) {
		model.addAttribute("owner", new Owner()); // 🔹 빈 Owner 객체 추가
		return "owners/findOwners";
	}

	@GetMapping("/new")
	public String getOwnerAddPage(Model model) {
		model.addAttribute("owner", new Owner()); // 🔹 빈 Owner 객체 추가
		return "owners/createOrUpdateOwnerForm";
	}

	@PostMapping("/new")
	public String createOwner(@ModelAttribute("owner") Owner owner) {
		Owner savedOwner = ownerService.save(owner);
		return "redirect:/owners/" + savedOwner.getId(); // 성공 시 상세 페이지로 이동
	}

	@GetMapping
	public String getOwnersInfo(@RequestParam(name = "lastName", required = false) String lastName, Model model) {
		List<Owner> owners = ownerService.getOwnersInfo(lastName);
		System.out.println("owners.size() = " + owners.size());
		model.addAttribute("listOwners", owners);
		return "owners/ownersList";
	}

	@GetMapping("/{id}")
	public String getOwnersDetail(@PathVariable long id, Model model) {
		Owner owner = ownerService.findById(id);
		model.addAttribute("owner", owner);
		return "owners/ownerDetails";
	}

	@GetMapping("/{id}/edit")
	public String getOwnerEditView(@PathVariable long id, Model model) {
		Owner owner = ownerService.findById(id);

		model.addAttribute("owner", owner);
		return "owners/createOrUpdateOwnerForm";
	}

	@PostMapping("/{id}/edit")
	public String updateOwner(@PathVariable Long id, @ModelAttribute Owner owner, Model model) {
		Owner updatedOwner = ownerService.updateOwner(id, owner);
		model.addAttribute("owner", updatedOwner);
		return "redirect:/owners/" + id;
	}

}
