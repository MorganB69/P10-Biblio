package fr.mb.biblio.soapbusiness.test;


import fr.mb.biblio.dao.contract.UtilisateurDao;
import fr.mb.biblio.models.beans.Livre;
import fr.mb.biblio.models.beans.Utilisateur;
import org.springframework.stereotype.Service;

import javax.inject.Inject;


@Service
public class LivreTestManagerImpl implements LivreTestManager {
	
	@Inject
	private UtilisateurDao utilisateurDao;
	
	
	
	public Livre getLivre(Integer id) {
		Livre livre=new Livre();
		livre.setIdLivre(id);
		return livre;
	}
	
	public void insert(Utilisateur user) {

		
		this.utilisateurDao.persist(user);
		
	}

}
