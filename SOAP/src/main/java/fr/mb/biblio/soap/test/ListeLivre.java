package fr.mb.biblio.soap.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import fr.mb.biblio.dao.contract.GenericDAO;
import fr.mb.biblio.dao.contract.LivreDao;
import fr.mb.biblio.dao.impl.GenreDaoImpl;
import fr.mb.biblio.dao.impl.LivreDaoImpl;
import fr.mb.biblio.dao.impl.OuvrageDaoImpl;
import fr.mb.biblio.models.beans.Auteur;
import fr.mb.biblio.models.beans.Editeur;
import fr.mb.biblio.models.beans.Genre;
import fr.mb.biblio.models.beans.Livre;
import fr.mb.biblio.models.beans.Ouvrage;

public  class  ListeLivre {
		private List<Livre> liste=new ArrayList<Livre>();
		

		
		public ListeLivre(List<Ouvrage> listOuvrage, List<Genre> listGenre) {
		// TODO Auto-generated method stub


		

		
		Livre livre=new Livre();
		Auteur auteur=new Auteur();
		Editeur editeur=new Editeur();

		
		
		
		//Titre
		livre.setTitre("La jeune Fille et la nuit");
		//Date
		String date="24-04-2018";
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate dateparution= LocalDate.parse(date,df);
		
		

		livre.setParution(dateparution);
		//Image (nom par défaut)
		livre.setImage("La jeune Fille et la nuit.jpg");
		
		//Auteur
		auteur.setNom("Musso");
		auteur.setPrenom("Guillaume");
		auteur.getLivres().add(livre);


		
		//Editeur
		editeur.setNom("Calmann-Levy");


		
		//Resume
		livre.setResume("Côte d’Azur - Hiver 1992 "
				+ "Une nuit glaciale, alors que le campus de son lycée est paralysé par une tempête de neige, Vinca Rockwell, 19 ans, l’une des plus brillantes élèves de classes prépas, s’enfuit avec son professeur de philo avec qui elle entretenait une relation secrète. Pour la jeune fille, « l’amour est tout ou il n’est rien ».Personne ne la reverra jamais.");
		
		//Ouvrage
		for (Iterator iterator = listOuvrage.iterator(); iterator.hasNext();) {
			Ouvrage ouvrage2 = (Ouvrage) iterator.next();
			if(ouvrage2.getIdOuvrage()==1)livre.setOuvrage(ouvrage2);
			
		}
		
		
		//Genre
		for (Iterator iterator = listGenre.iterator(); iterator.hasNext();) {
			Genre genre2 = (Genre) iterator.next();
			if(genre2.getIdGenre()==10)livre.getGenres().add(genre2);
		}
		
		


		//Ajout Auteurs/Editeur/ouvrage/genre au livre
		livre.getAuteurs().add(auteur);
		livre.getEditeurs().add(editeur);

		
		this.liste.add(livre);
		
		
		}

		public  List<Livre> getListe() {
			return liste;
		}

		public void setListe(List<Livre> liste) {
			this.liste = liste;
		}
		
		

	

}
