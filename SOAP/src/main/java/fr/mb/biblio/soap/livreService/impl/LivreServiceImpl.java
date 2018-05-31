package fr.mb.biblio.soap.livreService.impl;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.mb.biblio.dao.contract.GenericDAO;
import fr.mb.biblio.dao.contract.LivreDao;
import fr.mb.biblio.dao.impl.AbstractDaoImpl;
import fr.mb.biblio.models.beans.Genre;
import fr.mb.biblio.models.beans.Livre;
import fr.mb.biblio.models.beans.Ouvrage;
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
@Transactional
public class LivreServiceImpl implements LivreService {
	
	private static Logger logger = LogManager.getLogger(LivreServiceImpl.class);
	
	/**
	 * Dao à injecter
	 */
	@Inject
	LivreDao livreDao;
	@Inject
	GenericDAO<Ouvrage> ouvrageDao;
	@Inject
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
	 * @see fr.mb.biblio.soap.livreService.contract.LivreService#insert(fr.mb.biblio.models.beans.Livre)
	 */
	@Override
	@Transactional
	public void insert(Livre livre) throws FunctionalException {
		if (livre==null) throw new FunctionalException("Le livre est null");
	
		else livreDao.persist(livre);


	}

	/* (non-Javadoc)
	 * @see fr.mb.biblio.soap.livreService.contract.LivreService#getLivreById(java.lang.Integer)
	 */
	@Override
	@Transactional
	public Livre getLivreById(Integer id) throws NotFoundException {
		
		
		livreReturn=livreDao.findById(id);
		if (livreReturn==null) throw new NotFoundException("Le livre n'a pas été trouvé");
		
		return livreReturn;
	}

	/* (non-Javadoc)
	 * @see fr.mb.biblio.soap.livreService.contract.LivreService#getAllLivres(java.lang.Integer, java.lang.Integer)
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
	 * @see fr.mb.biblio.soap.livreService.contract.LivreService#rechercheLivres(fr.mb.biblio.models.recherche.RechercheLivre, java.lang.Integer, java.lang.Integer)
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
	
	

}
