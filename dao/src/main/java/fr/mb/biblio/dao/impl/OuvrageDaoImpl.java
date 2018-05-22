package fr.mb.biblio.dao.impl;


import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import fr.mb.biblio.dao.contract.GenericDAO;
import fr.mb.biblio.models.beans.Ouvrage;



@Transactional
public class OuvrageDaoImpl extends AbstractDaoImpl<Ouvrage> implements GenericDAO<Ouvrage> {

	public OuvrageDaoImpl(Class<Ouvrage> entityClass) {
		super(entityClass);
		// TODO Auto-generated constructor stub
	}


	
	
	
	







}
