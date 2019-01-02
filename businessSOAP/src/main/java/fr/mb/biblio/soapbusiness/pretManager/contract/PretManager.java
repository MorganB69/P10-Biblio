package fr.mb.biblio.soapbusiness.pretManager.contract;

import fr.mb.biblio.models.LocalDateXmlAdapter;
import fr.mb.biblio.models.beans.Pret;
import fr.mb.biblio.models.exception.FunctionalException;
import fr.mb.biblio.models.exception.NotFoundException;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.List;

/**
 * WebService pour la gestion des prets
 * @author Morgan
 *
 */
public interface PretManager {


	Boolean isAdmin(String usernamefromHeader) throws NotFoundException;

	/**
	 * Creation d'un nouveau pret
	 * @param livreId
	 * @param emprunteurId
	 * @throws FunctionalException
	 * @throws NotFoundException 
	 */
	Pret nouveauPret( Integer livreId,  Integer emprunteurId) throws FunctionalException, NotFoundException;

	/**
	 * Prolongation d'un pret
	 * @param pretId
	 * @throws FunctionalException
	 * @throws NotFoundException
	 */
	Pret prolongerPret( Integer pretId,  Integer emprunteurId) throws  FunctionalException, NotFoundException;

	/**
	 * Retour d'un pret
	 * @param pretId
	 * @throws FunctionalException
	 * @throws NotFoundException
	 */
	String retourPret( Integer pretId) throws FunctionalException, NotFoundException;

	/**
	 * Obtenir un pret selon son id
	 * @param id
	 * @return
	 * @throws NotFoundException
	 * @throws FunctionalException
	 */
	Pret getPretById( Integer id)throws NotFoundException, FunctionalException;


	/**
	 * Creation de pret en fixant manuellement la date de debut
	 * @param livreId
	 * @param emprunteurId
	 * @param dateDebut
	 * @return
	 * @throws FunctionalException
	 * @throws NotFoundException
	 */
	Pret creationPretDate( Integer livreId,  Integer emprunteurId, LocalDate dateDebut)throws FunctionalException, NotFoundException;


	/**
	 * Obtenir la liste des prets en cours
	 * @return
	 * @throws FunctionalException
	 */
	List<Pret> getPretsEnCoursByUser(Integer utilisateurId) throws  FunctionalException;


	/**
	 * Obtenir la liste des prets en cours
	 * @return
	 * @throws FunctionalException
	 */
	List<Pret> getPretsEnCours() throws  FunctionalException;

	/**
	 * Obtenir les prets qui ont été prolongés
	 * @return
	 * @throws FunctionalException
	 */
	List<Pret> getPretsProlonges() throws  FunctionalException;

	/**
	 * Obtenir les prets en retard
	 * @return
	 * @throws FunctionalException
	 */
	List<Pret> getPretsRetards() throws  FunctionalException;

	/**
	 * Obtention des prets en retard dans 5 jours des utilisateurs concernés
	 * @return
	 * @throws FunctionalException
	 */
	List<Pret> getPretsFuturRetard() throws FunctionalException;



	/**
	 * Methode de relance par mail
	 * @return
	 * @throws FunctionalException
	 * @throws Exception
	 */
	void relanceMailRetards() throws  FunctionalException, Exception;

    /**
     * Methode fixant si le livre est disponible ou non
     * @param livreId
     * @throws FunctionalException
     * @throws NotFoundException
     */
    void setDisponibilite( Integer livreId) throws FunctionalException,NotFoundException;

    /**
     * Methode pour supprimer un pret
     * @param pretId
     * @throws NotFoundException
     */
    void deletePret( Integer pretId) throws NotFoundException, FunctionalException;
	
	
}
