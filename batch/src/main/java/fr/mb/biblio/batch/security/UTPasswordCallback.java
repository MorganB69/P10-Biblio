package fr.mb.biblio.batch.security;

import java.io.IOException;
import java.util.Properties;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;

public class UTPasswordCallback implements CallbackHandler {

	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		
		String username="";
		String mdp="";
		try{
	         // chargement des propriétés
	         Properties prop = PropertyLoader.load("src/main/resources/connect.properties");
	         username=prop.getProperty("identifiant");
	         mdp=prop.getProperty("mdp");
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }	
		
		for (Callback callback : callbacks) {
			WSPasswordCallback wpc = (WSPasswordCallback) callback;
			if (wpc.getIdentifier().equals(username)) {
				wpc.setPassword(mdp);
				return;
			}
		}
	}
}
