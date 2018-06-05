package fr.mb.biblio.webapp.actions;

import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;


import fr.mb.biblio.webapp.services.identification.IdentificationService;
import fr.mb.biblio.webapp.services.identification.NotFoundException_Exception;
import fr.mb.biblio.webapp.services.identification.Utilisateur;





/**
 * Action d'identification de l'utilisateur
 * @author Morgan
 *
 */
public class LoginAction extends ActionSupport implements SessionAware{
	
	/**
	 *objet de session 
	 */
	private Map<String, Object> session;
		
	@Inject
	private IdentificationService identificationClient;
	/**
	 *Utilisateur voulant se logger 
	 */
	private Utilisateur user;
	/**
	 *login saisi de l'utilisateur 
	 */
	private String login;
	/**
	 *mdp saisi de l'utilisateur 
	 */
	private String password;
	
	private static final Logger logger = LogManager.getLogger(LoginAction.class);
	
	
	
	//Methodes
	/**
	 * Méthode pour se login
	 * @return
	 */
	public String doLogin() {
		String result = ActionSupport.INPUT;
        if (!StringUtils.isAllEmpty(login, password)) {
            try {
                this.user=identificationClient.identification(login, password);  

                	this.session.put("user", user);
                	this.session.put("mdpUser", password);
                	this.addActionMessage("utilisateur connecté : "+ user.getIdentifiant());
                result = ActionSupport.SUCCESS;
                
            } catch (NotFoundException_Exception pEx) {
                this.addActionError("Identifiant ou mot de passe invalide !");
                
                
            }
        }
        
        return result;
		
	}
	
	/**
	 * Méthode pour se logout
	 * @return
	 */
	public String doLogout() {
		this.session.remove("user");
		this.session.remove("mdpUser");
		return ActionSupport.SUCCESS;
	}
	
	
	
	
	
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map<String, Object> getSession() {
		return session;
	}

}
