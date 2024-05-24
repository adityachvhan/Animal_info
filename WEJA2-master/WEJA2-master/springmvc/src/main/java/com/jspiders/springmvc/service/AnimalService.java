package com.jspiders.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springmvc.pojo.AnimalPOJO;
import com.jspiders.springmvc.repository.AnimalRepository;

@Service
public class AnimalService {

	@Autowired
	private AnimalRepository repository;

	public AnimalPOJO addanimal(AnimalPOJO animalPOJO) {

		AnimalPOJO pojo = repository.addanimal(animalPOJO);

		return pojo;
	}

	public List<AnimalPOJO> getAllAnimal() {

		List<AnimalPOJO> pojos = repository.getAllAnimal();

		return pojos;
	}

	public AnimalPOJO getAnimalById(Long id) {

		AnimalPOJO animal = repository.getAnimalById(id);

		return animal;
	}

	public AnimalPOJO updateAnimal(AnimalPOJO animalPOJO) {

		AnimalPOJO animal = repository.updateAnimal(animalPOJO);

		return animal;

	}

	public AnimalPOJO removeAnimal(Long id) {

		AnimalPOJO animalPOJO = repository.removeAnimal(id);

		return animalPOJO;
	}

}
