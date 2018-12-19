package fr.mb.biblio.soapbusiness.resaManager.contract;

import fr.mb.biblio.models.beans.Livre;
import fr.mb.biblio.models.beans.Reservation;
import fr.mb.biblio.models.beans.Utilisateur;
import fr.mb.biblio.models.exception.FunctionalException;
import fr.mb.biblio.models.exception.NotFoundException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

/**
 * Service permettant la gestion de reservation des livres
 */
public interface ResaManager {

    /**
     * Obtention d'une reservation via Id
     * @param reasaId
     * @return
     * @throws FunctionalException
     * @throws NotFoundException
     */
    Reservation getResaById( Integer reasaId) throws FunctionalException, NotFoundException;

    /**
     * Creation d'une nouvelle resa
     * @param livreId
     * @param demandeurId
     * @return
     * @throws FunctionalException
     * @throws NotFoundException
     */
    Reservation newReservation( Integer livreId, Integer demandeurId) throws FunctionalException, NotFoundException;

    /**
     * Suppression d'une resa
     * @param resaId
     * @throws FunctionalException
     * @throws NotFoundException
     */
    void deleteReservation(Integer resaId)throws FunctionalException, NotFoundException;

    /**
     * Obtention de la liste des resas par id de l'utilisateur
     * @param demandeurId
     * @return
     * @throws FunctionalException
     */
    List<Reservation> getResaByUserId( Integer demandeurId)throws FunctionalException;

    /**
     * Obtention des resas par id du livre
     * @param livreId
     * @return
     * @throws FunctionalException
     */
    List<Reservation> getResaByLivreId( Integer livreId)throws FunctionalException;

    /**
     * Verification qu'un livre n'a pas atteint un nombre maximal de reservation en cours
     * @param livre
     * @throws FunctionalException
     */
    void checkNbExemplaire(Livre livre) throws FunctionalException;

    /**
     * Verif qu'un user n'a pas de pret en cours sur livre de la resa
     * @param demandeur
     * @param livre
     * @throws FunctionalException
     */
    void checkUserResa(Utilisateur demandeur, Livre livre) throws FunctionalException;

    /**
     * Commencement de la resa avec une date de resa du jour et une date de fin dans 2 jours
     * @param resaId
     * @return
     * @throws FunctionalException
     * @throws NotFoundException
     */
    Reservation startResa( Integer resaId) throws FunctionalException, NotFoundException;

    /**
     * Construction du mail envoye pour prevenir un user que sa reservation a commencee
     * @param resaId
     * @throws FunctionalException
     * @throws NotFoundException
     */
    void mailResa( Integer resaId) throws FunctionalException, NotFoundException, Exception;

    /**
     * Verification des reservations terminee (>48h)
     * @throws FunctionalException
     */
    void verifEndResa();


}
