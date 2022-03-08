package com.grs.onetoone.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.grs.onetoone.dto.EngineDTO;
import com.grs.onetoone.util.HibernateUtil;

public class EngineDAOImpl implements EngineDAO {

	private SessionFactory factory = HibernateUtil.getSessionFactory();
	@Override
	public void saveEngine(EngineDTO dto) {
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			session.save(dto);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		

	}

}
