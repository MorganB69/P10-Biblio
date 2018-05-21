package fr.mb.biblio.models.beans;
// Generated 17 mai 2018 21:05:11 by Hibernate Tools 5.2.10.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Genre generated by hbm2java
 */
@Entity
@Table(name = "genre", schema = "public")
public class Genre implements java.io.Serializable {

	private int idGenre;
	private String genre;
	private Set<Livre> livres = new HashSet<Livre>(0);

	public Genre() {
	}

	public Genre(int idGenre, String genre) {
		this.idGenre = idGenre;
		this.genre = genre;
	}

	public Genre(int idGenre, String genre, Set<Livre> livres) {
		this.idGenre = idGenre;
		this.genre = genre;
		this.livres = livres;
	}

	@Id

	@Column(name = "id_genre", unique = true, nullable = false)
	public int getIdGenre() {
		return this.idGenre;
	}

	public void setIdGenre(int idGenre) {
		this.idGenre = idGenre;
	}

	@Column(name = "genre", nullable = false)
	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "genres")
	public Set<Livre> getLivres() {
		return this.livres;
	}

	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}

}
