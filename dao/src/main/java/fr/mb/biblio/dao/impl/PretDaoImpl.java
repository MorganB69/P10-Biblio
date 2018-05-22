package fr.mb.biblio.dao.impl;


import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import fr.mb.biblio.dao.contract.PretDao;
import fr.mb.biblio.models.beans.Pret;



@Transactional
public class PretDaoImpl extends AbstractDaoImpl<Pret> implements PretDao {

	public PretDaoImpl(Class<Pret> entityClass) {
		super(entityClass);
		// TODO Auto-generated constructor stub
	}

	
	
	







}
