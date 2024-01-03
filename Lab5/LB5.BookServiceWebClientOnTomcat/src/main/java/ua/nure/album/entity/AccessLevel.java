
package ua.nure.album.entity;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AccessLevel.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="AccessLevel"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="PRIVATE"/&gt;
 *     &lt;enumeration value="LINK_ONLY"/&gt;
 *     &lt;enumeration value="PUBLIC"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "AccessLevel")
@XmlEnum
public enum AccessLevel {

    PRIVATE,
    LINK_ONLY,
    PUBLIC;

    public String value() {
        return name();
    }

    public static AccessLevel fromValue(String v) {
        return valueOf(v);
    }

}