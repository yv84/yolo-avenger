
package me.yv84.helloworldws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the me.yv84.helloworldws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetEcho_QNAME = new QName("http://helloworldws.yv84.me/", "getEcho");
    private final static QName _GetList_QNAME = new QName("http://helloworldws.yv84.me/", "getList");
    private final static QName _GetListResponse_QNAME = new QName("http://helloworldws.yv84.me/", "getListResponse");
    private final static QName _GetEchoResponse_QNAME = new QName("http://helloworldws.yv84.me/", "getEchoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: me.yv84.helloworldws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetEchoResponse }
     * 
     */
    public GetEchoResponse createGetEchoResponse() {
        return new GetEchoResponse();
    }

    /**
     * Create an instance of {@link GetEcho }
     * 
     */
    public GetEcho createGetEcho() {
        return new GetEcho();
    }

    /**
     * Create an instance of {@link GetList }
     * 
     */
    public GetList createGetList() {
        return new GetList();
    }

    /**
     * Create an instance of {@link GetListResponse }
     * 
     */
    public GetListResponse createGetListResponse() {
        return new GetListResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEcho }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://helloworldws.yv84.me/", name = "getEcho")
    public JAXBElement<GetEcho> createGetEcho(GetEcho value) {
        return new JAXBElement<GetEcho>(_GetEcho_QNAME, GetEcho.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://helloworldws.yv84.me/", name = "getList")
    public JAXBElement<GetList> createGetList(GetList value) {
        return new JAXBElement<GetList>(_GetList_QNAME, GetList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://helloworldws.yv84.me/", name = "getListResponse")
    public JAXBElement<GetListResponse> createGetListResponse(GetListResponse value) {
        return new JAXBElement<GetListResponse>(_GetListResponse_QNAME, GetListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEchoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://helloworldws.yv84.me/", name = "getEchoResponse")
    public JAXBElement<GetEchoResponse> createGetEchoResponse(GetEchoResponse value) {
        return new JAXBElement<GetEchoResponse>(_GetEchoResponse_QNAME, GetEchoResponse.class, null, value);
    }

}
