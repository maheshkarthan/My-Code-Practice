package XMLConverterWithAttributes;

import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import XMLConverterWithAttributes.ResponseWorldpay.Response;
import XMLConverterWithAttributes.ResponseWorldpay.Response.PaymentStatus;
import XMLConverterWithAttributes.ResponseWorldpay.Response.PaymentStatus.Payment;
import XMLConverterWithAttributes.ResponseWorldpay.Response.PaymentStatus.Payment.Amount;
import XMLConverterWithAttributes.ResponseWorldpay.Response.PaymentStatus.Payment.ResponseCode;
import XMLConverterWithAttributes.ResponseWorldpay.Response.PaymentStatus.Payment.Balance;
import XMLConverterWithAttributes.ResponseWorldpay.Response.PaymentStatus.Payment.RiskScore;

public class ObjectToXmlResponse {

    public static void main(String args[]) throws Exception {
        JAXBContext contextObj = JAXBContext.newInstance(ResponseWorldpay.class);

        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshallerObj.setProperty("com.sun.xml.internal.bind.xmlHeaders", 
                "\n<!DOCTYPE paymentService PUBLIC \"-//WorldPay//DTD WorldPay PaymentService v1//EN\"\n\"http://dtd.worldpay.com/paymentService_v1.dtd\">");
        
        ResponseWorldpay response =  new ResponseWorldpay();
        ResponseWorldpay.Response reply = new Response();
        ResponseWorldpay.Response.PaymentStatus orderStatus = new PaymentStatus();
        ResponseWorldpay.Response.PaymentStatus.Payment payment = new Payment();
        ResponseWorldpay.Response.PaymentStatus.Payment.Amount amount = new Amount();
        ResponseWorldpay.Response.PaymentStatus.Payment.ResponseCode authorisationId = new ResponseCode();
        ResponseWorldpay.Response.PaymentStatus.Payment.Balance balance = new Balance();
        ResponseWorldpay.Response.PaymentStatus.Payment.Amount amount1 = new Amount();
        ResponseWorldpay.Response.PaymentStatus.Payment.RiskScore riskScore = new RiskScore();
        
        amount.setCurrencyCode("USD");
        amount.setDebitCreditIndicator("uiui");
        amount.setExponent("eeeee");
        amount.setValue("bbbb");
        
        payment.setAmount(amount);
        riskScore.setValue("Risk");
        payment.setRiskScore(riskScore);
        authorisationId.setId("3");
        payment.setResponseCode(authorisationId);
        payment.setPaymentMethod("VISA");
        payment.setCardNumber("44444444444444444");
        payment.setPaymentState("AUTHORISED");
        
        amount1.setCurrencyCode("EUR");
        amount1.setDebitCreditIndicator("yyyy");
        amount1.setExponent("ggg");
        amount1.setValue("ooo");
        balance.setAccountType("NONCC");
        balance.setAmount(amount1);
        
        payment.setBalance(balance);
        orderStatus.setMerchantTransactionId("55");
        orderStatus.setPayment(payment);
        
        reply.setPaymentStatus(orderStatus);
        response.setMerchantCode("12345");
        response.setVersion("1.5");
        response.setResponse(reply);
        marshallerObj.marshal(response, new FileOutputStream("C:/Users/mkartan/Desktop/response.xml"));

        System.out.println("Created XML Successfully!");
    }
}
