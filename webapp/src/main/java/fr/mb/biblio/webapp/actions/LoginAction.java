package fr.mb.biblio.webapp.actions;

import java.util.Map;



import fr.mb.biblio.webappBusiness.contract.LoginWebManager;
import fr.mb.biblio.webappConsumer.services.identification.Utilisateur;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;


import org.springframework.beans.factory.annotation.Autowired;


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
		
	@Autowired
	private LoginWebManager loginWebManager;
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

		try {
		
        if (!StringUtils.isAllEmpty(login, password)) {
			this.user=loginWebManager.identification(login, password);

			this.session.put("user", user);
			this.session.put("mdpUser", password);
			this.addActionMessage("utilisateur connecté : "+ user.getIdentifiant());
			result = ActionSupport.SUCCESS;

		}

		}
		catch(Exception e) {
			addActionError("Service momentanément indisponible");
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
		this.session.remove("lastAction");
		this.session.remove("url");
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
