
package fr.mb.biblio.batch.service.reservation;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.mb.biblio.batch.service.reservation package. 
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

    private final static QName _VerifEndResa_QNAME = new QName("http://contract.resaService.soap.biblio.mb.fr/", "verifEndResa");
    private final static QName _Genre_QNAME = new QName("http://contract.resaService.soap.biblio.mb.fr/", "genre");
    private final static QName _FunctionalException_QNAME = new QName("http://contract.resaService.soap.biblio.mb.fr/", "FunctionalException");
    private final static QName _MailResa_QNAME = new QName("http://contract.resaService.soap.biblio.mb.fr/", "mailResa");
    private final static QName _NewReservation_QNAME = new QName("http://contract.resaService.soap.biblio.mb.fr/", "newReservation");
    private final static QName _GetResaByLivreIdResponse_QNAME = new QName("http://contract.resaService.soap.biblio.mb.fr/", "getResaByLivreIdResponse");
    private final static QName _GetResaByUserId_QNAME = new QName("http://contract.resaService.soap.biblio.mb.fr/", "getResaByUserId");
    private final static QName _Ouvrage_QNAME = new QName("http://contract.resaService.soap.biblio.mb.fr/", "ouvrage");
    private final static QName _GetResaByLivreId_QNAME = new QName("http://contract.resaService.soap.biblio.mb.fr/", "getResaByLivreId");
    private final static QName _NewReservationResponse_QNAME = new QName("http://contract.resaService.soap.biblio.mb.fr/", "newReservationResponse");
    private final static QName _StartResa_QNAME = new QName("http://contract.resaService.soap.biblio.mb.fr/", "startResa");
    private final static QName _NotFoundException_QNAME = new QName("http://contract.resaService.soap.biblio.mb.fr/", "NotFoundException");
    private final static QName _StartResaResponse_QNAME = new QName("http://contract.resaService.soap.biblio.mb.fr/", "startResaResponse");
    private final static QName _DeleteReservation_QNAME = new QName("http://contract.resaService.soap.biblio.mb.fr/", "deleteReservation");
    private final static QName _VerifEndResaResponse_QNAME = new QName("http://contract.resaService.soap.biblio.mb.fr/", "verifEndResaResponse");
    private final static QName _Auteur_QNAME = new QName("http://contract.resaService.soap.biblio.mb.fr/", "auteur");
    private final static QName _Editeur_QNAME = new QName("http://contract.resaService.soap.biblio.mb.fr/", "editeur");
    private final static QName _Exception_QNAME = new QName("http://contract.resaService.soap.biblio.mb.fr/", "Exception");
    private final static QName _DeleteReservationResponse_QNAME = new QName("http://contract.resaService.soap.biblio.mb.fr/", "deleteReservationResponse");
    private final static QName _GetResaById_QNAME = new QName("http://contract.resaService.soap.biblio.mb.fr/", "getResaById");
    private final static QName _GetResaByIdResponse_QNAME = new QName("http://contract.resaService.soap.biblio.mb.fr/", "getResaByIdResponse");
    private final static QName _GetResaByUserIdResponse_QNAME = new QName("http://contract.resaService.soap.biblio.mb.fr/", "getResaByUserIdResponse");
    private final static QName _MailResaResponse_QNAME = new QName("http://contract.resaService.soap.biblio.mb.fr/", "mailResaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.mb.biblio.batch.service.reservation
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetResaById }
     * 
     */
    public GetResaById createGetResaById() {
        return new GetResaById();
    }

    /**
     * Create an instance of {@link DeleteReservationResponse }
     * 
     */
    public DeleteReservationResponse createDeleteReservationResponse() {
        return new DeleteReservationResponse();
    }

    /**
     * Create an instance of {@link GetResaByIdResponse }
     * 
     */
    public GetResaByIdResponse createGetResaByIdResponse() {
        return new GetResaByIdResponse();
    }

    /**
     * Create an instance of {@link GetResaByUserIdResponse }
     * 
     */
    public GetResaByUserIdResponse createGetResaByUserIdResponse() {
        return new GetResaByUserIdResponse();
    }

    /**
     * Create an instance of {@link MailResaResponse }
     * 
     */
    public MailResaResponse createMailResaResponse() {
        return new MailResaResponse();
    }

    /**
     * Create an instance of {@link StartResaResponse }
     * 
     */
    public StartResaResponse createStartResaResponse() {
        return new StartResaResponse();
    }

    /**
     * Create an instance of {@link NotFoundException }
     * 
     */
    public NotFoundException createNotFoundException() {
        return new NotFoundException();
    }

    /**
     * Create an instance of {@link DeleteReservation }
     * 
     */
    public DeleteReservation createDeleteReservation() {
        return new DeleteReservation();
    }

    /**
     * Create an instance of {@link VerifEndResaResponse }
     * 
     */
    public VerifEndResaResponse createVerifEndResaResponse() {
        return new VerifEndResaResponse();
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
     * Create an instance of {@link Editeur }
     * 
     */
    public Editeur createEditeur() {
        return new Editeur();
    }

    /**
     * Create an instance of {@link GetResaByUserId }
     * 
     */
    public GetResaByUserId createGetResaByUserId() {
        return new GetResaByUserId();
    }

    /**
     * Create an instance of {@link Ouvrage }
     * 
     */
    public Ouvrage createOuvrage() {
        return new Ouvrage();
    }

    /**
     * Create an instance of {@link NewReservationResponse }
     * 
     */
    public NewReservationResponse createNewReservationResponse() {
        return new NewReservationResponse();
    }

    /**
     * Create an instance of {@link GetResaByLivreId }
     * 
     */
    public GetResaByLivreId createGetResaByLivreId() {
        return new GetResaByLivreId();
    }

    /**
     * Create an instance of {@link StartResa }
     * 
     */
    public StartResa createStartResa() {
        return new StartResa();
    }

    /**
     * Create an instance of {@link Genre }
     * 
     */
    public Genre createGenre() {
        return new Genre();
    }

    /**
     * Create an instance of {@link VerifEndResa }
     * 
     */
    public VerifEndResa createVerifEndResa() {
        return new VerifEndResa();
    }

    /**
     * Create an instance of {@link MailResa }
     * 
     */
    public MailResa createMailResa() {
        return new MailResa();
    }

    /**
     * Create an instance of {@link FunctionalException }
     * 
     */
    public FunctionalException createFunctionalException() {
        return new FunctionalException();
    }

    /**
     * Create an instance of {@link NewReservation }
     * 
     */
    public NewReservation createNewReservation() {
        return new NewReservation();
    }

    /**
     * Create an instance of {@link GetResaByLivreIdResponse }
     * 
     */
    public GetResaByLivreIdResponse createGetResaByLivreIdResponse() {
        return new GetResaByLivreIdResponse();
    }

    /**
     * Create an instance of {@link Utilisateur }
     * 
     */
    public Utilisateur createUtilisateur() {
        return new Utilisateur();
    }

    /**
     * Create an instance of {@link Reservation }
     * 
     */
    public Reservation createReservation() {
        return new Reservation();
    }

    /**
     * Create an instance of {@link Livre }
     * 
     */
    public Livre createLivre() {
        return new Livre();
    }

    /**
     * Create an instance of {@link ReservationWS }
     * 
     */
    public ReservationWS createReservationWS() {
        return new ReservationWS();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifEndResa }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.resaService.soap.biblio.mb.fr/", name = "verifEndResa")
    public JAXBElement<VerifEndResa> createVerifEndResa(VerifEndResa value) {
        return new JAXBElement<VerifEndResa>(_VerifEndResa_QNAME, VerifEndResa.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Genre }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.resaService.soap.biblio.mb.fr/", name = "genre")
    public JAXBElement<Genre> createGenre(Genre value) {
        return new JAXBElement<Genre>(_Genre_QNAME, Genre.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FunctionalException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.resaService.soap.biblio.mb.fr/", name = "FunctionalException")
    public JAXBElement<FunctionalException> createFunctionalException(FunctionalException value) {
        return new JAXBElement<FunctionalException>(_FunctionalException_QNAME, FunctionalException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MailResa }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.resaService.soap.biblio.mb.fr/", name = "mailResa")
    public JAXBElement<MailResa> createMailResa(MailResa value) {
        return new JAXBElement<MailResa>(_MailResa_QNAME, MailResa.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NewReservation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.resaService.soap.biblio.mb.fr/", name = "newReservation")
    public JAXBElement<NewReservation> createNewReservation(NewReservation value) {
        return new JAXBElement<NewReservation>(_NewReservation_QNAME, NewReservation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetResaByLivreIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.resaService.soap.biblio.mb.fr/", name = "getResaByLivreIdResponse")
    public JAXBElement<GetResaByLivreIdResponse> createGetResaByLivreIdResponse(GetResaByLivreIdResponse value) {
        return new JAXBElement<GetResaByLivreIdResponse>(_GetResaByLivreIdResponse_QNAME, GetResaByLivreIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetResaByUserId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.resaService.soap.biblio.mb.fr/", name = "getResaByUserId")
    public JAXBElement<GetResaByUserId> createGetResaByUserId(GetResaByUserId value) {
        return new JAXBElement<GetResaByUserId>(_GetResaByUserId_QNAME, GetResaByUserId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Ouvrage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.resaService.soap.biblio.mb.fr/", name = "ouvrage")
    public JAXBElement<Ouvrage> createOuvrage(Ouvrage value) {
        return new JAXBElement<Ouvrage>(_Ouvrage_QNAME, Ouvrage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetResaByLivreId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.resaService.soap.biblio.mb.fr/", name = "getResaByLivreId")
    public JAXBElement<GetResaByLivreId> createGetResaByLivreId(GetResaByLivreId value) {
        return new JAXBElement<GetResaByLivreId>(_GetResaByLivreId_QNAME, GetResaByLivreId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NewReservationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.resaService.soap.biblio.mb.fr/", name = "newReservationResponse")
    public JAXBElement<NewReservationResponse> createNewReservationResponse(NewReservationResponse value) {
        return new JAXBElement<NewReservationResponse>(_NewReservationResponse_QNAME, NewReservationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StartResa }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.resaService.soap.biblio.mb.fr/", name = "startResa")
    public JAXBElement<StartResa> createStartResa(StartResa value) {
        return new JAXBElement<StartResa>(_StartResa_QNAME, StartResa.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotFoundException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.resaService.soap.biblio.mb.fr/", name = "NotFoundException")
    public JAXBElement<NotFoundException> createNotFoundException(NotFoundException value) {
        return new JAXBElement<NotFoundException>(_NotFoundException_QNAME, NotFoundException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StartResaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.resaService.soap.biblio.mb.fr/", name = "startResaResponse")
    public JAXBElement<StartResaResponse> createStartResaResponse(StartResaResponse value) {
        return new JAXBElement<StartResaResponse>(_StartResaResponse_QNAME, StartResaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteReservation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.resaService.soap.biblio.mb.fr/", name = "deleteReservation")
    public JAXBElement<DeleteReservation> createDeleteReservation(DeleteReservation value) {
        return new JAXBElement<DeleteReservation>(_DeleteReservation_QNAME, DeleteReservation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifEndResaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.resaService.soap.biblio.mb.fr/", name = "verifEndResaResponse")
    public JAXBElement<VerifEndResaResponse> createVerifEndResaResponse(VerifEndResaResponse value) {
        return new JAXBElement<VerifEndResaResponse>(_VerifEndResaResponse_QNAME, VerifEndResaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Auteur }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.resaService.soap.biblio.mb.fr/", name = "auteur")
    public JAXBElement<Auteur> createAuteur(Auteur value) {
        return new JAXBElement<Auteur>(_Auteur_QNAME, Auteur.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Editeur }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.resaService.soap.biblio.mb.fr/", name = "editeur")
    public JAXBElement<Editeur> createEditeur(Editeur value) {
        return new JAXBElement<Editeur>(_Editeur_QNAME, Editeur.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.resaService.soap.biblio.mb.fr/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteReservationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.resaService.soap.biblio.mb.fr/", name = "deleteReservationResponse")
    public JAXBElement<DeleteReservationResponse> createDeleteReservationResponse(DeleteReservationResponse value) {
        return new JAXBElement<DeleteReservationResponse>(_DeleteReservationResponse_QNAME, DeleteReservationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetResaById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.resaService.soap.biblio.mb.fr/", name = "getResaById")
    public JAXBElement<GetResaById> createGetResaById(GetResaById value) {
        return new JAXBElement<GetResaById>(_GetResaById_QNAME, GetResaById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetResaByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.resaService.soap.biblio.mb.fr/", name = "getResaByIdResponse")
    public JAXBElement<GetResaByIdResponse> createGetResaByIdResponse(GetResaByIdResponse value) {
        return new JAXBElement<GetResaByIdResponse>(_GetResaByIdResponse_QNAME, GetResaByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetResaByUserIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.resaService.soap.biblio.mb.fr/", name = "getResaByUserIdResponse")
    public JAXBElement<GetResaByUserIdResponse> createGetResaByUserIdResponse(GetResaByUserIdResponse value) {
        return new JAXBElement<GetResaByUserIdResponse>(_GetResaByUserIdResponse_QNAME, GetResaByUserIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MailResaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.resaService.soap.biblio.mb.fr/", name = "mailResaResponse")
    public JAXBElement<MailResaResponse> createMailResaResponse(MailResaResponse value) {
        return new JAXBElement<MailResaResponse>(_MailResaResponse_QNAME, MailResaResponse.class, null, value);
    }

}
