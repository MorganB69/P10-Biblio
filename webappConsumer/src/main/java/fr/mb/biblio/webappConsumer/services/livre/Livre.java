
package fr.mb.biblio.webappConsumer.services.livre;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Classe Java pour livre complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="livre">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="auteurs" type="{http://contract.livreService.soap.biblio.mb.fr/}auteur" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="disponible" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="editeurs" type="{http://contract.livreService.soap.biblio.mb.fr/}editeur" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="exemplaire" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="genres" type="{http://contract.livreService.soap.biblio.mb.fr/}genre" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="idLivre" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="image" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ouvrage" type="{http://contract.livreService.soap.biblio.mb.fr/}ouvrage" minOccurs="0"/>
 *         &lt;element name="parution" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="resume" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="titre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "livre", propOrder = {
    "auteurs",
    "disponible",
    "editeurs",
    "exemplaire",
    "genres",
    "idLivre",
    "image",
    "ouvrage",
    "parution",
    "resume",
    "titre"
})
public class Livre {

    @XmlElement(nillable = true)
    protected List<Auteur> auteurs;
    protected Boolean disponible;
    @XmlElement(nillable = true)
    protected List<Editeur> editeurs;
    protected int exemplaire;
    @XmlElement(nillable = true)
    protected List<Genre> genres;
    protected int idLivre;
    protected String image;
    protected Ouvrage ouvrage;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "date")
    protected LocalDate parution;
    protected String resume;
    protected String titre;

    /**
     * Gets the value of the auteurs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the auteurs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAuteurs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Auteur }
     * 
     * 
     */
    public List<Auteur> getAuteurs() {
        if (auteurs == null) {
            auteurs = new ArrayList<Auteur>();
        }
        return this.auteurs;
    }

    /**
     * Obtient la valeur de la propri�t� disponible.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDisponible() {
        return disponible;
    }

    /**
     * D�finit la valeur de la propri�t� disponible.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDisponible(Boolean value) {
        this.disponible = value;
    }

    /**
     * Gets the value of the editeurs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the editeurs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEditeurs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Editeur }
     * 
     * 
     */
    public List<Editeur> getEditeurs() {
        if (editeurs == null) {
            editeurs = new ArrayList<Editeur>();
        }
        return this.editeurs;
    }

    /**
     * Obtient la valeur de la propri�t� exemplaire.
     * 
     */
    public int getExemplaire() {
        return exemplaire;
    }

    /**
     * D�finit la valeur de la propri�t� exemplaire.
     * 
     */
    public void setExemplaire(int value) {
        this.exemplaire = value;
    }

    /**
     * Gets the value of the genres property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genres property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGenres().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Genre }
     * 
     * 
     */
    public List<Genre> getGenres() {
        if (genres == null) {
            genres = new ArrayList<Genre>();
        }
        return this.genres;
    }

    /**
     * Obtient la valeur de la propri�t� idLivre.
     * 
     */
    public int getIdLivre() {
        return idLivre;
    }

    /**
     * D�finit la valeur de la propri�t� idLivre.
     * 
     */
    public void setIdLivre(int value) {
        this.idLivre = value;
    }

    /**
     * Obtient la valeur de la propri�t� image.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImage() {
        return image;
    }

    /**
     * D�finit la valeur de la propri�t� image.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImage(String value) {
        this.image = value;
    }

    /**
     * Obtient la valeur de la propri�t� ouvrage.
     * 
     * @return
     *     possible object is
     *     {@link Ouvrage }
     *     
     */
    public Ouvrage getOuvrage() {
        return ouvrage;
    }

    /**
     * D�finit la valeur de la propri�t� ouvrage.
     * 
     * @param value
     *     allowed object is
     *     {@link Ouvrage }
     *     
     */
    public void setOuvrage(Ouvrage value) {
        this.ouvrage = value;
    }

    /**
     * Obtient la valeur de la propri�t� parution.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public LocalDate getParution() {
        return parution;
    }

    /**
     * D�finit la valeur de la propri�t� parution.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParution(LocalDate value) {
        this.parution = value;
    }

    /**
     * Obtient la valeur de la propri�t� resume.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResume() {
        return resume;
    }

    /**
     * D�finit la valeur de la propri�t� resume.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResume(String value) {
        this.resume = value;
    }

    /**
     * Obtient la valeur de la propri�t� titre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitre() {
        return titre;
    }

    /**
     * D�finit la valeur de la propri�t� titre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitre(String value) {
        this.titre = value;
    }

}
