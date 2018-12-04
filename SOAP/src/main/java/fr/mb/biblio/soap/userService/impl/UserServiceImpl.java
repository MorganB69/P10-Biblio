package fr.mb.biblio.soap.userService.impl;

import javax.inject.Inject;
import javax.transaction.Transactional;

import fr.mb.biblio.soapbusiness.userManager.contract.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
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
@Service
 public class UserServiceImpl implements UserService {


	/**
	 * Utilisé pour la récupération d'un utilisateur en bd
	 */
	Utilisateur user;

	@Autowired
	UserManager userManager;

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * fr.mb.biblio.soap.userManager.contract.userManager#identificationManager(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	@Transactional
	public Utilisateur identification(String identifiant, String mdp) throws NotFoundException {

		user = userManager.identification(identifiant, mdp);

		return user;


	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * fr.mb.biblio.soap.userManager.contract.userManager#insert(fr.mb.biblio.models
	 * .beans.Utilisateur)
	 */
	@Override
	@Transactional
	public void insert(Utilisateur utilisateur) throws FunctionalException {

		userManager.insert(utilisateur);
	}


	/* (non-Javadoc)
	 * @see fr.mb.biblio.soap.userManager.contract.userManager#getUtilisateurById(java.lang.Integer)
	 */
	@Override
	@Transactional
	public Utilisateur getUtilisateurById(Integer id) throws NotFoundException, FunctionalException {
		user = userManager.getUtilisateurById(id);
		return user;
	}

	@Override
	@Transactional
	public Integer getUserIdByName(String nom, String prenom) throws NotFoundException, FunctionalException {
		Integer id = userManager.getUserIdByName(nom, prenom);
		return id;


	}
}
