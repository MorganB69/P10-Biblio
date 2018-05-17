package fr.mb.biblio.dao.impl;
// Generated 17 mai 2018 21:45:12 by Hibernate Tools 5.2.10.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.mb.biblio.models.beans.Genre;

/**
 * Home object for domain model class Genre.
 * @see fr.mb.biblio.dao.impl.Genre
 * @author Hibernate Tools
 */
@Stateless
public class GenreHome {

	private static final Log log = LogFactory.getLog(GenreHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Genre transientInstance) {
		log.debug("persisting Genre instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Genre persistentInstance) {
		log.debug("removing Genre instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Genre merge(Genre detachedInstance) {
		log.debug("merging Genre instance");
		try {
			Genre result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Genre findById(int id) {
		log.debug("getting Genre instance with id: " + id);
		try {
			Genre instance = entityManager.find(Genre.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
