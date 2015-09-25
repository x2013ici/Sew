
package com.stfx.cli.sew.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for qosInputModel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="qosInputModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="executionPrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reliability" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="responseTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "qosInputModel", propOrder = {
    "executionPrice",
    "reliability",
    "responseTime"
})
public class QosInputModel {

    protected String executionPrice;
    protected String reliability;
    protected String responseTime;

    /**
     * Gets the value of the executionPrice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExecutionPrice() {
        return executionPrice;
    }

    /**
     * Sets the value of the executionPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExecutionPrice(String value) {
        this.executionPrice = value;
    }

    /**
     * Gets the value of the reliability property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReliability() {
        return reliability;
    }

    /**
     * Sets the value of the reliability property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReliability(String value) {
        this.reliability = value;
    }

    /**
     * Gets the value of the responseTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseTime() {
        return responseTime;
    }

    /**
     * Sets the value of the responseTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseTime(String value) {
        this.responseTime = value;
    }

}
