package fr.mb.biblio.soap.pretService.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.transaction.annotation.Transactional;

import fr.mb.biblio.dao.contract.LivreDao;
import fr.mb.biblio.dao.contract.PretDao;
import fr.mb.biblio.dao.contract.UtilisateurDao;
import fr.mb.biblio.models.beans.Livre;
import fr.mb.biblio.models.beans.Pret;
import fr.mb.biblio.models.beans.Utilisateur;
import fr.mb.biblio.models.exception.FunctionalException;
import fr.mb.biblio.models.exception.NotFoundException;
import fr.mb.biblio.soap.pretService.contract.PretService;

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

			// Vérification que le prêt est en retard
			if (LocalDate.now().isAfter(dateFin)) {
				// Prolongation de la date de fin
				dateFin=dateFin.plusDays(DUREEPRET);
				// Modification des paramètres
				pret.setDateFin(dateFin);
				pret.setProlonge(true);

				pretDao.update(pret);
			}

			else
				throw new FunctionalException("Le prêt n'est pas encore en retard");

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

	@Override
	@Transactional
	public List<Pret> getPretsEnCours() throws FunctionalException {
		listeReturn=pretDao.findPretEnCours(0, 12);
		if (listeReturn==null) throw new FunctionalException("Pas de prêt en cours trouvé");
		return listeReturn;
	}

	@Override
	@Transactional
	public List<Pret> getPretsProlonges() throws FunctionalException {
		listeReturn=pretDao.findPretEnCoursProlonge(0, 12);
		if (listeReturn==null) throw new FunctionalException("Pas de prêt en cours prolongé trouvé");
		return listeReturn;
	}

	@Override
	@Transactional
	public List<Pret> getPretsRetards() throws FunctionalException {
		LocalDate dateJour=LocalDate.now();
		listeReturn=pretDao.findPretRetard(0, 12, dateJour);
		if (listeReturn==null) throw new FunctionalException("Pas de prêt en cours en retard trouvé");
		return listeReturn;
	}

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

	@Override
	public void relanceMailRetards() throws FunctionalException {
		SimpleMailMessage message = new SimpleMailMessage();
		String to="brighi.morgan@wanadoo.fr";
		String subject="test";
		String text="Test de relance de mail";
        message.setTo(to); 
        message.setSubject(subject); 
        message.setText(text);
        emailSender.send(message);
		
	}

}
