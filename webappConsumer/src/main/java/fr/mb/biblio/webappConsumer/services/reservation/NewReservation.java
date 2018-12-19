
package fr.mb.biblio.webappConsumer.services.reservation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour newReservation complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="newReservation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="livreId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="demandeurId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "newReservation", propOrder = {
    "livreId",
    "demandeurId"
})
public class NewReservation {

    protected Integer livreId;
    protected Integer demandeurId;

    /**
     * Obtient la valeur de la propriété livreId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLivreId() {
        return livreId;
    }

    /**
     * Définit la valeur de la propriété livreId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLivreId(Integer value) {
        this.livreId = value;
    }

    /**
     * Obtient la valeur de la propriété demandeurId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDemandeurId() {
        return demandeurId;
    }

    /**
     * Définit la valeur de la propriété demandeurId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDemandeurId(Integer value) {
        this.demandeurId = value;
    }

}
