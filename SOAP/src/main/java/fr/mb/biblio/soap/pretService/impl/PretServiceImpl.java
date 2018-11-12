package fr.mb.biblio.soap.pretService.impl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.*;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import fr.mb.biblio.dao.contract.LivreDao;
import fr.mb.biblio.dao.contract.PretDao;
import fr.mb.biblio.dao.contract.UtilisateurDao;
import fr.mb.biblio.models.Mail;
import fr.mb.biblio.models.beans.Livre;
import fr.mb.biblio.models.beans.Pret;
import fr.mb.biblio.models.beans.Utilisateur;
import fr.mb.biblio.models.exception.FunctionalException;
import fr.mb.biblio.models.exception.NotFoundException;
import fr.mb.biblio.soap.pretService.contract.PretService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * Implemetation du service de gestion des prets
 * 
 * @author Morgan
 *
 */
public class PretServiceImpl implements PretService {

	private static final Logger logger = LogManager.getLogger(PretServiceImpl.class);

	/**
	 * Dao pour les prets
	 */
	@Inject
	PretDao pretDao;
	@Inject
	UtilisateurDao utilisateurDao;
	@Inject
	LivreDao livreDao;
	
	@Inject
    public JavaMailSender emailSender;
	
	 @Inject
	private Configuration freemarkerConfig;
	
	

	/**
	 * Pret à retourner
	 */
	Pret pretReturn;

	/**
	 * Liste de pret a retourner
	 */
	List<Pret> listeReturn;

	/**
	 * Durée de pret definit dans un fichier properties car configurable
	 */
	@Value("${dureePret}")
	Integer DUREEPRET;

	@Resource
	WebServiceContext ctx;

	/**
	 * Vérification du statut d'administrateur du user qui est loggé
	 * 
	 * @return
	 */
	public Boolean isAdmin() throws NotFoundException {

		// get detail from request headers
		String usernameFromHeader = (String) ctx.getMessageContext().get("USERNAME");
		logger.info(usernameFromHeader);
		Utilisateur user = utilisateurDao.getUser(usernameFromHeader);
		if (user == null)
			throw new NotFoundException("Utilisateur non trouvé");

		return user.getAdmin();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.mb.biblio.soap.pretService.contract.PretService#nouveauPret(java.lang.
	 * Integer, java.lang.Integer)
	 */
	@Override
	@Transactional
	public Pret nouveauPret(Integer livreId, Integer emprunteurId) throws FunctionalException, NotFoundException {
		
		if(livreId<=0||livreId==null||emprunteurId<=0||emprunteurId==null) throw new FunctionalException("Données incorrectes");
		
		else {
		Pret pret=new Pret();
		
		if (isAdmin()==true) {
			//Récupération de l'utilisateur
			Utilisateur emprunteur=utilisateurDao.findById(emprunteurId);
			//Récupération du livre à emprunter
			Livre livre=livreDao.findById(livreId);
			
			if(emprunteur==null||livre==null) throw new NotFoundException("Non trouvé en base de donénes");
			else {
				//Vérification disponibilité du livre
				if (livre.getDisponible()==false) throw new FunctionalException ("Le livre n'est pas disponible");
				
				else {
					//Date de début du pret
					LocalDate dateDebut=LocalDate.now();
					//Date de fin théorique
					LocalDate dateFin=dateDebut.plusDays(DUREEPRET);
					
					//Enregistrement des parametres
					pret.setDateDebut(dateDebut);
					pret.setDateFin(dateFin);
					pret.setUtilisateur(emprunteur);
					pret.setLivre(livre);
					pret.getLivre().setDisponible(false);
					pret.setProlonge(false);
					
					pretDao.persist(pret);}}}
		else throw new FunctionalException("Seul un administrateur peut enregistrer un nouveau prêt");
			
			return pret;}
		}

	/* (non-Javadoc)
	 * @see fr.mb.biblio.soap.pretService.contract.PretService#prolongerPret(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	@Transactional
	public Pret prolongerPret(Integer pretId, Integer emprunteurId) throws FunctionalException, NotFoundException {
		
		if(pretId<=0||pretId==null||emprunteurId<=0||emprunteurId==null) throw new FunctionalException("Données incorrectes");
		
		// Récupération du prêt
		Pret pret = pretDao.findById(pretId);
		if(pret==null)throw new NotFoundException("le prêt renseigné n'est pas trouvable");
		else {
		// Vérification que le l'utilisateur correspond à celui du prêt et vérification
		// que le prêt n'est pas prolongé
		if (emprunteurId == pret.getUtilisateur().getIdUtilisateur() && pret.isProlonge() == false) {

			// Récupération de la date de fin
			LocalDate dateFin = pret.getDateFin();


				dateFin=dateFin.plusDays(DUREEPRET);
				// Modification des paramètres
				pret.setDateFin(dateFin);
				pret.setProlonge(true);

				pretDao.update(pret);


		} else
			throw new FunctionalException("Le prêt a déjà été prolongé ou l'utilisateur n'est pas bon");

		return pret;
		}
	}

	/* (non-Javadoc)
	 * @see fr.mb.biblio.soap.pretService.contract.PretService#retourPret(java.lang.Integer)
	 */
	@Override
	@Transactional
	public String retourPret(Integer pretId) throws FunctionalException, NotFoundException {
		
		if(pretId<=0||pretId==null) throw new FunctionalException("Données incorrectes");
		
		// Récupération du prêt
		Pret pret = pretDao.findById(pretId);
		
		if(pret==null)throw new NotFoundException("Le prêt n'existe pas");
		if(pret.getDateEffective()!=null)throw new FunctionalException("Le prêt est déjà terminé");
		
		//Insertion de la date de retour effective du pret
		LocalDate dateEffective = LocalDate.now();
		pret.setDateEffective(dateEffective);
		//Changement du statut du livre en disponible
		pret.getLivre().setDisponible(true);
		pretDao.update(pret);
		String reponse="Le prêt est terminé";
		return reponse;
	}

	/* (non-Javadoc)
	 * @see fr.mb.biblio.soap.pretService.contract.PretService#getPretById(java.lang.Integer)
	 */
	@Override
	@Transactional
	public Pret getPretById(Integer pretId) throws FunctionalException, NotFoundException {
		if(pretId<=0||pretId==null) throw new FunctionalException("Données incorrectes");
		
		// Récupération du prêt
		Pret pret = pretDao.findById(pretId);
		if(pret==null)throw new NotFoundException("Le prêt n'existe pas");
		return pret;
	}

	/* (non-Javadoc)
	 * @see fr.mb.biblio.soap.pretService.contract.PretService#getPretsEnCours()
	 */
	@Override
	@Transactional
	public List<Pret> getPretsEnCours() throws FunctionalException {
		listeReturn=pretDao.findPretEnCours(0, 12);
		if (listeReturn==null) throw new FunctionalException("Pas de prêt en cours trouvé");
		return listeReturn;
	}

	/* (non-Javadoc)
	 * @see fr.mb.biblio.soap.pretService.contract.PretService#getPretsProlonges()
	 */
	@Override
	@Transactional
	public List<Pret> getPretsProlonges() throws FunctionalException {
		listeReturn=pretDao.findPretEnCoursProlonge(0, 12);
		if (listeReturn==null) throw new FunctionalException("Pas de prêt en cours prolongé trouvé");
		return listeReturn;
	}

	/* (non-Javadoc)
	 * @see fr.mb.biblio.soap.pretService.contract.PretService#getPretsRetards()
	 */
	@Override
	@Transactional
	public List<Pret> getPretsRetards() throws FunctionalException {
		LocalDate dateJour=LocalDate.now();
		listeReturn=pretDao.findPretRetard(0, 100, dateJour);
		if (listeReturn==null) throw new FunctionalException("Pas de prêt en cours en retard trouvé");
		return listeReturn;
	}

	/* (non-Javadoc)
	 * @see fr.mb.biblio.soap.pretService.contract.PretService#creationPretDate(java.lang.Integer, java.lang.Integer, java.time.LocalDate)
	 */
	@Override
	@Transactional
	public Pret creationPretDate(Integer livreId, Integer emprunteurId, LocalDate dateDebut)
			throws FunctionalException, NotFoundException {

		
		if(livreId<=0||livreId==null||emprunteurId<=0||emprunteurId==null) throw new FunctionalException("Données incorrectes");
		
		else {
		Pret pret=new Pret();
		
		if (isAdmin()==true) {
			//Récupération de l'utilisateur
			Utilisateur emprunteur=utilisateurDao.findById(emprunteurId);
			//Récupération du livre à emprunter
			Livre livre=livreDao.findById(livreId);
			
			if(emprunteur==null||livre==null) throw new NotFoundException("Non trouvé en base de donénes");
			else {
				//Vérification disponibilité du livre
				if (livre.getDisponible()==false) throw new FunctionalException ("Le livre n'est pas disponible");
				
				else {

					
					//Date de fin théorique
					
					LocalDate dateFin=dateDebut.plusDays(DUREEPRET);
					
					//Enregistrement des parametres
					pret.setDateDebut(dateDebut);
					pret.setDateFin(dateFin);
					pret.setUtilisateur(emprunteur);
					pret.setLivre(livre);
					pret.getLivre().setDisponible(false);
					pret.setProlonge(false);
					
					pretDao.persist(pret);}}}
		else throw new FunctionalException("Seul un administrateur peut enregistrer un nouveau prêt");
			
			return pret;}
	}
	
	

	/* (non-Javadoc)
	 * @see fr.mb.biblio.soap.pretService.contract.PretService#relanceMailRetards()
	 */
	@Override
	@Transactional
	@Scheduled(cron = "${instructionSchedularTime}")
	public void relanceMailRetards() throws Exception {
		
		//Récupération des prets en retard
		List<Pret>listeRetard=getPretsRetards();
		
		//Pour chaque pret en retard, envoi d'un mail de relance a l'empreunteur
		for (Iterator iterator = listeRetard.iterator(); iterator.hasNext();) {
			Pret pret = (Pret) iterator.next();
			Mail mail = new Mail("mb.testocrbiblio@gmail.com",pret.getUtilisateur().getMail(),"Relance Prêt Biblio");

	 
	        Map < String, Object > model = new HashMap < String, Object > ();
	        model.put("prenom", pret.getUtilisateur().getPrenom());
	        model.put("nom", pret.getUtilisateur().getNom());
	        model.put("titre", pret.getLivre().getTitre());
	        model.put("date", pret.getDateFin());
	        mail.setModel(model);
	 

	        sendSimpleMessage(mail);
		}
		
		
        
    }

	@Override
	public void setDisponibilite(Integer livreId) throws FunctionalException, NotFoundException {
		if (livreId==0)throw new FunctionalException("les données sont incorrectes");
		else {
			Livre livre = livreDao.findById(livreId);
			int nbPretsEnCours=0;
			Set<Pret> listePret=livre.getPrets();

			if(livre==null) throw new NotFoundException("Livre non trouvé en base de données");


			for (Iterator<Pret> iterator = listePret.iterator(); iterator.hasNext(); ) {
				Pret next =  iterator.next();
				if (next.getDateEffective()==null) nbPretsEnCours++;

			}
			if (1==nbPretsEnCours)livre.setDisponible(false);
			else livre.setDisponible(true);

			livreDao.update(livre);



		}
	}

	/**
	 * @param pretId
	 * @throws NotFoundException
	 * @throws FunctionalException
	 */
	@Override
	public void deletePret(Integer pretId) throws NotFoundException, FunctionalException  {
		if(pretId<=0||pretId==null) throw new FunctionalException("Données incorrectes");

		// Récupération du prêt
		Pret pret = pretDao.findById(pretId);
		if(pret==null)throw new NotFoundException("Le prêt n'existe pas");
		else
			pretDao.delete(pret);
	}


	/**
	 * Méthode de configuration d'envoi d'un mail
	 * @param mail
	 * @throws MessagingException
	 * @throws IOException
	 * @throws TemplateException
	 */
	public void sendSimpleMessage(Mail mail) throws MessagingException, IOException, TemplateException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        

        Template t = freemarkerConfig.getTemplate("email-template.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, mail.getModel());

        helper.setTo(mail.getTo());
        helper.setText(html, true);
        helper.setSubject(mail.getSubject());
        helper.setFrom(mail.getFrom());

        emailSender.send(message);
    }

	@Override
	@Transactional
	public List<Pret> getPretsEnCoursByUser(Integer utilisateurId) throws FunctionalException {
		listeReturn=pretDao.findPretEnCoursByUser(utilisateurId);
		if (listeReturn==null) throw new FunctionalException("Pas de prêt en cours trouvé");
		return listeReturn;
	}

	

}
