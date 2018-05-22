package fr.mb.biblio.soap.livreService.impl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import fr.mb.biblio.dao.contract.LivreDao;
import fr.mb.biblio.models.beans.Livre;
import fr.mb.biblio.models.exception.FunctionalException;
import fr.mb.biblio.models.exception.NotFoundException;
import fr.mb.biblio.models.recherche.RechercheLivre;
import fr.mb.biblio.soap.livreService.contract.LivreService;

/**
 * Implémentation du service de gestion des livres
 * @author Morgan
 *
 */
public class LivreServiceImpl implements LivreService {
	
	/**
	 * Dao à injecter
	 */
	@Inject
	LivreDao livreDao;
	
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

	@Override
	@Transactional
	public Livre getLivreById(Integer id) throws NotFoundException {
		livreReturn=livreDao.findById(id);
		if (livreReturn==null) throw new NotFoundException("Le livre n'a pas été trouvé");
		
		return livreReturn;
	}

	@Override
	public List<Livre> getAllLivres(Integer offset, Integer nb) {
		listeReturn=livreDao.findAllOffset(offset, nb);
		return listeReturn;
	}

	@Override
	public List<Livre> rechercheLivres(RechercheLivre recherche, Integer offset, Integer nb) {
		listeReturn=livreDao.rechercheLivres(recherche, offset, nb);
		return listeReturn;
	}

}
