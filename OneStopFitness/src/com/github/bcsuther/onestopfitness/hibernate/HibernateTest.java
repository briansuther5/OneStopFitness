package com.github.bcsuther.onestopfitness.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.github.bcsuther.onestopfitness.model.User;

public class HibernateTest {

	public static void main(String[] args) {
		User user = new User();
		user.setUserId(1);
		user.setUsername("bcsuther");
		user.setFirstName("Brian");
		user.setLastName("Suther");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}
}
