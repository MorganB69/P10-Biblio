package fr.mb.biblio.soap.test;



import javax.inject.Inject;

import org.springframework.stereotype.Service;

import fr.mb.biblio.dao.impl.UtilisateurHome;
import fr.mb.biblio.models.beans.Livre;
import fr.mb.biblio.models.beans.Utilisateur;


@Service
public class LivreTestServiceImpl implements LivreTestService {
	
	@Inject
	private UtilisateurHome utilisateurDao;
	
	
	
	public Livre getLivre(Integer id) {
		Livre livre=new Livre();
		livre.setIdLivre(id);
		return livre;
	}
	
	public void insert() {
		Utilisateur user=new Utilisateur();
		user.setIdentifiant("Morgan");
		user.setMail("brighi.morgan@mail.com");
		user.setMdp("azerty");
		user.setNom("Brighi");
		user.setPrenom("Morgan");
		
		this.utilisateurDao.persist(user);
		
	}

}
