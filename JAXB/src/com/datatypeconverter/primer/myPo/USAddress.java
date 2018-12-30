//
// 此檔案是由 JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 所產生 
// 請參閱 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 一旦重新編譯來源綱要, 對此檔案所做的任何修改都將會遺失. 
// 產生時間: 2013.01.18 於 05:12:47 PM CST 
//


package com.datatypeconverter.primer.myPo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * First line of documentation for a <b>USAddress</b>.
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "USAddress", propOrder = {
    "toName",
    "street",
    "city",
    "state",
    "zipCode"
})
public class USAddress {

    @XmlElement(name = "name", required = true)
    protected String toName;
    @XmlElement(required = true)
    protected String street;
    @XmlElement(required = true)
    protected String city;
    @XmlElement(required = true)
    protected USState state;
    @XmlElement(name = "zip", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Integer zipCode;
    @XmlAttribute(name = "country")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String country;

    /**
     * 取得 toName 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToName() {
        return toName;
    }

    /**
     * 設定 toName 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToName(String value) {
        this.toName = value;
    }

    /**
     * 取得 street 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreet() {
        return street;
    }

    /**
     * 設定 street 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreet(String value) {
        this.street = value;
    }

    /**
     * 取得 city 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * 設定 city 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * 取得 state 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link USState }
     *     
     */
    public USState getState() {
        return state;
    }

    /**
     * 設定 state 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link USState }
     *     
     */
    public void setState(USState value) {
        this.state = value;
    }

    /**
     * 取得 zipCode 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getZipCode() {
        return zipCode;
    }

    /**
     * 設定 zipCode 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZipCode(Integer value) {
        this.zipCode = value;
    }

    /**
     * 取得 country 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        if (country == null) {
            return "TW";
        } else {
            return country;
        }
    }

    /**
     * 設定 country 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
    }

}
