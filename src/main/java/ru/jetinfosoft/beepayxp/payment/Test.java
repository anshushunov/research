package ru.jetinfosoft.beepayxp.payment;

import javax.xml.bind.*;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPMessage;
import javax.xml.stream.*;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by Андрей on 10.09.2016.
 */

//reference:
    //working with XML https://softwarecave.org/2014/02/18/parse-xml-document-using-streaming-api-for-xml-stax/
    // http://adamish.com/blog/archives/707
    // https://numberformat.wordpress.com/2013/10/12/using-jaxb-to-unmarshal-a-soap-response/
    // http://tedone.typepad.com/blog/2011/06/unmarshalling-benchmark-in-java-jaxb-vs-stax-vs-woodstox.html

public class Test {

    public static final void main(String[] args) throws Exception {
        way1();
    }

    private static void way1() throws Exception {
        XMLInputFactory xif = XMLInputFactory.newFactory();
        StreamSource xml = new StreamSource("src/test/resources/request3.xml");
        XMLStreamReader xsr = xif.createXMLStreamReader(xml);

        //skip envelope
        xsr.nextTag();
        while(xsr.hasNext()) {
            if(xsr.isStartElement() && xsr.getLocalName().equals("partnerBalanceRequest")) {
                break;
            }
            if(xsr.isStartElement()) {
                System.out.println(xsr.getLocalName());
            }
            xsr.next();
        }

        JAXBContext jc = JAXBContext.newInstance(ru.jetinfosoft.beepayxp.payment.PartnerBalanceRequest.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        JAXBElement<ru.jetinfosoft.beepayxp.payment.PartnerBalanceRequest> jb = unmarshaller.unmarshal(xsr, ru.jetinfosoft.beepayxp.payment.PartnerBalanceRequest.class);
        xsr.close();

        ru.jetinfosoft.beepayxp.payment.PartnerBalanceRequest customer = jb.getValue();
        System.out.println(customer.getEndDate());
    }


    private static void way2() throws Exception {
        File file = new File("src/test/resources/request3.xml");
        InputStream inputStream = new FileInputStream(file);

        SOAPMessage message = MessageFactory.newInstance().createMessage(null,inputStream);
        Unmarshaller unmarshaller = JAXBContext.newInstance(ru.jetinfosoft.beepayxp.payment.PartnerBalanceRequest.class).createUnmarshaller();

        JAXBElement<ru.jetinfosoft.beepayxp.payment.PartnerBalanceRequest> jb =
                unmarshaller.unmarshal(message.getSOAPBody().extractContentAsDocument(), ru.jetinfosoft.beepayxp.payment.PartnerBalanceRequest.class);

        ru.jetinfosoft.beepayxp.payment.PartnerBalanceRequest customer = jb.getValue();
        System.out.println(customer.getEndDate());
    }


}
