package fr.mb.biblio.soapbusiness.livreManager.impl;

import fr.mb.biblio.dao.contract.GenericDAO;
import fr.mb.biblio.dao.contract.LivreDao;
import fr.mb.biblio.models.beans.Genre;
import fr.mb.biblio.models.beans.Livre;
import fr.mb.biblio.models.beans.Ouvrage;
import fr.mb.biblio.models.beans.Pret;
import fr.mb.biblio.models.exception.FunctionalException;
import fr.mb.biblio.models.exception.NotFoundException;
import fr.mb.biblio.models.recherche.RechercheLivre;
import fr.mb.biblio.soapbusiness.livreManager.contract.LivreManager;
import fr.mb.biblio.soapbusiness.test.CreationLivreAleatoire;
import fr.mb.biblio.soapbusiness.test.ListeLivre;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

/**
 * Implémentation du service de gestion des livres
 * @author Morgan
 *
 */
@Service
@Transactional
public class LivreManagerImpl implements LivreManager {
	
	private static Logger logger = LogManager.getLogger(LivreManagerImpl.class);
	
	/**
	 * Dao à injecter
	 */
	@Autowired
	LivreDao livreDao;
	@Autowired
	GenericDAO<Ouvrage> ouvrageDao;
	@Autowired
	GenericDAO<Genre> genreDao;
	
	/**
	 * Livre à retourner
	 */
	Livre livreReturn;
	
	/**
	 * Liste de livres à retourner
	 */
	List<Livre>listeReturn;

	/* (non-Javadoc)
	 * @see fr.mb.biblio.soap.livreManager.contract.LivreManager#insert(fr.mb.biblio.models.beans.Livre)
	 */
	@Override
	@Transactional
	public void insert(Livre livre) throws FunctionalException {
		if (livre==null) throw new FunctionalException("Le livre est null");
	
		else livreDao.persist(livre);


	}

	/* (non-Javadoc)
	 * @see fr.mb.biblio.soap.livreManager.contract.LivreManager#getLivreById(java.lang.Integer)
	 */
	@Override
	@Transactional
	public Livre getLivreById(Integer id) throws NotFoundException {
		
		
		livreReturn=livreDao.findById(id);
		if (livreReturn==null) throw new NotFoundException("Le livre n'a pas été trouvé");
		
		return livreReturn;
	}

	/* (non-Javadoc)
	 * @see fr.mb.biblio.soap.livreManager.contract.LivreManager#getAllLivres(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	@Transactional
	public List<Livre> getAllLivres(Integer offset, Integer nb) throws FunctionalException {
		if(offset==null||offset<0||nb==null||nb<=0) throw new FunctionalException("Données invalides");
		else listeReturn=livreDao.findAllOffset(offset, nb);
			if(listeReturn==null) throw new FunctionalException("Liste vide");
			
		return listeReturn;
	}

	/* (non-Javadoc)
	 * @see fr.mb.biblio.soap.livreManager.contract.LivreManager#rechercheLivres(fr.mb.biblio.models.recherche.RechercheLivre, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	@Transactional
	public List<Livre> rechercheLivres(RechercheLivre recherche, Integer offset, Integer nb) throws FunctionalException {

		if(recherche.getTitre().length()<=3||recherche.getTitre()==null) throw new FunctionalException("Insérer plus de 3 caractères");
		else if(offset==null||offset<0||nb==null||nb<=0) throw new FunctionalException("Données invalides");
			else {
			listeReturn=livreDao.rechercheLivres(recherche, offset, nb);
				if(listeReturn==null) throw new FunctionalException("Liste vide");
				else {
					for (Iterator iterator = listeReturn.iterator(); iterator.hasNext();) {
						Livre livre = (Livre) iterator.next();

		}}}
		return listeReturn;
	}
	
	@Transactional
	public void insertionExemple() throws FunctionalException {
		List <Ouvrage> listOuvrage = ouvrageDao.findAll();
		List<Genre>listGenre= genreDao.findAll();
		
		ListeLivre listeExemple= new ListeLivre(listOuvrage,listGenre);
		
		List<Livre> liste=listeExemple.getListe();
		for (Iterator iterator = liste.iterator(); iterator.hasNext();) {
			Livre livre = (Livre) iterator.next();
			if (livre==null) throw new FunctionalException("Le livre est null");
			else livreDao.persist(livre);
			
		}
	}
	
	@Transactional
	public void creationAleatoireLivre(Integer nb) throws FunctionalException {
		List <Ouvrage> listOuvrage = ouvrageDao.findAll();
		List<Genre>listGenre= genreDao.findAll();
		
		CreationLivreAleatoire listeExemple= new CreationLivreAleatoire(listOuvrage,listGenre,nb);
		
		List<Livre> liste=listeExemple.getListe();
		for (Iterator iterator = liste.iterator(); iterator.hasNext();) {
			Livre livre = (Livre) iterator.next();
			if (livre==null) throw new FunctionalException("Le livre est null");
			else livreDao.persist(livre);
			
		}
	}

	/* (non-Javadoc)
	 * @see fr.mb.biblio.soap.livreManager.contract.LivreManager#dateRetourLivre(java.lang.Integer)
	 */
	@Override
	@Transactional
	public String dateRetourLivre(Integer idLivre) throws FunctionalException, NotFoundException {
		LocalDate dateRetour = null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String dateFormat="";
		livreReturn=livreDao.findById(idLivre);
		if (livreReturn==null) throw new NotFoundException("Le livre n'a pas été trouvé");
		
		for (Iterator iterator = livreReturn.getPrets().iterator(); iterator.hasNext();) {
			Pret pret = (Pret) iterator.next();
			if(pret.getDateEffective()==null) dateRetour=pret.getDateFin();
			
		}
		if (dateRetour==null) throw new FunctionalException ("Pas de date de retour trouvée");
		else dateFormat=dateRetour.format(formatter);
		
		
		return dateFormat;
	}

	@Override
	public Long countLivres(RechercheLivre recherche) {
		Long nb=livreDao.countLivres(recherche);
		return nb;
	}
	
	

}
