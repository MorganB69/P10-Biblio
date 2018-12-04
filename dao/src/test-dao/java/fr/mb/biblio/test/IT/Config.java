package fr.mb.biblio.test.IT;

import fr.mb.biblio.dao.contract.*;
import fr.mb.biblio.dao.impl.*;
import fr.mb.biblio.models.beans.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("fr.mb.biblio")// scan for services
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

    @Bean(name = "resaDao")
    public ResaDao resaDao() {
        return new ResaDaoImpl(Reservation.class);
    }
    
    
    


}
