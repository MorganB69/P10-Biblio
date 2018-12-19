
package fr.mb.biblio.batch.service.pret;

import java.time.LocalDate;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Classe Java pour pret complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
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
 *         &lt;element name="livre" type="{http://contract.pretService.soap.biblio.mb.fr/}livre" minOccurs="0"/>
 *         &lt;element name="prolonge" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="utilisateur" type="{http://contract.pretService.soap.biblio.mb.fr/}utilisateur" minOccurs="0"/>
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
    "livre",
    "prolonge",
    "utilisateur"
})
public class Pret {

    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "date")
    protected LocalDate dateDebut;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "date")
    protected LocalDate dateEffective;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "date")
    protected LocalDate dateFin;
    protected int idPret;
    protected Livre livre;
    protected boolean prolonge;
    protected Utilisateur utilisateur;

    /**
     * Obtient la valeur de la propri�t� dateDebut.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public LocalDate getDateDebut() {
        return dateDebut;
    }

    /**
     * D�finit la valeur de la propri�t� dateDebut.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateDebut(LocalDate value) {
        this.dateDebut = value;
    }

    /**
     * Obtient la valeur de la propri�t� dateEffective.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public LocalDate getDateEffective() {
        return dateEffective;
    }

    /**
     * D�finit la valeur de la propri�t� dateEffective.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateEffective(LocalDate value) {
        this.dateEffective = value;
    }

    /**
     * Obtient la valeur de la propri�t� dateFin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public LocalDate getDateFin() {
        return dateFin;
    }

    /**
     * D�finit la valeur de la propri�t� dateFin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateFin(LocalDate value) {
        this.dateFin = value;
    }

    /**
     * Obtient la valeur de la propri�t� idPret.
     * 
     */
    public int getIdPret() {
        return idPret;
    }

    /**
     * D�finit la valeur de la propri�t� idPret.
     * 
     */
    public void setIdPret(int value) {
        this.idPret = value;
    }

    /**
     * Obtient la valeur de la propri�t� livre.
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
     * D�finit la valeur de la propri�t� livre.
     * 
     * @param value
     *     allowed object is
     *     {@link Livre }
     *     
     */
    public void setLivre(Livre value) {
        this.livre = value;
    }

    /**
     * Obtient la valeur de la propri�t� prolonge.
     * 
     */
    public boolean isProlonge() {
        return prolonge;
    }

    /**
     * D�finit la valeur de la propri�t� prolonge.
     * 
     */
    public void setProlonge(boolean value) {
        this.prolonge = value;
    }

    /**
     * Obtient la valeur de la propri�t� utilisateur.
     * 
     * @return
     *     possible object is
     *     {@link Utilisateur }
     *     
     */
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    /**
     * D�finit la valeur de la propri�t� utilisateur.
     * 
     * @param value
     *     allowed object is
     *     {@link Utilisateur }
     *     
     */
    public void setUtilisateur(Utilisateur value) {
        this.utilisateur = value;
    }

}
