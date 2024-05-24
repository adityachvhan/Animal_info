package com.jspiders.springmvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.springmvc.pojo.AnimalPOJO;

@Repository
public class AnimalRepository {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	private static Query query;

	public static void openConnection() {

		entityManagerFactory = Persistence.createEntityManagerFactory("animal");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}

	public static void closeConnection() {

		if (entityManagerFactory != null) {

			entityManagerFactory.close();
		}

		if (entityManager != null) {
			entityManager.close();
		}

		if (entityTransaction != null) {

			if (entityTransaction.isActive()) {

				entityTransaction.rollback();
			}
		}
	}

	public AnimalPOJO addanimal(AnimalPOJO animalPOJO) {
		openConnection();

		entityTransaction.begin();
		entityManager.persist(animalPOJO);

		entityTransaction.commit();
		closeConnection();
		return animalPOJO;
	}

	public List<AnimalPOJO> getAllAnimal() {
		openConnection();

		entityTransaction.begin();

		String jpql = "from AnimalPOJO";
		query = entityManager.createQuery(jpql);
		List<AnimalPOJO> animal = query.getResultList();
		entityTransaction.commit();
		return animal;
	}

	public AnimalPOJO getAnimalById(Long id) {
		openConnection();
		entityTransaction.begin();

		AnimalPOJO animal = entityManager.find(AnimalPOJO.class, id);

		entityTransaction.commit();
		closeConnection();
		return animal;

	}

	public AnimalPOJO removeAnimal(Long id) {

		openConnection();
		entityTransaction.begin();

		AnimalPOJO animalPOJO = entityManager.find(AnimalPOJO.class, id);

		if (animalPOJO != null) {
			entityManager.remove(animalPOJO);
			entityTransaction.commit();
			closeConnection();
			return animalPOJO;
		}

		entityTransaction.commit();
		closeConnection();
		return null;
	}

	public AnimalPOJO updateAnimal(AnimalPOJO animalPOJO) {

		openConnection();
		entityTransaction.begin();

		AnimalPOJO pojo = entityManager.find(AnimalPOJO.class, animalPOJO.getId());

		pojo.setName(animalPOJO.getName());
		pojo.setCategory(animalPOJO.getCategory());
		pojo.setImage(animalPOJO.getImage());
		pojo.setDescription(animalPOJO.getDescription());
		pojo.setLifeExpectancy(animalPOJO.getLifeExpectancy());
	
		entityManager.persist(pojo);

		entityTransaction.commit();
		closeConnection();
		return pojo;
	}

}
