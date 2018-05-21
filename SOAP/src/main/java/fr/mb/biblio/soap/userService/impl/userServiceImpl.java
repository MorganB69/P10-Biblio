package fr.mb.biblio.soap.userService.impl;

import javax.inject.Inject;
import javax.transaction.Transactional;

import fr.mb.biblio.dao.contract.UtilisateurDao;
import fr.mb.biblio.models.beans.Utilisateur;
import fr.mb.biblio.models.exception.NotFoundException;
import fr.mb.biblio.soap.userService.contract.userService;

public class userServiceImpl implements userService {

	@Inject
	UtilisateurDao utilisateurDao;
	
	Utilisateur user;
	
	@Override
	@Transactional
	public Utilisateur identification(String identifiant, String mdp) throws NotFoundException{
		
		
		user=utilisateurDao.identification(identifiant, mdp);
		if (user==null) {
			throw new NotFoundException("Identifiant ou Mot de passe incorrect");
		}
			
		
		return user;
		
		
	}

}
