package fr.mb.biblio.soapbusiness.identificationManager.impl;

import fr.mb.biblio.dao.contract.UtilisateurDao;
import fr.mb.biblio.models.beans.Utilisateur;
import fr.mb.biblio.models.exception.NotFoundException;
import fr.mb.biblio.soapbusiness.identificationManager.contract.identificationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;

@Service
public class IdentificationManagerImpl implements identificationManager {
	
	/**
	 * DAO à injecter
	 */
	@Autowired
	UtilisateurDao utilisateurDao;

	/**
	 * Utilisé pour la récupération d'un utilisateur en bd
	 */
	Utilisateur user;

	@Transactional
	public Utilisateur identification(String identifiant,String mdp) throws NotFoundException {
		
		user=utilisateurDao.identification(identifiant, mdp);
		if (user==null) throw new NotFoundException("L'utilisateur n'existe pas");
		else return user;
	}

}
