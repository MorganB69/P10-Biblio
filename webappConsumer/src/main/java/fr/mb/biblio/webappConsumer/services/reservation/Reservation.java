
package fr.mb.biblio.webappConsumer.services.reservation;

import java.time.LocalDate;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Classe Java pour reservation complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="reservation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="debutResa" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="demandeur" type="{http://contract.resaService.soap.biblio.mb.fr/}utilisateur" minOccurs="0"/>
 *         &lt;element name="finResa" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="livre" type="{http://contract.resaService.soap.biblio.mb.fr/}livre" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reservation", propOrder = {
    "debutResa",
    "demandeur",
    "finResa",
    "id",
    "livre"
})
public class Reservation {

    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "date")
    protected LocalDate debutResa;
    protected Utilisateur demandeur;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "date")
    protected LocalDate finResa;
    protected int id;
    protected Livre livre;

    /**
     * Obtient la valeur de la propriété debutResa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public LocalDate getDebutResa() {
        return debutResa;
    }

    /**
     * Définit la valeur de la propriété debutResa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDebutResa(LocalDate value) {
        this.debutResa = value;
    }

    /**
     * Obtient la valeur de la propriété demandeur.
     * 
     * @return
     *     possible object is
     *     {@link Utilisateur }
     *     
     */
    public Utilisateur getDemandeur() {
        return demandeur;
    }

    /**
     * Définit la valeur de la propriété demandeur.
     * 
     * @param value
     *     allowed object is
     *     {@link Utilisateur }
     *     
     */
    public void setDemandeur(Utilisateur value) {
        this.demandeur = value;
    }

    /**
     * Obtient la valeur de la propriété finResa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public LocalDate getFinResa() {
        return finResa;
    }

    /**
     * Définit la valeur de la propriété finResa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFinResa(LocalDate value) {
        this.finResa = value;
    }

    /**
     * Obtient la valeur de la propriété id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propriété livre.
     * 
     * @return
     *     possible object is
     *     {@link Livre }
     *     
     */
    public Livre getLivre() {
        return livre;
    }

    /**
     * Définit la valeur de la propriété livre.
     * 
     * @param value
     *     allowed object is
     *     {@link Livre }
     *     
     */
    public void setLivre(Livre value) {
        this.livre = value;
    }

}
