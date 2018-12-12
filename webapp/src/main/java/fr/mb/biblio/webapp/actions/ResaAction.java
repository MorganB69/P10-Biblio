package fr.mb.biblio.webapp.actions;

import com.opensymphony.xwork2.ActionSupport;
import fr.mb.biblio.webappBusiness.contract.ResaWebManager;
import fr.mb.biblio.webappConsumer.services.livre.Livre;
import fr.mb.biblio.webappConsumer.services.reservation.FunctionalException_Exception;
import fr.mb.biblio.webappConsumer.services.reservation.NotFoundException_Exception;
import fr.mb.biblio.webappConsumer.services.reservation.Reservation;
import fr.mb.biblio.webappConsumer.services.identification.Utilisateur;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 *
 */
public class ResaAction extends ActionSupport implements SessionAware {
    /**
     * Manager gestion des resa
     */
    @Autowired
    private ResaWebManager resaWebManager;
    /**
     * Permet de stocker les objets en session
     */
    private Map<String, Object> session;

    /**
     * Reservation
     */
    private Reservation resa;

    /**
     * Livre
     */
    private Livre livre;

    /**
     * id du livre pour une resa
     */
    private Integer idLivre;

    /**
     * utilisateur
     */
    private Utilisateur user;

    /**
     * Nouvelle reservation
     * @return
     */
    public String newResa() throws NotFoundException_Exception, FunctionalException_Exception {
       try {
            this.user = (Utilisateur) session.get("user");

            resa=resaWebManager.newReservation(this.idLivre,this.user.getIdUtilisateur());


           }catch(Exception e){
               addActionError("Le service est momentanément indisponible");
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }




    @Override
    public void setSession(Map<String, Object> session) {
        this.session=session;
    }

    public ResaWebManager getResaWebManager() {
        return resaWebManager;
    }

    public void setResaWebManager(ResaWebManager resaWebManager) {
        this.resaWebManager = resaWebManager;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public Reservation getResa() {
        return resa;
    }

    public void setResa(Reservation resa) {
        this.resa = resa;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Integer getIdLivre() {
        return idLivre;
    }

    public void setIdLivre(Integer idLivre) {
        this.idLivre = idLivre;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }
}
