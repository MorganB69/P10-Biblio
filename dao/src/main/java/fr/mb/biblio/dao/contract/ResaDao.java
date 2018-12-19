package fr.mb.biblio.dao.contract;


import fr.mb.biblio.models.beans.Reservation;

import java.util.List;

/**
 *
 */
public interface ResaDao {
    /**
     * Persister l'entité en bd
     * @param  entité à insérer en bd
     */
    public void persist(Reservation entity);

    /**
     * Mettre à jour l'entité en bd
     * @param  entité à mettre à jour en base de donnée
     */
    public void update(Reservation entity);

    /**
     * Trouver l'entité en fonction de son id
     * @param id pour trouver l'entité
     * @return l'entité
     */
    public Reservation findById(int id);

    /**
     * Supprimer l'entité de la bd
     * @param entité
     */
    public void delete(Reservation entity);

    /**
     * Récupère une liste de l'entité en bd
     * @return une liste des entités demandées
     */
    public List<Reservation> findAll();

    /**
     * Obtention de la liste des reservation par utilisateur
     * @return
     */
    public List<Reservation> getResaByUserId(Integer userId);


    /**
     * Obtention de la liste des reservations pour un livre
     * @param livreId
     * @return
     */
    public List<Reservation> getResaByLivreId(Integer livreId);


    /**
     * Obtention des reservations terminées
     * @return
     */
    List<Reservation>getResaEnd();
}
