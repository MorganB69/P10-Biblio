
package fr.mb.biblio.batch.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour nouveauPret complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="nouveauPret">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="livreId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
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
@XmlType(name = "nouveauPret", propOrder = {
    "livreId",
    "emprunteurId"
})
public class NouveauPret {

    protected Integer livreId;
    protected Integer emprunteurId;

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
