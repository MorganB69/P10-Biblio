package fr.mb.biblio.dao.impl;


import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import fr.mb.biblio.dao.contract.GenericDAO;
import fr.mb.biblio.models.beans.Auteur;



@Transactional
public class AuteurDaoImpl extends AbstractDaoImpl<Auteur> implements GenericDAO<Auteur> {

	public AuteurDaoImpl(Class<Auteur> entityClass) {
		super(entityClass);
		// TODO Auto-generated constructor stub
	}


	
	
	
	







}
