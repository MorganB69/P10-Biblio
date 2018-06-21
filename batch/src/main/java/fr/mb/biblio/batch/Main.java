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
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.mb.biblio.batch.security.PropertyLoader;
import fr.mb.biblio.batch.security.UTPasswordCallback;
import fr.mb.biblio.batch.service.Exception_Exception;
import fr.mb.biblio.batch.service.FunctionalException_Exception;
import fr.mb.biblio.batch.service.PretService;
import fr.mb.biblio.batch.service.PretServiceImplService;

public class Main {

	public static void main(String[] args) {
		

		
		
	ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:**/applicationContext*.xml");

	PretService hw=(PretService) context.getBean("pretClient");	
	
	

	
	//LANCEMENT DU SERVICE DE RELANCE DES MAILS EN RETARD
	try {
		hw.relanceMailRetards();
	} catch (Exception_Exception | FunctionalException_Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

}
