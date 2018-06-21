package fr.mb.biblio.batch.security;

import java.io.IOException;
import java.util.Properties;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UTPasswordCallback implements CallbackHandler {
	
	public static String username;
	
	public static String mdp;
	
	
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		


		
		for (Callback callback : callbacks) {
			WSPasswordCallback wpc = (WSPasswordCallback) callback;
			if (wpc.getIdentifier().equals(username)) {
				wpc.setPassword(mdp);
				return;
			}
		}
	}


	public String getUsername() {
		return username;
	}

	@Value("${connect.identifiant}")
	public void setUsername(String username) {
		this.username = username;
	}


	public String getMdp() {
		return mdp;
	}

	@Value("${connect.mdp}")
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
}
