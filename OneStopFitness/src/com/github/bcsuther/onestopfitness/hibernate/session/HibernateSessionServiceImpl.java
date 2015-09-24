package com.github.bcsuther.onestopfitness.hibernate.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("hibernateSessionService")
public class HibernateSessionServiceImpl implements HibernateSessionService {

	@Override
	public Session getHibernateSession() {
		SessionFactory sessionFactory = getHibernateSessionFactory();
		Session session = sessionFactory.openSession();
		return session;
	}

	private SessionFactory getHibernateSessionFactory() {
		return new Configuration().configure().buildSessionFactory();
	}

}
