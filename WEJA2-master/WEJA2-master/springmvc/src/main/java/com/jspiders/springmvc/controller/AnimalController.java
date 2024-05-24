package com.jspiders.springmvc.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.jspiders.springmvc.pojo.AnimalPOJO;
import com.jspiders.springmvc.service.AnimalService;

@Controller
public class AnimalController {

	@Autowired
	private AnimalService service;

	@GetMapping("/home")
	public String home(ModelMap map) {

		List<AnimalPOJO> animal = service.getAllAnimal();

		map.addAttribute("Animal", animal);
		return "Home";
	}

	@GetMapping("/add")
	public String add() {
		return "Add";
	}

	@PostMapping("/add")
	public String addanimal(@ModelAttribute("animal") AnimalPOJO animal,
			@RequestParam("imageFile") CommonsMultipartFile file) throws IOException {

		System.out.println(file.getName());

		if (!file.isEmpty()) {
			animal.setImage(file.getBytes());
		}

		AnimalPOJO pojo = service.addanimal(animal);

		return "Add";

	}

	
	@GetMapping("/remove/{id}")
	public String removeAnimal(@PathVariable Long id) {

		AnimalPOJO animalPOJO = service.removeAnimal(id);
		return "redirect:/home";

	}
	
	
	
	@GetMapping("/edit/{id}")
	public String showEditPage(@PathVariable Long id, ModelMap map) {
		AnimalPOJO animal = service.getAnimalById(id);

		map.addAttribute("animal", animal);
		return "Edit";
	}

	@PostMapping("/edit/update")
	public String updateAnimal(@ModelAttribute("animal") AnimalPOJO animal,
			@RequestParam("imageFile") CommonsMultipartFile file) throws IOException {

		AnimalPOJO animalPOJO = service.updateAnimal(animal);

		if (!file.isEmpty()) {
			animal.setImage(file.getBytes());
		}

		return "redirect:/home";
	}


}
