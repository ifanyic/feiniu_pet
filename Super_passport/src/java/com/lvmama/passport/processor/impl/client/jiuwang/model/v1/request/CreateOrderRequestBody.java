//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.04.25 at 03:35:22 ���� CST 
//


package com.lvmama.passport.processor.impl.client.jiuwang.model.v1.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * 【畅游通提供】【订单】创建订单（createOrder）
 * 
 * <p>Java class for CreateOrderRequestBody complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateOrderRequestBody">
 *   &lt;complexContent>
 *     &lt;extension base="{http://tour.ectrip.com/2014/QMRequestDataSchema}RequestBody">
 *       &lt;sequence>
 *         &lt;element name="orderInfo">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="orderId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="product">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="resourceId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="productName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="visitDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="sellPrice" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="contactPerson">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="mobile" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="credentials" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="credentialsType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="visitPerson">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="person" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="credentials" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="credentialsType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="orderQuantity" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="orderPrice" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="orderStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateOrderRequestBody", propOrder = {
    "orderInfo"
})
public class CreateOrderRequestBody
    extends RequestBody
{

    @XmlElement(required = true)
    protected CreateOrderRequestBody.OrderInfo orderInfo;

    /**
     * Gets the value of the orderInfo property.
     *
     * @return
     *     possible object is
     *     {@link CreateOrderRequestBody.OrderInfo }
     *
     */
    public CreateOrderRequestBody.OrderInfo getOrderInfo() {
        return orderInfo;
    }

    /**
     * Sets the value of the orderInfo property.
     *
     * @param value
     *     allowed object is
     *     {@link CreateOrderRequestBody.OrderInfo }
     *
     */
    public void setOrderInfo(CreateOrderRequestBody.OrderInfo value) {
        this.orderInfo = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="orderId" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="product">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="resourceId" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="productName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="visitDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="sellPrice" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="contactPerson">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="mobile" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="credentials" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="credentialsType" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="visitPerson">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="person" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="credentials" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="credentialsType" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="orderQuantity" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="orderPrice" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="orderStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "orderId",
        "product",
        "contactPerson",
        "visitPerson",
        "orderQuantity",
        "orderPrice",
        "orderStatus"
    })
    public static class OrderInfo {

        @XmlElement(required = true)
        protected String orderId;
        @XmlElement(required = true)
        protected CreateOrderRequestBody.OrderInfo.Product product;
        @XmlElement(required = true)
        protected CreateOrderRequestBody.OrderInfo.ContactPerson contactPerson;
        @XmlElement(required = true)
        protected CreateOrderRequestBody.OrderInfo.VisitPerson visitPerson;
        @XmlElement(required = true)
        protected String orderQuantity;
        @XmlElement(required = true)
        protected String orderPrice;
        @XmlElement(required = true)
        protected String orderStatus;

        /**
         * Gets the value of the orderId property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getOrderId() {
            return orderId;
        }

        /**
         * Sets the value of the orderId property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setOrderId(String value) {
            this.orderId = value;
        }

        /**
         * Gets the value of the product property.
         *
         * @return
         *     possible object is
         *     {@link CreateOrderRequestBody.OrderInfo.Product }
         *
         */
        public CreateOrderRequestBody.OrderInfo.Product getProduct() {
            return product;
        }

        /**
         * Sets the value of the product property.
         *
         * @param value
         *     allowed object is
         *     {@link CreateOrderRequestBody.OrderInfo.Product }
         *
         */
        public void setProduct(CreateOrderRequestBody.OrderInfo.Product value) {
            this.product = value;
        }

        /**
         * Gets the value of the contactPerson property.
         *
         * @return
         *     possible object is
         *     {@link CreateOrderRequestBody.OrderInfo.ContactPerson }
         *
         */
        public CreateOrderRequestBody.OrderInfo.ContactPerson getContactPerson() {
            return contactPerson;
        }

        /**
         * Sets the value of the contactPerson property.
         *
         * @param value
         *     allowed object is
         *     {@link CreateOrderRequestBody.OrderInfo.ContactPerson }
         *
         */
        public void setContactPerson(CreateOrderRequestBody.OrderInfo.ContactPerson value) {
            this.contactPerson = value;
        }

        /**
         * Gets the value of the visitPerson property.
         *
         * @return
         *     possible object is
         *     {@link CreateOrderRequestBody.OrderInfo.VisitPerson }
         *
         */
        public CreateOrderRequestBody.OrderInfo.VisitPerson getVisitPerson() {
            return visitPerson;
        }

        /**
         * Sets the value of the visitPerson property.
         *
         * @param value
         *     allowed object is
         *     {@link CreateOrderRequestBody.OrderInfo.VisitPerson }
         *
         */
        public void setVisitPerson(CreateOrderRequestBody.OrderInfo.VisitPerson value) {
            this.visitPerson = value;
        }

        /**
         * Gets the value of the orderQuantity property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getOrderQuantity() {
            return orderQuantity;
        }

        /**
         * Sets the value of the orderQuantity property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setOrderQuantity(String value) {
            this.orderQuantity = value;
        }

        /**
         * Gets the value of the orderPrice property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getOrderPrice() {
            return orderPrice;
        }

        /**
         * Sets the value of the orderPrice property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setOrderPrice(String value) {
            this.orderPrice = value;
        }

        /**
         * Gets the value of the orderStatus property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getOrderStatus() {
            return orderStatus;
        }

        /**
         * Sets the value of the orderStatus property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setOrderStatus(String value) {
            this.orderStatus = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         *
         * <p>The following schema fragment specifies the expected content contained within this class.
         *
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="mobile" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="credentials" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="credentialsType" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         *
         *
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "name",
            "mobile",
            "credentials",
            "credentialsType"
        })
        public static class ContactPerson {

            @XmlElement(required = true)
            protected String name;
            @XmlElement(required = true)
            protected String mobile;
            @XmlElement(required = true)
            protected String credentials;
            @XmlElement(required = true)
            protected String credentialsType;

            /**
             * Gets the value of the name property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getName() {
                return name;
            }

            /**
             * Sets the value of the name property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * Gets the value of the mobile property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getMobile() {
                return mobile;
            }

            /**
             * Sets the value of the mobile property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setMobile(String value) {
                this.mobile = value;
            }

            /**
             * Gets the value of the credentials property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getCredentials() {
                return credentials;
            }

            /**
             * Sets the value of the credentials property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setCredentials(String value) {
                this.credentials = value;
            }

            /**
             * Gets the value of the credentialsType property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getCredentialsType() {
                return credentialsType;
            }

            /**
             * Sets the value of the credentialsType property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setCredentialsType(String value) {
                this.credentialsType = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         *
         * <p>The following schema fragment specifies the expected content contained within this class.
         *
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="resourceId" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="productName" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="visitDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="sellPrice" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         *
         *
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "resourceId",
            "productName",
            "visitDate",
            "sellPrice"
        })
        public static class Product {

            @XmlElement(required = true)
            protected String resourceId;
            @XmlElement(required = true)
            protected String productName;
            @XmlElement(required = true)
            protected String visitDate;
            @XmlElement(required = true)
            protected String sellPrice;

            /**
             * Gets the value of the resourceId property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getResourceId() {
                return resourceId;
            }

            /**
             * Sets the value of the resourceId property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setResourceId(String value) {
                this.resourceId = value;
            }

            /**
             * Gets the value of the productName property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getProductName() {
                return productName;
            }

            /**
             * Sets the value of the productName property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setProductName(String value) {
                this.productName = value;
            }

            /**
             * Gets the value of the visitDate property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getVisitDate() {
                return visitDate;
            }

            /**
             * Sets the value of the visitDate property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setVisitDate(String value) {
                this.visitDate = value;
            }

            /**
             * Gets the value of the sellPrice property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getSellPrice() {
                return sellPrice;
            }

            /**
             * Sets the value of the sellPrice property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setSellPrice(String value) {
                this.sellPrice = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         *
         * <p>The following schema fragment specifies the expected content contained within this class.
         *
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="person" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="credentials" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="credentialsType" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         *
         *
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "person"
        })
        public static class VisitPerson {

            protected List<Person> person;

            /**
             * Gets the value of the person property.
             *
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the person property.
             *
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getPerson().add(newItem);
             * </pre>
             *
             *
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link CreateOrderRequestBody.OrderInfo.VisitPerson.Person }
             *
             *
             */
            public List<Person> getPerson() {
                if (person == null) {
                    person = new ArrayList<Person>();
                }
                return this.person;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="credentials" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="credentialsType" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "name",
                "credentials",
                "credentialsType"
            })
            public static class Person {

                @XmlElement(required = true)
                protected String name;
                @XmlElement(required = true)
                protected String credentials;
                @XmlElement(required = true)
                protected String credentialsType;

                /**
                 * Gets the value of the name property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getName() {
                    return name;
                }

                /**
                 * Sets the value of the name property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setName(String value) {
                    this.name = value;
                }

                /**
                 * Gets the value of the credentials property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCredentials() {
                    return credentials;
                }

                /**
                 * Sets the value of the credentials property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCredentials(String value) {
                    this.credentials = value;
                }

                /**
                 * Gets the value of the credentialsType property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCredentialsType() {
                    return credentialsType;
                }

                /**
                 * Sets the value of the credentialsType property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCredentialsType(String value) {
                    this.credentialsType = value;
                }

            }

        }

    }

}
