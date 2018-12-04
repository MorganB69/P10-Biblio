package fr.mb.biblio.soap.resaService.impl;

import fr.mb.biblio.dao.contract.LivreDao;
import fr.mb.biblio.dao.contract.ResaDao;
import fr.mb.biblio.dao.contract.UtilisateurDao;
import fr.mb.biblio.models.Mail;
import fr.mb.biblio.models.beans.Livre;
import fr.mb.biblio.models.beans.Reservation;
import fr.mb.biblio.models.beans.Utilisateur;
import fr.mb.biblio.models.exception.FunctionalException;
import fr.mb.biblio.models.exception.NotFoundException;
import fr.mb.biblio.soap.pretService.contract.PretService;
import fr.mb.biblio.soap.pretService.impl.PretServiceImpl;
import fr.mb.biblio.soap.resaService.contract.ResaService;
import fr.mb.biblio.soapbusiness.resaManager.contract.ResaManager;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import net.sf.ehcache.search.expression.Not;
import org.apache.commons.collections4.FunctorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.*;

import static org.bouncycastle.asn1.iana.IANAObjectIdentifiers.mail;

/**
 * Implementation du service de reservation
 */
@Service
public class ResaServiceImpl implements ResaService {

    @Autowired
    ResaManager resaManager;


    /**
     * Liste de reservation à retourner
     */
    private List<Reservation>resaListReturn = new ArrayList<Reservation>();
    /**
     * Reservation à retourner
     */
    private Reservation resaReturn = new Reservation();


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
    public List<Reservation> getResaByUserId(Integer demandeurId) throws FunctionalException {
        resaListReturn=resaManager.getResaByUserId(demandeurId);
            return resaListReturn;
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
