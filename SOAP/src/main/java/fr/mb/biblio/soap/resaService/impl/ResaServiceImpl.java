package fr.mb.biblio.soap.resaService.impl;

import fr.mb.biblio.dao.contract.LivreDao;
import fr.mb.biblio.dao.contract.ResaDao;
import fr.mb.biblio.dao.contract.UtilisateurDao;
import fr.mb.biblio.models.beans.Livre;
import fr.mb.biblio.models.beans.Reservation;
import fr.mb.biblio.models.beans.Utilisateur;
import fr.mb.biblio.models.exception.FunctionalException;
import fr.mb.biblio.models.exception.NotFoundException;
import fr.mb.biblio.soap.resaService.contract.ResaService;
import net.sf.ehcache.search.expression.Not;
import org.apache.commons.collections4.FunctorException;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ResaServiceImpl implements ResaService {

    @Inject
    ResaDao resaDao;

    @Inject
    LivreDao livreDao;

    @Inject
    UtilisateurDao utilisateurDao;

    private List<Reservation>resaListReturn = new ArrayList<Reservation>();
    private Reservation resaReturn = new Reservation();


    @Override
    @Transactional
    public Reservation newReservation(Integer livreId, Integer demandeurId) throws FunctionalException, NotFoundException {

        if(livreId <= 0 || demandeurId <= 0) throw new FunctionalException("Données incorrectes");
        else {
            //Récupération du livre
            Livre livre = livreDao.findById(livreId);
            //Récupération du demandeur
            Utilisateur demandeur = utilisateurDao.findById(demandeurId);

            //Persistence en db
            if(demandeur==null||livre==null) throw new NotFoundException("Non trouvé en base de données");
            else {
                resaReturn.setLivre(livre);
                resaReturn.setDemandeur(demandeur);
                //Verification du nombre d'examplaires
                this.checkNbExemplaire(livre);
                //Verification que l'emprunteur n'a pas déjà une résa
                this.checkUserResa(demandeur,livre);

                resaDao.persist(resaReturn);}


            return resaReturn;
        }
    }

    @Override
    public void deleteReservation(Integer resaId) throws FunctionalException, NotFoundException {
        if(resaId <= 0) throw new FunctionalException("les données sont incorrectes");
        else{
            resaReturn=resaDao.findById(resaId);
            if (resaReturn==null) throw new NotFoundException("La reservation n'a pas été trouvée");
            else {
                resaDao.delete(resaReturn);
            }

        }

    }

    @Override
    public List<Reservation> getResaByUserId(Integer demandeurId) throws FunctionalException {
        if (demandeurId <= 0) throw new FunctionalException("Les données sont incorrectes");
        else {
            resaListReturn=resaDao.getResaByUserId(demandeurId);
            return resaListReturn;
        }

    }

    @Override
    public List<Reservation> getResaByLivreId(Integer livreId) throws FunctionalException {
        if (livreId <= 0) throw new FunctionalException("Les données sont incorrectes");
        else {
            resaListReturn=resaDao.getResaByLivreId(livreId);
            return resaListReturn;
        }
    }

    @Override
    public void checkNbExemplaire(Livre livre) throws FunctionalException {
        int exemplaire = livre.getExemplaire();
        int nbResa = livre.getListeResa().size();
        if(nbResa>=2*exemplaire) throw new FunctionalException("La liste de réservation est pleine");

    }

    @Override
    public void checkUserResa(Utilisateur demandeur, Livre livre) throws FunctionalException {
        List<Reservation>listResa = resaDao.getResaByUserId(demandeur.getIdUtilisateur());
        for (Reservation next : listResa) {
            if (next.getLivre().getIdLivre() == livre.getIdLivre())
                throw new FunctionalException("L'utilisateur a déjà une réservation pour ce livre");

        }

    }

    @Override
    @Transactional
    public Reservation startResa(Integer resaId) throws FunctionalException, NotFoundException {
        if(resaId<=0) throw new FunctionalException("Les données sont incorrectes");
        else{
            resaReturn=resaDao.findById(resaId);
            if (resaReturn==null) throw new NotFoundException("La réservation n'a pas été trouvée");
            else{
                LocalDate dateDebut = LocalDate.now();
                LocalDate datefin = dateDebut.plusDays(2);
                resaReturn.setDebutResa(dateDebut);
                resaReturn.setFinResa(datefin);
                return resaReturn;
            }

        }
    }

    @Override
    public void mailResa(Integer resaId) throws FunctionalException, NotFoundException {

    }

    @Override
    public void verifEndResa() throws FunctionalException {

    }
}
