package fr.mb.biblio.soap.pretService.impl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.xml.ws.WebServiceContext;

import fr.mb.biblio.models.beans.Reservation;
import fr.mb.biblio.soap.resaService.contract.ResaService;
import fr.mb.biblio.soapbusiness.pretManager.contract.PretManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
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
@Service
public class PretServiceImpl implements PretService {

	private static final Logger logger = LogManager.getLogger(PretServiceImpl.class);



	 @Autowired
	PretManager pretManager;


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

	@Resource
	WebServiceContext ctx;

	/**
	 * Vérification du statut d'administrateur du user qui est loggé
	 * 
	 * @return
	 */
	private Boolean isAdmin() throws NotFoundException {

		// get detail from request headers
		String usernameFromHeader = (String) ctx.getMessageContext().get("USERNAME");
		Boolean isAdmin = pretManager.isAdmin(usernameFromHeader);
		return isAdmin;
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

		if(isAdmin()){
			pretReturn= pretManager.nouveauPret(livreId,emprunteurId);
		}
		else throw new FunctionalException("Seul un administrateur peut enregistrer un nouveau prêt");
		return pretReturn;
		}

	/* (non-Javadoc)
	 * @see fr.mb.biblio.soap.pretManager.contract.PretManager#prolongerPret(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	@Transactional
	public Pret prolongerPret(Integer pretId, Integer emprunteurId) throws FunctionalException, NotFoundException {

		pretReturn=pretManager.prolongerPret(pretId,emprunteurId);
		return pretReturn;
	}

	/* (non-Javadoc)
	 * @see fr.mb.biblio.soap.pretManager.contract.PretManager#retourPret(java.lang.Integer)
	 */
	@Override
	@Transactional
	public String retourPret(Integer pretId) throws FunctionalException, NotFoundException {
		String reponse=pretManager.retourPret(pretId);
		return reponse;
	}

	/* (non-Javadoc)
	 * @see fr.mb.biblio.soap.pretManager.contract.PretManager#getPretById(java.lang.Integer)
	 */
	@Override
	@Transactional
	public Pret getPretById(Integer pretId) throws FunctionalException, NotFoundException {
		pretReturn=pretManager.getPretById(pretId);
		return pretReturn;
	}

	/* (non-Javadoc)
	 * @see fr.mb.biblio.soap.pretManager.contract.PretManager#getPretsEnCours()
	 */
	@Override
	@Transactional
	public List<Pret> getPretsEnCours() throws FunctionalException {
		listeReturn=pretManager.getPretsEnCours();
		return listeReturn;
	}

	/* (non-Javadoc)
	 * @see fr.mb.biblio.soap.pretManager.contract.PretManager#getPretsProlonges()
	 */
	@Override
	@Transactional
	public List<Pret> getPretsProlonges() throws FunctionalException {
		listeReturn=pretManager.getPretsProlonges();
		return listeReturn;
	}

	/* (non-Javadoc)
	 * @see fr.mb.biblio.soap.pretManager.contract.PretManager#getPretsRetards()
	 */
	@Override
	@Transactional
	public List<Pret> getPretsRetards() throws FunctionalException {
		listeReturn=pretManager.getPretsRetards();
		return listeReturn;
	}

	@Override
	public List<Pret> getPretsFuturRetards() throws FunctionalException {
		listeReturn=pretManager.getPretsFuturRetard();
		return listeReturn;
	}

	/* (non-Javadoc)
	 * @see fr.mb.biblio.soap.pretManager.contract.PretManager#creationPretDate(java.lang.Integer, java.lang.Integer, java.time.LocalDate)
	 */
	@Override
	@Transactional
	public Pret creationPretDate(Integer livreId, Integer emprunteurId, LocalDate dateDebut)
			throws FunctionalException, NotFoundException {
		if (isAdmin()){
			pretReturn=pretManager.creationPretDate(livreId,emprunteurId,dateDebut);
		}
		else throw new FunctionalException("Seul un administrateur peut enregistrer un nouveau prêt");

		return pretReturn;
	}

	
	

	/* (non-Javadoc)
	 * @see fr.mb.biblio.soap.pretManager.contract.PretManager#relanceMailRetards()
	 */
	@Override
	@Transactional
	//@Scheduled(cron = "${instructionSchedularTime}")
	public void relanceMailRetards() throws Exception {
		pretManager.relanceMailRetards();
		}

		
        


	@Override
	@Transactional
	public void setDisponibilite(Integer livreId) throws FunctionalException, NotFoundException {
		pretManager.setDisponibilite(livreId);
	}


	/**
	 * @param pretId
	 * @throws NotFoundException
	 * @throws FunctionalException
	 */
	@Override
	public void deletePret(Integer pretId) throws NotFoundException, FunctionalException  {
		pretManager.deletePret(pretId);
	}




	@Override
	@Transactional
	public List<Pret> getPretsEnCoursByUser(Integer utilisateurId) throws FunctionalException {

		listeReturn=pretManager.getPretsEnCoursByUser(utilisateurId);
		return listeReturn;
	}

	

}
