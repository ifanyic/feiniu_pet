//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.06.21 at 05:21:00 PM CST 
//


package com.lvmama.elong.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement; 
import java.util.List; 
import com.alibaba.fastjson.annotation.JSONField;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GiftBelongTo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GiftBelongTo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SHotelId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RoomTypeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RateplanId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GiftBelongTo", propOrder = {
    "sHotelId",
    "roomTypeId",
    "rateplanId"
})
public class GiftBelongTo {

    @JSONField(name = "SHotelId")
    protected String sHotelId;
    @JSONField(name = "RoomTypeId")
    protected String roomTypeId;
    @JSONField(name = "RateplanId")
    protected int rateplanId;

    /**
     * Gets the value of the sHotelId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSHotelId() {
        return sHotelId;
    }

    /**
     * Sets the value of the sHotelId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSHotelId(String value) {
        this.sHotelId = value;
    }

    /**
     * Gets the value of the roomTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomTypeId() {
        return roomTypeId;
    }

    /**
     * Sets the value of the roomTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomTypeId(String value) {
        this.roomTypeId = value;
    }

    /**
     * Gets the value of the rateplanId property.
     * 
     */
    public int getRateplanId() {
        return rateplanId;
    }

    /**
     * Sets the value of the rateplanId property.
     * 
     */
    public void setRateplanId(int value) {
        this.rateplanId = value;
    }

}
