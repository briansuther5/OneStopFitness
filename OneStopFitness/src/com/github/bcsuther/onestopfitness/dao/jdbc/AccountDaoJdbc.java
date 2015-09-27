package com.github.bcsuther.onestopfitness.dao.jdbc;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.github.bcsuther.onestopfitness.dao.AccountDao;
import com.github.bcsuther.onestopfitness.hibernate.session.HibernateSessionService;
import com.github.bcsuther.onestopfitness.model.UserProfile;
import com.github.bcsuther.onestopfitness.security.PasswordEncryptorService;

@Component
@Qualifier("accountDao")
public class AccountDaoJdbc implements AccountDao {

	@Autowired
	@Qualifier("hibernateSessionService")
	HibernateSessionService hibernateSessionService;
	
	@Autowired
	@Qualifier("passwordEncryptorService")
	PasswordEncryptorService passwordEncryptorService;
	
	@Override
	public void createUserAccount(UserProfile userProfile) {
		userProfile.setPassword(this.passwordEncryptorService.encryptPassword(userProfile.getPassword()));
		Session hibernateSession = this.hibernateSessionService.getHibernateSession();
		hibernateSession.beginTransaction();
		hibernateSession.save(userProfile);
		hibernateSession.getTransaction().commit();
	}

	@Override
	public UserProfile findUserByUsername(String username) {
		Session hibernateSession = this.hibernateSessionService.getHibernateSession();
		UserProfile dbUserProfile = (UserProfile) hibernateSession.createCriteria(UserProfile.class).add(Restrictions.eqOrIsNull("username", username)).uniqueResult();
		return dbUserProfile;
	}

	@Override
	public UserProfile findUserByUserDetails(UserDetails userDetails) {
		Session hibernateSession = this.hibernateSessionService.getHibernateSession();
		UserProfile dbUserProfile = (UserProfile) hibernateSession.createCriteria(UserProfile.class).add(Restrictions.eqOrIsNull("username", userDetails.getUsername())).uniqueResult();
		return dbUserProfile;
	}

}
