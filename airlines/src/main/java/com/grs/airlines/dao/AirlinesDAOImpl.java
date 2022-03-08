package com.grs.airlines.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.grs.airlines.dto.AirlinesDTO;
import com.grs.airlines.util.HibernateUtil;

public class AirlinesDAOImpl implements AirlinesDAO {

	public void save(AirlinesDTO dto) {
		EntityManagerFactory factory = HibernateUtil.getSessionFactory();

		EntityManager entityManager = factory.createEntityManager();

			entityManager.getTransaction().begin();

			entityManager.persist(dto);

			entityManager.getTransaction().commit();
			
			entityManager.close();

	}

	public AirlinesDTO getByName(String name) {
		EntityManagerFactory factory = null;
		EntityManager entityManager = null;
		AirlinesDTO dto = null;
		try {
			factory = HibernateUtil.getSessionFactory();

			entityManager = factory.createEntityManager();

			entityManager.getTransaction().begin();

			dto = entityManager.find(AirlinesDTO.class, name);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
		return dto;
	}

	public AirlinesDTO UpdateFleetSizeByName(int fleet, String name) {
		EntityManagerFactory factory = null;
		EntityManager entityManager = null;
		AirlinesDTO dto = null;
		try {
			factory = HibernateUtil.getSessionFactory();

			entityManager = factory.createEntityManager();

			entityManager.getTransaction().begin();

			dto = entityManager.find(AirlinesDTO.class, name);

			dto.setFleetSize(fleet);
			entityManager.merge(dto);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
		return dto;
	}

	public AirlinesDTO deleteByName(String name) {
		EntityManagerFactory factory = null;
		EntityManager entityManager = null;
		AirlinesDTO dto = null;
		try {
			factory = HibernateUtil.getSessionFactory();

			entityManager = factory.createEntityManager();

			entityManager.getTransaction().begin();

			dto = entityManager.find(AirlinesDTO.class, name);

			entityManager.remove(dto);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
		return dto;
	}

}
