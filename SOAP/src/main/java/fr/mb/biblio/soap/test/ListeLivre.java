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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
import javassist.expr.NewArray;

public  class  ListeLivre {
		private List<Map> listeMap=new ArrayList<Map>();
		private List<Livre>liste=new ArrayList<Livre>();
		
		
		
		
		

		
		public ListeLivre(List<Ouvrage> listOuvrage, List<Genre> listGenre) {
		// TODO Auto-generated method stub
		Map<String, String> livreMap1=new LinkedHashMap<>();	
		livreMap1.put("titre", "La jeune Fille et la nuit");
		livreMap1.put("auteurPrenom","Guillaume");
		livreMap1.put("auteurNom", "Musso");
		livreMap1.put("editeurNom", "Calmann-Levy");
		livreMap1.put("image", livreMap1.get("titre")+".jpg");
		livreMap1.put("dateParution", "24-04-2018");
		livreMap1.put("resume",
				"Côte d’Azur - Hiver 1992 Une nuit glaciale, alors que le campus de son lycée est paralysé par une tempête de neige, Vinca Rockwell, 19 ans, l’une des plus brillantes élèves de classes prépas, s’enfuit avec son professeur de philo avec qui elle entretenait une relation secrète. Pour la jeune fille, « l’amour est tout ou il n’est rien ».Personne ne la reverra jamais.");
		livreMap1.put("genre", "10");
		livreMap1.put("ouvrage", "1");		
		this.listeMap.add(livreMap1);
		
		Map<String, String> livreMap2=new LinkedHashMap<>();	
		livreMap2.put("titre", "Une fille comme elle");
		livreMap2.put("auteurPrenom","Marc");
		livreMap2.put("auteurNom", "Levy");
		livreMap2.put("editeurNom", "Robert Laffont");
		livreMap2.put("image", livreMap2.get("titre")+".jpg");
		livreMap2.put("dateParution", "18-05-2018");
		livreMap2.put("resume",
				"Marc Levy est un multi-instrumentiste de l’imaginaire… La plus jolie des comédies romantiques. Tout est sourire dans ce roman. Entrez au 12 de la Cinquième Avenue. Vous verrez, c’est du plaisir à tous les étages. » Pierre Vavasseur, Le Parisien « Une trépidante comédie newyorkaise. » RTL, Bernard Lehut« Des personnages hauts en couleur. Une pétillante comédie de mœurs. » Valérie Trierweiler, Paris Match« Une formidable comédie… où tout peut arriver.");
		livreMap2.put("genre", "10");
		livreMap2.put("ouvrage", "1");		
		this.listeMap.add(livreMap2);
		
		Map<String, String> livreMap3=new LinkedHashMap<>();	
		livreMap3.put("titre", "Sang famille");
		livreMap3.put("auteurPrenom","Michel");
		livreMap3.put("auteurNom", "Bussi");
		livreMap3.put("editeurNom", "Presses De La Cite");
		livreMap3.put("image", livreMap3.get("titre")+".jpg");
		livreMap3.put("dateParution", "16-05-2018");
		livreMap3.put("resume",
				" Tel un soleil brutal, la lumière du phare des Enchaînés inonde la pièce. Une seconde à peine. Puis l'obscurité reprend le dessus, simplement percée du halo des lampes torches.Je vais mourir ici.C'est une certitude."
				+"Une seule question me hante, la dernière : jusqu'où sont-ils prêts à aller pour me faire avouer ? A fouiller ma mémoire, comme s'ils pouvaient en arracher les souvenirs qu'ils convoitent ?"
				+"Tout est allé si vite, à peine quatre jours."
				+"Je n'étais alors qu'un adolescent parmi d'autres."
				+"Un orphelin."
				+"C'est du moins ce qu'on avait toujours voulu me faire croire... ");
		livreMap3.put("genre", "4");
		livreMap3.put("ouvrage", "1");		
		this.listeMap.add(livreMap3);
		
		Map<String, String> livreMap4=new LinkedHashMap<>();	
		livreMap4.put("titre", "Buck Danny - Tome 8 : Black cobra");
		livreMap4.put("auteurPrenom","Frédéric");
		livreMap4.put("auteurNom", "Zumbiehl");
		livreMap4.put("editeurNom", "Cinebook");
		livreMap4.put("image", livreMap4.get("titre")+".jpg");
		livreMap4.put("dateParution", "16-05-2018");
		livreMap4.put("resume",
				" L'histoire d'un pilote d'avion");
		livreMap4.put("genre", "3");
		livreMap4.put("ouvrage", "2");		
		this.listeMap.add(livreMap4);
		
		
		for (int i = 0; i < this.listeMap.size(); i++) {
			Livre livre=new Livre();
			Auteur auteur=new Auteur();
			Editeur editeur=new Editeur();
			
			//Titre
			livre.setTitre((String) this.listeMap.get(i).get("titre"));
			//Date
			String date=(String) this.listeMap.get(i).get("dateParution");
			DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate dateparution= LocalDate.parse(date,df);
			livre.setParution(dateparution);
			
			//Image (nom par défaut)
			livre.setImage((String) this.listeMap.get(i).get("image"));
			
			//Auteur
			auteur.setNom((String) this.listeMap.get(i).get("auteurNom"));
			auteur.setPrenom((String) this.listeMap.get(i).get("auteurPrenom"));
			auteur.getLivres().add(livre);


			
			//Editeur
			editeur.setNom((String) this.listeMap.get(i).get("editeurNom"));


			
			//Resume
			livre.setResume((String) this.listeMap.get(i).get("resume"));
			
			//Ouvrage
			for (Iterator iterator = listOuvrage.iterator(); iterator.hasNext();) {
				Ouvrage ouvrage2 = (Ouvrage) iterator.next();
				if(ouvrage2.getIdOuvrage()== Integer.parseInt((String) this.listeMap.get(i).get("ouvrage")))livre.setOuvrage(ouvrage2);
				
			}
			
			
			//Genre
			for (Iterator iterator = listGenre.iterator(); iterator.hasNext();) {
				Genre genre2 = (Genre) iterator.next();
				if(genre2.getIdGenre()==Integer.parseInt((String) this.listeMap.get(i).get("genre")))livre.getGenres().add(genre2);
			}

			//Ajout Auteurs/Editeur/ouvrage/genre au livre
			livre.getAuteurs().add(auteur);
			livre.getEditeurs().add(editeur);

			
			this.liste.add(livre);
			
			
			
		}
		

		
		
		
		}

		public  List<Livre> getListe() {
			return liste;
		}

		public void setListe(List<Livre> liste) {
			this.liste = liste;
		}

		public List<Map> getListeMap() {
			return listeMap;
		}

		public void setListeMap(List<Map> listeMap) {
			this.listeMap = listeMap;
		}
		
		

	

}
