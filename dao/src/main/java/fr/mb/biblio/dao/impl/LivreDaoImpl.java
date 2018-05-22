package fr.mb.biblio.dao.impl;

import java.util.List;

import javax.inject.Named;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import fr.mb.biblio.dao.contract.LivreDao;
import fr.mb.biblio.models.beans.Livre;
import fr.mb.biblio.models.recherche.RechercheLivre;



@Transactional
public class LivreDaoImpl extends AbstractDaoImpl<Livre> implements LivreDao {

	public LivreDaoImpl(Class<Livre> entityClass) {
		super(entityClass);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Livre> rechercheLivres(RechercheLivre recherche, Integer offset, Integer nbPages) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//-------------SELECTION DES SITES-------------
		String SQL = " SELECT DISTINCT livre FROM Livre as livre ";
		
		//-------------JOINTURES FACULTATIVES----------------
		if (recherche.getAuteur()!=null) SQL+="JOIN livre.auteurs as auteur";
		if (recherche.getGenre()!=null) SQL+="JOIN livre.genre as genre";
		
		//-------------CRITERE DE RECHERCHE---------------
		
		//-------------CRITERES OBLIGATOIRES---------------
				
		SQL+=" WHERE (livre.titre LIKE (:titre)%)";
		
		//-------------CRITERES FACULTATIFS---------------
		if (recherche.getAuteur()!=null) SQL+="AND (auteur.nom LIKE(:auteur)%";
		if (recherche.getGenre()!=null) SQL+="AND (genre.genre LIKE(:genre)%";
		
		//TRI
		SQL+="  ORDER BY livre.titre ASC ";
		
		
		
		
		//CREATION DE LA QUERY
		Query query = session.createQuery(SQL);
		query.setParameter("titre", recherche.getTitre());
		if (recherche.getAuteur()!=null) query.setParameter("auteur", recherche.getAuteur());
		if (recherche.getGenre()!=null) query.setParameter("genre", recherche.getGenre());
		
		
		

		query.setFirstResult(offset);
		query.setMaxResults(nbPages);
		
		List<Livre> list = query.list();
		session.close();
		return list;
	}


	
	
	
	







}
