package fr.mb.biblio.webappBusiness.impl;

import fr.mb.biblio.webappBusiness.contract.PretWebManager;
import fr.mb.biblio.webappConsumer.services.pret.FunctionalException_Exception;
import fr.mb.biblio.webappConsumer.services.pret.NotFoundException_Exception;
import fr.mb.biblio.webappConsumer.services.pret.Pret;
import fr.mb.biblio.webappConsumer.services.pret.PretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class PretWebManagerImpl implements PretWebManager {

    @Autowired
    PretService pretClient;

    List<Pret>listPret;
    Pret pret;

    @Override
    public List<Pret> getPretsEnCoursByUser(Integer id) throws FunctionalException_Exception {
        listPret=pretClient.getPretsEnCoursByUser(id);
        return listPret;
    }

    @Override
    public void prolongerPret(Integer idPret, Integer idUser) throws NotFoundException_Exception, FunctionalException_Exception {
        pretClient.prolongerPret(idPret,idUser);

    }
}
