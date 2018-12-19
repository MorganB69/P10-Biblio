
package fr.mb.biblio.batch.service.reservation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getResaByUserId complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getResaByUserId">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
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
@XmlType(name = "getResaByUserId", propOrder = {
    "demandeurId"
})
public class GetResaByUserId {

    protected Integer demandeurId;

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
