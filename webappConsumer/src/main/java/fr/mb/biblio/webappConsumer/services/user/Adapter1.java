
package fr.mb.biblio.webappConsumer.services.user;

import java.time.LocalDate;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class Adapter1
    extends XmlAdapter<String, LocalDate>
{


    public LocalDate unmarshal(String value) {
        return (fr.mb.biblio.webappConsumer.services.LocalDateXmlAdapter.unmarshal(value));
    }

    public String marshal(LocalDate value) {
        return (fr.mb.biblio.webappConsumer.services.LocalDateXmlAdapter.marshal(value));
    }

}
