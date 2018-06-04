package fr.mb.biblio.models;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class LocalDateXmlAdapter extends XmlAdapter<XMLGregorianCalendar, LocalDate> {
    private final DatatypeFactory datatypeFactory;
    public LocalDateXmlAdapter() throws DatatypeConfigurationException{
        this.datatypeFactory = DatatypeFactory.newInstance();
    }
    public LocalDate unmarshal(XMLGregorianCalendar xmlDate) throws Exception {
        return LocalDate.of(xmlDate.getYear(), xmlDate.getMonth(), xmlDate.getDay());
    }
    public XMLGregorianCalendar marshal(LocalDate localDate) throws Exception {
        return datatypeFactory.newXMLGregorianCalendarDate(localDate.getYear(), localDate.getMonth().getValue(), localDate.getDayOfMonth(),  DatatypeConstants.FIELD_UNDEFINED);
    }
}
