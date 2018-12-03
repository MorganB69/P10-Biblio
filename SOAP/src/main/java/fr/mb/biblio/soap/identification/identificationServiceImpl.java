package fr.mb.biblio.soap.identification;

import javax.inject.Inject;
import javax.transaction.Transactional;

import fr.mb.biblio.dao.contract.UtilisateurDao;
import fr.mb.biblio.models.beans.Utilisateur;
import fr.mb.biblio.models.exception.NotFoundException;

import fr.mb.biblio.soapbusiness.userManager.contract.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class identificationServiceImpl implements identificationService{
	


    @Autowired
	UserManager userManager;

	/**
	 * Utilisé pour la récupération d'un utilisateur en bd
	 */
	Utilisateur user;

	@Transactional
	public Utilisateur identification(String identifiant,String mdp) throws NotFoundException {
		
		user= userManager.identification(identifiant,mdp);

		return user;
	}

}
