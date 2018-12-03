package fr.mb.biblio.dao.impl;


import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.mb.biblio.dao.contract.GenericDAO;

import static org.springframework.beans.factory.config.BeanDefinition.*;


/**
 * Classe abstraite permettant l'injection du template hibernate ou d'une sessionFactory
 * @author Morgan
 *
 */
@Transactional
public abstract class AbstractDaoImpl<T extends Serializable>  {


	protected Class<T> entityClass;
	
	/**
	 * Template hibernate utilisé pour les requêtes basiques
	 */
	@Autowired
	HibernateTemplate template;
	
	/**
	 * Permet de créer des sessions personnalisées pour des requêtes plus complexes
	 */	
	@Autowired
	SessionFactory sessionFactory;
	
	private static Logger logger = LogManager.getLogger(AbstractDaoImpl.class);
	

	public AbstractDaoImpl(Class<T> entityClass) {
		this.entityClass = entityClass;
	}


	public void persist(T entity) {
		Session session = sessionFactory.getCurrentSession();
		session.save(entity);

		
	}


	public void update(T entity) {
		Session session = sessionFactory.getCurrentSession();
		session.update(entity);

		
	}


	public T findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		T entity=(session.get(entityClass,id));
		
		return entity;
	}


	public void delete(T entity) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(entity);

	}


	public List<T> findAll() {
		Session session = sessionFactory.getCurrentSession();
		
		Query query=session.createQuery("from "+entityClass.getName());
		List<T> list = query.list();

		return list;
	}
	

	public List<T> findAllOffset(Integer offset, Integer nbPages) {
		Session session = sessionFactory.getCurrentSession();

		
		Query query=session.createQuery("from "+entityClass.getName());
		query.setFirstResult(offset);
		query.setMaxResults(nbPages);
		
		List<T> list = query.list();

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
	
	public void setEntityClass( Class<T> classToSet ) {
	      this.entityClass = classToSet;
	   }
public Class <T> getEntityClass() {
	return entityClass;
}

}
