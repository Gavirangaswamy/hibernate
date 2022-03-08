package com.grs.onetomany.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.grs.onetomany.dto.UserDTO;
import com.grs.onetomany.util.HibernateUtil;

public class UserDAOImpl implements UserDAO {

	private SessionFactory factory =(SessionFactory) HibernateUtil.getSessionFactory();

	public void saveUser(UserDTO dto) {
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			session.save(dto);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			if(session!=null)
				session.close();
		}
	}

	

}
