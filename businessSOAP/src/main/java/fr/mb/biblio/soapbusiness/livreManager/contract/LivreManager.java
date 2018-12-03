package fr.mb.biblio.soapbusiness.livreManager.contract;

import fr.mb.biblio.models.beans.Livre;
import fr.mb.biblio.models.exception.FunctionalException;
import fr.mb.biblio.models.exception.NotFoundException;
import fr.mb.biblio.models.recherche.RechercheLivre;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

/**
 * Service permettant la gestion d'un livre
 * @author Morgan
 *
 */

public interface LivreManager {
	
	/**
	 * Rajout d'un livre
	 * @param livre
	 * @throws FunctionalException
	 */

	public void insert( Livre livre) throws FunctionalException;

	/**
	 * Obtention d'un livre via son id
	 * @param id
	 * @return
	 * @throws NotFoundException
	 */

	public Livre getLivreById( Integer id) throws NotFoundException;

	/**
	 * Obtention de tous les livres selon un offset et un nb de pages
	 * @param offset
	 * @param nb
	 * @return
	 * @throws FunctionalException
	 */

	public List<Livre> getAllLivres( Integer offset, Integer nb) throws FunctionalException;

	/**
	 * Obtention du nombre de résultat de la recherche
	 * @param recherche
	 * @return
	 * @throws FunctionalException
	 */

	public Long countLivres( RechercheLivre recherche);

	/**
	 * Obtention des livres selon des critères de recherche, un offset et un nb de pages
	 * @param recherche
	 * @param offset
	 * @param nb
	 * @return
	 * @throws FunctionalException
	 */
	public List<Livre> rechercheLivres(RechercheLivre recherche, Integer offset,Integer nb) throws FunctionalException;


	/**
	 * Insertion de livres rentrés manuellement
	 * @throws FunctionalException
	 */
	public void insertionExemple() throws FunctionalException;

	/**
	 * Insertion de livres aléatoires
	 * @param nb
	 * @throws FunctionalException
	 */
	public void creationAleatoireLivre(Integer nb) throws FunctionalException;

	/**
	 * Trouver la date de retour d'un livre via son id
	 * @param nb
	 * @throws FunctionalException
	 */
	public String dateRetourLivre(Integer idLivre) throws FunctionalException, NotFoundException;

	
	}

