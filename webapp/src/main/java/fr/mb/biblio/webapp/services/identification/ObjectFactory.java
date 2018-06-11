
package fr.mb.biblio.webapp.services.identification;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.mb.biblio.webapp.services.identification package. 
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

    private final static QName _NotFoundException_QNAME = new QName("http://identification.soap.biblio.mb.fr/", "NotFoundException");
    private final static QName _IdentificationResponse_QNAME = new QName("http://identification.soap.biblio.mb.fr/", "identificationResponse");
    private final static QName _Identification_QNAME = new QName("http://identification.soap.biblio.mb.fr/", "identification");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.mb.biblio.webapp.services.identification
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Identification }
     * 
     */
    public Identification createIdentification() {
        return new Identification();
    }

    /**
     * Create an instance of {@link NotFoundException }
     * 
     */
    public NotFoundException createNotFoundException() {
        return new NotFoundException();
    }

    /**
     * Create an instance of {@link IdentificationResponse }
     * 
     */
    public IdentificationResponse createIdentificationResponse() {
        return new IdentificationResponse();
    }

    /**
     * Create an instance of {@link Utilisateur }
     * 
     */
    public Utilisateur createUtilisateur() {
        return new Utilisateur();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotFoundException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://identification.soap.biblio.mb.fr/", name = "NotFoundException")
    public JAXBElement<NotFoundException> createNotFoundException(NotFoundException value) {
        return new JAXBElement<NotFoundException>(_NotFoundException_QNAME, NotFoundException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://identification.soap.biblio.mb.fr/", name = "identificationResponse")
    public JAXBElement<IdentificationResponse> createIdentificationResponse(IdentificationResponse value) {
        return new JAXBElement<IdentificationResponse>(_IdentificationResponse_QNAME, IdentificationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Identification }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://identification.soap.biblio.mb.fr/", name = "identification")
    public JAXBElement<Identification> createIdentification(Identification value) {
        return new JAXBElement<Identification>(_Identification_QNAME, Identification.class, null, value);
    }

}
