package fr.mb.biblio.dao.testDao;


import fr.mb.biblio.dao.contract.ResaDao;
import fr.mb.biblio.models.beans.Reservation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations= {"/ApplicationContext.xml"})
@ActiveProfiles(profiles = "test")
class ITResaDaoImpl {

    @Autowired
    ResaDao resaDao;

    @Test
    @Transactional
    void getResaByUserIdTest() {
        List<Reservation> resa = resaDao.getResaByUserId(2);
    }

    @Test
    @Transactional
    void initTest(){
        assertNotNull(resaDao,"OK");
    }
}

