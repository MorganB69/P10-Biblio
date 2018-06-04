package fr.mb.biblio.configuration;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import fr.mb.biblio.dao.contract.GenericDAO;
import fr.mb.biblio.dao.contract.LivreDao;
import fr.mb.biblio.dao.contract.PretDao;
import fr.mb.biblio.dao.contract.UtilisateurDao;
import fr.mb.biblio.dao.impl.AuteurDaoImpl;
import fr.mb.biblio.dao.impl.EditeurDaoImpl;
import fr.mb.biblio.dao.impl.GenreDaoImpl;
import fr.mb.biblio.dao.impl.LivreDaoImpl;
import fr.mb.biblio.dao.impl.OuvrageDaoImpl;
import fr.mb.biblio.dao.impl.PretDaoImpl;
import fr.mb.biblio.dao.impl.UtilisateurDaoImpl;
import fr.mb.biblio.models.beans.Auteur;
import fr.mb.biblio.models.beans.Editeur;
import fr.mb.biblio.models.beans.Genre;
import fr.mb.biblio.models.beans.Livre;
import fr.mb.biblio.models.beans.Ouvrage;
import fr.mb.biblio.models.beans.Pret;
import fr.mb.biblio.models.beans.Utilisateur;

@Configuration
@ComponentScan("fr.mb.biblio.soap")// scan for services
@EnableScheduling
public class Config {

    @Bean(name="utilisateurDao")
    public UtilisateurDao utilisateurDao() {
        return new UtilisateurDaoImpl (Utilisateur.class);
    }
    
    @Bean(name = "auteurDao")
    public GenericDAO<Auteur> auteurDao() {
        return new AuteurDaoImpl (Auteur.class);
    }
    
    @Bean(name = "editeurDao")
    public GenericDAO<Editeur> editeurDao() {
        return new EditeurDaoImpl (Editeur.class);
    }
    
    @Bean(name = "genreDao")
    public GenericDAO<Genre> genreDao() {
        return new GenreDaoImpl (Genre.class);
    }
    
    @Bean(name = "livreDao")
    public LivreDao livreDao() {
        return new LivreDaoImpl (Livre.class);
    }
    
    @Bean(name = "ouvrageDao")
    public GenericDAO<Ouvrage> ouvrageDao() {
        return new OuvrageDaoImpl (Ouvrage.class);
    }
    
    @Bean(name = "pretDao")
    public PretDao pretDao() {
        return new PretDaoImpl (Pret.class);
    }
    
    
    


}
