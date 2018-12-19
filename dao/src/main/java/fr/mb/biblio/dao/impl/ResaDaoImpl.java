package fr.mb.biblio.dao.impl;

import fr.mb.biblio.dao.contract.ResaDao;
import fr.mb.biblio.models.beans.Reservation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.time.LocalDate;
import java.util.List;

public class ResaDaoImpl extends AbstractDaoImpl<Reservation> implements ResaDao {

    private static Logger logger = LogManager.getLogger(ResaDaoImpl.class);

    public ResaDaoImpl(Class<Reservation> entityClass) {
        super(entityClass);
    }


    @Override
    public List<Reservation> getResaByUserId(Integer userId) {
        Session session = sessionFactory.getCurrentSession();

        String SQL=" SELECT DISTINCT reservation FROM Reservation as reservation ";

        //-------------CRITERES OBLIGATOIRES---------------

        SQL+=" WHERE ((:userId)=reservation.demandeur.idUtilisateur) ";

        //TRI
        SQL+=" ORDER BY reservation.id ASC ";

        //CREATION DE LA QUERY

        Query query = session.createQuery(SQL);
        query.setParameter("userId", userId);

        logger.info(query.getQueryString());




        List<Reservation> list = query.list();
        return list;
    }

    @Override
    public List<Reservation> getResaByLivreId(Integer livreId) {
        Session session = sessionFactory.getCurrentSession();

        String SQL=" SELECT DISTINCT reservation FROM Reservation as reservation ";

        //-------------CRITERES OBLIGATOIRES---------------

        SQL+=" WHERE ((:livreId)=reservation.livre.idLivre) ";

        //TRI
        SQL+=" ORDER BY reservation.id ASC ";

        //CREATION DE LA QUERY

        Query query = session.createQuery(SQL);
        query.setParameter("livreId", livreId);

        logger.info(query.getQueryString());

        List<Reservation> list = query.list();
        return list;
    }

    @Override
    public List<Reservation> getResaEnd() {
        LocalDate dateJour = LocalDate.now();

        Session session = sessionFactory.getCurrentSession();

        String SQL=" SELECT DISTINCT reservation FROM Reservation as reservation ";

        SQL+=" WHERE ((:dateJour) > reservation.finResa) ";

        SQL+=" ORDER BY reservation.id ASC ";

        Query query = session.createQuery(SQL);
        query.setParameter("dateJour", dateJour);

        logger.info(query.getQueryString());

        List<Reservation> list = query.list();
        return list;
    }
}
