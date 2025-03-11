package dev.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Step01CreatingEntityManager {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("step01_entity_lifecycle");

		EntityManager manager = factory.createEntityManager();
		System.out.println("manager = " + manager);
	}
}
