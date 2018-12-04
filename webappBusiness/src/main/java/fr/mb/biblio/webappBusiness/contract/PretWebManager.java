package fr.mb.biblio.webappBusiness.contract;

import fr.mb.biblio.webappConsumer.services.pret.Pret;

import java.util.List;

public interface PretWebManager {
    List<Pret> getPretsEnCoursByUser(Integer id);

    void prolongerPret(Integer idPret, Integer idUser);


}
