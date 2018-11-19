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
    public Reservation newReservation(@WebParam(name = "livreId") Integer livreId,@WebParam(name = "demandeurId") Integer demandeurId) throws FunctionalException, NotFoundException;

    @WebMethod
    public void deleteReservation(@WebParam(name = "resaId") Integer resaId)throws FunctionalException, NotFoundException;

    @WebMethod
    public List<Reservation> getResaByUserId(@WebParam(name = "demandeurId")Integer demandeurId)throws FunctionalException;

    @WebMethod
    public  List<Reservation> getResaByLivreId(@WebParam(name = "livreId")Integer livreId)throws FunctionalException;

    public void checkNbExemplaire(Livre livre) throws FunctionalException;

    public void checkUserResa(Utilisateur demandeur, Livre livre) throws FunctionalException;
}
