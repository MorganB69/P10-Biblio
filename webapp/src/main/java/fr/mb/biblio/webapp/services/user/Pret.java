
package fr.mb.biblio.webapp.services.user;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour pret complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="pret">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dateDebut" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="dateEffective" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="dateFin" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="idPret" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="prolonge" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pret", propOrder = {
    "dateDebut",
    "dateEffective",
    "dateFin",
    "idPret",
    "prolonge"
})
public class Pret {

    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateDebut;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateEffective;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateFin;
    protected int idPret;
    protected boolean prolonge;

    /**
     * Obtient la valeur de la propriété dateDebut.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateDebut() {
        return dateDebut;
    }

    /**
     * Définit la valeur de la propriété dateDebut.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateDebut(XMLGregorianCalendar value) {
        this.dateDebut = value;
    }

    /**
     * Obtient la valeur de la propriété dateEffective.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateEffective() {
        return dateEffective;
    }

    /**
     * Définit la valeur de la propriété dateEffective.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateEffective(XMLGregorianCalendar value) {
        this.dateEffective = value;
    }

    /**
     * Obtient la valeur de la propriété dateFin.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateFin() {
        return dateFin;
    }

    /**
     * Définit la valeur de la propriété dateFin.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateFin(XMLGregorianCalendar value) {
        this.dateFin = value;
    }

    /**
     * Obtient la valeur de la propriété idPret.
     * 
     */
    public int getIdPret() {
        return idPret;
    }

    /**
     * Définit la valeur de la propriété idPret.
     * 
     */
    public void setIdPret(int value) {
        this.idPret = value;
    }

    /**
     * Obtient la valeur de la propriété prolonge.
     * 
     */
    public boolean isProlonge() {
        return prolonge;
    }

    /**
     * Définit la valeur de la propriété prolonge.
     * 
     */
    public void setProlonge(boolean value) {
        this.prolonge = value;
    }

}
