package fr.mb.biblio.soapbusiness.userManager.impl;

import fr.mb.biblio.dao.contract.UtilisateurDao;
import fr.mb.biblio.models.beans.Utilisateur;
import fr.mb.biblio.models.exception.FunctionalException;
import fr.mb.biblio.models.exception.NotFoundException;
import fr.mb.biblio.soapbusiness.userManager.contract.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 * Service de gestion d'un utilisateur
 * 
 * @author Morgan
 *
 */
 @Service("userManager")
 public class UserManagerImpl implements UserManager {

	/**
	 * DAO à injecter
	 */
	@Autowired
	UtilisateurDao utilisateurDao;

	/**
	 * Utilisé pour la récupération d'un utilisateur en bd
	 */
	Utilisateur user;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.mb.biblio.soap.userManager.contract.userManager#identificationManager(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	@Transactional
	public Utilisateur identification(String identifiant,String mdp) throws NotFoundException {
		
		user=utilisateurDao.identification(identifiant, mdp);
		if (user==null) throw new NotFoundException("L'utilisateur n'existe pas");
		else return user;
		


		

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

		if (utilisateur == null)
			throw new FunctionalException("Utilisateur null");
		else
			utilisateurDao.persist(utilisateur);
		}
	

	/* (non-Javadoc)
	 * @see fr.mb.biblio.soap.userManager.contract.userManager#getUtilisateurById(java.lang.Integer)
	 */
	@Override
	@Transactional
	public Utilisateur getUtilisateurById(Integer id) throws NotFoundException, FunctionalException {
 {		if(id<=0||id==null) throw new FunctionalException("L'id doit être renseigné");
 		
 		else user = utilisateurDao.findById(id);
		
		if (user == null) {
			throw new NotFoundException("Utilisateur non trouvé");
		}

		return user;
	}
	}

	@Override
	@Transactional
	public Integer getUserIdByName(String nom, String prenom) throws NotFoundException, FunctionalException {
		{
			Integer user = utilisateurDao.getUserIdByName(nom, prenom);

			
			if (user == null) {
				throw new NotFoundException("Utilisateur non trouvé");
			}

			return user;
		}
	}

	@Override
	public void setOptionRelance(Integer id, Boolean relance) throws FunctionalException, NotFoundException {
		if(id<=0||id==null) throw new FunctionalException("L'id doit être renseigné");
		else user = utilisateurDao.findById(id);

		if (user == null) {
			throw new NotFoundException("Utilisateur non trouvé");
		}
		else {
			user.setRelance(relance);
			utilisateurDao.update(user);
		}

	}

}
