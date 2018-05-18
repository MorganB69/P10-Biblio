package fr.mb.biblio.dao.impl;


import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;

import fr.mb.biblio.dao.contract.GenericDAO;


/**
 * Classe abstraite permettant l'injection du template hibernate ou d'une sessionFactory
 * @author Morgan
 *
 */
public abstract class AbstractDaoImpl<T>  {
	
	/**
	 * Template hibernate utilisé pour les requêtes basiques
	 */
	@Inject
	HibernateTemplate template;
	
	/**
	 * Permet de créer des sessions personnalisées pour des requêtes plus complexes
	 */	
	@Inject
	SessionFactory sessionFactory;
	

	private Class<T> entityClass;
	

	public void setClass( Class< T > classToSet ) {
		      this.entityClass = classToSet;
		   }
	
	

	
	public void persist(T entity) {
		Session session = sessionFactory.openSession();
		session.save(entity);
		session.close();
		
	}

	
	public void update(T entity) {
		Session session = sessionFactory.openSession();
		session.update(entity);
		session.close();
		
	}

	
	public T findById(int id) {
		Session session = sessionFactory.openSession();
		
		T entity=(session.get(entityClass,id));
		session.close();
		return entity;
	}

	
	public void delete(T entity) {
		Session session = sessionFactory.openSession();
		session.delete(entity);
		session.close();
		
	}

	
	public List<T> findAll() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query=session.createQuery("from "+entityClass.getName());
		List<T> list = query.list();
		session.close();
		return list;
	}

 
	
	public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
