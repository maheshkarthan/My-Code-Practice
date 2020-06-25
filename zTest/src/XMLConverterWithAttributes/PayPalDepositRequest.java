package XMLConverterWithAttributes;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "paymentService")
public class PayPalDepositRequest {

    private Request request;
    private String version = "1.4";
    private String merchantCode;

    @XmlElement(name = "submit")
    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    @XmlAttribute
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @XmlAttribute
    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public static class Request {
        
        private Order order;

        @XmlElement(name = "order")
        public Order getOrder() {
            return order;
        }

        public void setOrder(Order order) {
            this.order = order;
        }

        @XmlType(propOrder = {"merchantTransactionId", "shopperLanguageCode", "description", "amount", "orderContent", "paymentDetails", "shopper"})
        public static class Order {

            private String merchantTransactionId;
            private String shopperLanguageCode;
            private String description;
            private Amount amount;
            private String orderContent;
            private PaymentDetails paymentDetails;
            private Shopper shopper;

            @XmlAttribute(name = "orderCode")
            public String getMerchantTransactionId() {
                return merchantTransactionId;
            }

            public void setMerchantTransactionId(String merchantTransactionId) {
                this.merchantTransactionId = merchantTransactionId;
            }

            @XmlAttribute(name = "shopperLanguageCode")
            public String getShopperLanguageCode() {
                return shopperLanguageCode;
            }

            public void setShopperLanguageCode(String shopperLanguageCode) {
                this.shopperLanguageCode = shopperLanguageCode;
            }

            @XmlElement(name = "description")
            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            @XmlElement(name = "amount")
            public Amount getAmount() {
                return amount;
            }

            public void setAmount(Amount amount) {
                this.amount = amount;
            }

            @XmlElement(name = "orderContent")
            public String getOrderContent() {
                return orderContent;
            }

            public void setOrderContent(String orderContent) {
                this.orderContent = orderContent;
            }

            @XmlElement(name = "paymentDetails")
            public PaymentDetails getPaymentDetails() {
                return paymentDetails;
            }

            public void setPaymentDetails(PaymentDetails paymentDetails) {
                this.paymentDetails = paymentDetails;
            }

            @XmlElement(name = "shopper")
            public Shopper getShopper() {
                return shopper;
            }

            public void setShopper(Shopper shopper) {
                this.shopper = shopper;
            }

            public static class Amount {

                private String currencyCode;
                private String exponent;
                private String value;

                @XmlAttribute(name = "currencyCode")
                public String getCurrencyCode() {
                    return currencyCode;
                }

                public void setCurrencyCode(String currencyCode) {
                    this.currencyCode = currencyCode;
                }

                @XmlAttribute(name = "exponent")
                public String getExponent() {
                    return exponent;
                }

                public void setExponent(String exponent) {
                    this.exponent = exponent;
                }

                @XmlAttribute(name = "value")
                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }

            public static class PaymentDetails {

                private PayPalExpress payPalExpress;

                @XmlElement(name = "PAYPAL-EXPRESS")
                public PayPalExpress getPayPalExpress() {
                    return payPalExpress;
                }

                public void setPayPalExpress(PayPalExpress payPalExpress) {
                    this.payPalExpress = payPalExpress;
                }

                public static class PayPalExpress {

                    private String firstInBillingRun;
                    private String successUrl;
                    private String failureUrl;
                    private String cancelUrl;

                    @XmlAttribute(name = "firstInBillingRun")
                    public String getFirstInBillingRun() {
                        return firstInBillingRun;
                    }

                    public void setFirstInBillingRun(String firstInBillingRun) {
                        this.firstInBillingRun = firstInBillingRun;
                    }

                    @XmlElement(name = "successUrl")
                    public String getSuccessUrl() {
                        return successUrl;
                    }

                    public void setSuccessUrl(String successUrl) {
                        this.successUrl = successUrl;
                    }

                    @XmlElement(name = "failureUrl")
                    public String getFailureUrl() {
                        return failureUrl;
                    }

                    public void setFailureUrl(String failureUrl) {
                        this.failureUrl = failureUrl;
                    }

                    @XmlElement(name = "cancelUrl")
                    public String getCancelUrl() {
                        return cancelUrl;
                    }

                    public void setCancelUrl(String cancelUrl) {
                        this.cancelUrl = cancelUrl;
                    }
                }
            }

            public static class Shopper {

                private String shopperEmailAddress;

                @XmlElement(name = "shopperEmailAddress")
                public String getShopperEmailAddress() {
                    return shopperEmailAddress;
                }

                public void setShopperEmailAddress(String shopperEmailAddress) {
                    this.shopperEmailAddress = shopperEmailAddress;
                }
            }
        }
    }
}
