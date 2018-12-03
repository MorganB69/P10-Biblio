package fr.mb.biblio.soap.livreService.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import fr.mb.biblio.soapbusiness.livreManager.contract.LivreManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.mb.biblio.dao.contract.GenericDAO;
import fr.mb.biblio.dao.contract.LivreDao;
import fr.mb.biblio.dao.impl.AbstractDaoImpl;
import fr.mb.biblio.models.beans.Genre;
import fr.mb.biblio.models.beans.Livre;
import fr.mb.biblio.models.beans.Ouvrage;
import fr.mb.biblio.models.beans.Pret;
import fr.mb.biblio.models.exception.FunctionalException;
import fr.mb.biblio.models.exception.NotFoundException;
import fr.mb.biblio.models.recherche.RechercheLivre;
import fr.mb.biblio.soap.livreService.contract.LivreService;
import fr.mb.biblio.soap.test.CreationLivreAleatoire;
import fr.mb.biblio.soap.test.ListeLivre;

/**
 * Implémentation du service de gestion des livres
 * @author Morgan
 *
 */
@Service
@Transactional
public class LivreServiceImpl implements LivreService {
	
	private static Logger logger = LogManager.getLogger(LivreServiceImpl.class);
	


	@Autowired
	LivreManager livreManager;
	
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
		livreManager.insert(livre);
	}

	/* (non-Javadoc)
	 * @see fr.mb.biblio.soap.livreManager.contract.LivreManager#getLivreById(java.lang.Integer)
	 */
	@Override
	@Transactional
	public Livre getLivreById(Integer id) throws NotFoundException {
		livreReturn=livreManager.getLivreById(id);
		return livreReturn;
	}

	/* (non-Javadoc)
	 * @see fr.mb.biblio.soap.livreManager.contract.LivreManager#getAllLivres(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	@Transactional
	public List<Livre> getAllLivres(Integer offset, Integer nb) throws FunctionalException {
		listeReturn=livreManager.getAllLivres(offset,nb);
		return listeReturn;
	}

	/* (non-Javadoc)
	 * @see fr.mb.biblio.soap.livreManager.contract.LivreManager#rechercheLivres(fr.mb.biblio.models.recherche.RechercheLivre, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	@Transactional
	public List<Livre> rechercheLivres(RechercheLivre recherche, Integer offset, Integer nb) throws FunctionalException {
		listeReturn=livreManager.rechercheLivres(recherche,offset,nb);
		return listeReturn;
	}
	
	@Transactional
	public void insertionExemple() throws FunctionalException {
		livreManager.insertionExemple();
	}
	
	@Transactional
	public void creationAleatoireLivre(Integer nb) throws FunctionalException {
		livreManager.creationAleatoireLivre(nb);
	}

	/* (non-Javadoc)
	 * @see fr.mb.biblio.soap.livreManager.contract.LivreManager#dateRetourLivre(java.lang.Integer)
	 */
	@Override
	@Transactional
	public String dateRetourLivre(Integer idLivre) throws FunctionalException, NotFoundException {
		String dateFormat = livreManager.dateRetourLivre(idLivre);
		return dateFormat;
	}

	@Override
	public Long countLivres(RechercheLivre recherche) {
		Long nb=livreManager.countLivres(recherche);
		return nb;
	}
	
	

}
