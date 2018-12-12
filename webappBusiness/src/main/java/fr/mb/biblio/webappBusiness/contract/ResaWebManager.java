package fr.mb.biblio.webappBusiness.contract;

import fr.mb.biblio.webappConsumer.services.reservation.FunctionalException_Exception;
import fr.mb.biblio.webappConsumer.services.reservation.NotFoundException_Exception;
import fr.mb.biblio.webappConsumer.services.reservation.Reservation;

import java.util.List;

public interface ResaWebManager {
    List<Reservation> getListResaByLivreId(Integer livreId) throws FunctionalException_Exception;

    Reservation newReservation(Integer livreId, Integer demandeurId) throws NotFoundException_Exception, FunctionalException_Exception;
}
