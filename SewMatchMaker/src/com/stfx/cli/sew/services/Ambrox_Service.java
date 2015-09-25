
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
@WebServiceClient(name = "Ambrox", targetNamespace = "http://services.sew.cli.stfx.com/", wsdlLocation = "http://54.200.112.228:8080/SewWsdls/Ambrox?wsdl")
public class Ambrox_Service
    extends Service
{

    private final static URL AMBROX_WSDL_LOCATION;
    private final static WebServiceException AMBROX_EXCEPTION;
    private final static QName AMBROX_QNAME = new QName("http://services.sew.cli.stfx.com/", "Ambrox");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://54.200.112.228:8080/SewWsdls/Ambrox?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        AMBROX_WSDL_LOCATION = url;
        AMBROX_EXCEPTION = e;
    }

    public Ambrox_Service() {
        super(__getWsdlLocation(), AMBROX_QNAME);
    }

    public Ambrox_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), AMBROX_QNAME, features);
    }

    public Ambrox_Service(URL wsdlLocation) {
        super(wsdlLocation, AMBROX_QNAME);
    }

    public Ambrox_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, AMBROX_QNAME, features);
    }

    public Ambrox_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Ambrox_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Ambrox
     */
    @WebEndpoint(name = "AmbroxPort")
    public Ambrox getAmbroxPort() {
        return super.getPort(new QName("http://services.sew.cli.stfx.com/", "AmbroxPort"), Ambrox.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Ambrox
     */
    @WebEndpoint(name = "AmbroxPort")
    public Ambrox getAmbroxPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://services.sew.cli.stfx.com/", "AmbroxPort"), Ambrox.class, features);
    }

    private static URL __getWsdlLocation() {
        if (AMBROX_EXCEPTION!= null) {
            throw AMBROX_EXCEPTION;
        }
        return AMBROX_WSDL_LOCATION;
    }

}