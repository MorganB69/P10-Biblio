package fr.mb.biblio.webappBusiness.impl;

import fr.mb.biblio.webappBusiness.contract.ResaWebManager;
import fr.mb.biblio.webappConsumer.services.reservation.FunctionalException_Exception;
import fr.mb.biblio.webappConsumer.services.reservation.ResaService;
import fr.mb.biblio.webappConsumer.services.reservation.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResaWebManagerImpl implements ResaWebManager {

    @Autowired
    ResaService resaService;

    List<Reservation> listResaReturn;
    Reservation resaReturn;

    @Override
    public List<Reservation> getListResaByLivreId(Integer livreId) throws FunctionalException_Exception {
        listResaReturn = resaService.getResaByLivreId(livreId);
        return  listResaReturn;
    }
}
