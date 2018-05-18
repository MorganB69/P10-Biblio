package fr.mb.biblio.dao.impl;


import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import fr.mb.biblio.dao.contract.GenericDAO;
import fr.mb.biblio.models.beans.Genre;


@Named("genreDao")
@Transactional
public class GenreDaoImpl extends AbstractDaoImpl<Genre> implements GenericDAO<Genre> {
	
	
	
	







}
