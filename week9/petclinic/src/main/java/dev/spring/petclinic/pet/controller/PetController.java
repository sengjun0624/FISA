package dev.spring.petclinic.pet.controller;

import dev.spring.petclinic.owner.model.Owner;
import dev.spring.petclinic.owner.service.OwnerService;
import dev.spring.petclinic.pet.controller.dto.PetRes;
import dev.spring.petclinic.pet.enums.PetType;
import dev.spring.petclinic.pet.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/owners/{ownerId}/pets")
@RequiredArgsConstructor
public class PetController {
	private final PetService petService;
	private final OwnerService ownerService;

	// 🔹 GET /owners/{ownerId}/pets → 특정 Owner의 Pet 목록 보기
	@GetMapping
	public String getPets(@PathVariable Long ownerId, Model model) {
		List<PetRes> pets = petService.getPetsByOwner(ownerId);
		Owner owner = ownerService.findById(ownerId);

		model.addAttribute("owner", owner);
		model.addAttribute("pets", pets);
		return "owners/ownerDetails";
	}

	@GetMapping("/new")
	public String showAddPetForm(@PathVariable Long ownerId, Model model) {
		Owner owner = ownerService.findById(ownerId);


		List<PetType> petTypes = List.of(PetType.DOG, PetType.CAT, PetType.BIRD, PetType.FISH);

		model.addAttribute("owner", owner);
		model.addAttribute("pet", new PetRes());  // 빈 PetRes 객체
		model.addAttribute("types", petTypes);     // PetType 목록 추가
		return "pets/createOrUpdatePetForm";
	}



	// 🔹 POST /owners/{ownerId}/pets/new → 새로운 Pet 추가 후 저장
	@PostMapping("/new")
	public String addPet(
		@PathVariable Long ownerId,
		@ModelAttribute PetRes pet,
		RedirectAttributes redirectAttributes
	) {
		petService.addPet(ownerId, pet);
		redirectAttributes.addFlashAttribute("success", "New pet added successfully!");
		return "redirect:/owners/" + ownerId;
	}

}
