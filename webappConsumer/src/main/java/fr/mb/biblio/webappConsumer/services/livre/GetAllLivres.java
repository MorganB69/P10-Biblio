
package fr.mb.biblio.webappConsumer.services.livre;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getAllLivres complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getAllLivres">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="offset" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nb" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAllLivres", propOrder = {
    "offset",
    "nb"
})
public class GetAllLivres {

    protected Integer offset;
    protected Integer nb;

    /**
     * Obtient la valeur de la propri�t� offset.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOffset() {
        return offset;
    }

    /**
     * D�finit la valeur de la propri�t� offset.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOffset(Integer value) {
        this.offset = value;
    }

    /**
     * Obtient la valeur de la propri�t� nb.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNb() {
        return nb;
    }

    /**
     * D�finit la valeur de la propri�t� nb.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNb(Integer value) {
        this.nb = value;
    }

}
