package fr.mb.biblio.dao.impl;


import java.time.LocalDate;
import java.util.List;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import fr.mb.biblio.dao.contract.PretDao;
import fr.mb.biblio.models.beans.Livre;
import fr.mb.biblio.models.beans.Pret;



@Transactional
public class PretDaoImpl extends AbstractDaoImpl<Pret> implements PretDao {
	
	private static Logger logger = LogManager.getLogger(PretDaoImpl.class);

	public PretDaoImpl(Class<Pret> entityClass) {
		super(entityClass);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Pret> findPretEnCours(Integer offset, Integer nbPages) {
		Session session = sessionFactory.getCurrentSession();
		
			String SQL=" SELECT DISTINCT pret FROM Pret as pret ";
			
			//-------------CRITERES OBLIGATOIRES---------------
			
			SQL+=" WHERE (pret.dateEffective = null) ";
			
			//TRI
			SQL+=" ORDER BY pret.idPret ASC ";

			//CREATION DE LA QUERY
			Query query = session.createQuery(SQL);
			
			logger.info(query.getQueryString());
			

			query.setFirstResult(offset);
			query.setMaxResults(nbPages);
			
			List<Pret> list = query.list();
			return list;
		

	}

	@Override
	public List<Pret> findPretEnCoursProlonge(Integer offset, Integer nbPages) {
		Session session = sessionFactory.getCurrentSession();
		
		String SQL=" SELECT DISTINCT pret FROM Pret as pret ";
		
		//-------------CRITERES OBLIGATOIRES---------------
		
		SQL+=" WHERE (pret.dateEffective = null AND pret.prolonge=true)  ";
		
		//TRI
		SQL+=" ORDER BY pret.idPret ASC ";

		//CREATION DE LA QUERY
		Query query = session.createQuery(SQL);
		
		logger.info(query.getQueryString());
		

		query.setFirstResult(offset);
		query.setMaxResults(nbPages);
		
		List<Pret> list = query.list();
		return list;
	}

	@Override
	public List<Pret> findPretRetard(Integer offset, Integer nbPages, LocalDate dateJour) {
Session session = sessionFactory.getCurrentSession();
		
		String SQL=" SELECT DISTINCT pret FROM Pret as pret ";
		
		//-------------CRITERES OBLIGATOIRES---------------
		
		SQL+=" WHERE (pret.dateEffective = null AND (:dateJour)>pret.dateFin)  ";
		
		//TRI
		SQL+=" ORDER BY pret.idPret ASC ";

		//CREATION DE LA QUERY
		Query query = session.createQuery(SQL);
		query.setParameter("dateJour", dateJour);
		
		logger.info(query.getQueryString());
		

		query.setFirstResult(offset);
		query.setMaxResults(nbPages);
		
		List<Pret> list = query.list();
		return list;
	
	}

	
	
	







}
