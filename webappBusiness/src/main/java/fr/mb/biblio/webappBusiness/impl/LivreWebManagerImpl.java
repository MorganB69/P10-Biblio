package fr.mb.biblio.webappBusiness.impl;

import fr.mb.biblio.webappBusiness.contract.LivreWebManager;
import fr.mb.biblio.webappConsumer.services.livre.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivreWebManagerImpl implements LivreWebManager {

    @Autowired
    LivreService livreClient;

    List<Livre>listeLivres;
    Livre livre;


    @Override
    public List<Livre> getAllLivres(Integer start, Integer nb) throws FunctionalException_Exception {
        listeLivres=livreClient.getAllLivres(start,nb);
        return listeLivres;
    }

    @Override
    public List<Livre> rechercheLivres(RechercheLivre recherche, Integer start, Integer pageSize) throws FunctionalException_Exception {
       listeLivres=livreClient.rechercheLivres(recherche,start,pageSize);
       return listeLivres;
    }

    @Override
    public Livre getLivreById(Integer id) throws NotFoundException_Exception {
        livre=livreClient.getLivreById(id);
        return livre;
    }

    @Override
    public Long countLivres(RechercheLivre recherche) {
        Long count = livreClient.countLivres(recherche);
        return count;
    }
    @Override
    public String dateRetourLivre(Integer idLivre) throws NotFoundException_Exception, FunctionalException_Exception {
        String date = livreClient.dateRetourLivre(idLivre);
        return date;
    }
}
