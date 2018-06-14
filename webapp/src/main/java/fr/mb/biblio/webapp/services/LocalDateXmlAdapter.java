package fr.mb.biblio.webapp.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;


public class LocalDateXmlAdapter {
	
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	
    
    public static LocalDate unmarshal(String v) throws Exception {
        return LocalDate.parse(v,formatter);
    }

    public static String marshal(LocalDate v) throws Exception {
        if (v != null) {
            return v.format(formatter);
        } else {
            return null;
        }
    }
}

