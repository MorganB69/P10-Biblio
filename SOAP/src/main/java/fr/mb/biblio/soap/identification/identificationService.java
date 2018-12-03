package fr.mb.biblio.soap.identification;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import fr.mb.biblio.models.beans.Utilisateur;
import fr.mb.biblio.models.exception.NotFoundException;

@WebService(name="identificationManager")
public interface identificationService {
	
	/**
	 * Méthode d'identificationManager de l'utilisateur
	 * @param identifiant
	 * @param mdp
	 * @return
	 * @throws NotFoundException
	 */
	@WebMethod
	public Utilisateur identification(@WebParam(name="identifiant")String identifiant,@WebParam(name="mdp")String mdp)
				throws NotFoundException;

}
