// package com.gersimuca.cma;
//
// import jakarta.persistence.EntityManager;
// import jakarta.persistence.EntityManagerFactory;
// import jakarta.persistence.EntityTransaction;
// import jakarta.persistence.Persistence;
// import org.junit.jupiter.api.AfterAll;
// import org.junit.jupiter.api.Test;
// import org.junit.runner.RunWith;
// import org.springframework.test.context.junit4.SpringRunner;
//
// @RunWith(SpringRunner.class)
// public class ApplicationTests {
//
//	@AfterAll
//	private static EntityManagerFactory openConnectionEntityManagerFactory(){
//		return Persistence.createEntityManagerFactory("cma-prod");
//	}
//
//	@Test
//	public void testConnection() {
//		EntityManagerFactory entityManagerFactory = openConnectionEntityManagerFactory();
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		entityTransaction.begin();
//		entityTransaction.commit();
//		entityManager.close();
//		entityManagerFactory.close();
//	}
//
// }
