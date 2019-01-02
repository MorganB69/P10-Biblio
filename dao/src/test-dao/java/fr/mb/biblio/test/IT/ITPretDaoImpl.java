package fr.mb.biblio.test.IT;

import fr.mb.biblio.dao.contract.PretDao;
import fr.mb.biblio.models.beans.Pret;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations= {"/ApplicationContextTestDao.xml"})
@ActiveProfiles(profiles = "test")
@Transactional
public class ITPretDaoImpl {

    @Autowired
    PretDao pretDao;

    @Test
    @Rollback
    public void getPretFuturRetardIT(){
        LocalDate date = LocalDate.of(2019,01,02);
        List<Pret> listeRetard = pretDao.findPretEnCoursFuturRetard(date);
        assertEquals(3, listeRetard.size());


    }
}
