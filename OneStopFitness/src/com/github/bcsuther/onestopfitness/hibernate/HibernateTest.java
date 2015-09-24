package com.github.bcsuther.onestopfitness.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.github.bcsuther.onestopfitness.model.UserProfile;

public class HibernateTest {

	public static void main(String[] args) {
		UserProfile userProfile = new UserProfile();
		userProfile.setUsername("bcsuther");
		userProfile.setFirstName("Brian");
		userProfile.setLastName("Suther");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(userProfile);
		session.getTransaction().commit();
	}
}
