package fr.mb.biblio.webapp.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import fr.mb.biblio.webapp.services.pret.FunctionalException_Exception;
import fr.mb.biblio.webapp.services.pret.Pret;
import fr.mb.biblio.webapp.services.pret.PretService;
import fr.mb.biblio.webapp.services.pret.Utilisateur;

/**
 * Action pour la gestion des prêts
 * @author Morgan
 *
 */
public class PretAction extends ActionSupport implements SessionAware {
	//---------ATTRIBUTS--------------
		/**
		 * Client service de pret
		 */
		@Inject
		private PretService pretClient;
		
		/**
		 * Permet de stocker les objets en session
		 */
		private Map<String, Object> session;
		
		
		/**
		 *Pour la gestion de l'utilisateur connecté 
		 */
		private Utilisateur user;
		
		private List <Pret> listPret=new ArrayList<Pret>();
		
		
		//--------------------ACTIONS--------------------
		
		public String getPrets() {
			this.user=(Utilisateur) session.get("user");
			try {
				this.listPret=pretClient.getPretsEnCoursByUser(this.user.getIdUtilisateur());
			} catch (FunctionalException_Exception e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
			
			
			return Action.SUCCESS;
		}
		
		
		
		

		public PretService getPretClient() {
			return pretClient;
		}

		public void setPretClient(PretService pretClient) {
			this.pretClient = pretClient;
		}

		public Map<String, Object> getSession() {
			return session;
		}

		public void setSession(Map<String, Object> session) {
			this.session = session;
		}





		public Utilisateur getUser() {
			return user;
		}





		public void setUser(Utilisateur user) {
			this.user = user;
		}





		public List<Pret> getListPret() {
			return listPret;
		}





		public void setListPret(List<Pret> listPret) {
			this.listPret = listPret;
		}
		
		
}
