
package com.stfx.cli.sew.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Gmax", targetNamespace = "http://services.sew.cli.stfx.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Gmax {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns com.stfx.cli.sew.services.OutputModel
     */
    @WebMethod(operationName = "GmaxService")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "GmaxService", targetNamespace = "http://services.sew.cli.stfx.com/", className = "com.stfx.cli.sew.services.GmaxService")
    @ResponseWrapper(localName = "GmaxServiceResponse", targetNamespace = "http://services.sew.cli.stfx.com/", className = "com.stfx.cli.sew.services.GmaxServiceResponse")
    public OutputModel gmaxService(
        @WebParam(name = "arg0", targetNamespace = "")
        InputModel arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        QosInputModel arg1);

}
