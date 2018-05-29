package fr.mb.biblio.soap.pretService.impl;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
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
 * @author Morgan
 *
 */
public class PretServiceImpl implements PretService {
	
	

	
	/**
	 * Dao pour les prets
	 */
	@Inject
	PretDao pretDao;
	@Inject
	UtilisateurDao utilisateurDao;
	@Inject
	LivreDao livreDao;
	
	/**
	 * Pret à retourner
	 */
	Pret pretReturn;
	
	/**
	 * Liste de pret a retourner
	 */
	List <Pret>listeReturn;
	
	@Value( "${dureePret}" )
	Integer DUREEPRET;
	
	

	@Override
	@Transactional
	public Pret nouveauPret(Integer livreId, Integer emprunteurId) throws FunctionalException {
		
			
		Pret pret=new Pret();
		Utilisateur emprunteur=utilisateurDao.findById(emprunteurId);
		Livre livre=livreDao.findById(livreId);
		LocalDate dateDebut=LocalDate.now();
		LocalDate dateFin=dateDebut.plusDays(DUREEPRET);
		pret.setDateDebut(dateDebut);
		pret.setDateFin(dateFin);
		pret.setUtilisateur(emprunteur);
		pret.setLivre(livre);
		pret.setProlonge(false);
		
		pretDao.persist(pret);
		
		return pret;
		}

	

	@Override
	@Transactional
	public Pret prolongerPret(Pret pret, Utilisateur user) throws FunctionalException {
		return pret;

	}

	@Override
	@Transactional
	public String retourPret(Pret pret) throws FunctionalException {
		String statut="Le prêt est terminé";
		return statut;

	}

	@Override
	@Transactional
	public Pret getPretById(Integer id) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Pret> getPretsEnCours() throws FunctionalException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Pret> getPretsProlonges() throws FunctionalException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Pret> getPretsRetards() throws FunctionalException {
		// TODO Auto-generated method stub
		return null;
	}

}
