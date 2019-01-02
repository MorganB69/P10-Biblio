
package fr.mb.biblio.webappConsumer.services.user;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.mb.biblio.webappConsumer.services.user package. 
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

    private final static QName _InsertResponse_QNAME = new QName("http://contract.userService.soap.biblio.mb.fr/", "insertResponse");
    private final static QName _GetUserIdByName_QNAME = new QName("http://contract.userService.soap.biblio.mb.fr/", "getUserIdByName");
    private final static QName _IdentificationResponse_QNAME = new QName("http://contract.userService.soap.biblio.mb.fr/", "identificationResponse");
    private final static QName _SetOptionRelanceResponse_QNAME = new QName("http://contract.userService.soap.biblio.mb.fr/", "setOptionRelanceResponse");
    private final static QName _FunctionalException_QNAME = new QName("http://contract.userService.soap.biblio.mb.fr/", "FunctionalException");
    private final static QName _Insert_QNAME = new QName("http://contract.userService.soap.biblio.mb.fr/", "insert");
    private final static QName _NotFoundException_QNAME = new QName("http://contract.userService.soap.biblio.mb.fr/", "NotFoundException");
    private final static QName _GetUserIdByNameResponse_QNAME = new QName("http://contract.userService.soap.biblio.mb.fr/", "getUserIdByNameResponse");
    private final static QName _SetOptionRelance_QNAME = new QName("http://contract.userService.soap.biblio.mb.fr/", "setOptionRelance");
    private final static QName _GetUtilisateurById_QNAME = new QName("http://contract.userService.soap.biblio.mb.fr/", "getUtilisateurById");
    private final static QName _Identification_QNAME = new QName("http://contract.userService.soap.biblio.mb.fr/", "identification");
    private final static QName _GetUtilisateurByIdResponse_QNAME = new QName("http://contract.userService.soap.biblio.mb.fr/", "getUtilisateurByIdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.mb.biblio.webappConsumer.services.user
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetUtilisateurByIdResponse }
     * 
     */
    public GetUtilisateurByIdResponse createGetUtilisateurByIdResponse() {
        return new GetUtilisateurByIdResponse();
    }

    /**
     * Create an instance of {@link GetUtilisateurById }
     * 
     */
    public GetUtilisateurById createGetUtilisateurById() {
        return new GetUtilisateurById();
    }

    /**
     * Create an instance of {@link Identification }
     * 
     */
    public Identification createIdentification() {
        return new Identification();
    }

    /**
     * Create an instance of {@link SetOptionRelance }
     * 
     */
    public SetOptionRelance createSetOptionRelance() {
        return new SetOptionRelance();
    }

    /**
     * Create an instance of {@link GetUserIdByNameResponse }
     * 
     */
    public GetUserIdByNameResponse createGetUserIdByNameResponse() {
        return new GetUserIdByNameResponse();
    }

    /**
     * Create an instance of {@link Insert }
     * 
     */
    public Insert createInsert() {
        return new Insert();
    }

    /**
     * Create an instance of {@link NotFoundException }
     * 
     */
    public NotFoundException createNotFoundException() {
        return new NotFoundException();
    }

    /**
     * Create an instance of {@link GetUserIdByName }
     * 
     */
    public GetUserIdByName createGetUserIdByName() {
        return new GetUserIdByName();
    }

    /**
     * Create an instance of {@link IdentificationResponse }
     * 
     */
    public IdentificationResponse createIdentificationResponse() {
        return new IdentificationResponse();
    }

    /**
     * Create an instance of {@link SetOptionRelanceResponse }
     * 
     */
    public SetOptionRelanceResponse createSetOptionRelanceResponse() {
        return new SetOptionRelanceResponse();
    }

    /**
     * Create an instance of {@link FunctionalException }
     * 
     */
    public FunctionalException createFunctionalException() {
        return new FunctionalException();
    }

    /**
     * Create an instance of {@link InsertResponse }
     * 
     */
    public InsertResponse createInsertResponse() {
        return new InsertResponse();
    }

    /**
     * Create an instance of {@link Utilisateur }
     * 
     */
    public Utilisateur createUtilisateur() {
        return new Utilisateur();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.userService.soap.biblio.mb.fr/", name = "insertResponse")
    public JAXBElement<InsertResponse> createInsertResponse(InsertResponse value) {
        return new JAXBElement<InsertResponse>(_InsertResponse_QNAME, InsertResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserIdByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.userService.soap.biblio.mb.fr/", name = "getUserIdByName")
    public JAXBElement<GetUserIdByName> createGetUserIdByName(GetUserIdByName value) {
        return new JAXBElement<GetUserIdByName>(_GetUserIdByName_QNAME, GetUserIdByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.userService.soap.biblio.mb.fr/", name = "identificationResponse")
    public JAXBElement<IdentificationResponse> createIdentificationResponse(IdentificationResponse value) {
        return new JAXBElement<IdentificationResponse>(_IdentificationResponse_QNAME, IdentificationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetOptionRelanceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.userService.soap.biblio.mb.fr/", name = "setOptionRelanceResponse")
    public JAXBElement<SetOptionRelanceResponse> createSetOptionRelanceResponse(SetOptionRelanceResponse value) {
        return new JAXBElement<SetOptionRelanceResponse>(_SetOptionRelanceResponse_QNAME, SetOptionRelanceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FunctionalException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.userService.soap.biblio.mb.fr/", name = "FunctionalException")
    public JAXBElement<FunctionalException> createFunctionalException(FunctionalException value) {
        return new JAXBElement<FunctionalException>(_FunctionalException_QNAME, FunctionalException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Insert }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.userService.soap.biblio.mb.fr/", name = "insert")
    public JAXBElement<Insert> createInsert(Insert value) {
        return new JAXBElement<Insert>(_Insert_QNAME, Insert.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotFoundException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.userService.soap.biblio.mb.fr/", name = "NotFoundException")
    public JAXBElement<NotFoundException> createNotFoundException(NotFoundException value) {
        return new JAXBElement<NotFoundException>(_NotFoundException_QNAME, NotFoundException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserIdByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.userService.soap.biblio.mb.fr/", name = "getUserIdByNameResponse")
    public JAXBElement<GetUserIdByNameResponse> createGetUserIdByNameResponse(GetUserIdByNameResponse value) {
        return new JAXBElement<GetUserIdByNameResponse>(_GetUserIdByNameResponse_QNAME, GetUserIdByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetOptionRelance }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.userService.soap.biblio.mb.fr/", name = "setOptionRelance")
    public JAXBElement<SetOptionRelance> createSetOptionRelance(SetOptionRelance value) {
        return new JAXBElement<SetOptionRelance>(_SetOptionRelance_QNAME, SetOptionRelance.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUtilisateurById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.userService.soap.biblio.mb.fr/", name = "getUtilisateurById")
    public JAXBElement<GetUtilisateurById> createGetUtilisateurById(GetUtilisateurById value) {
        return new JAXBElement<GetUtilisateurById>(_GetUtilisateurById_QNAME, GetUtilisateurById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Identification }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.userService.soap.biblio.mb.fr/", name = "identification")
    public JAXBElement<Identification> createIdentification(Identification value) {
        return new JAXBElement<Identification>(_Identification_QNAME, Identification.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUtilisateurByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contract.userService.soap.biblio.mb.fr/", name = "getUtilisateurByIdResponse")
    public JAXBElement<GetUtilisateurByIdResponse> createGetUtilisateurByIdResponse(GetUtilisateurByIdResponse value) {
        return new JAXBElement<GetUtilisateurByIdResponse>(_GetUtilisateurByIdResponse_QNAME, GetUtilisateurByIdResponse.class, null, value);
    }

}
