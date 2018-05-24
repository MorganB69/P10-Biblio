package fr.mb.biblio.models.recherche;

public class RechercheLivre {
	private String titre;
	private Integer auteur;
	private Integer genre;
	private Integer editeur;
	
	
	public RechercheLivre() {
		super();
	}
	
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Integer getAuteur() {
		return auteur;
	}
	public void setAuteur(Integer auteur) {
		this.auteur = auteur;
	}
	public Integer getGenre() {
		return genre;
	}
	public void setGenre(Integer genre) {
		this.genre = genre;
	}
	public Integer getEditeur() {
		return editeur;
	}
	public void setEditeur(Integer editeur) {
		this.editeur = editeur;
	}
	
}
