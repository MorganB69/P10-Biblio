package fr.mb.biblio.webappBusiness.contract;

import fr.mb.biblio.webappConsumer.services.livre.FunctionalException_Exception;
import fr.mb.biblio.webappConsumer.services.livre.Livre;
import fr.mb.biblio.webappConsumer.services.livre.NotFoundException_Exception;
import fr.mb.biblio.webappConsumer.services.livre.RechercheLivre;

import java.util.List;

public interface LivreWebManager {

    List<Livre> getAllLivres(Integer start, Integer nb) throws FunctionalException_Exception;

    List<Livre> rechercheLivres(RechercheLivre recherche, Integer start, Integer pageSize) throws FunctionalException_Exception;

    Livre getLivreById(Integer id) throws NotFoundException_Exception;

    Long countLivres(RechercheLivre recherche);


    String dateRetourLivre(Integer idLivre) throws NotFoundException_Exception, FunctionalException_Exception;
}
