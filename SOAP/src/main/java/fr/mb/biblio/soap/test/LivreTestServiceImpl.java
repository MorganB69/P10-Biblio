package fr.mb.biblio.soap.test;



import javax.inject.Inject;

import fr.mb.biblio.soapbusiness.test.LivreTestManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.mb.biblio.dao.contract.GenericDAO;
import fr.mb.biblio.dao.contract.UtilisateurDao;
import fr.mb.biblio.dao.impl.UtilisateurDaoImpl;
import fr.mb.biblio.models.beans.Livre;
import fr.mb.biblio.models.beans.Utilisateur;


@Service
public class LivreTestServiceImpl implements LivreTestService {


	@Autowired
	LivreTestManager livreTestManager;
	
	
	
	public Livre getLivre(Integer id) {
		Livre livre;
		livre= livreTestManager.getLivre(id);
		return livre;
	}
	
	public void insert(Utilisateur user) {
	livreTestManager.insert(user);
	}

}
