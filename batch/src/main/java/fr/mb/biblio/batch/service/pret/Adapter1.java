
package fr.mb.biblio.batch.service.pret;

import java.time.LocalDate;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class Adapter1
    extends XmlAdapter<String, LocalDate>
{


    public LocalDate unmarshal(String value) {
        return (fr.mb.biblio.batch.service.LocalDateXmlAdapter.unmarshal(value));
    }

    public String marshal(LocalDate value) {
        return (fr.mb.biblio.batch.service.LocalDateXmlAdapter.marshal(value));
    }

}
