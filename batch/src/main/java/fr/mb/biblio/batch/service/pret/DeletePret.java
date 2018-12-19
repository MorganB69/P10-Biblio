
package fr.mb.biblio.batch.service.pret;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour deletePret complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="deletePret">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pretId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deletePret", propOrder = {
    "pretId"
})
public class DeletePret {

    protected Integer pretId;

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

}
