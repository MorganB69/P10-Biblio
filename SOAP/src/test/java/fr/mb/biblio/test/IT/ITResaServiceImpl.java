package fr.mb.biblio.test.IT;

import fr.mb.biblio.models.beans.Reservation;
import fr.mb.biblio.models.exception.FunctionalException;
import fr.mb.biblio.models.exception.NotFoundException;
import fr.mb.biblio.soap.resaService.contract.ResaService;
import fr.mb.biblio.soap.resaService.impl.ResaServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;


import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations= {"/ApplicationContext.xml"})
@ActiveProfiles(profiles = "test")
@Transactional
public class ITResaServiceImpl {

    private ResaService resaService = new ResaServiceImpl();

    @Test
    public void newReservationTest() throws NotFoundException, FunctionalException {

        Reservation resa = resaService.newReservation(13,2);
        assertTrue(resa.getId()!=0);


    }

}
