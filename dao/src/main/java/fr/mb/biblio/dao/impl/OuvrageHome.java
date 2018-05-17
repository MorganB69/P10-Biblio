package fr.mb.biblio.dao.impl;
// Generated 17 mai 2018 21:45:12 by Hibernate Tools 5.2.10.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.mb.biblio.models.beans.Ouvrage;

/**
 * Home object for domain model class Ouvrage.
 * @see fr.mb.biblio.dao.impl.Ouvrage
 * @author Hibernate Tools
 */
@Stateless
public class OuvrageHome {

	private static final Log log = LogFactory.getLog(OuvrageHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Ouvrage transientInstance) {
		log.debug("persisting Ouvrage instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Ouvrage persistentInstance) {
		log.debug("removing Ouvrage instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Ouvrage merge(Ouvrage detachedInstance) {
		log.debug("merging Ouvrage instance");
		try {
			Ouvrage result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Ouvrage findById(int id) {
		log.debug("getting Ouvrage instance with id: " + id);
		try {
			Ouvrage instance = entityManager.find(Ouvrage.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
