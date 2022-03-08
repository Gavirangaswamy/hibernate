package com.grs.socialmedia.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

	private static EntityManagerFactory factory;
	
	static {
		factory = Persistence.createEntityManagerFactory("pu");
	}
	
	public static EntityManagerFactory getSessionFactory() {
		return factory;
	}
}
