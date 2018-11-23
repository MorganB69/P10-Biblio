package fr.mb.biblio.soap.resaService.contract;

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
@WebService(name = "resaService")
public interface ResaService {

    @WebMethod
    Reservation newReservation(@WebParam(name = "livreId") Integer livreId, @WebParam(name = "demandeurId") Integer demandeurId) throws FunctionalException, NotFoundException;

    @WebMethod
    void deleteReservation(@WebParam(name = "resaId") Integer resaId)throws FunctionalException, NotFoundException;

    @WebMethod
    List<Reservation> getResaByUserId(@WebParam(name = "demandeurId") Integer demandeurId)throws FunctionalException;

    @WebMethod
    List<Reservation> getResaByLivreId(@WebParam(name = "livreId") Integer livreId)throws FunctionalException;

    void checkNbExemplaire(Livre livre) throws FunctionalException;

    void checkUserResa(Utilisateur demandeur, Livre livre) throws FunctionalException;

    @WebMethod
    Reservation startResa (@WebParam(name="resaId")Integer resaId) throws FunctionalException, NotFoundException;

    @WebMethod
    void mailResa(@WebParam(name="resaId")Integer resaId) throws FunctionalException, NotFoundException;

    @WebMethod
    void verifEndResa() throws  FunctionalException;


}
