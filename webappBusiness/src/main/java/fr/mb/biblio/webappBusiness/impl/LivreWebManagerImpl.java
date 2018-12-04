package fr.mb.biblio.webappBusiness.impl;

import fr.mb.biblio.webappBusiness.contract.LivreWebManager;
import fr.mb.biblio.webappConsumer.services.livre.Livre;
import fr.mb.biblio.webappConsumer.services.livre.LivreManager;
import fr.mb.biblio.webappConsumer.services.livre.RechercheLivre;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LivreWebManagerImpl implements LivreWebManager {

    @Autowired
    LivreService livreService;


    @Override
    public List<Livre> getAllLivres(Integer start, Integer nb) {

        return null;
    }

    @Override
    public List<Livre> rechercheLivres(RechercheLivre recherche, Integer start, Integer pageSize) {
        return null;
    }

    @Override
    public Livre getLivreById(Integer id) {
        return null;
    }

    @Override
    public Long countLivres(RechercheLivre recherche) {
        return null;
    }
}
