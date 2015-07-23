package com.galionet.server.db.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public abstract class DaoTemplate<T> {

	private SessionFactory sessionFactory;
	private Class<T> clazz;
	
	

	public DaoTemplate(){
		
	}
	
	@SuppressWarnings("unchecked")
	public T getObjectById(int id){
		T object= (T)getCurrentSession().get(clazz, id);
		return object;
	}
	
	public Object createObject(T object){
		Object result=getCurrentSession().save(object);
		return result;
	}
	
	public void updateObject(T object){
		getCurrentSession().update(object) ;
	}
	
	public void deleteObject(int id){
		T object = getObjectById(id);
		if(object!=null){
			getCurrentSession().delete(object);
		}
	}
	
	public void deleteObject(T object){
		if(object!=null){
			getCurrentSession().delete(object);
		}
	}
	
	public Class<T> getClazz() {
		return clazz;
	}
	
	public final void setClazz(Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}
	
	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
