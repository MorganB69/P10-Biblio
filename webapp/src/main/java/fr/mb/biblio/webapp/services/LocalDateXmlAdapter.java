package fr.mb.biblio.webapp.services;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class LocalDateXmlAdapter {
	public static LocalDate unmarshal(String v) throws Exception {
        return LocalDate.parse(v);
    }

	public static String marshal(LocalDate v) throws Exception {
        if (v != null) {
            return v.toString();
        } else {
            return null;
        }
    }
}

