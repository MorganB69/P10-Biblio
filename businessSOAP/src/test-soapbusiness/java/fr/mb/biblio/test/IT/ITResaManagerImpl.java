package fr.mb.biblio.test.IT;

import fr.mb.biblio.dao.contract.ResaDao;
import fr.mb.biblio.models.beans.Reservation;
import fr.mb.biblio.models.exception.FunctionalException;
import fr.mb.biblio.models.exception.NotFoundException;
import fr.mb.biblio.soapbusiness.resaManager.contract.ResaManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "/ApplicationContextTestBusiness.xml")
public class ITResaManagerImpl {

    @Autowired
    ResaManager resaManager;

    @Autowired
    ResaDao resaDao;

    @Test
    @Transactional
    public void newReservationTest() throws NotFoundException, FunctionalException {
        Reservation resa = resaManager.newReservation(8,2);
        assertTrue(resa.getId()!=0);
        assertThrows(NotFoundException.class, ()-> resaManager.newReservation(50,2));
        assertThrows(FunctionalException.class, ()->resaManager.newReservation(0,2));

    }

    @Test
    @Transactional
    public void deleteReservationTest() {
        assertDoesNotThrow(()->resaManager.deleteReservation(1));
        assertThrows(NotFoundException.class,()->resaManager.deleteReservation(5));
        assertThrows(FunctionalException.class,()->resaManager.deleteReservation(0));

    }

    @Test
    @Transactional
    public void startResaTest() throws NotFoundException, FunctionalException {
        resaManager.startResa(1);
        Reservation resa = resaManager.getResaById(1);
        LocalDate dateNow = LocalDate.now();
        LocalDate dateEnd = LocalDate.now().plusDays(2);
        assertEquals(0, resa.getDebutResa().compareTo(dateNow), "verification date début");
        assertEquals(0,resa.getFinResa().compareTo(dateEnd),"verification date fin");

    }

    @Test
    @Transactional
    public void verifEndResa() throws NotFoundException, FunctionalException {
        Reservation resa = resaManager.newReservation(1,1);
        LocalDate dateDebut=LocalDate.of(2018,10,12);
        LocalDate dateFin = dateDebut.plusDays(2);
        Integer id = resa.getId();
        resa.setDebutResa(dateDebut);
        resa.setFinResa(dateFin);
        resaDao.update(resa);

        resaManager.verifEndResa();

        assertThrows(NotFoundException.class,()-> resaManager.getResaById(id));

    }


}
