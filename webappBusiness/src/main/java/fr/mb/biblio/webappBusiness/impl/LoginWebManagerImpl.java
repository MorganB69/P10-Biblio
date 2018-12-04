package fr.mb.biblio.webappBusiness.impl;

import fr.mb.biblio.webappBusiness.contract.LoginWebManager;
import fr.mb.biblio.webappConsumer.services.identification.IdentificationService;
import fr.mb.biblio.webappConsumer.services.identification.NotFoundException_Exception;
import fr.mb.biblio.webappConsumer.services.identification.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginWebManagerImpl implements LoginWebManager {

    @Autowired
    IdentificationService identificationClient;

    Utilisateur user;

    public Utilisateur identification(String login, String mdp) throws NotFoundException_Exception {
        user=identificationClient.identification(login,mdp);
        return user;
    }
}
