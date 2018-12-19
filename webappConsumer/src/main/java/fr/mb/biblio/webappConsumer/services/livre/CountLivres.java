
package fr.mb.biblio.webappConsumer.services.livre;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour countLivres complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="countLivres">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="recherche" type="{http://contract.livreService.soap.biblio.mb.fr/}rechercheLivre" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "countLivres", propOrder = {
    "recherche"
})
public class CountLivres {

    protected RechercheLivre recherche;

    /**
     * Obtient la valeur de la propriété recherche.
     * 
     * @return
     *     possible object is
     *     {@link RechercheLivre }
     *     
     */
    public RechercheLivre getRecherche() {
        return recherche;
    }

    /**
     * Définit la valeur de la propriété recherche.
     * 
     * @param value
     *     allowed object is
     *     {@link RechercheLivre }
     *     
     */
    public void setRecherche(RechercheLivre value) {
        this.recherche = value;
    }

}
