package fr.mb.biblio.test.IT;

import fr.mb.biblio.models.beans.Reservation;
import fr.mb.biblio.models.exception.FunctionalException;
import fr.mb.biblio.models.exception.NotFoundException;
import fr.mb.biblio.soap.resaService.contract.ResaService;
import fr.mb.biblio.soap.resaService.impl.ResaServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "/ApplicationContext.xml")
public class ITResaServiceImpl {

    @Autowired
    ResaService resaService;

    @Test
    public void newReservationTest() throws NotFoundException, FunctionalException {
        Reservation resa = resaService.newReservation(8,2);
        assertTrue(resa.getId()!=0);

    }
}
