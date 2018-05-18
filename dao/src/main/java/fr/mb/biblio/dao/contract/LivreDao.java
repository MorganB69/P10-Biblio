package fr.mb.biblio.dao.contract;

import java.util.List;

import fr.mb.biblio.models.beans.Livre;

public interface LivreDao {
	/**
	 * Persister l'entité en bd
	 * @param  entité à insérer en bd
	 */
	public void persist(Livre entity);
	
	/**
	 * Mettre à jour l'entité en bd
	 * @param  entité à mettre à jour en base de donnée
	 */
	public void update(Livre entity);
	
	/**
	 * Trouver l'entité en fonction de son id
	 * @param id pour trouver l'entité
	 * @return l'entité
	 */
	public Livre findById(int id);
	
	/**
	 * Supprimer l'entité de la bd
	 * @param entité
	 */
	public void delete(Livre entity);
	
	/**
	 * Récupère une liste de l'entité en bd
	 * @return une liste des entités demandées
	 */
	public List<Livre> findAll();
}
