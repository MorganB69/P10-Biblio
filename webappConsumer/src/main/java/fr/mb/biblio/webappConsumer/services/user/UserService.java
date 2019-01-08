
package fr.mb.biblio.webappConsumer.services.user;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "userService", targetNamespace = "http://contract.userService.soap.biblio.mb.fr/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface UserService {


    /**
     * 
     * @param relance
     * @param id
     * @throws FunctionalException_Exception
     * @throws NotFoundException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "setOptionRelance", targetNamespace = "http://contract.userService.soap.biblio.mb.fr/", className = "fr.mb.biblio.webappConsumer.services.user.SetOptionRelance")
    @ResponseWrapper(localName = "setOptionRelanceResponse", targetNamespace = "http://contract.userService.soap.biblio.mb.fr/", className = "fr.mb.biblio.webappConsumer.services.user.SetOptionRelanceResponse")
    public void setOptionRelance(
        @WebParam(name = "id", targetNamespace = "")
        Integer id,
        @WebParam(name = "relance", targetNamespace = "")
        Boolean relance)
        throws FunctionalException_Exception, NotFoundException_Exception
    ;

    /**
     * 
     * @param nom
     * @param prenom
     * @return
     *     returns java.lang.Integer
     * @throws FunctionalException_Exception
     * @throws NotFoundException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getUserIdByName", targetNamespace = "http://contract.userService.soap.biblio.mb.fr/", className = "fr.mb.biblio.webappConsumer.services.user.GetUserIdByName")
    @ResponseWrapper(localName = "getUserIdByNameResponse", targetNamespace = "http://contract.userService.soap.biblio.mb.fr/", className = "fr.mb.biblio.webappConsumer.services.user.GetUserIdByNameResponse")
    public Integer getUserIdByName(
        @WebParam(name = "nom", targetNamespace = "")
        String nom,
        @WebParam(name = "prenom", targetNamespace = "")
        String prenom)
        throws FunctionalException_Exception, NotFoundException_Exception
    ;

    /**
     * 
     * @param id
     * @return
     *     returns fr.mb.biblio.webappConsumer.services.user.Utilisateur
     * @throws FunctionalException_Exception
     * @throws NotFoundException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getUtilisateurById", targetNamespace = "http://contract.userService.soap.biblio.mb.fr/", className = "fr.mb.biblio.webappConsumer.services.user.GetUtilisateurById")
    @ResponseWrapper(localName = "getUtilisateurByIdResponse", targetNamespace = "http://contract.userService.soap.biblio.mb.fr/", className = "fr.mb.biblio.webappConsumer.services.user.GetUtilisateurByIdResponse")
    public Utilisateur getUtilisateurById(
        @WebParam(name = "id", targetNamespace = "")
        Integer id)
        throws FunctionalException_Exception, NotFoundException_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns fr.mb.biblio.webappConsumer.services.user.Utilisateur
     * @throws NotFoundException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "identification", targetNamespace = "http://contract.userService.soap.biblio.mb.fr/", className = "fr.mb.biblio.webappConsumer.services.user.Identification")
    @ResponseWrapper(localName = "identificationResponse", targetNamespace = "http://contract.userService.soap.biblio.mb.fr/", className = "fr.mb.biblio.webappConsumer.services.user.IdentificationResponse")
    public Utilisateur identification(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1)
        throws NotFoundException_Exception
    ;

    /**
     * 
     * @param utilisateur
     * @throws FunctionalException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "insert", targetNamespace = "http://contract.userService.soap.biblio.mb.fr/", className = "fr.mb.biblio.webappConsumer.services.user.Insert")
    @ResponseWrapper(localName = "insertResponse", targetNamespace = "http://contract.userService.soap.biblio.mb.fr/", className = "fr.mb.biblio.webappConsumer.services.user.InsertResponse")
    public void insert(
        @WebParam(name = "utilisateur", targetNamespace = "")
        Utilisateur utilisateur)
        throws FunctionalException_Exception
    ;

}
