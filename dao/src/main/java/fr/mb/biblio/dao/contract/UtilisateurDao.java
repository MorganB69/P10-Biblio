package fr.mb.biblio.dao.contract;

import java.util.List;


import fr.mb.biblio.models.beans.Utilisateur;

public interface UtilisateurDao {
	/**
	 * Persister l'entité en bd
	 * @param  entité à insérer en bd
	 */
	public void persist(Utilisateur entity);
	
	/**
	 * Mettre à jour l'entité en bd
	 * @param  entité à mettre à jour en base de donnée
	 */
	public void update(Utilisateur entity);
	
	/**
	 * Trouver l'entité en fonction de son id
	 * @param id pour trouver l'entité
	 * @return l'entité
	 */
	public Utilisateur findById(int id);
	
	/**
	 * Supprimer l'entité de la bd
	 * @param entité
	 */
	public void delete(Utilisateur entity);
	
	/**
	 * Récupère une liste de l'entité en bd
	 * @return une liste des entités demandées
	 */
	public List<Utilisateur> findAll();
	
	/**
	 * Récupère une liste des entités selon un offset et un nb par page
	 * @param offset
	 * @param nbPages
	 * @return
	 */
	public List<Utilisateur> findAllOffset(Integer offset, Integer nbPages);
	
	/**
	 * Récupère en bd l'utilisateur en fonction de l'identifiant et du mot de passe
	 * @param identifiant
	 * @param mdp
	 * @return
	 */
	public Utilisateur identification(String identifiant,String mdp);
	
	public Utilisateur getUser(String identifiant);
	
	public Integer getUserIdByName(String Nom, String Prenom);
}
