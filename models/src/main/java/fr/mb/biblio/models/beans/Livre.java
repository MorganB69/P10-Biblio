package fr.mb.biblio.models.beans;
// Generated 17 mai 2018 21:05:11 by Hibernate Tools 5.2.10.Final

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import fr.mb.biblio.models.LocalDateXmlAdapter;



/**
 * Livre generated by hbm2java
 */
@Entity
@Table(name = "livre", catalog = "projet")
public class Livre implements java.io.Serializable {

	private int idLivre;
	private Ouvrage ouvrage;
	private String titre;
	private LocalDate parution;
	private String image;
	private String resume;
	private Boolean disponible;
	private Set<Auteur> auteurs = new HashSet<Auteur>(0);
	private Set<Genre> genres = new HashSet<Genre>(0);
	private Set<Editeur> editeurs = new HashSet<Editeur>(0);
	private Set<Pret> prets = new HashSet<Pret>(0);

	public Livre() {
	}

	public Livre(int idLivre, Ouvrage ouvrage, String titre, LocalDate parution, String image, String resume,Boolean disponible) {
		this.idLivre = idLivre;
		this.ouvrage = ouvrage;
		this.titre = titre;
		this.parution = parution;
		this.image = image;
		this.resume = resume;
		this.disponible=disponible;
	}

	public Livre(int idLivre, Ouvrage ouvrage, String titre, LocalDate parution, String image, String resume,Boolean disponible,
			Set<Auteur> auteurs, Set<Genre> genres, Set<Editeur> editeurs, Set<Pret> prets) {
		this.idLivre = idLivre;
		this.ouvrage = ouvrage;
		this.titre = titre;
		this.parution = parution;
		this.image = image;
		this.resume = resume;
		this.disponible=disponible;
		this.auteurs = auteurs;
		this.genres = genres;
		this.editeurs = editeurs;
		this.prets = prets;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_livre", unique = true, nullable = false)
	public int getIdLivre() {
		return this.idLivre;
	}

	public void setIdLivre(int idLivre) {
		this.idLivre = idLivre;
	}

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_ouvrage")
	public Ouvrage getOuvrage() {
		return this.ouvrage;
	}

	public void setOuvrage(Ouvrage ouvrage) {
		this.ouvrage = ouvrage;
	}

	@Column(name = "titre", nullable = false)
	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	@XmlJavaTypeAdapter(LocalDateXmlAdapter.class)
	@XmlSchemaType(name = "date")
	@Column(name = "parution", nullable = false, length = 13)
	public LocalDate getParution() {
		return this.parution;
	}

	public void setParution(LocalDate dateparution) {
		this.parution = dateparution;
	}

	@Column(name = "image", nullable = false)
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "resume", nullable = false)
	public String getResume() {
		return this.resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}
	@Column(name = "disponible", nullable = false)
	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

	@ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name = "livre_auteur",catalog = "projet", joinColumns = {
	@JoinColumn(name = "id_livre", nullable = false, updatable = false) }, inverseJoinColumns = {
	@JoinColumn(name = "id_auteur", nullable = false, updatable = false) })
	public Set<Auteur> getAuteurs() {
		return this.auteurs;
	}

	public void setAuteurs(Set<Auteur> auteurs) {

		this.auteurs = auteurs;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "livre_genre",catalog = "projet", joinColumns = {
			@JoinColumn(name = "id_livre", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "id_genre", nullable = false, updatable = false) })
	public Set<Genre> getGenres() {
		return this.genres;
	}

	public void setGenres(Set<Genre> genres) {

		this.genres = genres;
	}

	@ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name = "livre_editeur",catalog = "projet", joinColumns = {
			@JoinColumn(name = "id_livre", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "id_editeur", nullable = false, updatable = false) })
	public Set<Editeur> getEditeurs() {
		return this.editeurs;
	}

	public void setEditeurs(Set<Editeur> editeurs) {

		this.editeurs = editeurs;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "livre")
	public Set<Pret> getPrets() {
		return this.prets;
	}

	public void setPrets(Set<Pret> prets) {
		this.prets = prets;
	}

}
