
package ua.nure.album.service;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 3.0.0
 * Generated source version: 3.0
 * 
 */
@WebServiceClient(name = "Album", targetNamespace = "http://album.nure.ua/service", wsdlLocation = "http://localhost:9000/albums?wsdl")
public class Album
    extends Service
{

    private final static URL ALBUM_WSDL_LOCATION;
    private final static WebServiceException ALBUM_EXCEPTION;
    private final static QName ALBUM_QNAME = new QName("http://album.nure.ua/service", "Album");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:9000/albums?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ALBUM_WSDL_LOCATION = url;
        ALBUM_EXCEPTION = e;
    }

    public Album() {
        super(__getWsdlLocation(), ALBUM_QNAME);
    }

    public Album(WebServiceFeature... features) {
        super(__getWsdlLocation(), ALBUM_QNAME, features);
    }

    public Album(URL wsdlLocation) {
        super(wsdlLocation, ALBUM_QNAME);
    }

    public Album(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ALBUM_QNAME, features);
    }

    public Album(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Album(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns AlbumService
     */
    @WebEndpoint(name = "AlbumPort")
    public AlbumService getAlbumPort() {
        return super.getPort(new QName("http://album.nure.ua/service", "AlbumPort"), AlbumService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AlbumService
     */
    @WebEndpoint(name = "AlbumPort")
    public AlbumService getAlbumPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://album.nure.ua/service", "AlbumPort"), AlbumService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ALBUM_EXCEPTION!= null) {
            throw ALBUM_EXCEPTION;
        }
        return ALBUM_WSDL_LOCATION;
    }

}
