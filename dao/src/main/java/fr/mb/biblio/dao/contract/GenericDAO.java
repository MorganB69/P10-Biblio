package fr.mb.biblio.dao.contract;

import java.util.List;


public interface GenericDAO <T> {
	

	/**
	 * Persister l'entité en bd
	 * @param  entité à insérer en bd
	 */
	public void persist(T entity);
	
	/**
	 * Mettre à jour l'entité en bd
	 * @param  entité à mettre à jour en base de donnée
	 */
	public void update(T entity);
	
	/**
	 * Trouver l'entité en fonction de son id
	 * @param id pour trouver l'entité
	 * @return l'entité
	 */
	public T findById(int id);
	
	/**
	 * Supprimer l'entité de la bd
	 * @param entité
	 */
	public void delete(T entity);
	
	/**
	 * Récupère une liste de l'entité en bd
	 * @return une liste des entités demandées
	 */
	public List<T> findAll();
	
	/**
	 * Récupère une liste des entités selon un offset et un nb par page
	 * @param offset
	 * @param nbPages
	 * @return
	 */
	public List<T> findAllOffset(Integer offset, Integer nbPages);
	


}
