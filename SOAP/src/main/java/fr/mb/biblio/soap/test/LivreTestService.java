package fr.mb.biblio.soap.test;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import fr.mb.biblio.models.beans.Livre;
import fr.mb.biblio.models.beans.Utilisateur;


@WebService(name="livreService")
public interface LivreTestService {
	
	@WebMethod
	public Livre getLivre(@WebParam(name="id")Integer id);
	
	@WebMethod
	public void insert(@WebParam(name="utilisateur")Utilisateur user);

}
