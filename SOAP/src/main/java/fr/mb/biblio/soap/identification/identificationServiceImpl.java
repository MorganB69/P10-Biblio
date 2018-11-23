package fr.mb.biblio.soap.identification;

import javax.inject.Inject;
import javax.transaction.Transactional;

import fr.mb.biblio.dao.contract.UtilisateurDao;
import fr.mb.biblio.models.beans.Utilisateur;
import fr.mb.biblio.models.exception.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class identificationServiceImpl implements identificationService{
	
	/**
	 * DAO à injecter
	 */
	@Inject
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
