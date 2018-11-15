package fr.mb.biblio.dao.testDao;


import fr.mb.biblio.dao.contract.ResaDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations= {"/ApplicationContext.xml"})
@ActiveProfiles(profiles = "dev")
class ResaDaoImplTest {

    @Autowired
    ResaDao resaDao;

    @Test
    @Transactional
    void getResaByUserId() {
        resaDao.getResaByUserId(2);
    }
}