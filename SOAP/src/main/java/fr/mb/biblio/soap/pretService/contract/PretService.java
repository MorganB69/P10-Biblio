package fr.mb.biblio.soap.pretService.contract;

import java.time.LocalDate;
import java.util.List;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.scheduling.annotation.Scheduled;

import fr.mb.biblio.models.LocalDateXmlAdapter;
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
	 * @throws NotFoundException 
	 */
	@WebMethod
	public Pret nouveauPret(@WebParam(name="livreId")Integer livreId,@WebParam(name="emprunteurId") Integer emprunteurId) throws FunctionalException, NotFoundException;
	
	/**
	 * Prolongation d'un pret
	 * @param pret
	 * @throws FunctionalException
	 * @throws NotFoundException 
	 */
	@WebMethod
	public Pret prolongerPret(@WebParam(name="pretId")Integer pretId,@WebParam(name="emprunteurId") Integer emprunteurId) throws  FunctionalException, NotFoundException;
	
	/**
	 * Retour d'un pret
	 * @param pret
	 * @throws FunctionalException
	 * @throws NotFoundException 
	 */
	@WebMethod
	public String retourPret(@WebParam(name="pretId")Integer pretId) throws FunctionalException, NotFoundException;
	
	/**
	 * Obtenir un pret selon son id
	 * @param id
	 * @return
	 * @throws NotFoundException
	 * @throws FunctionalException 
	 */
	@WebMethod
	public Pret getPretById(@WebParam(name="id")Integer id)throws NotFoundException, FunctionalException;	
	
	
	/**
	 * Creation de pret en fixant manuellement la date de debut
	 * @param livreId
	 * @param emprunteurId
	 * @param dateDebut
	 * @return
	 * @throws FunctionalException
	 * @throws NotFoundException
	 */
	@WebMethod
	public Pret creationPretDate(@WebParam(name="livreId")Integer livreId,@WebParam(name="emprunteurId") Integer emprunteurId,@WebParam(name="dateDebut")@XmlJavaTypeAdapter(LocalDateXmlAdapter.class) LocalDate dateDebut)throws FunctionalException, NotFoundException;
	

	/**
	 * Obtenir la liste des prets en cours
	 * @return
	 * @throws FunctionalException
	 */
	@WebMethod
	public List<Pret> getPretsEnCoursByUser(@WebParam(name="utilisateurId")Integer utilisateurId) throws  FunctionalException;

	
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
	public List<Pret> getPretsProlonges() throws  FunctionalException;
	
	/**
	 * Obtenir les prets en retard
	 * @return
	 * @throws FunctionalException
	 */
	@WebMethod
	public List<Pret> getPretsRetards() throws  FunctionalException;
	
	
	
	/**
	 * Methode de relance par mail
	 * @return
	 * @throws FunctionalException
	 * @throws Exception 
	 */
	@WebMethod
	public void relanceMailRetards() throws  FunctionalException, Exception;
	
	
	
	
}
