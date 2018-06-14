
package fr.mb.biblio.batch.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.mb.biblio.batch.service package. 
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

    private final static QName _GetPretsEnCoursByUserResponse_QNAME = new QName("http://contract.pretService.soap.biblio.mb.fr/", "getPretsEnCoursByUserResponse");
    private final static QName _NouveauPretResponse_QNAME = new QName("http://contract.pretService.soap.biblio.mb.fr/", "nouveauPretResponse");
    private final static QName _GetPretsProlongesResponse_QNAME = new QName("http://contract.pretService.soap.biblio.mb.fr/", "getPretsProlongesResponse");
    private final static QName _Genre_QNAME = new QName("http://contract.pretService.soap.biblio.mb.fr/", "genre");
    private final static QName _GetPretsEnCours_QNAME = new QName("http://contract.pretService.soap.biblio.mb.fr/", "getPretsEnCours");
    private final static QName _GetPretById_QNAME = new QName("http://contract.pretService.soap.biblio.mb.fr/", "getPretById");
    private final static QName _GetPretByIdResponse_QNAME = new QName("http://contract.pretService.soap.biblio.mb.fr/", "getPretByIdResponse");
    private final static QName _GetPretsRetards_QNAME = new QName("http://contract.pretService.soap.biblio.mb.fr/", "getPretsRetards");
    private final static QName _Pret_QNAME = new QName("http://contract.pretService.soap.biblio.mb.fr/", "pret");
    private final static QName _GetPretsEnCoursByUser_QNAME = new QName("http://contract.pretService.soap.biblio.mb.fr/", "getPretsEnCoursByUser");
    private final static QName _GetPretsProlonges_QNAME = new QName("http://contract.pretService.soap.biblio.mb.fr/", "getPretsProlonges");
    private final static QName _Editeur_QNAME = new QName("http://contract.pretService.soap.biblio.mb.fr/", "editeur");
    private final static QName _ProlongerPret_QNAME = new QName("http://contract.pretService.soap.biblio.mb.fr/", "prolongerPret");
    private final static QName _ProlongerPretResponse_QNAME = new QName("http://contract.pretService.soap.biblio.mb.fr/", "prolongerPretResponse");
    private final static QName _NotFoundException_QNAME = new QName("http://contract.pretService.soap.biblio.mb.fr/", "NotFoundException");
    private final static QName _RelanceMailRetardsResponse_QNAME = new QName("http://contract.pretService.soap.biblio.mb.fr/", "relanceMailRetardsResponse");
    private final static QName _Ouvrage_QNAME = new QName("http://contract.pretService.soap.biblio.mb.fr/", "ouvrage");
    private final static QName _RetourPret_QNAME = new QName("http://contract.pretService.soap.biblio.mb.fr/", "retourPret");
    private final static QName _FunctionalException_QNAME = new QName("http://contract.pretService.soap.biblio.mb.fr/", "FunctionalException");
    private final static QName _CreationPretDateResponse_QNAME = new QName("http://contract.pretService.soap.biblio.mb.fr/", "creationPretDateResponse");
    private final static QName _GetPretsEnCoursResponse_QNAME = new QName("http://contract.pretService.soap.biblio.mb.fr/", "getPretsEnCoursResponse");
    private final static QName _GetPretsRetardsResponse_QNAME = new QName("http://contract.pretService.soap.biblio.mb.fr/", "getPretsRetardsResponse");
    private final static QName _Exception_QNAME = new QName("http://contract.pretService.soap.biblio.mb.fr/", "Exception");
    private final static QName _Auteur_QNAME = new QName("http://contract.pretService.soap.biblio.mb.fr/", "auteur");
    private final static QName _CreationPretDate_QNAME = new QName("http://contract.pretService.soap.biblio.mb.fr/", "creationPretDate");
    private final static QName _RelanceMailRetards_QNAME = new QName("http://contract.pretService.soap.biblio.mb.fr/", "relanceMailRetards");
    private final static QName _NouveauPret_QNAME = new QName("http://contract.pretService.soap.biblio.mb.fr/", "nouveauPret");
    private final static QName _RetourPretResponse_QNAME = new QName("http://contract.pretService.soap.biblio.mb.fr/", "retourPretResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.mb.biblio.batch.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Pret }
     * 
     */
    public Pret createPret() {
        return new Pret();
    }

    /**
     * Create an instance of {@link GetPretsEnCoursByUser }
     * 
     */
    public GetPretsEnCoursByUser createGetPretsEnCoursByUser() {
        return new GetPretsEnCoursByUser();
    }

    /**
     * Create an instance of {@link NotFoundException }
     * 
     */
    public NotFoundException createNotFoundException() {
        return new NotFoundException();
    }

    /**
     * Create an instance of {@link RelanceMailRetardsResponse }
     * 
     */
    public RelanceMailRetardsResponse createRelanceMailRetardsResponse() {
        return new RelanceMailRetardsResponse();
    }

    /**
     * Create an instance of {@link GetPretsProlonges }
     * 
     */
    public GetPretsProlonges createGetPretsProlonges() {
        return new GetPretsProlonges();
    }

    /**
     * Create an instance of {@link Editeur }
     * 
     */
    public Editeur createEditeur() {
        return new Editeur();
    }

    /**
     * Create an instance of {@link ProlongerPret }
     * 
     */
    public ProlongerPret createProlongerPret() {
        return new ProlongerPret();
    }

    /**
     * Create an instance of {@link ProlongerPretResponse }
     * 
     */
    public ProlongerPretResponse createProlongerPretResponse() {
        return new ProlongerPretResponse();
    }

    /**
     * Create an instance of {@link NouveauPretResponse }
     * 
     */
    public NouveauPretResponse createNouveauPretResponse() {
        return new NouveauPretResponse();
    }

    /**
     * Create an instance of {@link GetPretsEnCoursByUserResponse }
     * 
     */
    public GetPretsEnCoursByUserResponse createGetPretsEnCoursByUserResponse() {
        return new GetPretsEnCoursByUserResponse();
    }

    /**
     * Create an instance of {@link Genre }
     * 
     */
    public Genre createGenre() {
        return new Genre();
    }

    /**
     * Create an instance of {@link GetPretsEnCours }
     * 
     */
    public GetPretsEnCours createGetPretsEnCours() {
        return new GetPretsEnCours();
    }

    /**
     * Create an instance of {@link GetPretById }
     * 
     */
    public GetPretById createGetPretById() {
        return new GetPretById();
    }

    /**
     * Create an instance of {@link GetPretByIdResponse }
     * 
     */
    public GetPretByIdResponse createGetPretByIdResponse() {
        return new GetPretByIdResponse();
    }

    /**
     * Create an instance of {@link GetPretsRetards }
     * 
     */
    public GetPretsRetards createGetPretsRetards() {
        return new GetPretsRetards();
    }

    /**
     * Create an instance of {@link GetPretsProlongesResponse }
     * 
     */
    public GetPretsProlongesResponse createGetPretsProlongesResponse() {
        return new GetPretsProlongesResponse();
    }

    /**
     * Create an instance of {@link GetPretsRetardsResponse }
     * 
     */
    public GetPretsRetardsResponse createGetPretsRetardsResponse() {
        return new GetPretsRetardsResponse();
    }

    /**
     * Create an instance of {@link CreationPretDateResponse }
     * 
     */
    public CreationPretDateResponse createCreationPretDateResponse() {
        return new CreationPretDateResponse();
    }

    /**
     * Create an instance of {@link GetPretsEnCoursResponse }
     * 
     */
    public GetPretsEnCoursResponse createGetPretsEnCoursResponse() {
        return new GetPretsEnCoursResponse();
    }

    /**
     * Create an instance of {@link NouveauPret }
     * 
     */
    public NouveauPret createNouveauPret() {
        return new NouveauPret();
    }

    /**
     * Create an instance of {@link RetourPretResponse }
     * 
     */
    public RetourPretResponse createRetourPretResponse() {
        return new RetourPretResponse();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link Auteur }
     * 
     */
    public Auteur createAuteur() {
        return new Auteur();
    }

    /**
     * Create an instance of {@link CreationPretDate }
     * 
     */
    public CreationPretDate createCreationPretDate() {
        return new CreationPretDate();
    }

    /**
     * Create an instance of {@link RelanceMailRetards }
     * 
     */
    public RelanceMailRetards createRelanceMailRetards() {
        return new RelanceMailRetards();
    }

    /**
     * Create an instance of {@link Ouvrage }
     * 
     */
    public Ouvrage createOuvrage() {
        return new Ouvrage();
    }

    /**
     * Create an instance of {@link FunctionalException }
     * 
     */
    public FunctionalException createFunctionalException() {
        return new FunctionalException();
    }

    /**
     * Create an instance of {@link RetourPret }
     * 
     */
    public RetourPret createRetourPret() {
        return new RetourPret();
    }

    /**
     * Create an instance of {@link Utilisateur }
     * 
     */
    public Utilisateur createUtilisateur() {
        return new Utilisateur();
    }

    /**
     * Create an instance of {@link Livre }
     * 
     */
    public Livre createLivre() {
        return new Livre();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPretsEnCoursByUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.pretService.soap.biblio.mb.fr/", name = "getPretsEnCoursByUserResponse")
    public JAXBElement<GetPretsEnCoursByUserResponse> createGetPretsEnCoursByUserResponse(GetPretsEnCoursByUserResponse value) {
        return new JAXBElement<GetPretsEnCoursByUserResponse>(_GetPretsEnCoursByUserResponse_QNAME, GetPretsEnCoursByUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NouveauPretResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.pretService.soap.biblio.mb.fr/", name = "nouveauPretResponse")
    public JAXBElement<NouveauPretResponse> createNouveauPretResponse(NouveauPretResponse value) {
        return new JAXBElement<NouveauPretResponse>(_NouveauPretResponse_QNAME, NouveauPretResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPretsProlongesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.pretService.soap.biblio.mb.fr/", name = "getPretsProlongesResponse")
    public JAXBElement<GetPretsProlongesResponse> createGetPretsProlongesResponse(GetPretsProlongesResponse value) {
        return new JAXBElement<GetPretsProlongesResponse>(_GetPretsProlongesResponse_QNAME, GetPretsProlongesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Genre }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.pretService.soap.biblio.mb.fr/", name = "genre")
    public JAXBElement<Genre> createGenre(Genre value) {
        return new JAXBElement<Genre>(_Genre_QNAME, Genre.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPretsEnCours }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.pretService.soap.biblio.mb.fr/", name = "getPretsEnCours")
    public JAXBElement<GetPretsEnCours> createGetPretsEnCours(GetPretsEnCours value) {
        return new JAXBElement<GetPretsEnCours>(_GetPretsEnCours_QNAME, GetPretsEnCours.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPretById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.pretService.soap.biblio.mb.fr/", name = "getPretById")
    public JAXBElement<GetPretById> createGetPretById(GetPretById value) {
        return new JAXBElement<GetPretById>(_GetPretById_QNAME, GetPretById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPretByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.pretService.soap.biblio.mb.fr/", name = "getPretByIdResponse")
    public JAXBElement<GetPretByIdResponse> createGetPretByIdResponse(GetPretByIdResponse value) {
        return new JAXBElement<GetPretByIdResponse>(_GetPretByIdResponse_QNAME, GetPretByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPretsRetards }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.pretService.soap.biblio.mb.fr/", name = "getPretsRetards")
    public JAXBElement<GetPretsRetards> createGetPretsRetards(GetPretsRetards value) {
        return new JAXBElement<GetPretsRetards>(_GetPretsRetards_QNAME, GetPretsRetards.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Pret }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.pretService.soap.biblio.mb.fr/", name = "pret")
    public JAXBElement<Pret> createPret(Pret value) {
        return new JAXBElement<Pret>(_Pret_QNAME, Pret.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPretsEnCoursByUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.pretService.soap.biblio.mb.fr/", name = "getPretsEnCoursByUser")
    public JAXBElement<GetPretsEnCoursByUser> createGetPretsEnCoursByUser(GetPretsEnCoursByUser value) {
        return new JAXBElement<GetPretsEnCoursByUser>(_GetPretsEnCoursByUser_QNAME, GetPretsEnCoursByUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPretsProlonges }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.pretService.soap.biblio.mb.fr/", name = "getPretsProlonges")
    public JAXBElement<GetPretsProlonges> createGetPretsProlonges(GetPretsProlonges value) {
        return new JAXBElement<GetPretsProlonges>(_GetPretsProlonges_QNAME, GetPretsProlonges.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Editeur }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.pretService.soap.biblio.mb.fr/", name = "editeur")
    public JAXBElement<Editeur> createEditeur(Editeur value) {
        return new JAXBElement<Editeur>(_Editeur_QNAME, Editeur.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProlongerPret }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.pretService.soap.biblio.mb.fr/", name = "prolongerPret")
    public JAXBElement<ProlongerPret> createProlongerPret(ProlongerPret value) {
        return new JAXBElement<ProlongerPret>(_ProlongerPret_QNAME, ProlongerPret.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProlongerPretResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.pretService.soap.biblio.mb.fr/", name = "prolongerPretResponse")
    public JAXBElement<ProlongerPretResponse> createProlongerPretResponse(ProlongerPretResponse value) {
        return new JAXBElement<ProlongerPretResponse>(_ProlongerPretResponse_QNAME, ProlongerPretResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotFoundException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.pretService.soap.biblio.mb.fr/", name = "NotFoundException")
    public JAXBElement<NotFoundException> createNotFoundException(NotFoundException value) {
        return new JAXBElement<NotFoundException>(_NotFoundException_QNAME, NotFoundException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RelanceMailRetardsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.pretService.soap.biblio.mb.fr/", name = "relanceMailRetardsResponse")
    public JAXBElement<RelanceMailRetardsResponse> createRelanceMailRetardsResponse(RelanceMailRetardsResponse value) {
        return new JAXBElement<RelanceMailRetardsResponse>(_RelanceMailRetardsResponse_QNAME, RelanceMailRetardsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Ouvrage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.pretService.soap.biblio.mb.fr/", name = "ouvrage")
    public JAXBElement<Ouvrage> createOuvrage(Ouvrage value) {
        return new JAXBElement<Ouvrage>(_Ouvrage_QNAME, Ouvrage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetourPret }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.pretService.soap.biblio.mb.fr/", name = "retourPret")
    public JAXBElement<RetourPret> createRetourPret(RetourPret value) {
        return new JAXBElement<RetourPret>(_RetourPret_QNAME, RetourPret.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FunctionalException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.pretService.soap.biblio.mb.fr/", name = "FunctionalException")
    public JAXBElement<FunctionalException> createFunctionalException(FunctionalException value) {
        return new JAXBElement<FunctionalException>(_FunctionalException_QNAME, FunctionalException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreationPretDateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.pretService.soap.biblio.mb.fr/", name = "creationPretDateResponse")
    public JAXBElement<CreationPretDateResponse> createCreationPretDateResponse(CreationPretDateResponse value) {
        return new JAXBElement<CreationPretDateResponse>(_CreationPretDateResponse_QNAME, CreationPretDateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPretsEnCoursResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.pretService.soap.biblio.mb.fr/", name = "getPretsEnCoursResponse")
    public JAXBElement<GetPretsEnCoursResponse> createGetPretsEnCoursResponse(GetPretsEnCoursResponse value) {
        return new JAXBElement<GetPretsEnCoursResponse>(_GetPretsEnCoursResponse_QNAME, GetPretsEnCoursResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPretsRetardsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.pretService.soap.biblio.mb.fr/", name = "getPretsRetardsResponse")
    public JAXBElement<GetPretsRetardsResponse> createGetPretsRetardsResponse(GetPretsRetardsResponse value) {
        return new JAXBElement<GetPretsRetardsResponse>(_GetPretsRetardsResponse_QNAME, GetPretsRetardsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.pretService.soap.biblio.mb.fr/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Auteur }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.pretService.soap.biblio.mb.fr/", name = "auteur")
    public JAXBElement<Auteur> createAuteur(Auteur value) {
        return new JAXBElement<Auteur>(_Auteur_QNAME, Auteur.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreationPretDate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.pretService.soap.biblio.mb.fr/", name = "creationPretDate")
    public JAXBElement<CreationPretDate> createCreationPretDate(CreationPretDate value) {
        return new JAXBElement<CreationPretDate>(_CreationPretDate_QNAME, CreationPretDate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RelanceMailRetards }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.pretService.soap.biblio.mb.fr/", name = "relanceMailRetards")
    public JAXBElement<RelanceMailRetards> createRelanceMailRetards(RelanceMailRetards value) {
        return new JAXBElement<RelanceMailRetards>(_RelanceMailRetards_QNAME, RelanceMailRetards.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NouveauPret }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.pretService.soap.biblio.mb.fr/", name = "nouveauPret")
    public JAXBElement<NouveauPret> createNouveauPret(NouveauPret value) {
        return new JAXBElement<NouveauPret>(_NouveauPret_QNAME, NouveauPret.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetourPretResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.pretService.soap.biblio.mb.fr/", name = "retourPretResponse")
    public JAXBElement<RetourPretResponse> createRetourPretResponse(RetourPretResponse value) {
        return new JAXBElement<RetourPretResponse>(_RetourPretResponse_QNAME, RetourPretResponse.class, null, value);
    }

}
