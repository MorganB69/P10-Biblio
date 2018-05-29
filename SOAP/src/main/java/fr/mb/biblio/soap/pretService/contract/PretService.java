package fr.mb.biblio.soap.pretService.contract;

import java.util.List;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import fr.mb.biblio.models.beans.Livre;
import fr.mb.biblio.models.beans.Pret;
import fr.mb.biblio.models.beans.Utilisateur;
import fr.mb.biblio.models.exception.FunctionalException;
import fr.mb.biblio.models.exception.NotFoundException;

/**
 * WebService pour la gestion des prets
 * @author Morgan
 *
 */
@WebService(name="pretService")
@HandlerChain(file="../../handlers.xml")
public interface PretService {
	
	/**
	 * Creation d'un nouveau pret
	 * @param livre
	 * @param user
	 * @throws FunctionalException
	 */
	@WebMethod
	public Pret nouveauPret(@WebParam(name="livreId")Integer livreId,@WebParam(name="emprunteurId") Integer emprunteurId) throws FunctionalException;
	
	/**
	 * Prolongation d'un pret
	 * @param pret
	 * @throws FunctionalException
	 */
	@WebMethod
	public Pret prolongerPret(@WebParam(name="pretId")Integer pretId,@WebParam(name="emprunteurId") Integer emprunteurId) throws  FunctionalException;
	
	/**
	 * Retour d'un pret
	 * @param pret
	 * @throws FunctionalException
	 */
	@WebMethod
	public String retourPret(@WebParam(name="pretId")Integer pretId) throws FunctionalException;
	
	/**
	 * Obtenir un pret selon son id
	 * @param id
	 * @return
	 * @throws NotFoundException
	 */
	@WebMethod
	public Pret getPretById(@WebParam(name="id")Integer id)throws NotFoundException;	
	
	/**
	 * Obtenir la liste des prets en cours
	 * @return
	 * @throws FunctionalException
	 */
	@WebMethod
	public List<Pret> getPretsEnCours() throws  FunctionalException;
	
	/**
	 * Obtenir les prets qui ont été prolongés
	 * @return
	 * @throws FunctionalException
	 */
	@WebMethod
	public List<Pret> getPretsProlonges() throws  FunctionalException;;
	
	/**
	 * Obtenir les prets en retard
	 * @return
	 * @throws FunctionalException
	 */
	@WebMethod
	public List<Pret> getPretsRetards() throws  FunctionalException;;
	
	
}
