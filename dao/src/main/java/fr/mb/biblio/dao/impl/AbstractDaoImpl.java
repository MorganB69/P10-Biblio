package fr.mb.biblio.dao.impl;


import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
public abstract class AbstractDaoImpl<T extends Serializable>  {
	
	protected Class<T> entityClass;
	
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
	
	private static Logger logger = LogManager.getLogger(AbstractDaoImpl.class);
	

	public AbstractDaoImpl(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@Transactional
	public void persist(T entity) {
		Session session = sessionFactory.openSession();
		session.save(entity);
		session.close();
		
	}

	@Transactional
	public void update(T entity) {
		Session session = sessionFactory.openSession();
		session.update(entity);
		session.close();
		
	}

	@Transactional
	public T findById(int id) {
		Session session = sessionFactory.openSession();
		logger.info(entityClass.getName());
		
		T entity=(session.get(entityClass,id));
		session.close();
		return entity;
	}

	@Transactional
	public void delete(T entity) {
		Session session = sessionFactory.openSession();
		session.delete(entity);
		session.close();
		
	}

	@Transactional
	public List<T> findAll() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query=session.createQuery("from "+entityClass.getName());
		List<T> list = query.list();
		session.close();
		return list;
	}
	
	@Transactional
	public List<T> findAllOffset(Integer offset, Integer nbPages) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query=session.createQuery("from "+entityClass.getName());
		query.setFirstResult(offset);
		query.setMaxResults(nbPages);
		
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
	
	public void setEntityClass( Class<T> classToSet ) {
	      this.entityClass = classToSet;
	   }
public Class <T> getEntityClass() {
	return entityClass;
}

}
