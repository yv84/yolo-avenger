import javax.xml.soap.*;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import java.lang.Object;
import java.lang.String;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class SOAPClientSAAJ {

    public static void main(String args[]) throws Exception {
        // Create SOAP Connection
        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection soapConnection = soapConnectionFactory.createConnection();

        // Send SOAP Message to SOAP Server
        String url = "http://127.0.0.1:8080/helloworldws/bar?wsdl";
        SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(), url);

        // print SOAP Response
        System.out.print("Response SOAP Message:");
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
        System.out.println("\nList: " + helloWorldMessages);

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
                <ns2:getList xmlns:ns2="http://helloworldws.yv84.me/"/>
            </S:Body>
        </S:Envelope>
         */

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("getList", "ns2");

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI  + "bar");

        soapMessage.saveChanges();

        /* Print the request message */
        System.out.print("Request SOAP Message:");
        soapMessage.writeTo(System.out);
        System.out.println();

        return soapMessage;
    }

}