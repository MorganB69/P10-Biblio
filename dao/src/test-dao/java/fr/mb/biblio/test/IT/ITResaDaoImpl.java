package fr.mb.biblio.test.IT;

import fr.mb.biblio.dao.contract.LivreDao;
import fr.mb.biblio.dao.contract.ResaDao;
import fr.mb.biblio.dao.contract.UtilisateurDao;
import fr.mb.biblio.models.beans.Livre;
import fr.mb.biblio.models.beans.Reservation;

import fr.mb.biblio.models.beans.Utilisateur;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
    @ContextConfiguration(locations= {"/ApplicationContextTestDao.xml"})
    @ActiveProfiles(profiles = "test")
    @Transactional
    public class ITResaDaoImpl {

        @Autowired
        ResaDao resaDao;
        @Autowired
        LivreDao livreDao;
        @Autowired
        UtilisateurDao utilisateurDao;

        @Test
        @Rollback
        public  void persistResaIT(){
            Reservation resa = new Reservation();
            //Récupération du livre
            Livre livre = livreDao.findById(13);
            //Récupération utilisateur
            Utilisateur utilisateur = utilisateurDao.findById(1);

            resa.setLivre(livre);
            resa.setDemandeur(utilisateur);

            resaDao.persist(resa);
            List reservationList = resaDao.findAll();
            assertTrue(reservationList.contains(resa),"La liste contient la réservation persisté :"+ resa.getId());

        }

        @Test
        @Rollback
        public void updateResaIT(){
            Reservation resa = resaDao.findById(42);
            LocalDate date=LocalDate.of(2019,01,14);
            resa.setDebutResa(date);
            resaDao.update(resa);
            resa=resaDao.findById(42);
            assertTrue(resa.getDebutResa().compareTo(date)==0,"verif que la date a été mise à jour"+resa.getDebutResa());

        }

        @Test
        public void getResaByUserIdIT() {
            List<Reservation> resa = resaDao.getResaByUserId(3);
            assertTrue(resa.size()==2);
            assertTrue(resa.stream().anyMatch(o -> o.getId()==(42)),"Test si une réservation test est bien présente");
            assertFalse(resa.stream().anyMatch(o -> o.getId()==(43)),"Test si une réservation d'un autre user n'est pas présente");

        }

        @Test
        public  void getResaByLivreIdIT(){
            List<Reservation>resa = resaDao.getResaByLivreId(2);
            assertTrue(resa.size()==2);
            assertTrue(resa.stream().anyMatch(o -> o.getId()==(42)),"Test si une réservation test est bien présente");
            assertFalse(resa.stream().anyMatch(o -> o.getId()==(44)),"Test si une réservation d'un autre livre n'est pas présente");


        }

        @Test
        @Rollback
        public void  getResaEnd(){
            Reservation resa = new Reservation();
            //Récupération du livre
            Livre livre = livreDao.findById(13);
            //Récupération utilisateur
            Utilisateur utilisateur = utilisateurDao.findById(1);
            LocalDate datedebut=LocalDate.of(2019,01,02);
            LocalDate datefin=LocalDate.of(2019,01,04);

            resa.setLivre(livre);
            resa.setDemandeur(utilisateur);
            resa.setDebutResa(datedebut);
            resa.setFinResa(datefin);


            resaDao.persist(resa);
            List<Reservation>resalist=resaDao.getResaEnd();
            LocalDate dateJour =LocalDate.of(2019,01,06);
            if (!resalist.isEmpty()) {
                for (Reservation next : resalist) {
                    assertTrue(next.getFinResa().compareTo(dateJour) < 0, "verification que la date de fin est dépassée");

                }
            }
        }


    }

