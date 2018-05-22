package fr.mb.biblio.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;


import fr.mb.biblio.dao.contract.UtilisateurDao;
import fr.mb.biblio.models.beans.Utilisateur;


@Transactional
public class UtilisateurDaoImpl extends AbstractDaoImpl<Utilisateur> implements UtilisateurDao {



	public UtilisateurDaoImpl(Class<Utilisateur> entityClass) {
		super(entityClass);
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional
	public Utilisateur identification(String identifiant, String mdp) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query=session.createQuery("FROM Utilisateur WHERE identifiant=(:ident) AND mdp=(:mdp)");
		query.setParameter("ident", identifiant);
		query.setParameter("mdp", mdp);
		List<Utilisateur> userList = query.getResultList();

		session.close();
		if (userList.isEmpty()){
			return null;
		}
		else {
			Utilisateur user=userList.get(0);
			return user;
			
		}
		
		
	}
	
	
	
	







}
