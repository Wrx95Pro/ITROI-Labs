
package ua.nure.album.service;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for removeImage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="removeImage"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="albumId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="imgUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "removeImage", propOrder = {
    "albumId",
    "imgUrl"
})
public class RemoveImage {

    @XmlElement(namespace = "")
    protected int albumId;
    @XmlElement(namespace = "")
    protected String imgUrl;

    /**
     * Gets the value of the albumId property.
     * 
     */
    public int getAlbumId() {
        return albumId;
    }

    /**
     * Sets the value of the albumId property.
     * 
     */
    public void setAlbumId(int value) {
        this.albumId = value;
    }

    /**
     * Gets the value of the imgUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * Sets the value of the imgUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImgUrl(String value) {
        this.imgUrl = value;
    }

}
