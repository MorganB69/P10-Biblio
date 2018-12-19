
package fr.mb.biblio.webappConsumer.services.pret;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour prolongerPret complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="prolongerPret">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pretId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="emprunteurId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "prolongerPret", propOrder = {
    "pretId",
    "emprunteurId"
})
public class ProlongerPret {

    protected Integer pretId;
    protected Integer emprunteurId;

    /**
     * Obtient la valeur de la propriété pretId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPretId() {
        return pretId;
    }

    /**
     * Définit la valeur de la propriété pretId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPretId(Integer value) {
        this.pretId = value;
    }

    /**
     * Obtient la valeur de la propriété emprunteurId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEmprunteurId() {
        return emprunteurId;
    }

    /**
     * Définit la valeur de la propriété emprunteurId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEmprunteurId(Integer value) {
        this.emprunteurId = value;
    }

}
