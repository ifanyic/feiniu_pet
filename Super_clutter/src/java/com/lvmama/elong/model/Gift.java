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
 * <p>Java class for Gift complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Gift">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseGiftRule">
 *       &lt;sequence>
 *         &lt;element name="GiftId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Gift", propOrder = {
    "giftId"
})
public class Gift
    extends BaseGiftRule
{

    @JSONField(name = "GiftId")
    protected int giftId;

    /**
     * Gets the value of the giftId property.
     * 
     */
    public int getGiftId() {
        return giftId;
    }

    /**
     * Sets the value of the giftId property.
     * 
     */
    public void setGiftId(int value) {
        this.giftId = value;
    }

	@Override
	public String toString() {
		return "Gift [giftId=" + giftId + "]";
	}

}
