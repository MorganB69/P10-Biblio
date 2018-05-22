package fr.mb.biblio.models.beans;
// Generated 17 mai 2018 21:05:11 by Hibernate Tools 5.2.10.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Ouvrage generated by hbm2java
 */
@Entity
@Table(name = "ouvrage")
public class Ouvrage implements java.io.Serializable {

	private int idOuvrage;
	private String typeouvrage;
	Set<Livre> livres = new HashSet<Livre>(0);

	public Ouvrage() {
	}

	public Ouvrage(int idOuvrage, String typeouvrage) {
		this.idOuvrage = idOuvrage;
		this.typeouvrage = typeouvrage;
	}

	public Ouvrage(int idOuvrage, String typeouvrage, Set<Livre> livres) {
		this.idOuvrage = idOuvrage;
		this.typeouvrage = typeouvrage;
		this.livres = livres;
	}

	@Id

	@Column(name = "id_ouvrage", unique = true, nullable = false)
	public int getIdOuvrage() {
		return this.idOuvrage;
	}

	public void setIdOuvrage(int idOuvrage) {
		this.idOuvrage = idOuvrage;
	}

	@Column(name = "typeouvrage", nullable = false)
	public String getTypeouvrage() {
		return this.typeouvrage;
	}

	public void setTypeouvrage(String typeouvrage) {
		this.typeouvrage = typeouvrage;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "ouvrage")
	public Set<Livre> getLivres() {
		return this.livres;
	}

	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}

}
