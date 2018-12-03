package fr.mb.biblio.soap.userService.contract;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import fr.mb.biblio.models.beans.Utilisateur;
import fr.mb.biblio.models.exception.FunctionalException;
import fr.mb.biblio.models.exception.NotFoundException;

/**
 * Service de gestion de l'utilisateur
 * @author Morgan
 *
 */
@WebService(name="userManager")
public interface UserService {
	
	/**
	 * Méthode d'identificationManager de l'utilisateur
	 * @param identifiant
	 * @param mdp
	 * @return
	 * @throws NotFoundException
	 */
	@WebMethod
	public Utilisateur identification(String identifiant,String mdp)
				throws NotFoundException;
	
	/**
	 * Méthode de rajout d'un utilisateur
	 * @param utilisateur
	 * @throws FunctionalException
	 */
	@WebMethod
	public void insert(
			@WebParam(name="utilisateur")Utilisateur utilisateur)
				throws FunctionalException;
	
	/**
	 * Méthode d'obtention d'un utilisateur via son id
	 * @param id
	 * @return
	 * @throws NotFoundException
	 */
	@WebMethod
	public Utilisateur getUtilisateurById(
			@WebParam(name="id")Integer id)
				throws NotFoundException,FunctionalException;
	
	
	@WebMethod
	public Integer getUserIdByName(
			@WebParam(name="nom")String nom ,@WebParam(name="prenom")String prenom)
				throws NotFoundException,FunctionalException;

}

