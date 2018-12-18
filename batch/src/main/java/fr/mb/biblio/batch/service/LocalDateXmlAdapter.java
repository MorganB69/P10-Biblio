package fr.mb.biblio.batch.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class LocalDateXmlAdapter {
	
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	
    
    public static LocalDate unmarshal(String v) {
        return LocalDate.parse(v,formatter);
    }

    public static String marshal(LocalDate v) {
        if (v != null) {
            return v.format(formatter);
        } else {
            return null;
        }
    }
}

