package XMLConverterWithAttributes;

import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import XMLConverterWithAttributes.RequestWorldpay.Request;
import XMLConverterWithAttributes.RequestWorldpay.Request.Order;
import XMLConverterWithAttributes.RequestWorldpay.Request.Order.Amount;
import XMLConverterWithAttributes.RequestWorldpay.Request.Order.Dynamic3DS;
import XMLConverterWithAttributes.RequestWorldpay.Request.Order.DynamicInteractionType;
import XMLConverterWithAttributes.RequestWorldpay.Request.Order.PaymentDetails;
import XMLConverterWithAttributes.RequestWorldpay.Request.Order.PaymentDetails.CardDetails;
import XMLConverterWithAttributes.RequestWorldpay.Request.Order.PaymentDetails.CardDetails.CardAddress;
import XMLConverterWithAttributes.RequestWorldpay.Request.Order.PaymentDetails.CardDetails.CardAddress.Address;
import XMLConverterWithAttributes.RequestWorldpay.Request.Order.PaymentDetails.CardDetails.ExpiryDate;
import XMLConverterWithAttributes.RequestWorldpay.Request.Order.PaymentDetails.CardDetails.ExpiryDate.Date;
import XMLConverterWithAttributes.RequestWorldpay.Request.Order.PaymentDetails.Session;
import XMLConverterWithAttributes.RequestWorldpay.Request.Order.User;
import XMLConverterWithAttributes.RequestWorldpay.Request.Order.User.BrowserDetails;

public class ObjectToXmlRequest {
    public static void main(String[] args) throws Exception {
        JAXBContext contextObj = JAXBContext.newInstance(RequestWorldpay.class);

        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshallerObj.setProperty("com.sun.xml.internal.bind.xmlHeaders", 
                "\n<!DOCTYPE paymentService PUBLIC \"-//WorldPay//DTD WorldPay PaymentService v1//EN\"\n\"http://dtd.worldpay.com/paymentService_v1.dtd\">");

        RequestWorldpay request = new RequestWorldpay();
        RequestWorldpay.Request submit=new Request();
        RequestWorldpay.Request.Order order = new Order();
        RequestWorldpay.Request.Order.Amount amount = new Amount();
        RequestWorldpay.Request.Order.PaymentDetails paymentDetails = new PaymentDetails();
        RequestWorldpay.Request.Order.User.BrowserDetails browser = new BrowserDetails();
        RequestWorldpay.Request.Order.User shopper = new User();
        RequestWorldpay.Request.Order.DynamicInteractionType dynamicInteractionType = new DynamicInteractionType();
        RequestWorldpay.Request.Order.Dynamic3DS dynamic3ds = new Dynamic3DS();
        RequestWorldpay.Request.Order.PaymentDetails.CardDetails cardDetails = new CardDetails();
        RequestWorldpay.Request.Order.PaymentDetails.CardDetails.ExpiryDate expiryDate = new ExpiryDate();
        RequestWorldpay.Request.Order.PaymentDetails.CardDetails.ExpiryDate.Date date = new Date();
        RequestWorldpay.Request.Order.PaymentDetails.CardDetails.CardAddress cardAddress = new CardAddress();
        RequestWorldpay.Request.Order.PaymentDetails.CardDetails.CardAddress.Address address = new Address();
        RequestWorldpay.Request.Order.PaymentDetails.Session session= new Session();
        
        
        amount.setCurrencyCode("GBP");
        amount.setExponent("2");
        amount.setValue("5000");
        
        date.setMonth("01");
        date.setYear("2020");
        expiryDate.setDate(date);
        
        address.setAddress1("AAA");
        address.setAddress2("BBB");
        address.setAddress3("CCC");
        address.setPostalCode("500001");
        address.setCity("City");
        address.setState("Hyderabad");
        address.setCountryCode("IND");
        
        cardAddress.setAddress(address);
        cardDetails.setCardNumber("4444333322221111");
        cardDetails.setExpiryDate(expiryDate);        
        cardDetails.setCardHolderName("A User");
        cardDetails.setCardAddress(cardAddress);
        session.setUserIPAddress("192.168.1.1");
        session.setId("9");
        
        paymentDetails.setCardDetails(cardDetails);
        paymentDetails.setSession(session);
        
        order.setMerchantTransactionId("EUR");
        order.setDescription("Ravi");
        shopper.setUserEmailAddress("mkartan@ivycomptech.com");
        
        browser.setAcceptHeader("text/html");
        browser.setUserAgentHeader("Chrome");
        shopper.setBrowserDetails(browser);
        
        dynamicInteractionType.setType("ECOMMERCE");
        dynamic3ds.setOverrideAdvice("3DS");      
        order.setDynamic3DS(dynamic3ds);
        order.setDynamicInteractionType(dynamicInteractionType);
        order.setDynamicMCC("09090");
        order.setUser(shopper);
        order.setAmount(amount);
        order.setPaymentDetails(paymentDetails);
        submit.setOrder(order);
        
        request.setVersion("1.5");
        request.setMerchantCode("12345");
        request.setRequest(submit);
        
        marshallerObj.marshal(request, new FileOutputStream("C:/Users/mkartan/Desktop/request.xml"));

        System.out.println("Created XML Successfully!");
    }
}