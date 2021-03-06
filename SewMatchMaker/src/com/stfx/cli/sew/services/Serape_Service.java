
package com.stfx.cli.sew.services;

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
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "Serape", targetNamespace = "http://services.sew.cli.stfx.com/", wsdlLocation = "http://54.200.112.228:8080/SewWsdls/Serape?wsdl")
public class Serape_Service
    extends Service
{

    private final static URL SERAPE_WSDL_LOCATION;
    private final static WebServiceException SERAPE_EXCEPTION;
    private final static QName SERAPE_QNAME = new QName("http://services.sew.cli.stfx.com/", "Serape");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://54.200.112.228:8080/SewWsdls/Serape?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SERAPE_WSDL_LOCATION = url;
        SERAPE_EXCEPTION = e;
    }

    public Serape_Service() {
        super(__getWsdlLocation(), SERAPE_QNAME);
    }

    public Serape_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), SERAPE_QNAME, features);
    }

    public Serape_Service(URL wsdlLocation) {
        super(wsdlLocation, SERAPE_QNAME);
    }

    public Serape_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SERAPE_QNAME, features);
    }

    public Serape_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Serape_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Serape
     */
    @WebEndpoint(name = "SerapePort")
    public Serape getSerapePort() {
        return super.getPort(new QName("http://services.sew.cli.stfx.com/", "SerapePort"), Serape.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Serape
     */
    @WebEndpoint(name = "SerapePort")
    public Serape getSerapePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://services.sew.cli.stfx.com/", "SerapePort"), Serape.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SERAPE_EXCEPTION!= null) {
            throw SERAPE_EXCEPTION;
        }
        return SERAPE_WSDL_LOCATION;
    }

}
