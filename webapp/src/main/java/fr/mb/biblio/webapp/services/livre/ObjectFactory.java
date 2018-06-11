
package fr.mb.biblio.webapp.services.livre;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.mb.biblio.webapp.services.livre package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _InsertionExemple_QNAME = new QName("http://contract.livreService.soap.biblio.mb.fr/", "insertionExemple");
    private final static QName _Ouvrage_QNAME = new QName("http://contract.livreService.soap.biblio.mb.fr/", "ouvrage");
    private final static QName _RechercheLivres_QNAME = new QName("http://contract.livreService.soap.biblio.mb.fr/", "rechercheLivres");
    private final static QName _GetAllLivresResponse_QNAME = new QName("http://contract.livreService.soap.biblio.mb.fr/", "getAllLivresResponse");
    private final static QName _GetLivreById_QNAME = new QName("http://contract.livreService.soap.biblio.mb.fr/", "getLivreById");
    private final static QName _InsertionExempleResponse_QNAME = new QName("http://contract.livreService.soap.biblio.mb.fr/", "insertionExempleResponse");
    private final static QName _Genre_QNAME = new QName("http://contract.livreService.soap.biblio.mb.fr/", "genre");
    private final static QName _GetAllLivres_QNAME = new QName("http://contract.livreService.soap.biblio.mb.fr/", "getAllLivres");
    private final static QName _FunctionalException_QNAME = new QName("http://contract.livreService.soap.biblio.mb.fr/", "FunctionalException");
    private final static QName _CreationAleatoireLivre_QNAME = new QName("http://contract.livreService.soap.biblio.mb.fr/", "creationAleatoireLivre");
    private final static QName _DateRetourLivreResponse_QNAME = new QName("http://contract.livreService.soap.biblio.mb.fr/", "dateRetourLivreResponse");
    private final static QName _CreationAleatoireLivreResponse_QNAME = new QName("http://contract.livreService.soap.biblio.mb.fr/", "creationAleatoireLivreResponse");
    private final static QName _GetLivreByIdResponse_QNAME = new QName("http://contract.livreService.soap.biblio.mb.fr/", "getLivreByIdResponse");
    private final static QName _DateRetourLivre_QNAME = new QName("http://contract.livreService.soap.biblio.mb.fr/", "dateRetourLivre");
    private final static QName _Insert_QNAME = new QName("http://contract.livreService.soap.biblio.mb.fr/", "insert");
    private final static QName _RechercheLivresResponse_QNAME = new QName("http://contract.livreService.soap.biblio.mb.fr/", "rechercheLivresResponse");
    private final static QName _NotFoundException_QNAME = new QName("http://contract.livreService.soap.biblio.mb.fr/", "NotFoundException");
    private final static QName _Auteur_QNAME = new QName("http://contract.livreService.soap.biblio.mb.fr/", "auteur");
    private final static QName _Editeur_QNAME = new QName("http://contract.livreService.soap.biblio.mb.fr/", "editeur");
    private final static QName _InsertResponse_QNAME = new QName("http://contract.livreService.soap.biblio.mb.fr/", "insertResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.mb.biblio.webapp.services.livre
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreationAleatoireLivreResponse }
     * 
     */
    public CreationAleatoireLivreResponse createCreationAleatoireLivreResponse() {
        return new CreationAleatoireLivreResponse();
    }

    /**
     * Create an instance of {@link GetLivreByIdResponse }
     * 
     */
    public GetLivreByIdResponse createGetLivreByIdResponse() {
        return new GetLivreByIdResponse();
    }

    /**
     * Create an instance of {@link DateRetourLivre }
     * 
     */
    public DateRetourLivre createDateRetourLivre() {
        return new DateRetourLivre();
    }

    /**
     * Create an instance of {@link Insert }
     * 
     */
    public Insert createInsert() {
        return new Insert();
    }

    /**
     * Create an instance of {@link RechercheLivresResponse }
     * 
     */
    public RechercheLivresResponse createRechercheLivresResponse() {
        return new RechercheLivresResponse();
    }

    /**
     * Create an instance of {@link NotFoundException }
     * 
     */
    public NotFoundException createNotFoundException() {
        return new NotFoundException();
    }

    /**
     * Create an instance of {@link InsertResponse }
     * 
     */
    public InsertResponse createInsertResponse() {
        return new InsertResponse();
    }

    /**
     * Create an instance of {@link Auteur }
     * 
     */
    public Auteur createAuteur() {
        return new Auteur();
    }

    /**
     * Create an instance of {@link Editeur }
     * 
     */
    public Editeur createEditeur() {
        return new Editeur();
    }

    /**
     * Create an instance of {@link InsertionExemple }
     * 
     */
    public InsertionExemple createInsertionExemple() {
        return new InsertionExemple();
    }

    /**
     * Create an instance of {@link Ouvrage }
     * 
     */
    public Ouvrage createOuvrage() {
        return new Ouvrage();
    }

    /**
     * Create an instance of {@link RechercheLivres }
     * 
     */
    public RechercheLivres createRechercheLivres() {
        return new RechercheLivres();
    }

    /**
     * Create an instance of {@link GetLivreById }
     * 
     */
    public GetLivreById createGetLivreById() {
        return new GetLivreById();
    }

    /**
     * Create an instance of {@link GetAllLivresResponse }
     * 
     */
    public GetAllLivresResponse createGetAllLivresResponse() {
        return new GetAllLivresResponse();
    }

    /**
     * Create an instance of {@link Genre }
     * 
     */
    public Genre createGenre() {
        return new Genre();
    }

    /**
     * Create an instance of {@link GetAllLivres }
     * 
     */
    public GetAllLivres createGetAllLivres() {
        return new GetAllLivres();
    }

    /**
     * Create an instance of {@link InsertionExempleResponse }
     * 
     */
    public InsertionExempleResponse createInsertionExempleResponse() {
        return new InsertionExempleResponse();
    }

    /**
     * Create an instance of {@link FunctionalException }
     * 
     */
    public FunctionalException createFunctionalException() {
        return new FunctionalException();
    }

    /**
     * Create an instance of {@link CreationAleatoireLivre }
     * 
     */
    public CreationAleatoireLivre createCreationAleatoireLivre() {
        return new CreationAleatoireLivre();
    }

    /**
     * Create an instance of {@link DateRetourLivreResponse }
     * 
     */
    public DateRetourLivreResponse createDateRetourLivreResponse() {
        return new DateRetourLivreResponse();
    }

    /**
     * Create an instance of {@link RechercheLivre }
     * 
     */
    public RechercheLivre createRechercheLivre() {
        return new RechercheLivre();
    }

    /**
     * Create an instance of {@link Livre }
     * 
     */
    public Livre createLivre() {
        return new Livre();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertionExemple }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.livreService.soap.biblio.mb.fr/", name = "insertionExemple")
    public JAXBElement<InsertionExemple> createInsertionExemple(InsertionExemple value) {
        return new JAXBElement<InsertionExemple>(_InsertionExemple_QNAME, InsertionExemple.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Ouvrage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.livreService.soap.biblio.mb.fr/", name = "ouvrage")
    public JAXBElement<Ouvrage> createOuvrage(Ouvrage value) {
        return new JAXBElement<Ouvrage>(_Ouvrage_QNAME, Ouvrage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RechercheLivres }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.livreService.soap.biblio.mb.fr/", name = "rechercheLivres")
    public JAXBElement<RechercheLivres> createRechercheLivres(RechercheLivres value) {
        return new JAXBElement<RechercheLivres>(_RechercheLivres_QNAME, RechercheLivres.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllLivresResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.livreService.soap.biblio.mb.fr/", name = "getAllLivresResponse")
    public JAXBElement<GetAllLivresResponse> createGetAllLivresResponse(GetAllLivresResponse value) {
        return new JAXBElement<GetAllLivresResponse>(_GetAllLivresResponse_QNAME, GetAllLivresResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLivreById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.livreService.soap.biblio.mb.fr/", name = "getLivreById")
    public JAXBElement<GetLivreById> createGetLivreById(GetLivreById value) {
        return new JAXBElement<GetLivreById>(_GetLivreById_QNAME, GetLivreById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertionExempleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.livreService.soap.biblio.mb.fr/", name = "insertionExempleResponse")
    public JAXBElement<InsertionExempleResponse> createInsertionExempleResponse(InsertionExempleResponse value) {
        return new JAXBElement<InsertionExempleResponse>(_InsertionExempleResponse_QNAME, InsertionExempleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Genre }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.livreService.soap.biblio.mb.fr/", name = "genre")
    public JAXBElement<Genre> createGenre(Genre value) {
        return new JAXBElement<Genre>(_Genre_QNAME, Genre.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllLivres }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.livreService.soap.biblio.mb.fr/", name = "getAllLivres")
    public JAXBElement<GetAllLivres> createGetAllLivres(GetAllLivres value) {
        return new JAXBElement<GetAllLivres>(_GetAllLivres_QNAME, GetAllLivres.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FunctionalException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.livreService.soap.biblio.mb.fr/", name = "FunctionalException")
    public JAXBElement<FunctionalException> createFunctionalException(FunctionalException value) {
        return new JAXBElement<FunctionalException>(_FunctionalException_QNAME, FunctionalException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreationAleatoireLivre }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.livreService.soap.biblio.mb.fr/", name = "creationAleatoireLivre")
    public JAXBElement<CreationAleatoireLivre> createCreationAleatoireLivre(CreationAleatoireLivre value) {
        return new JAXBElement<CreationAleatoireLivre>(_CreationAleatoireLivre_QNAME, CreationAleatoireLivre.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateRetourLivreResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.livreService.soap.biblio.mb.fr/", name = "dateRetourLivreResponse")
    public JAXBElement<DateRetourLivreResponse> createDateRetourLivreResponse(DateRetourLivreResponse value) {
        return new JAXBElement<DateRetourLivreResponse>(_DateRetourLivreResponse_QNAME, DateRetourLivreResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreationAleatoireLivreResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.livreService.soap.biblio.mb.fr/", name = "creationAleatoireLivreResponse")
    public JAXBElement<CreationAleatoireLivreResponse> createCreationAleatoireLivreResponse(CreationAleatoireLivreResponse value) {
        return new JAXBElement<CreationAleatoireLivreResponse>(_CreationAleatoireLivreResponse_QNAME, CreationAleatoireLivreResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLivreByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.livreService.soap.biblio.mb.fr/", name = "getLivreByIdResponse")
    public JAXBElement<GetLivreByIdResponse> createGetLivreByIdResponse(GetLivreByIdResponse value) {
        return new JAXBElement<GetLivreByIdResponse>(_GetLivreByIdResponse_QNAME, GetLivreByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateRetourLivre }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.livreService.soap.biblio.mb.fr/", name = "dateRetourLivre")
    public JAXBElement<DateRetourLivre> createDateRetourLivre(DateRetourLivre value) {
        return new JAXBElement<DateRetourLivre>(_DateRetourLivre_QNAME, DateRetourLivre.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Insert }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.livreService.soap.biblio.mb.fr/", name = "insert")
    public JAXBElement<Insert> createInsert(Insert value) {
        return new JAXBElement<Insert>(_Insert_QNAME, Insert.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RechercheLivresResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.livreService.soap.biblio.mb.fr/", name = "rechercheLivresResponse")
    public JAXBElement<RechercheLivresResponse> createRechercheLivresResponse(RechercheLivresResponse value) {
        return new JAXBElement<RechercheLivresResponse>(_RechercheLivresResponse_QNAME, RechercheLivresResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotFoundException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.livreService.soap.biblio.mb.fr/", name = "NotFoundException")
    public JAXBElement<NotFoundException> createNotFoundException(NotFoundException value) {
        return new JAXBElement<NotFoundException>(_NotFoundException_QNAME, NotFoundException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Auteur }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.livreService.soap.biblio.mb.fr/", name = "auteur")
    public JAXBElement<Auteur> createAuteur(Auteur value) {
        return new JAXBElement<Auteur>(_Auteur_QNAME, Auteur.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Editeur }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.livreService.soap.biblio.mb.fr/", name = "editeur")
    public JAXBElement<Editeur> createEditeur(Editeur value) {
        return new JAXBElement<Editeur>(_Editeur_QNAME, Editeur.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.livreService.soap.biblio.mb.fr/", name = "insertResponse")
    public JAXBElement<InsertResponse> createInsertResponse(InsertResponse value) {
        return new JAXBElement<InsertResponse>(_InsertResponse_QNAME, InsertResponse.class, null, value);
    }

}
