package fr.mb.biblio.webappConsumer.config;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.wss4j.common.ext.WSPasswordCallback;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;



public class ClientPasswordCallback implements CallbackHandler{
	
	/**
	 *Utilisateur voulant se logger 
	 */

	
	/**
	 *objet de session 
	 */
	String user;


	String mdp;
	
	private static final Logger logger = LogManager.getLogger(ClientPasswordCallback.class);


    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {

    	WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
    	user=System.getenv("LOGINSERVICE");
    	mdp=System.getenv("MDPSERVICE");
	

        pc.setIdentifier(user);
        pc.setPassword(mdp);
    }





	
}
