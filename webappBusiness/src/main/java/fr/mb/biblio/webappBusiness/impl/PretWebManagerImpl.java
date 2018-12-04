package fr.mb.biblio.webappBusiness.impl;

import fr.mb.biblio.webappBusiness.contract.PretWebManager;
import fr.mb.biblio.webappConsumer.services.pret.Pret;

import java.util.List;

public class PretWebManagerImpl implements PretWebManager {


    @Override
    public List<Pret> getPretsEnCoursByUser(Integer id) {
        return null;
    }

    @Override
    public void prolongerPret(Integer idPret, Integer idUser) {

    }
}
