package fr.mb.biblio.webapp.actions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



import fr.mb.biblio.webappBusiness.contract.LivreWebManager;
import fr.mb.biblio.webappConsumer.services.livre.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;


import com.opensymphony.xwork2.ActionSupport;


import org.springframework.beans.factory.annotation.Autowired;


/**
 * Action pour la recherche de livre
 * @author Morgan
 *
 */
public class LivreAction extends ActionSupport implements SessionAware {
	
	//---------ATTRIBUTS--------------

	@Autowired
	private LivreWebManager livreWebManager;
	
	/**
	 * Permet de stocker les objets en session
	 */
	private Map<String, Object> session;
	
	/**
	 *id pour récupérer le détail d'un livre 
	 */
	private Integer idLivre;
	
	/**
	 * Nombre de sites à afficher par page
	 */
	private Integer pageSize = 10;
	
	/**
	 * Liste pour l'affichage de livre
	 */
	private List<Livre> listLivre = new ArrayList<Livre>();
	
	
	
	/**
	 * Liste pour l'affichage de livre
	 */
	private List<Livre> listrecent= new ArrayList<Livre>();
	
	/**
	 * Liste de récupération des auteurs 
	 */
	private List<Auteur> listAuteur= new ArrayList<Auteur>();
	
	
	/**
	 * Liste de récupération des genres 
	 */
	private List<Genre> listGenre= new ArrayList<Genre>();
	
	/**
	 * Page sélectionnée et permet de définir l'Offset pour le changement de page
	 */
	private Integer start = 0;
	
	/**
	 * Titre pour la recherche d'un livre
	 */
	private String titre;
	
	/**
	 * Id d'un auteur pour affiner la recherche d'un livre
	 */
	private Integer auteurIdOut=10000;
	
	/**
	 * id d'un genre pour affiner la recherche d'un livre
	 */
	private Integer genreIdOut=10000;
	
	private Integer lastPage=0;
	
	private Long nbResult=(long) 0;
	
	/**
	 * Objet livre pour obtenir le détail d'un livre
	 */
	private Livre livre;
	
	/**
	 * Objet utilisé pour la recherche de livre
	 */
	private RechercheLivre recherche=new RechercheLivre();
	
	private LocalDate dateRetour;
	
	private static final Logger logger = LogManager.getLogger(LivreAction.class);
	
	
	//---------------------ACTIONS---------------------------------
	
	/**
	 * Recherche de livre en fonction du formulaire de recherche
	 * @return
	 */
	public String recherche() {
		String result = ActionSupport.INPUT;
		try {
			
			if(titre==null||titre.equals("")) {
				try {
					listrecent=livreWebManager.getAllLivres(start, 3);
				} catch (FunctionalException_Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
			if(titre!=null&&titre!=""){
				try {
					
					recherche.setTitre(titre);
					
					if(auteurIdOut!=null&&auteurIdOut!=10000) {
						recherche.setAuteur(auteurIdOut);
					}
					if(genreIdOut!=null&&genreIdOut!=10000) {
						recherche.setGenre(genreIdOut);
					}
			
			
					listLivre=livreWebManager.rechercheLivres(recherche, start,pageSize);
					
					if(listLivre==null||listLivre.isEmpty())addActionError("Aucun résultat trouvé");
					else {
						nbResult=livreWebManager.countLivres(recherche);
						double page = (double) pageSize;

						double lastPageNumber = (Math.ceil(nbResult / pageSize));
						
						lastPage=(int)lastPageNumber;
						
						
						
						for (Iterator iterator = listLivre.iterator(); iterator.hasNext();) {
							Livre livre = (Livre) iterator.next();
							for (Iterator iterator2 = livre.getAuteurs().iterator(); iterator2.hasNext();) {
								Auteur auteur = (Auteur) iterator2.next();
								listAuteur.add(auteur);						
							}
							for (Iterator iterator2 = livre.getGenres().iterator(); iterator2.hasNext();) {
								Genre genre = (Genre) iterator2.next();
								listGenre.add(genre);						
							}
						
							result = ActionSupport.SUCCESS;
						}
					}
					
				} catch (FunctionalException_Exception e) {
						addActionError(e.getMessage());
						
				}
				
				}}
		
		
		catch(Exception e) {
			addActionError("Le service est momentanément indisponible");
			result=ActionSupport.ERROR;
		}
		
		return result;}
	
	
	
	public String detail() {
		
		try {
		
		if (idLivre == null) {
			this.addActionError(getText("error.project.missing.id"));
		} else {
			try {
				String date="";
				livre = (Livre) livreWebManager.getLivreById(idLivre);
				try {
					date=livreWebManager.dateRetourLivre(idLivre);
					logger.info(livre.getParution().getClass());
					logger.info(livre.getParution());
					logger.info(date.getClass());
					logger.info(date);
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					dateRetour=LocalDate.parse(date, formatter);
					logger.info(dateRetour);
				} catch (FunctionalException_Exception e) {
					// TODO Auto-generated catch block
					e.getMessage();
				}

				
				
			} catch (NotFoundException_Exception Notfound) {
				this.addActionError(getText("error.project.notfound", Collections.singletonList(idLivre)));
				
			}
		}
		}
		catch(Exception e){
			addActionError("Le service est momentanément indisponible");
		}
		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}
	
	
	
	
	//---------------------GETTERS//SETTERS-------------------------
	
	


	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<Livre> getListLivre() {
		return listLivre;
	}

	public void setListLivre(List<Livre> listLivre) {
		this.listLivre = listLivre;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}




	public String getTitre() {
		return titre;
	}




	public void setTitre(String titre) {
		this.titre = titre;
	}




	public List<Auteur> getListAuteur() {
		return listAuteur;
	}




	public void setListAuteur(List<Auteur> listAuteur) {
		this.listAuteur = listAuteur;
	}




	public List<Genre> getListGenre() {
		return listGenre;
	}




	public void setListGenre(List<Genre> listGenre) {
		this.listGenre = listGenre;
	}




	public RechercheLivre getRecherche() {
		return recherche;
	}




	public void setRecherche(RechercheLivre recherche) {
		this.recherche = recherche;
	}




	public Integer getAuteurIdOut() {
		return auteurIdOut;
	}




	public void setAuteurIdOut(Integer auteurIdOut) {
		this.auteurIdOut = auteurIdOut;
	}




	public Integer getGenreIdOut() {
		return genreIdOut;
	}




	public void setGenreIdOut(Integer genreIdOut) {
		this.genreIdOut = genreIdOut;
	}


	public Integer getIdLivre() {
		return idLivre;
	}


	public void setIdLivre(Integer idLivre) {
		this.idLivre = idLivre;
	}


	public Livre getLivre() {
		return livre;
	}


	public void setLivre(Livre livre) {
		this.livre = livre;
	}


	public List<Livre> getListrecent() {
		return listrecent;
	}


	public void setListrecent(List<Livre> listrecent) {
		this.listrecent = listrecent;
	}


	public LocalDate getDateRetour() {
		return dateRetour;
	}


	public void setDateRetour(LocalDate dateRetour) {
		this.dateRetour = dateRetour;
	}



	public Integer getLastPage() {
		return lastPage;
	}



	public void setLastPage(Integer lastPage) {
		this.lastPage = lastPage;
	}



	public Long getNbResult() {
		return nbResult;
	}



	public void setNbResult(Long nbResult) {
		this.nbResult = nbResult;
	}

}
