
package fr.mb.biblio.webapp.services.identification;

import java.time.LocalDate;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class Adapter1
    extends XmlAdapter<String, LocalDate>
{


    public LocalDate unmarshal(String value) throws Exception {
        return (fr.mb.biblio.webapp.services.LocalDateXmlAdapter.unmarshal(value));
    }

    public String marshal(LocalDate value) throws Exception {
        return (fr.mb.biblio.webapp.services.LocalDateXmlAdapter.marshal(value));
    }

}
