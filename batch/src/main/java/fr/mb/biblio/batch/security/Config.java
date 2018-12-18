package fr.mb.biblio.batch.security;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("fr.mb.biblio.batch")// scan for services
@EnableScheduling
public class Config {
}
