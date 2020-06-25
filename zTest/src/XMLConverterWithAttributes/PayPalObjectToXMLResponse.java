package XMLConverterWithAttributes;

import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class PayPalObjectToXMLResponse {

    public static void main(String args[]) {
        try {
            JAXBContext contextObj = JAXBContext.newInstance(PayPalDepositResponse.class);

            Marshaller marshallerObj = contextObj.createMarshaller();
            marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshallerObj.setProperty("com.sun.xml.internal.bind.xmlHeaders", 
                    "\n<!DOCTYPE paymentService PUBLIC \"-//WorldPay//DTD WorldPay PaymentService v1//EN\"\n\"http://dtd.worldpay.com/paymentService_v1.dtd\">");

            PayPalDepositResponse response = new PayPalDepositResponse();
            PayPalDepositResponse.Response paypalResponse = new PayPalDepositResponse.Response();
            PayPalDepositResponse.Response.OrderStatus orderStatus = new PayPalDepositResponse.Response.OrderStatus();
            PayPalDepositResponse.Response.OrderStatus.Reference reference = new PayPalDepositResponse.Response.OrderStatus.Reference();
            response.setMerchantCode("hjmkcd");
            orderStatus.setOrderCode("edfesfs");
            reference.setId("id");
            reference.setReference("hiuiins");
            orderStatus.setReference(reference);
            paypalResponse.setOrderStatus(orderStatus);
            response.setResponse(paypalResponse);
            
            
            
            marshallerObj.marshal(response, new FileOutputStream("C:/Users/mkartan/Desktop/response.xml"));
            
            System.out.println("Created XML Successfully!");
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
