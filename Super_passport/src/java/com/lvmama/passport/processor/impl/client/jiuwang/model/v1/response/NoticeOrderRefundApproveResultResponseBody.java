//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.04.25 at 03:35:49 ���� CST 
//


package com.lvmama.passport.processor.impl.client.jiuwang.model.v1.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 【OTA提供】【订单】供应商通知用户申请退款结果（noticeOrderRefundApproveResult）
 * 
 * <p>Java class for NoticeOrderRefundApproveResultResponseBody complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NoticeOrderRefundApproveResultResponseBody">
 *   &lt;complexContent>
 *     &lt;extension base="{http://tour.ectrip.com/2014/QMResponseSchema}ResponseBody">
 *       &lt;sequence>
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NoticeOrderRefundApproveResultResponseBody", propOrder = {
    "message"
})
public class NoticeOrderRefundApproveResultResponseBody
    extends ResponseBody
{

    @XmlElement(required = true)
    protected String message;

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

}
