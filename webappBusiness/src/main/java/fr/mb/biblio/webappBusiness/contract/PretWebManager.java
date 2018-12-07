package fr.mb.biblio.webappBusiness.contract;

import fr.mb.biblio.webappConsumer.services.pret.FunctionalException_Exception;
import fr.mb.biblio.webappConsumer.services.pret.NotFoundException_Exception;
import fr.mb.biblio.webappConsumer.services.pret.Pret;

import java.util.List;

public interface PretWebManager {
    List<Pret> getPretsEnCoursByUser(Integer id) throws FunctionalException_Exception;

    void prolongerPret(Integer idPret, Integer idUser) throws NotFoundException_Exception, FunctionalException_Exception;


}
