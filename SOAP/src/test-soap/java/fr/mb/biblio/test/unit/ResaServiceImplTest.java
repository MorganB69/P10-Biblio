package fr.mb.biblio.test.unit;

import fr.mb.biblio.dao.contract.ResaDao;
import fr.mb.biblio.models.beans.Livre;
import fr.mb.biblio.models.beans.Reservation;
import fr.mb.biblio.models.exception.FunctionalException;
import fr.mb.biblio.soap.resaService.impl.ResaServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(MockitoExtension.class)
public class ResaServiceImplTest {

    //Classe à tester
    @InjectMocks
    private ResaServiceImpl resaService = new ResaServiceImpl();

    @Mock
    private ResaDao resaDao;

    @Test
    public void checkNbExemplaireTest() throws FunctionalException {
        Livre livreTest = new Livre();
        Set<Reservation> listeResa = new TreeSet<Reservation>();
        //Nombre d'exemplaire
        livreTest.setExemplaire(3);
        //Creation d'une liste non pleine
        for (int i = 0; i < 5; i++) {
            Reservation resa = new Reservation();
            resa.setId(i);
            listeResa.add(resa);
        }
        livreTest.setListeResa(listeResa);
        //Verification pas d'erreur
        assertDoesNotThrow(() -> resaService.checkNbExemplaire(livreTest));

        //Creation d'une liste pleine
        listeResa.clear();
        for (int i = 0; i < 6; i++) {
            Reservation resa = new Reservation();
            resa.setId(i);
            listeResa.add(resa);
        }
        //Verification qu'une exception est lancée
        assertThrows(FunctionalException.class,() -> resaService.checkNbExemplaire(livreTest));

    }


}
