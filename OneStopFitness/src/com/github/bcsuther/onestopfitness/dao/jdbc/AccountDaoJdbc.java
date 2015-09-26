package com.github.bcsuther.onestopfitness.dao.jdbc;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	
	@Autowired
	@Qualifier("passwordEncoder")
	PasswordEncoder passwordEncoder;
	
	@Override
	public void createUserAccount(UserProfile userProfile) {
		userProfile.setPassword(this.passwordEncoder.encode(userProfile.getPassword()));
		Session hibernateSession = this.hibernateSessionService.getHibernateSession();
		hibernateSession.beginTransaction();
		hibernateSession.save(userProfile);
		hibernateSession.getTransaction().commit();
	}

	@Override
	public UserProfile findUser(UserProfile userProfile) {
//		Session hibernateSession = this.hibernateSessionService.getHibernateSession();
//		UserProfile dbUserProfile = (UserProfile) hibernateSession.get(UserProfile.class, userProfile.getUsername());
//		if(userProfile.getUsername().equalsIgnoreCase(dbUserProfile.getUsername()) && this.passwordEncoder.encode(userProfile.getPassword()).equalsIgnoreCase(dbUserProfile.getPassword())) {
//			return dbUserProfile;
//		}
		return null;
	}

}
