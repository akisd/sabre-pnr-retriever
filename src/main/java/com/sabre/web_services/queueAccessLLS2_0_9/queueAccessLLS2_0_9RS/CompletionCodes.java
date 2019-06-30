//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.06.29 at 09:28:35 PM EEST 
//


package com.sabre.web_services.queueAccessLLS2_0_9.queueAccessLLS2_0_9RS;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CompletionCodes.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CompletionCodes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="Complete"/>
 *     &lt;enumeration value="Incomplete"/>
 *     &lt;enumeration value="NotProcessed"/>
 *     &lt;enumeration value="Unknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CompletionCodes")
@XmlEnum
public enum CompletionCodes {

    @XmlEnumValue("Complete")
    COMPLETE("Complete"),
    @XmlEnumValue("Incomplete")
    INCOMPLETE("Incomplete"),
    @XmlEnumValue("NotProcessed")
    NOT_PROCESSED("NotProcessed"),
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown");
    private final String value;

    CompletionCodes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CompletionCodes fromValue(String v) {
        for (CompletionCodes c: CompletionCodes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}