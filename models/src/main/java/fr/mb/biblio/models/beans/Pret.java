package fr.mb.biblio.models.beans;
// Generated 17 mai 2018 21:05:11 by Hibernate Tools 5.2.10.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Pret generated by hbm2java
 */
@Entity
@Table(name = "pret", catalog = "projet")
public class Pret implements java.io.Serializable {

	private int idPret;
	private Livre livre;
	private Utilisateur utilisateur;
	private Date dateDebut;
	private Date dateFin;
	private Date dateEffective;
	private boolean prolonge;

	public Pret() {
	}

	public Pret(int idPret, Livre livre, Utilisateur utilisateur, Date dateDebut, Date dateFin, Date dateEffective,
			boolean prolonge) {
		this.idPret = idPret;
		this.livre = livre;
		this.utilisateur = utilisateur;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.dateEffective = dateEffective;
		this.prolonge = prolonge;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pret", unique = true, nullable = false)
	public int getIdPret() {
		return this.idPret;
	}

	public void setIdPret(int idPret) {
		this.idPret = idPret;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_livre", nullable = false)
	public Livre getLivre() {
		return this.livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_utilisateur", nullable = false)
	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_debut", nullable = false, length = 13)
	public Date getDateDebut() {
		return this.dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_fin", nullable = false, length = 13)
	public Date getDateFin() {
		return this.dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_effective", nullable = false, length = 13)
	public Date getDateEffective() {
		return this.dateEffective;
	}

	public void setDateEffective(Date dateEffective) {
		this.dateEffective = dateEffective;
	}

	@Column(name = "prolonge", nullable = false)
	public boolean isProlonge() {
		return this.prolonge;
	}

	public void setProlonge(boolean prolonge) {
		this.prolonge = prolonge;
	}

}
