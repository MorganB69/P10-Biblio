package fr.mb.biblio.test.IT;

import fr.mb.biblio.dao.contract.ResaDao;
import fr.mb.biblio.models.beans.Reservation;
import fr.mb.biblio.models.exception.FunctionalException;
import fr.mb.biblio.models.exception.NotFoundException;
import fr.mb.biblio.soap.resaService.contract.ResaService;
import fr.mb.biblio.soap.resaService.impl.ResaServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "/ApplicationContext.xml")
public class ITResaServiceImpl {

    @Autowired
    ResaService resaService;

    @Autowired
    ResaDao resaDao;

    @Test
    @Transactional
    public void newReservationTest() throws NotFoundException, FunctionalException {
        Reservation resa = resaService.newReservation(8,2);
        assertTrue(resa.getId()!=0);
        assertThrows(NotFoundException.class, ()-> resaService.newReservation(50,2));
        assertThrows(FunctionalException.class, ()->resaService.newReservation(0,2));

    }

    @Test
    @Transactional
    public void deleteReservationTest() {
        assertDoesNotThrow(()->resaService.deleteReservation(1));
        assertThrows(NotFoundException.class,()->resaService.deleteReservation(5));
        assertThrows(FunctionalException.class,()->resaService.deleteReservation(0));

    }

    @Test
    @Transactional
    public void startResaTest() throws NotFoundException, FunctionalException {
        resaService.startResa(1);
        Reservation resa = resaService.getResaById(1);
        LocalDate dateNow = LocalDate.now();
        LocalDate dateEnd = LocalDate.now().plusDays(2);
        assertEquals(0, resa.getDebutResa().compareTo(dateNow), "verification date début");
        assertEquals(0,resa.getFinResa().compareTo(dateEnd),"verification date fin");

    }

    @Test
    @Transactional
    public void verifEndResa() throws NotFoundException, FunctionalException {
        Reservation resa = resaService.newReservation(1,1);
        LocalDate dateDebut=LocalDate.of(2018,10,12);
        LocalDate dateFin = dateDebut.plusDays(2);
        Integer id = resa.getId();
        resa.setDebutResa(dateDebut);
        resa.setFinResa(dateFin);
        resaDao.update(resa);

        resaService.verifEndResa();

        assertThrows(NotFoundException.class,()-> resaService.getResaById(id));

    }


}
