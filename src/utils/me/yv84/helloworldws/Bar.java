
package me.yv84.helloworldws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "bar", targetNamespace = "http://helloworldws.yv84.me/", wsdlLocation = "http://yv84-u12:8080/helloworldws/bar?wsdl")
public class Bar
    extends Service
{

    private final static URL BAR_WSDL_LOCATION;
    private final static WebServiceException BAR_EXCEPTION;
    private final static QName BAR_QNAME = new QName("http://helloworldws.yv84.me/", "bar");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://yv84-u12:8080/helloworldws/bar?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        BAR_WSDL_LOCATION = url;
        BAR_EXCEPTION = e;
    }

    public Bar() {
        super(__getWsdlLocation(), BAR_QNAME);
    }

    public Bar(WebServiceFeature... features) {
        super(__getWsdlLocation(), BAR_QNAME, features);
    }

    public Bar(URL wsdlLocation) {
        super(wsdlLocation, BAR_QNAME);
    }

    public Bar(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, BAR_QNAME, features);
    }

    public Bar(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Bar(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WsFoo
     */
    @WebEndpoint(name = "wsFooPort")
    public WsFoo getWsFooPort() {
        return super.getPort(new QName("http://helloworldws.yv84.me/", "wsFooPort"), WsFoo.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WsFoo
     */
    @WebEndpoint(name = "wsFooPort")
    public WsFoo getWsFooPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://helloworldws.yv84.me/", "wsFooPort"), WsFoo.class, features);
    }

    private static URL __getWsdlLocation() {
        if (BAR_EXCEPTION!= null) {
            throw BAR_EXCEPTION;
        }
        return BAR_WSDL_LOCATION;
    }

}
