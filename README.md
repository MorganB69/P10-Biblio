# P7-Biblio

Le projet a pour objectif de créer dans un premier temps un web service SOAP à destination d'une bibliothèque permettant : 
- L'identification de ses membres
- De trouver les ouvrages et de voir leur disponibilité
- De gérer les prêts (nouveaux prêts, retour, prolongation, gestion des prêts en retard etc.)

La suite du projet est :
- La création de web-app à destination des utilisateurs servant d'interface et devant communiquer avec le web-service pour récupérer les informations.
- La création d'un batch relançant par mail les utilisateurs dont les prêts sont en retard

FONCTIONALITES

WEBSERVICE
- Système d'identification (avec utilisation d'un usernameToken pour sécuriser la transmission d'information)
- Système de gestion des livres (création de nouveaux ouvrages aléatoires, obtention des détails d'un ouvrage etc.)
- Possiblité de recherche d'ouvrage (par titre, puis affiner par auteur ou genre)
- Système de gestion des prêts (nouveau, prolonger un prêt, fin d'un pret, obtention des prêts en retard, en cours etc.)
- Système de relance des prêts en retard via un scheduleur 

WEBAPP
- Login
- Recherche d'ouvrage
- Espace personnel permettant de gérer ses prêts

BATCH
- Appel le webservice de relance par mail

DEVELOPPEMENT

Projet développé avec les technologies suivantes : 

WEBSERVICE : 
- JAVA/JAVAEE
- MAVEN : Projet multi-modules/Gestion des dépendances/Packaging
- SPRING : utilisé principalement pour l'IoC, gérer le paramétrage du web service
- CXF : pour le web service
- HIBERNATE : pour la persistence des données. Configuré via les annotations. 


WEBAPP:
- JAVA/JAVAEE
- STRUTS2 : framework MVC utilisé pour la couche web-app
- MAVEN : Projet multi-modules/Gestion des dépendances/Packaging
- SPRING : utilisé principalement pour l'IoC, gérer le webservice
- HTML/CSS/BOOTSTRAP : pour les JSP

BATCH : 
- JAVA/JAVAEE

AUTRES : 
- Log4J pour la gestion des Logs.

- SQL PowerArchitect : conception de la base de donnée
- PostgreSQL/PGAdmin : administration et gestion de la base de données


CONFIGURATION

Base de donnée : Via PgAdmin : Créer une base de donnée et restaurer le fichier de backup P7 Biblio db def

Fichiers Properties à configurer au niveau du WEB SERVICE : 

Hibernate : Rajouter un fichier hibernate.properties dans les ressources spécifiant les paramètres de connexion à la base de donnée : 
	hibernate.connection.driver_class
	hibernate.connection.url
	hibernate.connection.username
	hibernate.connection.password
  
Durée de prêt : configPret.properties indiquant la durée de prêt

Configuration de l'envoi des emails : email.properties indiquant l'host, le port, username et password

relance via emails : relanceMail.properties indiquant le paramétrage de relance par mail via une expression "Cron"

Fichiers Properties à configurer au niveau du BATCH : Connect.properties spécifiant un utilisateur et mdp permettant la connexion sécurisée via UsernameToken
  


DEPLOIEMENT

WEB-Service
L'application a été packagée via Maven et peut être déployée sur une serveur via le fichier webservice.war.
ex pour Tomcat, mettre le fichier war dans le dossier webapps de Tomcat.

WEB-App
L'application a été packagée via Maven et peut être déployée sur une serveur via le fichier webapp.war.
ex pour Tomcat, mettre le fichier war dans le dossier webapps de Tomcat.

Batch
L'application est un Jar executable
