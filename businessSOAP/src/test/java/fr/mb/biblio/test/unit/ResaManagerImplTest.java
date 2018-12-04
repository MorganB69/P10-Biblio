package fr.mb.biblio.test.unit;

import fr.mb.biblio.dao.contract.ResaDao;
import fr.mb.biblio.models.beans.Livre;
import fr.mb.biblio.models.beans.Reservation;
import fr.mb.biblio.models.beans.Utilisateur;
import fr.mb.biblio.models.exception.FunctionalException;
import fr.mb.biblio.soapbusiness.resaManager.impl.ResaManagerImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ResaManagerImplTest {

    //Classe à tester
    @InjectMocks
    private ResaManagerImpl resaManager = new ResaManagerImpl();

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
        assertDoesNotThrow(() -> resaManager.checkNbExemplaire(livreTest));

        //Creation d'une liste pleine
        listeResa.clear();
        for (int i = 0; i < 6; i++) {
            Reservation resa = new Reservation();
            resa.setId(i);
            listeResa.add(resa);
        }
        //Verification qu'une exception est lancée
        assertThrows(FunctionalException.class,() -> resaManager.checkNbExemplaire(livreTest));

    }

    @Test
    public void checkUserResaTest() throws FunctionalException {

        List<Reservation>liste = new ArrayList<>();
        Utilisateur user= new Utilisateur();
        user.setIdUtilisateur(2);
        Livre livre = new Livre();
        livre.setIdLivre(1);
        Reservation resa = new Reservation();
        resa.setDemandeur(user);
        resa.setLivre(livre);


        liste.add(resa);


        when(resaDao.getResaByUserId(2)).thenReturn(liste);
        assertThrows(FunctionalException.class,() ->resaManager.checkUserResa(user,livre));

    }


}
