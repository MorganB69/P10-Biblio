package fr.mb.biblio.soapbusiness.pretManager.impl;



import fr.mb.biblio.dao.contract.LivreDao;
import fr.mb.biblio.dao.contract.PretDao;
import fr.mb.biblio.dao.contract.UtilisateurDao;
import fr.mb.biblio.models.Mail;
import fr.mb.biblio.models.beans.Livre;
import fr.mb.biblio.models.beans.Pret;
import fr.mb.biblio.models.beans.Reservation;
import fr.mb.biblio.models.beans.Utilisateur;
import fr.mb.biblio.models.exception.FunctionalException;
import fr.mb.biblio.models.exception.NotFoundException;
import fr.mb.biblio.soapbusiness.pretManager.contract.PretManager;
import fr.mb.biblio.soapbusiness.resaManager.contract.ResaManager;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.annotation.Resource;
import javax.inject.Inject;

import javax.xml.ws.WebServiceContext;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Implemetation du service de gestion des prets
 * 
 * @author Morgan
 *
 */
@Service
public class PretManagerImpl implements PretManager {

	private static final Logger logger = LogManager.getLogger(PretManagerImpl.class);

	/**
	 * Dao pour les prets
	 */
	@Autowired
	PretDao pretDao;
	@Autowired
	UtilisateurDao utilisateurDao;
	@Autowired
	LivreDao livreDao;

	@Autowired
    public JavaMailSender emailSender;

	@Autowired
	private Configuration freemarkerConfig;

	@Autowired
	 ResaManager resaManager;


	/**
	 * Liste de pret a retourner
	 */
	private List<Pret> listeReturn;

	private Pret pretReturn;

	/**
	 * Durée de pret definit dans un fichier properties car configurable
	 */
	@Value("${dureePret}")
	Integer DUREEPRET;



	/**
	 * Vérification du statut d'administrateur du user qui est loggé
	 *
	 * @return
	 */
	 public Boolean isAdmin(String usernameFromHeader) throws NotFoundException {


		Utilisateur user = utilisateurDao.getUser(usernameFromHeader);
		if (user == null)
			throw new NotFoundException("Utilisateur non trouvé");

		return user.getAdmin();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.mb.biblio.soap.pretManager.contract.PretManager#nouveauPret(java.lang.
	 * Integer, java.lang.Integer)
	 */
	@Override
	@Transactional
	public Pret nouveauPret(Integer livreId, Integer emprunteurId) throws FunctionalException, NotFoundException {
		
		if(livreId <= 0 || emprunteurId <= 0) throw new FunctionalException("Données incorrectes");
		
		else {


			//Récupération de l'utilisateur
			Utilisateur emprunteur=utilisateurDao.findById(emprunteurId);
			//Récupération du livre à emprunter
			Livre livre=livreDao.findById(livreId);
			
			if(emprunteur==null||livre==null) throw new NotFoundException("Non trouvé en base de données");
			else {
				//Vérification disponibilité du livre
				if (!livre.getDisponible()) throw new FunctionalException ("Le livre n'est pas disponible");
				
				else {
					//Date de début du pret
					LocalDate dateDebut=LocalDate.now();
					//Date de fin théorique
					LocalDate dateFin=dateDebut.plusDays(DUREEPRET);

					Set<Reservation>listResa=livre.getListeResa();
					if(!listResa.isEmpty()){
						Reservation resa=listResa.iterator().next();
						if(resa.getDemandeur().getIdUtilisateur()!=emprunteur.getIdUtilisateur()){
							throw new FunctionalException("Le livre est reservé par un autre utilisateur");
						}
						else{
							resaManager.deleteReservation(resa.getId());
						}
					}
					pretReturn=new Pret();
					//Enregistrement des parametres
					pretReturn.setDateDebut(dateDebut);
                    pretReturn.setDateFin(dateFin);
                    pretReturn.setUtilisateur(emprunteur);
					livre.getPrets().add(pretReturn);
                    pretReturn.setLivre(livre);
					
					pretDao.persist(pretReturn);
					setDisponibilite(livre.getIdLivre());
				}}}


			return pretReturn;}


	/* (non-Javadoc)
	 * @see fr.mb.biblio.soap.pretManager.contract.PretManager#prolongerPret(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	@Transactional
	public Pret prolongerPret(Integer pretId, Integer emprunteurId) throws FunctionalException, NotFoundException {
		
		if(pretId <= 0 || emprunteurId <= 0) throw new FunctionalException("Données incorrectes");
		
		// Récupération du prêt
		Pret pret = pretDao.findById(pretId);
		if(pret==null)throw new NotFoundException("le prêt renseigné n'est pas trouvable");
		else {
			//Verification que la date de pret n'est pas depassee
			//Date du jour
			LocalDate dateJour = LocalDate.now();
			if (dateJour.isBefore(pret.getDateFin())) {
				// Vérification que le l'utilisateur correspond à celui du prêt et vérification
				// que le prêt n'est pas prolongé
				if (emprunteurId == pret.getUtilisateur().getIdUtilisateur() && !pret.isProlonge()) {

					// Récupération de la date de fin
					LocalDate dateFin = pret.getDateFin();


					dateFin = dateFin.plusDays(DUREEPRET);
					pretReturn=new Pret();
					// Modification des paramètres
					pret.setDateFin(dateFin);
					pret.setProlonge(true);

					pretDao.update(pret);


				} else
					throw new FunctionalException("Le prêt a déjà été prolongé ou l'utilisateur n'est pas bon");

				return pret;
			}else
				throw new FunctionalException("La date de fin du prêt est dépassée, vous ne pouvez plus le prolonger");
		}
	}

	/* (non-Javadoc)
	 * @see fr.mb.biblio.soap.pretManager.contract.PretManager#retourPret(java.lang.Integer)
	 */
	@Override
	@Transactional
	public String retourPret(Integer pretId) throws FunctionalException, NotFoundException {
		
		if(pretId <= 0) throw new FunctionalException("Données incorrectes");
		
		// Récupération du prêt
		Pret pret = pretDao.findById(pretId);
		
		if(pret==null)throw new NotFoundException("Le prêt n'existe pas");
		if(pret.getDateEffective()!=null)throw new FunctionalException("Le prêt est déjà terminé");
		
		//Insertion de la date de retour effective du pret
		LocalDate dateEffective = LocalDate.now();
		pret.setDateEffective(dateEffective);
		pretDao.update(pret);
		//Changement du statut du livre en disponible
        setDisponibilite(pret.getLivre().getIdLivre());

		Set<Reservation> listResa = pret.getLivre().getListeResa();
		if(!listResa.isEmpty()){
			Reservation resa=listResa.iterator().next();
			resaManager.startResa(resa.getId());
			try {
				resaManager.mailResa(resa.getId());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		String reponse="Le prêt est terminé";
		return reponse;
	}

	/* (non-Javadoc)
	 * @see fr.mb.biblio.soap.pretManager.contract.PretManager#getPretById(java.lang.Integer)
	 */
	@Override
	@Transactional
	public Pret getPretById(Integer pretId) throws FunctionalException, NotFoundException {
		if(pretId <= 0) throw new FunctionalException("Données incorrectes");
		
		// Récupération du prêt
		Pret pret = pretDao.findById(pretId);
		if(pret==null)throw new NotFoundException("Le prêt n'existe pas");
		return pret;
	}

	/* (non-Javadoc)
	 * @see fr.mb.biblio.soap.pretManager.contract.PretManager#getPretsEnCours()
	 */
	@Override
	@Transactional
	public List<Pret> getPretsEnCours() throws FunctionalException {
		listeReturn=pretDao.findPretEnCours(0, 12);
		if (listeReturn==null) throw new FunctionalException("Pas de prêt en cours trouvé");
		return listeReturn;
	}

	/* (non-Javadoc)
	 * @see fr.mb.biblio.soap.pretManager.contract.PretManager#getPretsProlonges()
	 */
	@Override
	@Transactional
	public List<Pret> getPretsProlonges() throws FunctionalException {
		listeReturn=pretDao.findPretEnCoursProlonge(0, 12);
		if (listeReturn==null) throw new FunctionalException("Pas de prêt en cours prolongé trouvé");
		return listeReturn;
	}

	/* (non-Javadoc)
	 * @see fr.mb.biblio.soap.pretManager.contract.PretManager#getPretsRetards()
	 */
	@Override
	@Transactional
	public List<Pret> getPretsRetards() throws FunctionalException {
		LocalDate dateJour=LocalDate.now();
		listeReturn=pretDao.findPretRetard(dateJour);
		if (listeReturn==null) throw new FunctionalException("Pas de prêt en cours en retard trouvé");
		return listeReturn;
	}

	@Override
	@Transactional
	public List<Pret> getPretsFuturRetard() throws FunctionalException {
		LocalDate dateJour = LocalDate.now();
		LocalDate dateRetard = LocalDate.now().plusDays(5);
		listeReturn=pretDao.findPretEnCoursFuturRetard(dateRetard,dateJour);
		if (listeReturn==null) throw new FunctionalException("Pas de futurs prêts en retard trouvé");
		return listeReturn;
	}

	/* (non-Javadoc)
	 * @see fr.mb.biblio.soap.pretManager.contract.PretManager#creationPretDate(java.lang.Integer, java.lang.Integer, java.time.LocalDate)
	 */
	@Override
	@Transactional
	public Pret creationPretDate(Integer livreId, Integer emprunteurId, LocalDate dateDebut)
			throws FunctionalException, NotFoundException {

		
		if(livreId <= 0 || emprunteurId <= 0) throw new FunctionalException("Données incorrectes");
		
		else {

		

			//Récupération de l'utilisateur
			Utilisateur emprunteur=utilisateurDao.findById(emprunteurId);
			//Récupération du livre à emprunter
			Livre livre=livreDao.findById(livreId);
			
			if(emprunteur==null||livre==null) throw new NotFoundException("Non trouvé en base de donénes");
			else {
				//Vérification disponibilité du livre
				if (!livre.getDisponible()) throw new FunctionalException ("Le livre n'est pas disponible");
				
				else {

					
					//Date de fin théorique
					
					LocalDate dateFin=dateDebut.plusDays(DUREEPRET);
					pretReturn=new Pret();
					//Enregistrement des parametres
					pretReturn.setDateDebut(dateDebut);
                    pretReturn.setDateFin(dateFin);
                    pretReturn.setUtilisateur(emprunteur);
                    pretReturn.setLivre(livre);
					setDisponibilite(pretReturn.getIdPret());
                    pretReturn.setProlonge(false);
					
					pretDao.persist(pretReturn);}}}

			
			return pretReturn;}

	
	

	/* (non-Javadoc)
	 * @see fr.mb.biblio.soap.pretManager.contract.PretManager#relanceMailRetards()
	 */
	@Override
	@Transactional
	//@Scheduled(cron = "${instructionSchedularTime}")
	public void relanceMailRetards() throws Exception {
		
		//Récupération des prets en retard
		List<Pret>listeRetard=getPretsRetards();
		Set<Utilisateur>userRetard=new HashSet<>();
		List<Pret>listeRetardByUser;

		for (Pret pret :listeRetard) {
			userRetard.add(pret.getUtilisateur());
		}
		for(Utilisateur user : userRetard){
			listeRetardByUser=listeRetard.stream().filter(pret -> pret.getUtilisateur().getIdUtilisateur()==(user.getIdUtilisateur())).collect(Collectors.toList());
			Mail mail = new Mail("mb.testocrbiblio@gmail.com", user.getMail(), "Relance Prêt Biblio");


			Map<String, Object> model = new HashMap<String, Object>();
			model.put("prenom", user.getPrenom());
			model.put("nom", user.getNom());
			model.put("listeRetards", listeRetardByUser);
			mail.setModel(model);


			sendSimpleMessage(mail,"email-template.ftl");
			listeRetardByUser.clear();


		}
    }

	@Override
	@Transactional
	public void relanceMailFuturRetard() throws Exception {

		//Récupération des prets en retard
		List<Pret>listeRetard=getPretsFuturRetard();
		Set<Utilisateur>userRetard=new HashSet<>();
		List<Pret>listeRetardByUser;

		for (Pret pret :listeRetard) {
			userRetard.add(pret.getUtilisateur());
		}
		for(Utilisateur user : userRetard){
			listeRetardByUser=listeRetard.stream().filter(pret -> pret.getUtilisateur().getIdUtilisateur()==(user.getIdUtilisateur())).collect(Collectors.toList());
			Mail mail = new Mail("mb.testocrbiblio@gmail.com", user.getMail(), "Biblio : Fin de prêts");


			Map<String, Object> model = new HashMap<String, Object>();
			model.put("prenom", user.getPrenom());
			model.put("nom", user.getNom());
			model.put("listeRetards", listeRetardByUser);
			mail.setModel(model);


			sendSimpleMessage(mail,"email-template-finpret.ftl");
			listeRetardByUser.clear();


		}
	}

	@Override
	@Transactional
	public void setDisponibilite(Integer livreId) throws FunctionalException, NotFoundException {
		if (livreId==0)throw new FunctionalException("les données sont incorrectes");
		else {
			Livre livre = livreDao.findById(livreId);
			if(livre==null) throw new NotFoundException("Livre non trouvé en base de données");
			else {
				int exemplaire = livre.getExemplaire();
				int nbPretsEnCours = 0;
				Set<Pret> listePret = livre.getPrets();


				for (Pret next : listePret) {
					if (next.getDateEffective() == null) nbPretsEnCours++;

				}
				if (exemplaire <= nbPretsEnCours) livre.setDisponible(false);
				else livre.setDisponible(true);

				livreDao.update(livre);
			}



		}
	}


	/**
	 * @param pretId
	 * @throws NotFoundException
	 * @throws FunctionalException
	 */
	@Override
	public void deletePret(Integer pretId) throws NotFoundException, FunctionalException  {
		if(pretId <= 0) throw new FunctionalException("Données incorrectes");

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
	private void sendSimpleMessage(Mail mail, String template) throws MessagingException, IOException, TemplateException {
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
	@Transactional
	public List<Pret> getPretsEnCoursByUser(Integer utilisateurId) throws FunctionalException {
		listeReturn=pretDao.findPretEnCoursByUser(utilisateurId);
		if (listeReturn==null) throw new FunctionalException("Pas de prêt en cours trouvé");
		return listeReturn;
	}

	

}
