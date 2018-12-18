package fr.mb.biblio.batch;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;


public class Main {


	public static void main(String[] args) {


		ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:applicationContextBatch.xml");

		RunScheduler runner = (RunScheduler) context.getBean("RunScheduler");

		Boolean lancementBatch = true;
		String relance="0";
		while(lancementBatch==true){



		switch (relance) {
			case "0":
				System.out.println("Pour relancer manuellement les mails en retard taper 1");
				System.out.println("Pour arrêter le batch, taper 2");
				Scanner sc = new Scanner(System.in);
				relance = sc.nextLine();
				break;

			case "1":
				runner.relanceRetard();
				System.out.println("Relance des mails effectuée");
				relance ="0";
				break;
			case "2":
				System.out.println("Arrêt du batch");
				lancementBatch=false;
				System.exit(0);
				break;

			default:
				System.out.println("Mauvaise saisie");
				relance="0";
				break;

		}
		}





	}
}
