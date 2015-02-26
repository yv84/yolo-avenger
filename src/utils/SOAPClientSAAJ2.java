import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;


import java.lang.Object;
import java.lang.String;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class SOAPClientSAAJ2 {

    public static void main(String args[]) throws Exception {
        // Create SOAP Connection
        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection soapConnection = soapConnectionFactory.createConnection();

        // Send SOAP Message to SOAP Server
        String url = "http://127.0.0.1:8080/helloworldws/bar?wsdl";
        SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(), url);

        // print SOAP Response
        System.out.print("Response SOAP Message:");

        /*
        Response SOAP Message:
        <S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/" xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
            <SOAP-ENV:Header/>
            <S:Body>
                <ns2:getEchoResponse xmlns:ns2="http://helloworldws.yv84.me/">
                    <return>qwe</return>
                </ns2:getEchoResponse>
            </S:Body>
        </S:Envelope>
         */

        soapResponse.writeTo(System.out);
        soapConnection.close();

        SOAPEnvelope env = soapResponse.getSOAPPart().getEnvelope();
        SOAPBody body = env.getBody();
        String bodyName = body.getNodeName();
        List<String> helloWorldMessages = new ArrayList<String>();
        if (body.hasChildNodes()) {
            Iterator getListResponse = body.getChildElements();
            while (getListResponse.hasNext()) {
                SOAPElement ns2 = (SOAPElement) getListResponse.next();
                Iterator getReturnValues = ns2.getChildElements();
                while (getReturnValues.hasNext()) {
                    SOAPElement el = (SOAPElement) getReturnValues.next();
                    helloWorldMessages.add(el.getValue());
                }

            }
        }
        System.out.println("\nResponse: " + helloWorldMessages.get(0));

    }

    private static SOAPMessage createSOAPRequest() throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "http://helloworldws.yv84.me/";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("ns2", serverURI);

        /*
        Constructed SOAP Request Message:
        <S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/" xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
            <SOAP-ENV:Header/>
            <S:Body>
                <ns2:getEcho xmlns:ns2="http://helloworldws.yv84.me/">
                    <arg0>qwe</arg0>
                </ns2:getEcho>
            </S:Body>
        </S:Envelope>
         */

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapOperation = soapBody.addChildElement("getEcho", "ns2");
        SOAPElement soapArgsElem = soapOperation.addChildElement("arg0");
        soapArgsElem.addTextNode("Hello request!");

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI + "bar");

        soapMessage.saveChanges();

        /* Print the request message */
        System.out.print("Request SOAP Message:");
        soapMessage.writeTo(System.out);
        System.out.println();

        return soapMessage;
    }

}