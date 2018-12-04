package fr.mb.biblio.webappBusiness.contract;

import fr.mb.biblio.webappConsumer.services.livre.Livre;
import fr.mb.biblio.webappConsumer.services.livre.RechercheLivre;

import java.util.List;

public interface LivreWebManager {

    List<Livre> getAllLivres(Integer start, Integer nb);

    List<Livre> rechercheLivres(RechercheLivre recherche, Integer start, Integer pageSize);

    Livre getLivreById(Integer id);

    Long countLivres(RechercheLivre recherche);


}
