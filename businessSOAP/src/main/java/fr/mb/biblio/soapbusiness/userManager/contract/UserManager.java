package fr.mb.biblio.soapbusiness.userManager.contract;

import fr.mb.biblio.models.beans.Utilisateur;
import fr.mb.biblio.models.exception.FunctionalException;
import fr.mb.biblio.models.exception.NotFoundException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Service de gestion de l'utilisateur
 * @author Morgan
 *
 */
public interface UserManager {
	
	/**
	 * Méthode d'identificationManager de l'utilisateur
	 * @param identifiant
	 * @param mdp
	 * @return
	 * @throws NotFoundException
	 */
	Utilisateur identification(String identifiant, String mdp)
				throws NotFoundException;

	/**
	 * Méthode de rajout d'un utilisateur
	 * @param utilisateur
	 * @throws FunctionalException
	 */
	void insert(Utilisateur utilisateur)
				throws FunctionalException;

	/**
	 * Méthode d'obtention d'un utilisateur via son id
	 * @param id
	 * @return
	 * @throws NotFoundException
	 */
	Utilisateur getUtilisateurById( Integer id)
				throws NotFoundException,FunctionalException;



	public Integer getUserIdByName(String nom, String prenom)
				throws NotFoundException,FunctionalException;

}

