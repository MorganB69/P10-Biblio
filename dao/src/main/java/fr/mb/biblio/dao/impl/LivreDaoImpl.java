package fr.mb.biblio.dao.impl;

import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import fr.mb.biblio.dao.contract.LivreDao;
import fr.mb.biblio.models.beans.Livre;



@Transactional
public class LivreDaoImpl extends AbstractDaoImpl<Livre> implements LivreDao {

	public LivreDaoImpl(Class<Livre> entityClass) {
		super(entityClass);
		// TODO Auto-generated constructor stub
	}


	
	
	
	







}
