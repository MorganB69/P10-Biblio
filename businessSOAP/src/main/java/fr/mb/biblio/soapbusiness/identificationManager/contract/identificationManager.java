package fr.mb.biblio.soapbusiness.identificationManager.contract;

import fr.mb.biblio.models.beans.Utilisateur;
import fr.mb.biblio.models.exception.NotFoundException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;


public interface identificationManager {
	
	/**
	 * Méthode d'identificationManager de l'utilisateur
	 * @param identifiant
	 * @param mdp
	 * @return
	 * @throws NotFoundException
	 */

	public Utilisateur identification(String identifiant, String mdp)
				throws NotFoundException;

}
