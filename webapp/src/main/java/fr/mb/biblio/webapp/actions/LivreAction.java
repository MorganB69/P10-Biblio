package fr.mb.biblio.webapp.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import fr.mb.biblio.webapp.services.livre.FunctionalException_Exception;
import fr.mb.biblio.webapp.services.livre.Livre;
import fr.mb.biblio.webapp.services.livre.LivreService;
import fr.mb.biblio.webapp.services.livre.RechercheLivre;

/**
 * Action pour la recherche de livre
 * @author Morgan
 *
 */
public class LivreAction extends ActionSupport implements SessionAware {
	
	//---------ATTRIBUTS--------------
	@Inject
	private LivreService livreClient;
	
	/**
	 * Permet de stocker les objets en session
	 */
	private Map<String, Object> session;
	
	/**
	 * Nombre de sites à afficher par page
	 */
	private Integer pageSize = 10;
	
	/**
	 * Liste pour l'affichage de livre
	 */
	private List<Livre> listLivre = new ArrayList<Livre>();
	
	/**
	 * Page sélectionnée et permet de définir l'Offset pour le changement de page
	 */
	private Integer start = 0;
	
	private String titre;
	
	private RechercheLivre recherche=new RechercheLivre();
	
	private static final Logger logger = LogManager.getLogger(LivreAction.class);
	
	
	//---------------------ACTIONS---------------------------------
	
	public String recherche() {
		
		if(titre!=null&&titre!=""){
		try {
			
			recherche.setTitre(titre);
			listLivre=livreClient.rechercheLivres(recherche, start,pageSize);
			if(listLivre==null||listLivre.isEmpty())addActionError("Aucun résultat trouvé");
			
		} catch (FunctionalException_Exception e) {
				addActionError(e.getMessage());
		}
		
		}
		
		return (ActionSupport.SUCCESS);
	}
	
	
	
	
	//---------------------GETTERS//SETTERS-------------------------
	
	
	public LivreService getLivreClient() {
		return livreClient;
	}

	public void setLivreClient(LivreService livreClient) {
		this.livreClient = livreClient;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<Livre> getListLivre() {
		return listLivre;
	}

	public void setListLivre(List<Livre> listLivre) {
		this.listLivre = listLivre;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}




	public String getTitre() {
		return titre;
	}




	public void setTitre(String titre) {
		this.titre = titre;
	}

}
