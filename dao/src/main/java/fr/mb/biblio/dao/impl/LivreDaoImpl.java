package fr.mb.biblio.dao.impl;

import java.util.List;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import fr.mb.biblio.dao.contract.LivreDao;
import fr.mb.biblio.models.beans.Livre;
import fr.mb.biblio.models.recherche.RechercheLivre;




@Transactional
public class LivreDaoImpl extends AbstractDaoImpl<Livre> implements LivreDao {
	
	private static Logger logger = LogManager.getLogger(LivreDaoImpl.class);

	public LivreDaoImpl(Class<Livre> entityClass) {
		super(entityClass);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Livre> rechercheLivres(RechercheLivre recherche, Integer offset, Integer nbPages) {
		Session session = sessionFactory.getCurrentSession();

		
		//-------------SELECTION DES SITES-------------
		String SQL = " SELECT DISTINCT livre FROM Livre as livre ";
		
		//-------------JOINTURES FACULTATIVES----------------
		if (recherche.getAuteur()!=null&&recherche.getAuteur()!=0) SQL+=" JOIN livre.auteurs as auteur ";
		if (recherche.getGenre()!=null&&recherche.getGenre()!=0) SQL+=" JOIN livre.genres as genre ";
		
		//-------------CRITERE DE RECHERCHE---------------
		
		//-------------CRITERES OBLIGATOIRES---------------
				
		SQL+=" WHERE (UPPER(livre.titre) LIKE UPPER((:titre))) ";
		
		//-------------CRITERES FACULTATIFS---------------
		if (recherche.getAuteur()!=null&&recherche.getAuteur()!=0) SQL+=" AND (auteur.idAuteur=(:auteur)) ";
		if (recherche.getGenre()!=null&&recherche.getGenre()!=0) SQL+=" AND (genre.idGenre=(:genre)) ";
		
		//TRI
		SQL+=" ORDER BY livre.titre ASC ";
		
		
		
		
		//CREATION DE LA QUERY
		Query query = session.createQuery(SQL);
		query.setParameter("titre", "%"+recherche.getTitre()+"%");
		if (recherche.getAuteur()!=null&&recherche.getAuteur()!=0) query.setParameter("auteur", recherche.getAuteur());
		if (recherche.getGenre()!=null&&recherche.getGenre()!=0) query.setParameter("genre", recherche.getGenre());
		
		logger.info(query.getQueryString());
		

		query.setFirstResult(offset);
		query.setMaxResults(nbPages);
		
		List<Livre> list = query.list();
		return list;
	}


	
	
	
	







}
