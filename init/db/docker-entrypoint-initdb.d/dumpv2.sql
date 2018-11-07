--
-- PostgreSQL database dump
--

-- Dumped from database version 10.1
-- Dumped by pg_dump version 10.1

-- Started on 2018-11-07 10:43:44

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12924)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2922 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 196 (class 1259 OID 35132)
-- Name: auteur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE auteur (
    id_auteur integer NOT NULL,
    prenom character varying NOT NULL,
    nom character varying NOT NULL
);


ALTER TABLE auteur OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 35138)
-- Name: auteur_id_auteur_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE auteur_id_auteur_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE auteur_id_auteur_seq OWNER TO postgres;

--
-- TOC entry 2923 (class 0 OID 0)
-- Dependencies: 197
-- Name: auteur_id_auteur_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE auteur_id_auteur_seq OWNED BY auteur.id_auteur;


--
-- TOC entry 198 (class 1259 OID 35140)
-- Name: editeur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE editeur (
    id_editeur integer NOT NULL,
    nom character varying NOT NULL
);


ALTER TABLE editeur OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 35146)
-- Name: editeur_id_editeur_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE editeur_id_editeur_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE editeur_id_editeur_seq OWNER TO postgres;

--
-- TOC entry 2924 (class 0 OID 0)
-- Dependencies: 199
-- Name: editeur_id_editeur_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE editeur_id_editeur_seq OWNED BY editeur.id_editeur;


--
-- TOC entry 200 (class 1259 OID 35148)
-- Name: genre; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE genre (
    id_genre integer NOT NULL,
    genre character varying NOT NULL
);


ALTER TABLE genre OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 35154)
-- Name: genre_id_genre_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE genre_id_genre_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE genre_id_genre_seq OWNER TO postgres;

--
-- TOC entry 2925 (class 0 OID 0)
-- Dependencies: 201
-- Name: genre_id_genre_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE genre_id_genre_seq OWNED BY genre.id_genre;


--
-- TOC entry 202 (class 1259 OID 35156)
-- Name: livre; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE livre (
    id_livre integer NOT NULL,
    titre character varying NOT NULL,
    parution date NOT NULL,
    image character varying NOT NULL,
    resume character varying NOT NULL,
    id_ouvrage integer NOT NULL,
    disponible boolean DEFAULT true NOT NULL,
    exemplaire integer DEFAULT 1 NOT NULL
);


ALTER TABLE livre OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 35164)
-- Name: livre_auteur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE livre_auteur (
    id_livre integer NOT NULL,
    id_auteur integer NOT NULL
);


ALTER TABLE livre_auteur OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 35167)
-- Name: livre_editeur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE livre_editeur (
    id_livre integer NOT NULL,
    id_editeur integer NOT NULL
);


ALTER TABLE livre_editeur OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 35170)
-- Name: livre_genre; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE livre_genre (
    id_livre integer NOT NULL,
    id_genre integer NOT NULL
);


ALTER TABLE livre_genre OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 35173)
-- Name: livre_livre_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE livre_livre_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE livre_livre_id_seq OWNER TO postgres;

--
-- TOC entry 2926 (class 0 OID 0)
-- Dependencies: 206
-- Name: livre_livre_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE livre_livre_id_seq OWNED BY livre.id_livre;


--
-- TOC entry 207 (class 1259 OID 35175)
-- Name: ouvrage; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE ouvrage (
    id_ouvrage integer NOT NULL,
    typeouvrage character varying NOT NULL
);


ALTER TABLE ouvrage OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 35181)
-- Name: ouvrage_id_ouvrage_seq_1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ouvrage_id_ouvrage_seq_1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ouvrage_id_ouvrage_seq_1 OWNER TO postgres;

--
-- TOC entry 2927 (class 0 OID 0)
-- Dependencies: 208
-- Name: ouvrage_id_ouvrage_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ouvrage_id_ouvrage_seq_1 OWNED BY ouvrage.id_ouvrage;


--
-- TOC entry 209 (class 1259 OID 35183)
-- Name: pret; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE pret (
    id_pret integer NOT NULL,
    date_debut date NOT NULL,
    date_fin date NOT NULL,
    date_effective date,
    prolonge boolean NOT NULL,
    id_utilisateur integer NOT NULL,
    id_livre integer NOT NULL
);


ALTER TABLE pret OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 35186)
-- Name: pret_id_pret_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE pret_id_pret_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE pret_id_pret_seq OWNER TO postgres;

--
-- TOC entry 2928 (class 0 OID 0)
-- Dependencies: 210
-- Name: pret_id_pret_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE pret_id_pret_seq OWNED BY pret.id_pret;


--
-- TOC entry 211 (class 1259 OID 35188)
-- Name: reservation_id_resa_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE reservation_id_resa_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE reservation_id_resa_seq OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 35190)
-- Name: reservation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE reservation (
    id_resa integer DEFAULT nextval('reservation_id_resa_seq'::regclass) NOT NULL,
    date_debut date,
    date_fin date,
    id_livre integer NOT NULL,
    id_utilisateur integer NOT NULL
);


ALTER TABLE reservation OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 35194)
-- Name: utilisateur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE utilisateur (
    id_utilisateur integer NOT NULL,
    identifiant character varying NOT NULL,
    prenom character varying NOT NULL,
    nom character varying NOT NULL,
    mdp character varying NOT NULL,
    mail character varying NOT NULL,
    admin boolean DEFAULT false NOT NULL
);


ALTER TABLE utilisateur OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 35201)
-- Name: utilisateur_id_utilisateur_seq_1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE utilisateur_id_utilisateur_seq_1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE utilisateur_id_utilisateur_seq_1 OWNER TO postgres;

--
-- TOC entry 2929 (class 0 OID 0)
-- Dependencies: 214
-- Name: utilisateur_id_utilisateur_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE utilisateur_id_utilisateur_seq_1 OWNED BY utilisateur.id_utilisateur;


--
-- TOC entry 2730 (class 2604 OID 35203)
-- Name: auteur id_auteur; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY auteur ALTER COLUMN id_auteur SET DEFAULT nextval('auteur_id_auteur_seq'::regclass);


--
-- TOC entry 2731 (class 2604 OID 35204)
-- Name: editeur id_editeur; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY editeur ALTER COLUMN id_editeur SET DEFAULT nextval('editeur_id_editeur_seq'::regclass);


--
-- TOC entry 2732 (class 2604 OID 35205)
-- Name: genre id_genre; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY genre ALTER COLUMN id_genre SET DEFAULT nextval('genre_id_genre_seq'::regclass);


--
-- TOC entry 2735 (class 2604 OID 35206)
-- Name: livre id_livre; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY livre ALTER COLUMN id_livre SET DEFAULT nextval('livre_livre_id_seq'::regclass);


--
-- TOC entry 2736 (class 2604 OID 35207)
-- Name: ouvrage id_ouvrage; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ouvrage ALTER COLUMN id_ouvrage SET DEFAULT nextval('ouvrage_id_ouvrage_seq_1'::regclass);


--
-- TOC entry 2737 (class 2604 OID 35208)
-- Name: pret id_pret; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pret ALTER COLUMN id_pret SET DEFAULT nextval('pret_id_pret_seq'::regclass);


--
-- TOC entry 2740 (class 2604 OID 35209)
-- Name: utilisateur id_utilisateur; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY utilisateur ALTER COLUMN id_utilisateur SET DEFAULT nextval('utilisateur_id_utilisateur_seq_1'::regclass);


--
-- TOC entry 2897 (class 0 OID 35132)
-- Dependencies: 196
-- Data for Name: auteur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY auteur (id_auteur, prenom, nom) FROM stdin;
1	Guillaume	Musso
2	Marc	Levy
3	Michel	Bussi
4	Frédéric	Zumbiehl
5	Jean	Gaudreau
6	Paul	Lamy
7	Gaetane	LaGarde
8	Jade	Authier
9	Anne	Lamy
10	Paul	Laforge
11	Amber	Mercier
12	Marie	Mercier
13	Morgan	Gaudreau
14	Thomas	Pépin
\.


--
-- TOC entry 2899 (class 0 OID 35140)
-- Dependencies: 198
-- Data for Name: editeur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY editeur (id_editeur, nom) FROM stdin;
1	Calmann-Levy
2	Robert Laffont
3	Presses De La Cite
4	Cinebook
5	Coupart
6	Goguen
7	Sanschagrin
8	Charron
9	Chrétien
10	Sanschagrin
11	Aubé
12	Aubé
13	Lamontagne
14	Goguen
\.


--
-- TOC entry 2901 (class 0 OID 35148)
-- Dependencies: 200
-- Data for Name: genre; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY genre (id_genre, genre) FROM stdin;
1	Historique
2	Amour
3	Aventure
4	Policier
5	Science-Fiction
6	Fantasy
7	Fantastique
8	Horreur
9	Biographique
10	Fiction
\.


--
-- TOC entry 2903 (class 0 OID 35156)
-- Dependencies: 202
-- Data for Name: livre; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY livre (id_livre, titre, parution, image, resume, id_ouvrage, disponible, exemplaire) FROM stdin;
2	Une fille comme elle	2018-05-18	Une fille comme elle.jpg	Marc Levy est un multi-instrumentiste de l’imaginaire… La plus jolie des comédies romantiques. Tout est sourire dans ce roman. Entrez au 12 de la Cinquième Avenue. Vous verrez, c’est du plaisir à tous les étages. » Pierre Vavasseur, Le Parisien « Une trépidante comédie newyorkaise. » RTL, Bernard Lehut« Des personnages hauts en couleur. Une pétillante comédie de mœurs. » Valérie Trierweiler, Paris Match« Une formidable comédie… où tout peut arriver.	1	f	1
4	Buck Danny - Tome 8 : Black cobra	2018-05-16	Buck Danny - Tome 8 : Black cobra.jpg	 L'histoire d'un pilote d'avion	2	f	1
12	L'espion désespéré	2008-05-27	defautLivre.jpg	Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse nec arcu lobortis nulla ullamcorper aliquam id in diam. Nam dapibus, mauris ut feugiat tristique, nulla tortor lacinia libero, vel lacinia justo eros ut ipsum. Suspendisse maximus augue vitae velit pulvinar, a consequat ligula molestie. Aliquam commodo risus ut erat iaculis gravida. Nulla pulvinar ipsum quis enim auctor venenatis. Aenean felis ligula, elementum eget fringilla at, porttitor vel enim. In pulvinar malesuada iaculis. Pellentesque vel purus semper, suscipit elit sed, ultrices nibh. Donec felis neque, tincidunt non ante vel, maximus consectetur dui. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.	2	f	2
11	La déesse anglaise	1975-10-09	defautLivre.jpg	Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse nec arcu lobortis nulla ullamcorper aliquam id in diam. Nam dapibus, mauris ut feugiat tristique, nulla tortor lacinia libero, vel lacinia justo eros ut ipsum. Suspendisse maximus augue vitae velit pulvinar, a consequat ligula molestie. Aliquam commodo risus ut erat iaculis gravida. Nulla pulvinar ipsum quis enim auctor venenatis. Aenean felis ligula, elementum eget fringilla at, porttitor vel enim. In pulvinar malesuada iaculis. Pellentesque vel purus semper, suscipit elit sed, ultrices nibh. Donec felis neque, tincidunt non ante vel, maximus consectetur dui. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.	1	t	1
14	L'inconnu français	1995-04-03	defautLivre.jpg	Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse nec arcu lobortis nulla ullamcorper aliquam id in diam. Nam dapibus, mauris ut feugiat tristique, nulla tortor lacinia libero, vel lacinia justo eros ut ipsum. Suspendisse maximus augue vitae velit pulvinar, a consequat ligula molestie. Aliquam commodo risus ut erat iaculis gravida. Nulla pulvinar ipsum quis enim auctor venenatis. Aenean felis ligula, elementum eget fringilla at, porttitor vel enim. In pulvinar malesuada iaculis. Pellentesque vel purus semper, suscipit elit sed, ultrices nibh. Donec felis neque, tincidunt non ante vel, maximus consectetur dui. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.	3	t	1
13	L'espion mystérieux	1984-04-07	defautLivre.jpg	Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse nec arcu lobortis nulla ullamcorper aliquam id in diam. Nam dapibus, mauris ut feugiat tristique, nulla tortor lacinia libero, vel lacinia justo eros ut ipsum. Suspendisse maximus augue vitae velit pulvinar, a consequat ligula molestie. Aliquam commodo risus ut erat iaculis gravida. Nulla pulvinar ipsum quis enim auctor venenatis. Aenean felis ligula, elementum eget fringilla at, porttitor vel enim. In pulvinar malesuada iaculis. Pellentesque vel purus semper, suscipit elit sed, ultrices nibh. Donec felis neque, tincidunt non ante vel, maximus consectetur dui. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.	1	f	1
1	La jeune Fille et la nuit	2018-04-24	La jeune Fille et la nuit.jpg	Côte d’Azur - Hiver 1992 Une nuit glaciale, alors que le campus de son lycée est paralysé par une tempête de neige, Vinca Rockwell, 19 ans, l’une des plus brillantes élèves de classes prépas, s’enfuit avec son professeur de philo avec qui elle entretenait une relation secrète. Pour la jeune fille, « l’amour est tout ou il n’est rien ».Personne ne la reverra jamais.	1	t	1
3	Sang famille	2018-05-16	Sang famille.jpg	 Tel un soleil brutal, la lumière du phare des Enchaînés inonde la pièce. Une seconde à peine. Puis l'obscurité reprend le dessus, simplement percée du halo des lampes torches.Je vais mourir ici.C'est une certitude.Une seule question me hante, la dernière : jusqu'où sont-ils prêts à aller pour me faire avouer ? A fouiller ma mémoire, comme s'ils pouvaient en arracher les souvenirs qu'ils convoitent ?Tout est allé si vite, à peine quatre jours.Je n'étais alors qu'un adolescent parmi d'autres.Un orphelin.C'est du moins ce qu'on avait toujours voulu me faire croire... 	1	t	2
6	Le chien italien	2012-03-15	defautLivre.jpg	Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse nec arcu lobortis nulla ullamcorper aliquam id in diam. Nam dapibus, mauris ut feugiat tristique, nulla tortor lacinia libero, vel lacinia justo eros ut ipsum. Suspendisse maximus augue vitae velit pulvinar, a consequat ligula molestie. Aliquam commodo risus ut erat iaculis gravida. Nulla pulvinar ipsum quis enim auctor venenatis. Aenean felis ligula, elementum eget fringilla at, porttitor vel enim. In pulvinar malesuada iaculis. Pellentesque vel purus semper, suscipit elit sed, ultrices nibh. Donec felis neque, tincidunt non ante vel, maximus consectetur dui. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.	3	t	1
5	L'aventurier italien	2000-09-10	defautLivre.jpg	Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse nec arcu lobortis nulla ullamcorper aliquam id in diam. Nam dapibus, mauris ut feugiat tristique, nulla tortor lacinia libero, vel lacinia justo eros ut ipsum. Suspendisse maximus augue vitae velit pulvinar, a consequat ligula molestie. Aliquam commodo risus ut erat iaculis gravida. Nulla pulvinar ipsum quis enim auctor venenatis. Aenean felis ligula, elementum eget fringilla at, porttitor vel enim. In pulvinar malesuada iaculis. Pellentesque vel purus semper, suscipit elit sed, ultrices nibh. Donec felis neque, tincidunt non ante vel, maximus consectetur dui. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.	2	f	3
8	L'inconnu riche	2007-07-26	defautLivre.jpg	Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse nec arcu lobortis nulla ullamcorper aliquam id in diam. Nam dapibus, mauris ut feugiat tristique, nulla tortor lacinia libero, vel lacinia justo eros ut ipsum. Suspendisse maximus augue vitae velit pulvinar, a consequat ligula molestie. Aliquam commodo risus ut erat iaculis gravida. Nulla pulvinar ipsum quis enim auctor venenatis. Aenean felis ligula, elementum eget fringilla at, porttitor vel enim. In pulvinar malesuada iaculis. Pellentesque vel purus semper, suscipit elit sed, ultrices nibh. Donec felis neque, tincidunt non ante vel, maximus consectetur dui. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.	1	t	1
7	La dame pauvre	1970-12-08	defautLivre.jpg	Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse nec arcu lobortis nulla ullamcorper aliquam id in diam. Nam dapibus, mauris ut feugiat tristique, nulla tortor lacinia libero, vel lacinia justo eros ut ipsum. Suspendisse maximus augue vitae velit pulvinar, a consequat ligula molestie. Aliquam commodo risus ut erat iaculis gravida. Nulla pulvinar ipsum quis enim auctor venenatis. Aenean felis ligula, elementum eget fringilla at, porttitor vel enim. In pulvinar malesuada iaculis. Pellentesque vel purus semper, suscipit elit sed, ultrices nibh. Donec felis neque, tincidunt non ante vel, maximus consectetur dui. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.	2	t	1
10	La femme désesperée	1999-05-15	defautLivre.jpg	Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse nec arcu lobortis nulla ullamcorper aliquam id in diam. Nam dapibus, mauris ut feugiat tristique, nulla tortor lacinia libero, vel lacinia justo eros ut ipsum. Suspendisse maximus augue vitae velit pulvinar, a consequat ligula molestie. Aliquam commodo risus ut erat iaculis gravida. Nulla pulvinar ipsum quis enim auctor venenatis. Aenean felis ligula, elementum eget fringilla at, porttitor vel enim. In pulvinar malesuada iaculis. Pellentesque vel purus semper, suscipit elit sed, ultrices nibh. Donec felis neque, tincidunt non ante vel, maximus consectetur dui. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.	2	t	2
9	L'aventurier anglais	1983-03-31	defautLivre.jpg	Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse nec arcu lobortis nulla ullamcorper aliquam id in diam. Nam dapibus, mauris ut feugiat tristique, nulla tortor lacinia libero, vel lacinia justo eros ut ipsum. Suspendisse maximus augue vitae velit pulvinar, a consequat ligula molestie. Aliquam commodo risus ut erat iaculis gravida. Nulla pulvinar ipsum quis enim auctor venenatis. Aenean felis ligula, elementum eget fringilla at, porttitor vel enim. In pulvinar malesuada iaculis. Pellentesque vel purus semper, suscipit elit sed, ultrices nibh. Donec felis neque, tincidunt non ante vel, maximus consectetur dui. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.	2	t	3
\.


--
-- TOC entry 2904 (class 0 OID 35164)
-- Dependencies: 203
-- Data for Name: livre_auteur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY livre_auteur (id_livre, id_auteur) FROM stdin;
1	1
2	2
3	3
4	4
5	5
6	6
7	7
8	8
9	9
10	10
11	11
12	12
13	13
14	14
\.


--
-- TOC entry 2905 (class 0 OID 35167)
-- Dependencies: 204
-- Data for Name: livre_editeur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY livre_editeur (id_livre, id_editeur) FROM stdin;
1	1
2	2
3	3
4	4
5	5
6	6
7	7
8	8
9	9
10	10
11	11
12	12
13	13
14	14
\.


--
-- TOC entry 2906 (class 0 OID 35170)
-- Dependencies: 205
-- Data for Name: livre_genre; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY livre_genre (id_livre, id_genre) FROM stdin;
1	10
2	10
3	4
4	3
5	10
6	2
7	6
8	1
9	2
10	5
11	10
12	3
13	8
14	10
\.


--
-- TOC entry 2908 (class 0 OID 35175)
-- Dependencies: 207
-- Data for Name: ouvrage; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY ouvrage (id_ouvrage, typeouvrage) FROM stdin;
1	Roman
2	Bande dessinée
3	Journal
4	Magazine
5	Documentaire
\.


--
-- TOC entry 2910 (class 0 OID 35183)
-- Dependencies: 209
-- Data for Name: pret; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY pret (id_pret, date_debut, date_fin, date_effective, prolonge, id_utilisateur, id_livre) FROM stdin;
2	2018-05-29	2018-06-26	\N	f	2	12
3	2018-05-29	2018-06-26	\N	f	3	2
4	2018-05-30	2018-06-27	\N	f	3	4
7	2018-04-04	2018-05-30	2018-06-01	t	3	8
6	2018-04-04	2018-05-02	\N	f	3	7
1	2018-05-29	2018-07-24	\N	t	2	13
8	2018-04-06	2018-06-01	\N	t	2	5
\.


--
-- TOC entry 2913 (class 0 OID 35190)
-- Dependencies: 212
-- Data for Name: reservation; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY reservation (id_resa, date_debut, date_fin, id_livre, id_utilisateur) FROM stdin;
\.


--
-- TOC entry 2914 (class 0 OID 35194)
-- Dependencies: 213
-- Data for Name: utilisateur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY utilisateur (id_utilisateur, identifiant, prenom, nom, mdp, mail, admin) FROM stdin;
2	Pauline	Pauline	L	azerty	mb.testocrbiblio@gmail.com	f
1	Morgan	Morgan	Brighi	azerty	mb.testocrbiblio@gmail.com	t
3	Jean	Jean	Dupont	1234	mb.testocrbiblio@gmail.com	f
\.


--
-- TOC entry 2930 (class 0 OID 0)
-- Dependencies: 197
-- Name: auteur_id_auteur_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('auteur_id_auteur_seq', 14, true);


--
-- TOC entry 2931 (class 0 OID 0)
-- Dependencies: 199
-- Name: editeur_id_editeur_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('editeur_id_editeur_seq', 14, true);


--
-- TOC entry 2932 (class 0 OID 0)
-- Dependencies: 201
-- Name: genre_id_genre_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('genre_id_genre_seq', 9, true);


--
-- TOC entry 2933 (class 0 OID 0)
-- Dependencies: 206
-- Name: livre_livre_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('livre_livre_id_seq', 14, true);


--
-- TOC entry 2934 (class 0 OID 0)
-- Dependencies: 208
-- Name: ouvrage_id_ouvrage_seq_1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('ouvrage_id_ouvrage_seq_1', 5, true);


--
-- TOC entry 2935 (class 0 OID 0)
-- Dependencies: 210
-- Name: pret_id_pret_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('pret_id_pret_seq', 8, true);


--
-- TOC entry 2936 (class 0 OID 0)
-- Dependencies: 211
-- Name: reservation_id_resa_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('reservation_id_resa_seq', 1, false);


--
-- TOC entry 2937 (class 0 OID 0)
-- Dependencies: 214
-- Name: utilisateur_id_utilisateur_seq_1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('utilisateur_id_utilisateur_seq_1', 3, true);


--
-- TOC entry 2742 (class 2606 OID 35211)
-- Name: auteur auteur_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY auteur
    ADD CONSTRAINT auteur_pk PRIMARY KEY (id_auteur);


--
-- TOC entry 2744 (class 2606 OID 35213)
-- Name: editeur editeur_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY editeur
    ADD CONSTRAINT editeur_pk PRIMARY KEY (id_editeur);


--
-- TOC entry 2746 (class 2606 OID 35215)
-- Name: genre genre_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY genre
    ADD CONSTRAINT genre_pk PRIMARY KEY (id_genre);


--
-- TOC entry 2750 (class 2606 OID 35217)
-- Name: livre_auteur livre_auteur_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY livre_auteur
    ADD CONSTRAINT livre_auteur_pk PRIMARY KEY (id_livre, id_auteur);


--
-- TOC entry 2752 (class 2606 OID 35219)
-- Name: livre_editeur livre_editeur_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY livre_editeur
    ADD CONSTRAINT livre_editeur_pk PRIMARY KEY (id_livre, id_editeur);


--
-- TOC entry 2754 (class 2606 OID 35221)
-- Name: livre_genre livre_genre_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY livre_genre
    ADD CONSTRAINT livre_genre_pk PRIMARY KEY (id_livre, id_genre);


--
-- TOC entry 2748 (class 2606 OID 35223)
-- Name: livre livre_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY livre
    ADD CONSTRAINT livre_pk PRIMARY KEY (id_livre);


--
-- TOC entry 2756 (class 2606 OID 35225)
-- Name: ouvrage ouvrage_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ouvrage
    ADD CONSTRAINT ouvrage_pk PRIMARY KEY (id_ouvrage);


--
-- TOC entry 2758 (class 2606 OID 35227)
-- Name: pret pret_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pret
    ADD CONSTRAINT pret_pk PRIMARY KEY (id_pret);


--
-- TOC entry 2762 (class 2606 OID 35229)
-- Name: reservation reservation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY reservation
    ADD CONSTRAINT reservation_pkey PRIMARY KEY (id_resa);


--
-- TOC entry 2764 (class 2606 OID 35231)
-- Name: utilisateur utilisateur_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY utilisateur
    ADD CONSTRAINT utilisateur_pk PRIMARY KEY (id_utilisateur);


--
-- TOC entry 2759 (class 1259 OID 35232)
-- Name: fki_livre_resa; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_livre_resa ON reservation USING btree (id_livre);


--
-- TOC entry 2760 (class 1259 OID 35233)
-- Name: fki_utilisateur_resa; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_utilisateur_resa ON reservation USING btree (id_utilisateur);


--
-- TOC entry 2766 (class 2606 OID 35234)
-- Name: livre_auteur auteur_livre_auteur_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY livre_auteur
    ADD CONSTRAINT auteur_livre_auteur_fk FOREIGN KEY (id_auteur) REFERENCES auteur(id_auteur);


--
-- TOC entry 2768 (class 2606 OID 35239)
-- Name: livre_editeur editeur_livre_editeur_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY livre_editeur
    ADD CONSTRAINT editeur_livre_editeur_fk FOREIGN KEY (id_editeur) REFERENCES editeur(id_editeur);


--
-- TOC entry 2770 (class 2606 OID 35244)
-- Name: livre_genre genre_livre_genre_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY livre_genre
    ADD CONSTRAINT genre_livre_genre_fk FOREIGN KEY (id_genre) REFERENCES genre(id_genre);


--
-- TOC entry 2767 (class 2606 OID 35249)
-- Name: livre_auteur livre_livre_auteur_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY livre_auteur
    ADD CONSTRAINT livre_livre_auteur_fk FOREIGN KEY (id_livre) REFERENCES livre(id_livre);


--
-- TOC entry 2769 (class 2606 OID 35254)
-- Name: livre_editeur livre_livre_editeur_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY livre_editeur
    ADD CONSTRAINT livre_livre_editeur_fk FOREIGN KEY (id_livre) REFERENCES livre(id_livre);


--
-- TOC entry 2771 (class 2606 OID 35259)
-- Name: livre_genre livre_livre_genre_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY livre_genre
    ADD CONSTRAINT livre_livre_genre_fk FOREIGN KEY (id_livre) REFERENCES livre(id_livre);


--
-- TOC entry 2772 (class 2606 OID 35264)
-- Name: pret livre_pret_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pret
    ADD CONSTRAINT livre_pret_fk FOREIGN KEY (id_livre) REFERENCES livre(id_livre);


--
-- TOC entry 2774 (class 2606 OID 35269)
-- Name: reservation livre_resa; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY reservation
    ADD CONSTRAINT livre_resa FOREIGN KEY (id_livre) REFERENCES livre(id_livre);


--
-- TOC entry 2765 (class 2606 OID 35274)
-- Name: livre ouvrage_livre_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY livre
    ADD CONSTRAINT ouvrage_livre_fk FOREIGN KEY (id_ouvrage) REFERENCES ouvrage(id_ouvrage);


--
-- TOC entry 2773 (class 2606 OID 35279)
-- Name: pret utilisateur_pret_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pret
    ADD CONSTRAINT utilisateur_pret_fk FOREIGN KEY (id_utilisateur) REFERENCES utilisateur(id_utilisateur);


--
-- TOC entry 2775 (class 2606 OID 35284)
-- Name: reservation utilisateur_resa; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY reservation
    ADD CONSTRAINT utilisateur_resa FOREIGN KEY (id_utilisateur) REFERENCES utilisateur(id_utilisateur);


-- Completed on 2018-11-07 10:43:45

--
-- PostgreSQL database dump complete
--

