package fr.mb.biblio.batch;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;


import fr.mb.biblio.batch.security.PropertyLoader;
import fr.mb.biblio.batch.security.UTPasswordCallback;
import fr.mb.biblio.batch.service.Exception_Exception;
import fr.mb.biblio.batch.service.FunctionalException_Exception;
import fr.mb.biblio.batch.service.PretService;
import fr.mb.biblio.batch.service.PretServiceImplService;

public class Main {

	public static void main(String[] args) {
		
		String username="";
		//RECUPERATION DE L'IDENTIFIANT DANS LE FICHIER PROPERTIES
		try{
	         // chargement des propriétés
	         Properties prop = PropertyLoader.load("src/main/resources/connect.properties");
	         username=prop.getProperty("identifiant");
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }	
		
		
		

		
	//CREATION DU SERVICE CLIENT	
	PretServiceImplService serv = new PretServiceImplService();
	PretService hw=serv.getPretServiceImplPort();
	
	//RECUPERATION DU CLIENT
	Client client = ClientProxy.getClient(hw);
	Endpoint endpoint = client.getEndpoint();
	
	//CONFIGURATION DE LA SECURITE POUR ACCEDER AU WEB SERVICE
	Map props = new HashMap();
	props.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
	props.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
	props.put(WSHandlerConstants.PW_CALLBACK_CLASS, UTPasswordCallback.class.getName());
	props.put(WSHandlerConstants.USER, username);
	
	WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(props);
	endpoint.getOutInterceptors().add(wssOut);
	
	//LANCEMENT DU SERVICE DE RELANCE DES MAILS EN RETARD
	try {
		hw.relanceMailRetards();
	} catch (Exception_Exception | FunctionalException_Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

}
