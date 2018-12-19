
package fr.mb.biblio.batch.service.reservation;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ResaServiceImplService", targetNamespace = "http://impl.resaService.soap.biblio.mb.fr/", wsdlLocation = "http://localhost:8080/resaService?wsdl")
public class ResaServiceImplService
    extends Service
{

    private final static URL RESASERVICEIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException RESASERVICEIMPLSERVICE_EXCEPTION;
    private final static QName RESASERVICEIMPLSERVICE_QNAME = new QName("http://impl.resaService.soap.biblio.mb.fr/", "ResaServiceImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/resaService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        RESASERVICEIMPLSERVICE_WSDL_LOCATION = url;
        RESASERVICEIMPLSERVICE_EXCEPTION = e;
    }

    public ResaServiceImplService() {
        super(__getWsdlLocation(), RESASERVICEIMPLSERVICE_QNAME);
    }

    public ResaServiceImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), RESASERVICEIMPLSERVICE_QNAME, features);
    }

    public ResaServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, RESASERVICEIMPLSERVICE_QNAME);
    }

    public ResaServiceImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, RESASERVICEIMPLSERVICE_QNAME, features);
    }

    public ResaServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ResaServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ResaService
     */
    @WebEndpoint(name = "ResaServiceImplPort")
    public ResaService getResaServiceImplPort() {
        return super.getPort(new QName("http://impl.resaService.soap.biblio.mb.fr/", "ResaServiceImplPort"), ResaService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ResaService
     */
    @WebEndpoint(name = "ResaServiceImplPort")
    public ResaService getResaServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://impl.resaService.soap.biblio.mb.fr/", "ResaServiceImplPort"), ResaService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (RESASERVICEIMPLSERVICE_EXCEPTION!= null) {
            throw RESASERVICEIMPLSERVICE_EXCEPTION;
        }
        return RESASERVICEIMPLSERVICE_WSDL_LOCATION;
    }

}
