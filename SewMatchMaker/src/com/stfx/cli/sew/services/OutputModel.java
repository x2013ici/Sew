
package com.stfx.cli.sew.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for outputModel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="outputModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ambrox" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cef3Serape" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gmaxTablet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="napa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serape" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "outputModel", propOrder = {
    "ambrox",
    "cef3Serape",
    "gmaxTablet",
    "napa",
    "serape"
})
public class OutputModel {

    protected String ambrox;
    protected String cef3Serape;
    protected String gmaxTablet;
    protected String napa;
    protected String serape;

    /**
     * Gets the value of the ambrox property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmbrox() {
        return ambrox;
    }

    /**
     * Sets the value of the ambrox property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmbrox(String value) {
        this.ambrox = value;
    }

    /**
     * Gets the value of the cef3Serape property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCef3Serape() {
        return cef3Serape;
    }

    /**
     * Sets the value of the cef3Serape property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCef3Serape(String value) {
        this.cef3Serape = value;
    }

    /**
     * Gets the value of the gmaxTablet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGmaxTablet() {
        return gmaxTablet;
    }

    /**
     * Sets the value of the gmaxTablet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGmaxTablet(String value) {
        this.gmaxTablet = value;
    }

    /**
     * Gets the value of the napa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNapa() {
        return napa;
    }

    /**
     * Sets the value of the napa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNapa(String value) {
        this.napa = value;
    }

    /**
     * Gets the value of the serape property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerape() {
        return serape;
    }

    /**
     * Sets the value of the serape property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerape(String value) {
        this.serape = value;
    }

}
