package fr.mb.biblio.soap.resaService.contract;

import fr.mb.biblio.models.beans.Livre;
import fr.mb.biblio.models.beans.Reservation;
import fr.mb.biblio.models.beans.Utilisateur;
import fr.mb.biblio.models.exception.FunctionalException;
import fr.mb.biblio.models.exception.NotFoundException;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

/**
 * Service permettant la gestion de reservation des livres
 */
@WebService(name = "resaManager")
public interface ResaService {

    /**
     * Obtention d'une reservation via Id
     * @param reasaId
     * @return
     * @throws FunctionalException
     * @throws NotFoundException
     */
    @WebMethod
    Reservation getResaById(@WebParam(name="resaId") Integer reasaId) throws FunctionalException, NotFoundException;

    /**
     * Creation d'une nouvelle resa
     * @param livreId
     * @param demandeurId
     * @return
     * @throws FunctionalException
     * @throws NotFoundException
     */
    @WebMethod
    Reservation newReservation(@WebParam(name = "livreId") Integer livreId, @WebParam(name = "demandeurId") Integer demandeurId) throws FunctionalException, NotFoundException;

    /**
     * Suppression d'une resa
     * @param resaId
     * @throws FunctionalException
     * @throws NotFoundException
     */
    @WebMethod
    void deleteReservation(@WebParam(name = "resaId") Integer resaId)throws FunctionalException, NotFoundException;

    /**
     * Obtention de la liste des resas par id de l'utilisateur
     * @param demandeurId
     * @return
     * @throws FunctionalException
     */
    @WebMethod
    List<Reservation> getResaByUserId(@WebParam(name = "demandeurId") Integer demandeurId)throws FunctionalException;

    /**
     * Obtention des resas par id du livre
     * @param livreId
     * @return
     * @throws FunctionalException
     */
    @WebMethod
    List<Reservation> getResaByLivreId(@WebParam(name = "livreId") Integer livreId)throws FunctionalException;



    /**
     * Commencement de la resa avec une date de resa du jour et une date de fin dans 2 jours
     * @param resaId
     * @return
     * @throws FunctionalException
     * @throws NotFoundException
     */
    @WebMethod
    Reservation startResa (@WebParam(name="resaId")Integer resaId) throws FunctionalException, NotFoundException;

    /**
     * Construction du mail envoye pour prevenir un user que sa reservation a commencee
     * @param resaId
     * @throws FunctionalException
     * @throws NotFoundException
     */
    @WebMethod
    void mailResa(@WebParam(name="resaId")Integer resaId) throws FunctionalException, NotFoundException, Exception;

    /**
     * Verification des reservations terminee (>48h)
     * @throws FunctionalException
     */
    @WebMethod
    void verifEndResa();


}
