package fr.mb.biblio.soapbusiness.test;

import fr.mb.biblio.models.beans.Livre;
import fr.mb.biblio.models.beans.Utilisateur;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;



public interface LivreTestManager {
	

	Livre getLivre(@WebParam(name = "id") Integer id);


	void insert(@WebParam(name = "utilisateur") Utilisateur user);

}
