
package ua.nure.album.service;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import ua.nure.album.entity.Album;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for listAlbumsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="listAlbumsResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://album.nure.ua/entity}listAlbums" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listAlbumsResponse", propOrder = {
    "listAlbums"
})
public class ListAlbumsResponse {

    @XmlElement(namespace = "http://album.nure.ua/entity")
    protected List<Album> listAlbums;

    /**
     * Gets the value of the listAlbums property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the listAlbums property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListAlbums().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Album }
     * 
     * 
     */
    public List<Album> getListAlbums() {
        if (listAlbums == null) {
            listAlbums = new ArrayList<Album>();
        }
        return this.listAlbums;
    }

}
