package fr.mb.biblio.soap.userService.impl;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import fr.mb.biblio.dao.contract.UtilisateurDao;
import fr.mb.biblio.models.beans.Utilisateur;
import fr.mb.biblio.models.exception.NotFoundException;
import fr.mb.biblio.soap.userService.contract.UserService;
import fr.mb.biblio.models.exception.FunctionalException;

/**
 * Service de gestion d'un utilisateur
 * 
 * @author Morgan
 *
 */
 public class UserServiceImpl implements UserService {

	/**
	 * DAO à injecter
	 */
	@Inject
	UtilisateurDao utilisateurDao;

	/**
	 * Utilisé pour la récupération d'un utilisateur en bd
	 */
	Utilisateur user;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.mb.biblio.soap.userService.contract.userService#identification(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	@Transactional
	public Utilisateur identification(String identifiant, String mdp) throws NotFoundException {

		user = utilisateurDao.identification(identifiant, mdp);
		
		if (user == null) {
			throw new NotFoundException("Identifiant ou Mot de passe incorrect");
		}

		return user;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.mb.biblio.soap.userService.contract.userService#insert(fr.mb.biblio.models
	 * .beans.Utilisateur)
	 */
	@Override
	@Transactional
	public void insert(Utilisateur utilisateur) throws FunctionalException {

		if (utilisateur == null)
			throw new FunctionalException("Utilisateur null");
		else
			utilisateurDao.persist(utilisateur);
		}
	

	/* (non-Javadoc)
	 * @see fr.mb.biblio.soap.userService.contract.userService#getUtilisateurById(java.lang.Integer)
	 */
	@Override
	@Transactional
	public Utilisateur getUtilisateurById(Integer id) throws NotFoundException, FunctionalException {
 {
		user = utilisateurDao.findById(id);
		
		if (user == null) {
			throw new NotFoundException("Utilisateur non trouvé");
		}

		return user;
	}
	}

}
