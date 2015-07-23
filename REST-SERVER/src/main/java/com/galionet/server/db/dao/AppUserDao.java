package com.galionet.server.db.dao;


import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.galionet.server.db.model.AppUser;



@Repository
public class AppUserDao extends DaoTemplate<AppUser> {

	public AppUserDao(){
		setClazz(AppUser.class);
	}

	public AppUser findByUserName(String userName){
		Query query=getCurrentSession().createSQLQuery(" select * from APP_USER where NAME=:userName ")
				.addEntity(AppUser.class);
		query.setParameter("userName", userName);
		return (AppUser) query.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<AppUser> getAllUsers(){
		Query query=getCurrentSession().createQuery(" from AppUser ");
		return query.list();
	}
}
