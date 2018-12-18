package fr.mb.biblio.webappBusiness.impl;

import fr.mb.biblio.webappBusiness.contract.ResaWebManager;
import fr.mb.biblio.webappConsumer.services.reservation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResaWebManagerImpl implements ResaWebManager {

    @Autowired
    ResaService resaService;

    List<Reservation> listResaReturn;
    Reservation resaReturn;
    List<ReservationWS>listResaWsReturn;

    @Override
    public List<Reservation> getListResaByLivreId(Integer livreId) throws FunctionalException_Exception {
        listResaReturn = resaService.getResaByLivreId(livreId);
        return  listResaReturn;
    }

    @Override
    public Reservation newReservation(Integer livreId, Integer demandeurId) throws NotFoundException_Exception, FunctionalException_Exception {
        resaReturn= resaService.newReservation(livreId,demandeurId);
        return resaReturn;
    }

    @Override
    public List<ReservationWS> getListResaByUserId(Integer userId) throws FunctionalException_Exception, NotFoundException_Exception {
       listResaWsReturn = resaService.getResaByUserId(userId);
       return  listResaWsReturn;
    }

    @Override
    public void deleteReservation(Integer resaId) throws NotFoundException_Exception, FunctionalException_Exception {
        resaService.deleteReservation(resaId);

    }
}
