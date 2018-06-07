package fr.mb.biblio.webapp.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;


import fr.mb.biblio.webapp.services.livre.Livre;
import fr.mb.biblio.webapp.services.livre.LivreService;



public class IndexAction extends ActionSupport implements SessionAware {
	
	
	@Inject
	private LivreService livreClient;
	
	/**
	 * Permet de stocker les objets en session
	 */
	private Map<String, Object> session;
	
	/**
	 * Nombre de sites à afficher par page
	 */
	private Integer pageSize = 3;
	
	/**
	 * Liste pour l'affichage de livre
	 */
	private List<Livre> listLivre = new ArrayList<Livre>();
	
	/**
	 * Page sélectionnée et permet de définir l'Offset pour le changement de page
	 */
	private Integer start = 0;
	
	 public String execute() throws Exception {
		 
		 listLivre=livreClient.getAllLivres(start, pageSize);

	        return SUCCESS;
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
}
