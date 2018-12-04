package fr.mb.biblio.webappConsumer.config;

import com.opensymphony.xwork2.ActionContext;
import fr.mb.biblio.webapp.services.identification.Utilisateur;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.wss4j.common.ext.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.Map;


public class ClientPasswordCallback implements CallbackHandler, SessionAware {
	
	/**
	 *Utilisateur voulant se logger 
	 */
	private Utilisateur user;
	
	/**
	 *objet de session 
	 */
	private Map<String, Object> session;
	
	private static final Logger logger = LogManager.getLogger(ClientPasswordCallback.class);


    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
    	session = ActionContext.getContext().getSession();
    	WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
        user = (Utilisateur) session.get("user");
        String mdp= (String) session.get("mdpUser");

        pc.setIdentifier(user.getIdentifiant());
        pc.setPassword(mdp);
    }


	public Utilisateur getUser() {
		return user;
	}


	public void setUser(Utilisateur user) {
		this.user = user;
	}


	public Map<String, Object> getSession() {
		return session;
	}


	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	
}
