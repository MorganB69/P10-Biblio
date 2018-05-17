package fr.mb.biblio.soap.test;



import fr.mb.biblio.models.test.LivreTest;


public class LivreTestServiceImpl implements LivreTestService {
	
	
	public LivreTest getLivre(Integer id) {
		LivreTest livre=new LivreTest();
		livre.setId(id);
		livre.setName("test numéro : "+id);
		return livre;
	}

}
