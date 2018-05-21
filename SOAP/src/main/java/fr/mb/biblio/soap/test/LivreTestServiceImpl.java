package fr.mb.biblio.soap.test;



import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.mb.biblio.dao.contract.GenericDAO;
import fr.mb.biblio.dao.contract.UtilisateurDao;
import fr.mb.biblio.dao.impl.UtilisateurDaoImpl;
import fr.mb.biblio.models.beans.Livre;
import fr.mb.biblio.models.beans.Utilisateur;


@Service
public class LivreTestServiceImpl implements LivreTestService {
	
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
