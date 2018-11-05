package fr.mb.biblio.models.beans;

import fr.mb.biblio.models.LocalDateXmlAdapter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "reservation", catalog = "projet")
public class Reservation implements Serializable {

    private int id;
    private LocalDate debutResa;
    private LocalDate finResa;
    private Livre livre;
    private Utilisateur demandeur;

    public Reservation(){

    }

    public Reservation(int id, LocalDate debutResa, LocalDate finResa, Livre livre, Utilisateur demandeur) {
        this.id = id;
        this.debutResa = debutResa;
        this.finResa = finResa;
        this.livre = livre;
        this.demandeur = demandeur;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resa", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @XmlJavaTypeAdapter(LocalDateXmlAdapter.class)
    @XmlSchemaType(name = "date")
    @Column(name = "debutResa", nullable = false, length = 13)
    public LocalDate getDebutResa() {
        return debutResa;
    }

    public void setDebutResa(LocalDate debutResa) {
        this.debutResa = debutResa;
    }

    @XmlJavaTypeAdapter(LocalDateXmlAdapter.class)
    @XmlSchemaType(name = "date")
    @Column(name = "finResa", nullable = false, length = 13)
    public LocalDate getFinResa() {
        return finResa;
    }

    public void setFinResa(LocalDate finResa) {
        this.finResa = finResa;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_livre", nullable = false)
    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_utilisateur", nullable = false)
    public Utilisateur getDemandeur() {
        return demandeur;
    }

    public void setDemandeur(Utilisateur demandeur) {
        this.demandeur = demandeur;
    }
}
