package fr.mb.biblio.webapp.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;


import fr.mb.biblio.webapp.services.livre.Livre;
import fr.mb.biblio.webapp.services.livre.LivreService;



/**
 * Action pour l'index. Juste la session a besoin d'être implantée
 * @author Morgan
 *
 */
public class IndexAction extends ActionSupport implements SessionAware {
	
	/**
	 * Permet de stocker les objets en session
	 */
	private Map<String, Object> session;
	
	
	 public String execute() throws Exception {
		 
	

	        return SUCCESS;
	    }
	 
	    /**
	     * Affichage des mentions légales
	     * @return
	     */
	    public String mentions() {
	    	return ActionSupport.SUCCESS;
	    }


	public Map<String, Object> getSession() {
		return session;
	}


	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	 
	 
	 
	 

}
