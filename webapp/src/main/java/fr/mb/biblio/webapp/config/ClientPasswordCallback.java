package fr.mb.biblio.webapp.config;

import java.io.IOException;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.wss4j.common.ext.WSPasswordCallback;

import fr.mb.biblio.webapp.services.user.Utilisateur;

public class ClientPasswordCallback implements CallbackHandler, SessionAware {
	
	
	
	/**
	 *objet de session 
	 */
	private Map<String, Object> session;


    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];

        Utilisateur user = (Utilisateur) session.get("user");
        String mdp= (String) session.get("mdpUser");

        pc.setIdentifier(user.getIdentifiant());
        pc.setPassword(mdp);
    }


	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}
}
