package fr.mb.biblio.soap;

import java.io.IOException;

import javax.inject.Inject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;

import fr.mb.biblio.dao.contract.UtilisateurDao;
import fr.mb.biblio.models.beans.Utilisateur;

public class ServerPasswordCallback implements CallbackHandler{
	
	@Inject
	UtilisateurDao utilisateurDao;

	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
		
		
			String identifiant = pc.getIdentifier();
			Utilisateur user = utilisateurDao.getUser(identifiant);
			
		

            pc.setPassword(user.getMdp());
        
		
	
	}
}
