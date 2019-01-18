package fr.mb.biblio.soap.resaService.impl;

import fr.mb.biblio.models.beans.Reservation;
import fr.mb.biblio.models.exception.FunctionalException;
import fr.mb.biblio.models.exception.NotFoundException;
import fr.mb.biblio.models.ws.ReservationWS;
import fr.mb.biblio.soap.resaService.contract.ResaService;
import fr.mb.biblio.soapbusiness.livreManager.contract.LivreManager;
import fr.mb.biblio.soapbusiness.resaManager.contract.ResaManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Implementation du service de reservation
 */
@Service
public class ResaServiceImpl implements ResaService {

    @Autowired
    ResaManager resaManager;

    @Autowired
    LivreManager livreManager;


    /**
     * Liste de reservation à retourner
     */
    private List<Reservation>resaListReturn = new ArrayList<Reservation>();
    /**
     * Reservation à retourner
     */
    private Reservation resaReturn = new Reservation();

    /**
     * Liste de reservationWS(avec info complementaires pour l espace de reservation)
     */
    private List<ReservationWS> resaWsListReturn = new ArrayList<>();


    /**
     * Obtention des resas par ID
     * @param resaId
     * @return
     * @throws FunctionalException
     * @throws NotFoundException
     */
    @Override
    @Transactional
    public Reservation getResaById(Integer resaId) throws FunctionalException, NotFoundException{
        resaReturn=resaManager.getResaById(resaId);
        return resaReturn;
    }


    /**
     * Nouvelle reservation
     * @param livreId
     * @param demandeurId
     * @return
     * @throws FunctionalException
     * @throws NotFoundException
     */
    @Override
    @Transactional
    public Reservation newReservation(Integer livreId, Integer demandeurId) throws FunctionalException, NotFoundException {
        resaReturn=resaManager.newReservation(livreId,demandeurId);
            return resaReturn;

    }

    /**
     * Suppression d'une reservation
     * @param resaId
     * @throws FunctionalException
     * @throws NotFoundException
     */
    @Override
    @Transactional
    public void deleteReservation(Integer resaId) throws FunctionalException, NotFoundException {
        resaManager.deleteReservation(resaId);
    }

    /**
     * Obtention des resas par demandeur
     * @param demandeurId
     * @return
     * @throws FunctionalException
     */
    @Override
    @Transactional
    public List<ReservationWS> getResaByUserId(Integer demandeurId) throws FunctionalException, NotFoundException {
        resaListReturn=resaManager.getResaByUserId(demandeurId);
        resaWsListReturn.clear();
        Boolean exception = false;
        String date=null;
        for(Reservation next : resaListReturn){
            ReservationWS resaWS = new ReservationWS();
            try{
                 date = livreManager.dateRetourLivre(next.getLivre().getIdLivre());
            }
            catch (FunctionalException e){
                exception=true;
            }
            LocalDate dateRetour=null;
            if(exception==false){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            dateRetour = LocalDate.parse(date,formatter);}


            resaWS.setReservation(next);
            resaWS.setDateRetour(dateRetour);
            Integer position = 1;
            Set<Reservation> listeResaByLivre = next.getLivre().getListeResa();

            Iterator<Reservation> iterator = listeResaByLivre.iterator();
            while (iterator.hasNext()) {
                Reservation reservation = iterator.next();
                if (demandeurId == reservation.getDemandeur().getIdUtilisateur()) break;
                else position++;
            }
            resaWS.setPositionUser(position);
            resaWS.setNbResaTotal(next.getLivre().getListeResa().size());
            resaWsListReturn.add(resaWS);

        }
            return resaWsListReturn;
    }

    /**
     * Obtention des resas par livre
     * @param livreId
     * @return
     * @throws FunctionalException
     */
    @Override
    @Transactional
    public List<Reservation> getResaByLivreId(Integer livreId) throws FunctionalException {
        resaListReturn=resaManager.getResaByLivreId(livreId);
            return resaListReturn;
    }





    /**
     * rajoute la date de début et de fin d'une resa (+2j)
     * @param resaId
     * @return
     * @throws FunctionalException
     * @throws NotFoundException
     */
    @Override
    @Transactional
    public Reservation startResa(Integer resaId) throws FunctionalException, NotFoundException {
        resaReturn=resaManager.startResa(resaId);
                return resaReturn;
    }

    /**
     * Configuration du modele de mail d'une resa
     * @param resaId
     * @throws Exception
     */
    @Override
    @Transactional
    public void mailResa(Integer resaId) throws Exception {
        resaManager.mailResa(resaId);
    }




    /**
     * Suppression des reservations terminées
     * @throws FunctionalException
     */
    @Override
    @Transactional
    public void verifEndResa() {
        resaManager.verifEndResa();
    }


}
