# P10-Biblio

v1.000
Le projet a pour objectif de créer dans un premier temps un web service SOAP à destination d'une bibliothèque permettant : 
- L'identification de ses membres
- De trouver les ouvrages et de voir leur disponibilité
- De gérer les prêts (nouveaux prêts, retour, prolongation, gestion des prêts en retard etc.)


- La création de web-app à destination des utilisateurs servant d'interface et devant communiquer avec le web-service pour récupérer les informations.
- La création d'un batch relançant par mail les utilisateurs dont les prêts sont en retard

v1.010
- Mise en place d'un système d'intégration continu avec docker/jenkins et automatisation des test

v1.011
- Correction d'un bug concernant la prolongation des prêts

v1.0.12
- Mise en place d'un système de réservation en ligne

v1.013
- Mise en place d'un système de relance des prêts arrivant à échéance

FONCTIONALITES

WEBSERVICE
- Système d'identification (avec utilisation d'un usernameToken pour sécuriser la transmission d'information)
- Système de gestion des livres (création de nouveaux ouvrages aléatoires, obtention des détails d'un ouvrage etc.)
- Possiblité de recherche d'ouvrage (par titre, puis affiner par auteur ou genre)
- Système de gestion des prêts (nouveau, prolonger un prêt, fin d'un pret, obtention des prêts en retard, en cours etc.)
- Système de relance des prêts en retard
- Système de réservation(création/suppression/etc.)
 

WEBAPP
- Login
- Recherche d'ouvrage
- Espace personnel permettant de gérer ses prêts
- Espace personnel permettant de gérer ses réservations

BATCH
Différents scheduleurs faisant appel au web-service :
- relance manuelle ou automatique des prêts en retard
- suppression automatique des réservations terminées
- rappel des prêts arrivant à échéance


DEVELOPPEMENT

Projet développé avec les technologies suivantes : 

WEBSERVICE : 
- JAVA/JAVAEE
- MAVEN : Projet multi-modules/Gestion des dépendances/Packaging
- SPRING : utilisé principalement pour l'IoC, gérer le paramétrage du web service
- JAX-WS et CXF : pour le web service
- HIBERNATE : pour la persistence des données. Configuré via les annotations. 


WEBAPP:
- JAVA/JAVAEE
- STRUTS2 : framework MVC utilisé pour la couche web-app
- MAVEN : Projet multi-modules/Gestion des dépendances/Packaging
- SPRING : utilisé principalement pour l'IoC
- JAX-WS et CXF : pour le web service côté client
- HTML/CSS/BOOTSTRAP : pour les JSP

BATCH : 
- JAVA/JAVAEE
- SPRING : utilisé principalement pour l'IoC
- JAX-WS et CXF : pour le web service côté client

AUTRES : 
- Log4J pour la gestion des Logs.

- SQL PowerArchitect : conception de la base de donnée
- PostgreSQL/PGAdmin : administration et gestion de la base de données

- Jenkins : Intégration continue
- Docker : déploiement sur des containers indépendants


CONFIGURATION

Les fichiers properties définissent des variables qui par défaut peuvent être renseignées via des variables d'environnement 
ou peuvent être renseignées manuellement directement dans les fichiers properties.

WEB SERVICE : 

- Hibernate : Hibernate.properties dans les ressources spécifiant les paramètres de connexion à la base de donnée : 
	hibernate.connection.driver_class
	hibernate.connection.url
	hibernate.connection.username
	hibernate.connection.password
  
- Durée de prêt : configPret.properties indiquant la durée de prêt

- Configuration de l'envoi des emails : email.properties indiquant l'host, le port, username et password

BATCH : 
- Connect.properties spécifiant un utilisateur et mdp permettant la connexion sécurisée via UsernameToken
- service.properties pour indiquer l'adresse du web-service
- batch.properties pour configurer les CRON

WEBAPP : 
 Configurer le fichier properties service.properties pour indiquer l'adresse du web-service déployé.
  


DEPLOIEMENT

SANS DOCKER : 

DATABASE : 
Créer une base de donnée et utiliser le script dumpvdef.sql importer la base de données 

WEB-Service
L'application peut être packagée via Maven et peut être déployée sur une serveur.
ex pour Tomcat, mettre le fichier war dans le dossier webapps de Tomcat.

WEB-App
L'application a été packagée via Maven et peut être déployée sur une serveur.
ex pour Tomcat, mettre le fichier war dans le dossier webapps de Tomcat.

Batch
L'application est un Jar executable

UTILISATION DE DOCKER :
Deployer la base de données en utilisant le docker-compose fourni :
'docker-compose up -d'

L'application est configurée pour builder une image docker Tomcat configurée automatiquement lors de son build en plaçant le DockerFile à la racine du projet.
Pour le web-service : 
- placer le DockerFile du webservice à la racine du dossier SOAP. Configurer directement dans le DockerFile les variables d'environnement si vous le souhaitez
- lancer le build (mvn package)
- lancer le container docker en configurant les variables d'environnement si non renseignées dans le DockerFile en rajoutant -e NOMENV='VALUEENV'
'docker run -d --name soapContainerTest -p 8081:8081 soap-test 

Pour la web-app :
- placer le DockerFile du webservice à la racine du dossier webapp. Configurer directement dans le DockerFile les variables d'environnement si vous le souhaitez
- lancer le build (mvn package)
- lancer le container docker en configurant les variables d'environnement si non renseignées dans le DockerFile en rajoutant -e NOMENV='VALUEENV'
'docker run -d --name webAppContainerTest -p 8086:8086 webapp-test

Pour le batch : 
- placer le DockerFile du batch à la racine du dossier batch. Configurer directement dans le DockerFile les variables d'environnement si vous le souhaitez
- lancer le build (mvn package)
- lancer le container docker en configurant les variables d'environnement si non renseignées dans le DockerFile en rajoutant -e NOMENV='VALUEENV'
'docker run -d --name batchAppContainerTest -p 8087:8087 batch-test


