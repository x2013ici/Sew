
package com.stfx.cli.sew.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.stfx.cli.sew.services package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GmaxService_QNAME = new QName("http://services.sew.cli.stfx.com/", "GmaxService");
    private final static QName _GmaxServiceResponse_QNAME = new QName("http://services.sew.cli.stfx.com/", "GmaxServiceResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.stfx.cli.sew.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GmaxService }
     * 
     */
    public GmaxService createGmaxService() {
        return new GmaxService();
    }

    /**
     * Create an instance of {@link GmaxServiceResponse }
     * 
     */
    public GmaxServiceResponse createGmaxServiceResponse() {
        return new GmaxServiceResponse();
    }

    /**
     * Create an instance of {@link QosInputModel }
     * 
     */
    public QosInputModel createQosInputModel() {
        return new QosInputModel();
    }

    /**
     * Create an instance of {@link InputModel }
     * 
     */
    public InputModel createInputModel() {
        return new InputModel();
    }

    /**
     * Create an instance of {@link OutputModel }
     * 
     */
    public OutputModel createOutputModel() {
        return new OutputModel();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GmaxService }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.sew.cli.stfx.com/", name = "GmaxService")
    public JAXBElement<GmaxService> createGmaxService(GmaxService value) {
        return new JAXBElement<GmaxService>(_GmaxService_QNAME, GmaxService.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GmaxServiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.sew.cli.stfx.com/", name = "GmaxServiceResponse")
    public JAXBElement<GmaxServiceResponse> createGmaxServiceResponse(GmaxServiceResponse value) {
        return new JAXBElement<GmaxServiceResponse>(_GmaxServiceResponse_QNAME, GmaxServiceResponse.class, null, value);
    }

}
