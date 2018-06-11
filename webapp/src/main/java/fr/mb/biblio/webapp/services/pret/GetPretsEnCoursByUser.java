
package fr.mb.biblio.webapp.services.pret;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getPretsEnCoursByUser complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getPretsEnCoursByUser">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="utilisateurId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPretsEnCoursByUser", propOrder = {
    "utilisateurId"
})
public class GetPretsEnCoursByUser {

    protected Integer utilisateurId;

    /**
     * Obtient la valeur de la propri�t� utilisateurId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getUtilisateurId() {
        return utilisateurId;
    }

    /**
     * D�finit la valeur de la propri�t� utilisateurId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setUtilisateurId(Integer value) {
        this.utilisateurId = value;
    }

}
