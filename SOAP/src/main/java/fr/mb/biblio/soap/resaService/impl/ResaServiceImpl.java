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

@Service
public class ResaServiceImpl implements ResaService {

    @Inject
    ResaDao resaDao;

    @Inject
    LivreDao livreDao;

    @Inject
    UtilisateurDao utilisateurDao;

    @Inject
    public JavaMailSender emailSender;

    @Inject
    private Configuration freemarkerConfig;


    private List<Reservation>resaListReturn = new ArrayList<Reservation>();
    private Reservation resaReturn = new Reservation();

   @Override
    @Transactional
    public Reservation getResaById(Integer resaId) throws FunctionalException, NotFoundException{
        if (resaId<=0) throw new FunctionalException("les données sont incorrectes");
        else{
            resaReturn = resaDao.findById(resaId);
            if (resaReturn==null) throw new NotFoundException("réservation non trouvée");
            else{
                return resaReturn;
            }
        }
    }


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
    @Transactional
    public void mailResa(Integer resaId) throws Exception {
      if(resaId<=0) throw new FunctionalException("Les données sont incorrectes");
       Reservation resa = getResaById(resaId);
       Utilisateur user = resa.getDemandeur();
       Livre livre = resa.getLivre();
       if (user==null||livre==null) throw new NotFoundException("Données non trouvées");
       else {
           Mail mail = new Mail("mb.testocrbiblio@gmail.com", user.getMail(), "Réservation");
           Map<String, Object> model = new HashMap<String, Object>();
           model.put("prenom", user.getPrenom());
           model.put("nom", user.getNom());
           model.put("resa", resa);
           model.put("livre",livre);
           mail.setModel(model);

           sendMailResa(mail,"emailResa-template.ftl");

       }

    }

    /**
     * Méthode de configuration d'envoi d'un mail
     * @param mail
     * @throws MessagingException
     * @throws IOException
     * @throws TemplateException
     */
    @SuppressWarnings("Duplicates")
    private void sendMailResa(Mail mail, String template) throws MessagingException, IOException, TemplateException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());


        freemarkerConfig.setDefaultEncoding("utf-8");
        Template t = freemarkerConfig.getTemplate(template);
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, mail.getModel());

        helper.setTo(mail.getTo());
        helper.setText(html, true);
        helper.setSubject(mail.getSubject());
        helper.setFrom(mail.getFrom());

        emailSender.send(message);
    }



    @Override
    public void verifEndResa() throws FunctionalException {

    }


}
