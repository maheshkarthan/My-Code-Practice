package XMLConverterWithAttributes;

import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class PayPalObjectToXMLRequest {

    public static void main(String args[]) {
        JAXBContext contextObj;
        try {
            contextObj = JAXBContext.newInstance(PayPalDepositRequest.class);
            Marshaller marshallerObj = contextObj.createMarshaller();
            marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshallerObj.setProperty("com.sun.xml.internal.bind.xmlHeaders", 
                    "\n<!DOCTYPE paymentService PUBLIC \"-//WorldPay//DTD WorldPay PaymentService v1//EN\"\n\"http://dtd.worldpay.com/paymentService_v1.dtd\">");
            
            PayPalDepositRequest request = new PayPalDepositRequest();
            PayPalDepositRequest.Request requestPapal = new PayPalDepositRequest.Request();
            PayPalDepositRequest.Request.Order order = new PayPalDepositRequest.Request.Order();
            PayPalDepositRequest.Request.Order.Amount amount = new PayPalDepositRequest.Request.Order.Amount();
            PayPalDepositRequest.Request.Order.Shopper shopper = new PayPalDepositRequest.Request.Order.Shopper();
            PayPalDepositRequest.Request.Order.PaymentDetails paymentDetails = new PayPalDepositRequest.Request.Order.PaymentDetails();
            PayPalDepositRequest.Request.Order.PaymentDetails.PayPalExpress paypalExpress = new PayPalDepositRequest.Request.Order.PaymentDetails.PayPalExpress();
            request.setMerchantCode("100");
            
            amount.setCurrencyCode("INR");
            amount.setExponent("uij");
            amount.setValue("jmkm");
            paypalExpress.setFirstInBillingRun("true");
            paypalExpress.setSuccessUrl("www");
            paypalExpress.setFailureUrl("uhnj");
            paypalExpress.setCancelUrl("jjjkx");
            paymentDetails.setPayPalExpress(paypalExpress);
            order.setPaymentDetails(paymentDetails);
            order.setAmount(amount);
            order.setDescription("Descrip");
            order.setMerchantTransactionId("Merchent");
            order.setOrderContent("content");
            order.setShopperLanguageCode("en");
            shopper.setShopperEmailAddress("@gmail.com");
            
            order.setShopper(shopper);
            requestPapal.setOrder(order);
            
            request.setRequest(requestPapal);
            
            
            marshallerObj.marshal(request, new FileOutputStream("C:/Users/mkartan/Desktop/request.xml"));
            
            System.out.println("Created XML Successfully!");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        
    }
}
