package com.practise.Utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
	
	private static SessionFactory factory;
	
	public static SessionFactory getSessionFactory()
	{
		if(factory == null) {
			factory = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory();
		}
		return factory;
	}
}
