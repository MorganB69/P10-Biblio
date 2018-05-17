package fr.mb.biblio.dao.impl;
// Generated 17 mai 2018 21:45:12 by Hibernate Tools 5.2.10.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.mb.biblio.models.beans.Editeur;

/**
 * Home object for domain model class Editeur.
 * @see fr.mb.biblio.dao.impl.Editeur
 * @author Hibernate Tools
 */
@Stateless
public class EditeurHome {

	private static final Log log = LogFactory.getLog(EditeurHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Editeur transientInstance) {
		log.debug("persisting Editeur instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Editeur persistentInstance) {
		log.debug("removing Editeur instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Editeur merge(Editeur detachedInstance) {
		log.debug("merging Editeur instance");
		try {
			Editeur result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Editeur findById(int id) {
		log.debug("getting Editeur instance with id: " + id);
		try {
			Editeur instance = entityManager.find(Editeur.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
