package fr.mb.biblio.webappBusiness.contract;

import fr.mb.biblio.webappConsumer.services.identification.Utilisateur;

public interface LoginWebManager {

    Utilisateur identification(String login, String mdp);
}
