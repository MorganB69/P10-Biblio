package fr.mb.biblio.soap.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import fr.mb.biblio.models.beans.Auteur;
import fr.mb.biblio.models.beans.Editeur;
import fr.mb.biblio.models.beans.Genre;
import fr.mb.biblio.models.beans.Livre;
import fr.mb.biblio.models.beans.Ouvrage;

public class CreationLivreAleatoire {
	
	private List<Livre>liste=new ArrayList<Livre>();
	

	
	public List<Livre> getListe() {
		return liste;
	}



	public void setListe(List<Livre> liste) {
		this.liste = liste;
	}



	public CreationLivreAleatoire(List<Ouvrage> listOuvrage, List<Genre> listGenre, Integer nb) {
		
		String[] prenom= {"Alexandrie","Amber","Gaetane","Morgan","Pauline","Jean","Jade", "Guillaume","Zoé","Paul","Matthieu","Thomas","Anne","Marie"};
		String[] nom= {"Lamy","Gaudreau","Leroy","Dupond","Proulx","Tremblay","Étoile", "Guimond", "Angélil", "Grandbois", "LaGarde","Authier","Coupart","Mercier","Laforge","Pépin"};
		String[] titre1f= {"La dame","La femme","La jeune fille", "L'étoile","La science","La déesse"};
		String[] titre1m= {"Le dieu","L'homme","Le chien","L'inconnu", "L'espion", "L'aventurier", "Le royaume"};
		String[] titre2f= {"mysterieuse","anglaise","perdue","italienne","riche","pauvre","américaine","désesperée"};
		String[] titre2m= {"mystérieux", "anglais", "perdu", "italien", "français", "pauvre", "riche", "américain", "désespéré"};
		String[] edition= {"Boisvert","Goguen","Aubé","Charron","Coupart", "Lamontagne", "Sanschagrin","Chrétien"};
		

		    
		    for (int j = 0; j < nb; j++) {
	    
		    Livre livre=new Livre();
			Auteur auteur=new Auteur();
			Editeur editeur=new Editeur();
			
			String titre=new String();
			String prenomAuteur=new String();
			String nomAuteur=new String();
			String nomEditeur=new String();
			String image="defautLivre.jpg";
			String resume="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse nec arcu lobortis nulla ullamcorper aliquam id in diam. Nam dapibus, mauris ut feugiat tristique, nulla tortor lacinia libero, vel lacinia justo eros ut ipsum. Suspendisse maximus augue vitae velit pulvinar, a consequat ligula molestie. Aliquam commodo risus ut erat iaculis gravida. Nulla pulvinar ipsum quis enim auctor venenatis. Aenean felis ligula, elementum eget fringilla at, porttitor vel enim. In pulvinar malesuada iaculis. Pellentesque vel purus semper, suscipit elit sed, ultrices nibh. Donec felis neque, tincidunt non ante vel, maximus consectetur dui. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.";
			 long minDay = LocalDate.of(1970, 1, 1).toEpochDay();
			    long maxDay = LocalDate.of(2017, 12, 31).toEpochDay();
			    long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
			    LocalDate dateParution = LocalDate.ofEpochDay(randomDay);
			
			    int genreId= 1 + (int)(Math.random() * ((10 - 1) + 1));
			    int ouvrageId= 1 + (int)(Math.random() * ((4 - 1) + 1));
			   
			
			
			int x=(Math.random()<0.5)?0:1;
			if (x==0) {
				titre+=titre1f[(int)(Math.random()*titre1f.length)];
				titre+=" "+titre2f[(int)(Math.random()*titre2f.length)];
			}
			else {
				titre+=titre1m[(int)(Math.random()*titre1m.length)];
				titre+=" "+titre2m[(int)(Math.random()*titre2m.length)];
			}
			
			prenomAuteur+=prenom[(int)(Math.random()*prenom.length)];
			nomAuteur+=nom[(int)(Math.random()*nom.length)];
			nomEditeur+=edition[(int)(Math.random()*edition.length)];
			
			
			//Titre
			livre.setTitre(titre);
			//Date
			livre.setParution(dateParution);
			
			//Image (nom par défaut)
			livre.setImage(image);
			livre.setDisponible(true);
			
			//Auteur
			auteur.setNom(nomAuteur);
			auteur.setPrenom(prenomAuteur);
			auteur.getLivres().add(livre);


			
			//Editeur
			editeur.setNom(nomEditeur);


			
			//Resume
			livre.setResume(resume);
			
			//Ouvrage
			for (Iterator iterator = listOuvrage.iterator(); iterator.hasNext();) {
				Ouvrage ouvrage2 = (Ouvrage) iterator.next();
				if(ouvrage2.getIdOuvrage()== ouvrageId)livre.setOuvrage(ouvrage2);
				
			}
			
			
			//Genre
			for (Iterator iterator = listGenre.iterator(); iterator.hasNext();) {
				Genre genre2 = (Genre) iterator.next();
				if(genre2.getIdGenre()==genreId)livre.getGenres().add(genre2);
			}

			//Ajout Auteurs/Editeur/ouvrage/genre au livre
			livre.getAuteurs().add(auteur);
			livre.getEditeurs().add(editeur);

			
			this.liste.add(livre);
		    }
		
	}
	
	
	
	

}
