package fr.mb.biblio.dao.impl;
// Generated 17 mai 2018 21:45:12 by Hibernate Tools 5.2.10.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.mb.biblio.models.beans.Livre;

/**
 * Home object for domain model class Livre.
 * @see fr.mb.biblio.dao.impl.Livre
 * @author Hibernate Tools
 */
@Stateless
public class LivreHome {

	private static final Log log = LogFactory.getLog(LivreHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Livre transientInstance) {
		log.debug("persisting Livre instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Livre persistentInstance) {
		log.debug("removing Livre instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Livre merge(Livre detachedInstance) {
		log.debug("merging Livre instance");
		try {
			Livre result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Livre findById(int id) {
		log.debug("getting Livre instance with id: " + id);
		try {
			Livre instance = entityManager.find(Livre.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
