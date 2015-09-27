package com.github.bcsuther.onestopfitness.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.core.context.SecurityContextHolder;

import com.github.bcsuther.onestopfitness.model.UserProfile;

public class HibernateTest {

	public static void main(String[] args) {
		UserProfile userProfile = new UserProfile();
		userProfile.setUsername("briansuther5");
		userProfile.setFirstName("Brian112");
		userProfile.setLastName("Suther112");
		userProfile.setPassword("pepsi522");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		UserProfile dbUserProfile = (UserProfile) session.createCriteria(UserProfile.class).add(Restrictions.eqOrIsNull("username", userProfile.getUsername())).uniqueResult();
//		if(dbUserProfile != null) {
//			Object principal = SecurityContextHolder.getContext().setAuthentication(authentication);
//			System.out.println("test");
//		}
//		if(userProfile.getUsername().equalsIgnoreCase(dbUserProfile.getUsername()) && this.passwordEncoder.encode(userProfile.getPassword()).equalsIgnoreCase(dbUserProfile.getPassword())) {
//			return dbUserProfile;
//		}
//		session.beginTransaction();
//		session.save(userProfile);
//		session.getTransaction().commit();
	}
}
