package fr.mb.biblio.batch;


import fr.mb.biblio.batch.service.pret.Exception_Exception;
import fr.mb.biblio.batch.service.pret.FunctionalException_Exception;
import fr.mb.biblio.batch.service.pret.PretService;
import fr.mb.biblio.batch.service.reservation.ResaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.inject.Inject;


public class RunScheduler {

    @Autowired
    PretService pretClient;

    @Autowired
    ResaService resaClient;

    public RunScheduler() {
        System.out.println("creation classe");
    }

    @Scheduled(cron = "${relancePretScheduler}")
    public void relanceRetard(){
        try {
            pretClient.relanceMailRetards();
        } catch (Exception_Exception | FunctionalException_Exception e) {
            e.printStackTrace();
        }
    }

    @Scheduled(cron = "${relancePretFuturScheduler}")
    public void relanceFuturRetard(){
        try {
            pretClient.relanceMailFuturRetard();
        } catch (Exception_Exception e) {
            e.printStackTrace();
        }
    }

    @Scheduled(cron = "${verifResaScheduler}" )
    public void verifResa(){
        resaClient.verifEndResa();
    }

}
