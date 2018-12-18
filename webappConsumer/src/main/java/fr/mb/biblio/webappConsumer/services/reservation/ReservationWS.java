
package fr.mb.biblio.webappConsumer.services.reservation;

import java.time.LocalDate;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Classe Java pour reservationWS complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="reservationWS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dateRetour" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="nbResaTotal" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="positionUser" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="reservation" type="{http://contract.resaService.soap.biblio.mb.fr/}reservation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reservationWS", propOrder = {
    "dateRetour",
    "nbResaTotal",
    "positionUser",
    "reservation"
})
public class ReservationWS {

    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "date")
    protected LocalDate dateRetour;
    protected Integer nbResaTotal;
    protected Integer positionUser;
    protected Reservation reservation;

    /**
     * Obtient la valeur de la propriété dateRetour.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public LocalDate getDateRetour() {
        return dateRetour;
    }

    /**
     * Définit la valeur de la propriété dateRetour.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateRetour(LocalDate value) {
        this.dateRetour = value;
    }

    /**
     * Obtient la valeur de la propriété nbResaTotal.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNbResaTotal() {
        return nbResaTotal;
    }

    /**
     * Définit la valeur de la propriété nbResaTotal.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNbResaTotal(Integer value) {
        this.nbResaTotal = value;
    }

    /**
     * Obtient la valeur de la propriété positionUser.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPositionUser() {
        return positionUser;
    }

    /**
     * Définit la valeur de la propriété positionUser.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPositionUser(Integer value) {
        this.positionUser = value;
    }

    /**
     * Obtient la valeur de la propriété reservation.
     * 
     * @return
     *     possible object is
     *     {@link Reservation }
     *     
     */
    public Reservation getReservation() {
        return reservation;
    }

    /**
     * Définit la valeur de la propriété reservation.
     * 
     * @param value
     *     allowed object is
     *     {@link Reservation }
     *     
     */
    public void setReservation(Reservation value) {
        this.reservation = value;
    }

}
