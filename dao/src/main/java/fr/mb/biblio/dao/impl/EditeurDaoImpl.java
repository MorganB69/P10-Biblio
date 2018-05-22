package fr.mb.biblio.dao.impl;


import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import fr.mb.biblio.dao.contract.GenericDAO;
import fr.mb.biblio.models.beans.Editeur;



@Transactional
public class EditeurDaoImpl extends AbstractDaoImpl<Editeur> implements GenericDAO<Editeur> {

	public EditeurDaoImpl(Class<Editeur> entityClass) {
		super(entityClass);
		// TODO Auto-generated constructor stub
	}

	
	
	
	







}
