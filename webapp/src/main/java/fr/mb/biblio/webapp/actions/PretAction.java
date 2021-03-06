package fr.mb.biblio.webapp.actions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



import fr.mb.biblio.webappBusiness.contract.PretWebManager;
import fr.mb.biblio.webappConsumer.services.pret.FunctionalException_Exception;
import fr.mb.biblio.webappConsumer.services.pret.NotFoundException_Exception;
import fr.mb.biblio.webappConsumer.services.pret.Pret;
import fr.mb.biblio.webappConsumer.services.identification.Utilisateur;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;


import com.opensymphony.xwork2.ActionSupport;



import org.springframework.beans.factory.annotation.Autowired;


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
		@Autowired
		private PretWebManager pretWebManager;
		
		/**
		 * Permet de stocker les objets en session
		 */
		private Map<String, Object> session;
		
		
		/**
		 *Pour la gestion de l'utilisateur connecté 
		 */
		private Utilisateur user;
		
		/**
		 *Liste des prets a obtenir 
		 */
		private List <Pret> listPret=new ArrayList<Pret>();
		
		/**
		 * Id du pret utilisé pour prolonger un prêt
		 */
		private Integer idPret;
		
		/**
		 *Pour l'affichage du nombre de jour de retard 
		 */
		private Integer nbJourRetard;
		
		LocalDate dateJour;

		
		/**
		 * Date du jour pour vérifier si un pret est en retard côté client
		 */
		private static final Logger logger = LogManager.getLogger(PretAction.class);
		//--------------------ACTIONS--------------------
		
		/**
		 * Affichage des prêts de l'utilisateur en session
		 * @return
		 */
		public String getPrets() {
			

			this.user=(Utilisateur) session.get("user");

			dateJour=LocalDate.now();



			try {
				listPret=pretWebManager.getPretsEnCoursByUser(this.user.getIdUtilisateur());
			} catch (FunctionalException_Exception e) {
				e.getMessage();
			}



			return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
		}
		
		public String prolongerPret() {
			try {
			this.user=(Utilisateur) session.get("user");
			try {
				pretWebManager.prolongerPret(idPret, user.getIdUtilisateur());
			} catch (FunctionalException_Exception e) {
				addActionError("Le prêt ne plus être prolongé");
			} catch (NotFoundException_Exception e) {
				addActionError(e.getMessage());
			}
			}
			catch(Exception e) {
				addActionError("Le service est momentanément indisponible");
			}
			return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
		}

		public String startRelance() {
			this.user = (Utilisateur) session.get("user");
			try {
				pretWebManager.setOptionRelance(user.getIdUtilisateur(), true);
				this.user.setRelance(true);
				this.session.put("user",this.user);


			} catch (fr.mb.biblio.webappConsumer.services.user.NotFoundException_Exception e) {
				addActionError(e.getMessage());
			} catch (fr.mb.biblio.webappConsumer.services.user.FunctionalException_Exception e) {
				addActionError("L'option  ne peut pas être mise à jour");
			}
			return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
		}
	public String stopRelance() {
		this.user = (Utilisateur) session.get("user");
		try {
			pretWebManager.setOptionRelance(user.getIdUtilisateur(), false);
			this.user.setRelance(false);
			this.session.put("user",this.user);


		} catch (fr.mb.biblio.webappConsumer.services.user.NotFoundException_Exception e) {
			addActionError(e.getMessage());
		} catch (fr.mb.biblio.webappConsumer.services.user.FunctionalException_Exception e) {
			addActionError("L'option  ne peut pas être mise à jour");
		}
		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
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

		public Integer getIdPret() {
			return idPret;
		}

		public void setIdPret(Integer idPret) {
			this.idPret = idPret;
		}

		public Integer getNbJourRetard() {
			return nbJourRetard;
		}

		public void setNbJourRetard(Integer nbJourRetard) {
			this.nbJourRetard = nbJourRetard;
		}

		public LocalDate getDateJour() {
			return dateJour;
		}

		public void setDateJour(LocalDate dateJour) {
			this.dateJour = dateJour;
		}

		




		
		
}
