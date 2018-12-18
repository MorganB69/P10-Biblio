
package fr.mb.biblio.batch.service.reservation;

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
@WebService(name = "resaService", targetNamespace = "http://contract.resaService.soap.biblio.mb.fr/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ResaService {


    /**
     * 
     */
    @WebMethod
    @RequestWrapper(localName = "verifEndResa", targetNamespace = "http://contract.resaService.soap.biblio.mb.fr/", className = "fr.mb.biblio.batch.service.reservation.VerifEndResa")
    @ResponseWrapper(localName = "verifEndResaResponse", targetNamespace = "http://contract.resaService.soap.biblio.mb.fr/", className = "fr.mb.biblio.batch.service.reservation.VerifEndResaResponse")
    public void verifEndResa();

    /**
     * 
     * @param resaId
     * @throws FunctionalException_Exception
     * @throws Exception_Exception
     * @throws NotFoundException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "mailResa", targetNamespace = "http://contract.resaService.soap.biblio.mb.fr/", className = "fr.mb.biblio.batch.service.reservation.MailResa")
    @ResponseWrapper(localName = "mailResaResponse", targetNamespace = "http://contract.resaService.soap.biblio.mb.fr/", className = "fr.mb.biblio.batch.service.reservation.MailResaResponse")
    public void mailResa(
        @WebParam(name = "resaId", targetNamespace = "")
        Integer resaId)
        throws Exception_Exception, FunctionalException_Exception, NotFoundException_Exception
    ;

    /**
     * 
     * @param resaId
     * @throws FunctionalException_Exception
     * @throws NotFoundException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "deleteReservation", targetNamespace = "http://contract.resaService.soap.biblio.mb.fr/", className = "fr.mb.biblio.batch.service.reservation.DeleteReservation")
    @ResponseWrapper(localName = "deleteReservationResponse", targetNamespace = "http://contract.resaService.soap.biblio.mb.fr/", className = "fr.mb.biblio.batch.service.reservation.DeleteReservationResponse")
    public void deleteReservation(
        @WebParam(name = "resaId", targetNamespace = "")
        Integer resaId)
        throws FunctionalException_Exception, NotFoundException_Exception
    ;

    /**
     * 
     * @param livreId
     * @param demandeurId
     * @return
     *     returns fr.mb.biblio.batch.service.reservation.Reservation
     * @throws FunctionalException_Exception
     * @throws NotFoundException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "newReservation", targetNamespace = "http://contract.resaService.soap.biblio.mb.fr/", className = "fr.mb.biblio.batch.service.reservation.NewReservation")
    @ResponseWrapper(localName = "newReservationResponse", targetNamespace = "http://contract.resaService.soap.biblio.mb.fr/", className = "fr.mb.biblio.batch.service.reservation.NewReservationResponse")
    public Reservation newReservation(
        @WebParam(name = "livreId", targetNamespace = "")
        Integer livreId,
        @WebParam(name = "demandeurId", targetNamespace = "")
        Integer demandeurId)
        throws FunctionalException_Exception, NotFoundException_Exception
    ;

    /**
     * 
     * @param resaId
     * @return
     *     returns fr.mb.biblio.batch.service.reservation.Reservation
     * @throws FunctionalException_Exception
     * @throws NotFoundException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getResaById", targetNamespace = "http://contract.resaService.soap.biblio.mb.fr/", className = "fr.mb.biblio.batch.service.reservation.GetResaById")
    @ResponseWrapper(localName = "getResaByIdResponse", targetNamespace = "http://contract.resaService.soap.biblio.mb.fr/", className = "fr.mb.biblio.batch.service.reservation.GetResaByIdResponse")
    public Reservation getResaById(
        @WebParam(name = "resaId", targetNamespace = "")
        Integer resaId)
        throws FunctionalException_Exception, NotFoundException_Exception
    ;

    /**
     * 
     * @param demandeurId
     * @return
     *     returns java.util.List<fr.mb.biblio.batch.service.reservation.ReservationWS>
     * @throws FunctionalException_Exception
     * @throws NotFoundException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getResaByUserId", targetNamespace = "http://contract.resaService.soap.biblio.mb.fr/", className = "fr.mb.biblio.batch.service.reservation.GetResaByUserId")
    @ResponseWrapper(localName = "getResaByUserIdResponse", targetNamespace = "http://contract.resaService.soap.biblio.mb.fr/", className = "fr.mb.biblio.batch.service.reservation.GetResaByUserIdResponse")
    public List<ReservationWS> getResaByUserId(
        @WebParam(name = "demandeurId", targetNamespace = "")
        Integer demandeurId)
        throws FunctionalException_Exception, NotFoundException_Exception
    ;

    /**
     * 
     * @param livreId
     * @return
     *     returns java.util.List<fr.mb.biblio.batch.service.reservation.Reservation>
     * @throws FunctionalException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getResaByLivreId", targetNamespace = "http://contract.resaService.soap.biblio.mb.fr/", className = "fr.mb.biblio.batch.service.reservation.GetResaByLivreId")
    @ResponseWrapper(localName = "getResaByLivreIdResponse", targetNamespace = "http://contract.resaService.soap.biblio.mb.fr/", className = "fr.mb.biblio.batch.service.reservation.GetResaByLivreIdResponse")
    public List<Reservation> getResaByLivreId(
        @WebParam(name = "livreId", targetNamespace = "")
        Integer livreId)
        throws FunctionalException_Exception
    ;

    /**
     * 
     * @param resaId
     * @return
     *     returns fr.mb.biblio.batch.service.reservation.Reservation
     * @throws FunctionalException_Exception
     * @throws NotFoundException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "startResa", targetNamespace = "http://contract.resaService.soap.biblio.mb.fr/", className = "fr.mb.biblio.batch.service.reservation.StartResa")
    @ResponseWrapper(localName = "startResaResponse", targetNamespace = "http://contract.resaService.soap.biblio.mb.fr/", className = "fr.mb.biblio.batch.service.reservation.StartResaResponse")
    public Reservation startResa(
        @WebParam(name = "resaId", targetNamespace = "")
        Integer resaId)
        throws FunctionalException_Exception, NotFoundException_Exception
    ;

}