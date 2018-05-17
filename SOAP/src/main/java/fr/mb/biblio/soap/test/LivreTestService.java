package fr.mb.biblio.soap.test;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import fr.mb.biblio.models.test.LivreTest;

@WebService(name="livreService")
public interface LivreTestService {
	
	@WebMethod
	public LivreTest getLivre(@WebParam(name="id")Integer id);

}
