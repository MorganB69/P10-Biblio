package fr.mb.biblio.soap.userService.contract;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import fr.mb.biblio.models.beans.Utilisateur;
import fr.mb.biblio.models.exception.NotFoundException;

@WebService(name="userService")
public interface userService {
	
	@WebMethod
	public Utilisateur identification(
			@WebParam(name="identifiant")String identifiant,
			@WebParam(name="mdp")String mdp)
				throws NotFoundException;

}
