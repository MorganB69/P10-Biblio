
package fr.mb.biblio.webapp.services.livre;

import java.util.List;
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
@WebService(name = "livreService", targetNamespace = "http://contract.livreService.soap.biblio.mb.fr/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface LivreService {


    /**
     * 
     * @throws FunctionalException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "insertionExemple", targetNamespace = "http://contract.livreService.soap.biblio.mb.fr/", className = "fr.mb.biblio.webapp.services.livre.InsertionExemple")
    @ResponseWrapper(localName = "insertionExempleResponse", targetNamespace = "http://contract.livreService.soap.biblio.mb.fr/", className = "fr.mb.biblio.webapp.services.livre.InsertionExempleResponse")
    public void insertionExemple()
        throws FunctionalException_Exception
    ;

    /**
     * 
     * @param offset
     * @param nb
     * @param recherche
     * @return
     *     returns java.util.List<fr.mb.biblio.webapp.services.livre.Livre>
     * @throws FunctionalException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "rechercheLivres", targetNamespace = "http://contract.livreService.soap.biblio.mb.fr/", className = "fr.mb.biblio.webapp.services.livre.RechercheLivres")
    @ResponseWrapper(localName = "rechercheLivresResponse", targetNamespace = "http://contract.livreService.soap.biblio.mb.fr/", className = "fr.mb.biblio.webapp.services.livre.RechercheLivresResponse")
    public List<Livre> rechercheLivres(
        @WebParam(name = "recherche", targetNamespace = "")
        RechercheLivre recherche,
        @WebParam(name = "offset", targetNamespace = "")
        Integer offset,
        @WebParam(name = "nb", targetNamespace = "")
        Integer nb)
        throws FunctionalException_Exception
    ;

    /**
     * 
     * @param recherche
     * @return
     *     returns java.lang.Long
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "countLivres", targetNamespace = "http://contract.livreService.soap.biblio.mb.fr/", className = "fr.mb.biblio.webapp.services.livre.CountLivres")
    @ResponseWrapper(localName = "countLivresResponse", targetNamespace = "http://contract.livreService.soap.biblio.mb.fr/", className = "fr.mb.biblio.webapp.services.livre.CountLivresResponse")
    public Long countLivres(
        @WebParam(name = "recherche", targetNamespace = "")
        RechercheLivre recherche);

    /**
     * 
     * @param idLivre
     * @return
     *     returns java.lang.String
     * @throws NotFoundException_Exception
     * @throws FunctionalException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "dateRetourLivre", targetNamespace = "http://contract.livreService.soap.biblio.mb.fr/", className = "fr.mb.biblio.webapp.services.livre.DateRetourLivre")
    @ResponseWrapper(localName = "dateRetourLivreResponse", targetNamespace = "http://contract.livreService.soap.biblio.mb.fr/", className = "fr.mb.biblio.webapp.services.livre.DateRetourLivreResponse")
    public String dateRetourLivre(
        @WebParam(name = "idLivre", targetNamespace = "")
        Integer idLivre)
        throws FunctionalException_Exception, NotFoundException_Exception
    ;

    /**
     * 
     * @param id
     * @return
     *     returns fr.mb.biblio.webapp.services.livre.Livre
     * @throws NotFoundException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getLivreById", targetNamespace = "http://contract.livreService.soap.biblio.mb.fr/", className = "fr.mb.biblio.webapp.services.livre.GetLivreById")
    @ResponseWrapper(localName = "getLivreByIdResponse", targetNamespace = "http://contract.livreService.soap.biblio.mb.fr/", className = "fr.mb.biblio.webapp.services.livre.GetLivreByIdResponse")
    public Livre getLivreById(
        @WebParam(name = "id", targetNamespace = "")
        Integer id)
        throws NotFoundException_Exception
    ;

    /**
     * 
     * @param livre
     * @throws FunctionalException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "insert", targetNamespace = "http://contract.livreService.soap.biblio.mb.fr/", className = "fr.mb.biblio.webapp.services.livre.Insert")
    @ResponseWrapper(localName = "insertResponse", targetNamespace = "http://contract.livreService.soap.biblio.mb.fr/", className = "fr.mb.biblio.webapp.services.livre.InsertResponse")
    public void insert(
        @WebParam(name = "livre", targetNamespace = "")
        Livre livre)
        throws FunctionalException_Exception
    ;

    /**
     * 
     * @param offset
     * @param nb
     * @return
     *     returns java.util.List<fr.mb.biblio.webapp.services.livre.Livre>
     * @throws FunctionalException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllLivres", targetNamespace = "http://contract.livreService.soap.biblio.mb.fr/", className = "fr.mb.biblio.webapp.services.livre.GetAllLivres")
    @ResponseWrapper(localName = "getAllLivresResponse", targetNamespace = "http://contract.livreService.soap.biblio.mb.fr/", className = "fr.mb.biblio.webapp.services.livre.GetAllLivresResponse")
    public List<Livre> getAllLivres(
        @WebParam(name = "offset", targetNamespace = "")
        Integer offset,
        @WebParam(name = "nb", targetNamespace = "")
        Integer nb)
        throws FunctionalException_Exception
    ;

    /**
     * 
     * @param nb
     * @throws FunctionalException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "creationAleatoireLivre", targetNamespace = "http://contract.livreService.soap.biblio.mb.fr/", className = "fr.mb.biblio.webapp.services.livre.CreationAleatoireLivre")
    @ResponseWrapper(localName = "creationAleatoireLivreResponse", targetNamespace = "http://contract.livreService.soap.biblio.mb.fr/", className = "fr.mb.biblio.webapp.services.livre.CreationAleatoireLivreResponse")
    public void creationAleatoireLivre(
        @WebParam(name = "nb", targetNamespace = "")
        Integer nb)
        throws FunctionalException_Exception
    ;

}
