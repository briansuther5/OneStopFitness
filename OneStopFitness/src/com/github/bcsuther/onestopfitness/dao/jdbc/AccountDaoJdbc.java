package com.github.bcsuther.onestopfitness.dao.jdbc;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.github.bcsuther.onestopfitness.dao.AccountDao;
import com.github.bcsuther.onestopfitness.hibernate.session.HibernateSessionService;
import com.github.bcsuther.onestopfitness.model.UserProfile;

@Component
@Qualifier("accountDao")
public class AccountDaoJdbc implements AccountDao {

	@Autowired
	@Qualifier("hibernateSessionService")
	HibernateSessionService hibernateSessionService;
	
	@Override
	public void createUserAccount(UserProfile userProfile) {
		Session hibernateSession = this.hibernateSessionService.getHibernateSession();
		hibernateSession.beginTransaction();
		hibernateSession.save(userProfile);
		hibernateSession.getTransaction().commit();
	}

}
