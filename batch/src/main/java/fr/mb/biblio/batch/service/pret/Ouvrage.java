
package fr.mb.biblio.batch.service.pret;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour ouvrage complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="ouvrage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idOuvrage" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="typeouvrage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ouvrage", propOrder = {
    "idOuvrage",
    "typeouvrage"
})
public class Ouvrage {

    protected int idOuvrage;
    protected String typeouvrage;

    /**
     * Obtient la valeur de la propri�t� idOuvrage.
     * 
     */
    public int getIdOuvrage() {
        return idOuvrage;
    }

    /**
     * D�finit la valeur de la propri�t� idOuvrage.
     * 
     */
    public void setIdOuvrage(int value) {
        this.idOuvrage = value;
    }

    /**
     * Obtient la valeur de la propri�t� typeouvrage.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeouvrage() {
        return typeouvrage;
    }

    /**
     * D�finit la valeur de la propri�t� typeouvrage.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeouvrage(String value) {
        this.typeouvrage = value;
    }

}
