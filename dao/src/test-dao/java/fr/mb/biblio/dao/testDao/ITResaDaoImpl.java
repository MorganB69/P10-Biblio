package fr.mb.biblio.dao.testDao;

import fr.mb.biblio.dao.contract.ResaDao;
import fr.mb.biblio.models.beans.Reservation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;


    @ExtendWith(SpringExtension.class)
    @ContextConfiguration(locations= {"/ApplicationContext.xml"})
    @ActiveProfiles(profiles = "test")
    @Transactional
    public class ITResaDaoImpl {

        @Autowired
        ResaDao resaDao;

        @Test
        public void getResaByUserId() {
            List<Reservation> resa = resaDao.getResaByUserId(2);
        }

        @Test
        public void init(){
            assertNotNull(resaDao,"OK");
        }
    }

