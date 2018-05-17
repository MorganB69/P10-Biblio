package fr.mb.biblio.dao.impl;
// Generated 17 mai 2018 21:45:12 by Hibernate Tools 5.2.10.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.mb.biblio.models.beans.Pret;

/**
 * Home object for domain model class Pret.
 * @see fr.mb.biblio.dao.impl.Pret
 * @author Hibernate Tools
 */
@Stateless
public class PretHome {

	private static final Log log = LogFactory.getLog(PretHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Pret transientInstance) {
		log.debug("persisting Pret instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Pret persistentInstance) {
		log.debug("removing Pret instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Pret merge(Pret detachedInstance) {
		log.debug("merging Pret instance");
		try {
			Pret result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Pret findById(int id) {
		log.debug("getting Pret instance with id: " + id);
		try {
			Pret instance = entityManager.find(Pret.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
