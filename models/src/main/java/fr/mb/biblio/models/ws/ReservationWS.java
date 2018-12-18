package fr.mb.biblio.models.ws;

import fr.mb.biblio.models.beans.Livre;
import fr.mb.biblio.models.beans.Pret;
import fr.mb.biblio.models.beans.Reservation;

import java.time.LocalDate;

public class ReservationWS {
    Reservation reservation;
    LocalDate dateRetour;
    Integer positionUser;
    Integer nbResaTotal;

    public ReservationWS() {
    }

    public ReservationWS(Reservation reservation, LocalDate dateRetour) {
        this.reservation = reservation;
        this.dateRetour = dateRetour;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public LocalDate getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(LocalDate dateRetour) {
        this.dateRetour = dateRetour;
    }

    public Integer getPositionUser() {
        return positionUser;
    }

    public void setPositionUser(Integer positionUser) {
        this.positionUser = positionUser;
    }

    public Integer getNbResaTotal() {
        return nbResaTotal;
    }

    public void setNbResaTotal(Integer nbResaTotal) {
        this.nbResaTotal = nbResaTotal;
    }
}
