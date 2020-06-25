package XMLConverterWithAttributes;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "paymentService")
public class RequestWorldpay {

    private Request request;
    private String version;
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

        @XmlType(propOrder = {"merchantTransactionId", "description", "amount", "paymentDetails", "user", "dynamicMCC", "dynamicInteractionType", "dynamic3DS"})
        public static class Order {

            private String merchantTransactionId;
            private String description;
            private Amount amount;
            private PaymentDetails paymentDetails;
            private User user;
            private String dynamicMCC;
            private DynamicInteractionType dynamicInteractionType;
            private Dynamic3DS dynamic3DS;

            @XmlAttribute(name = "orderCode")
            public String getMerchantTransactionId() {
                return merchantTransactionId;
            }

            public void setMerchantTransactionId(String merchantTransactionId) {
                this.merchantTransactionId = merchantTransactionId;
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

            @XmlElement(name = "shopper")
            public User getUser() {
                return user;
            }

            public void setUser(User user) {
                this.user = user;
            }

            @XmlElement(name = "dynamicMCC")
            public String getDynamicMCC() {
                return dynamicMCC;
            }

            public void setDynamicMCC(String dynamicMCC) {
                this.dynamicMCC = dynamicMCC;
            }

            @XmlElement(name = "dynamicInteractionType")
            public DynamicInteractionType getDynamicInteractionType() {
                return dynamicInteractionType;
            }

            public void setDynamicInteractionType(DynamicInteractionType dynamicInteractionType) {
                this.dynamicInteractionType = dynamicInteractionType;
            }

            @XmlElement(name = "dynamic3DS")
            public Dynamic3DS getDynamic3DS() {
                return dynamic3DS;
            }

            public void setDynamic3DS(Dynamic3DS dynamic3ds) {
                dynamic3DS = dynamic3ds;
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

            @XmlElement(name = "paymentDetails")
            public PaymentDetails getPaymentDetails() {
                return paymentDetails;
            }

            public void setPaymentDetails(PaymentDetails paymentDetails) {
                this.paymentDetails = paymentDetails;
            }

            public static class PaymentDetails {

                private CardDetails cardDetails;
                private Session session;

                @XmlElement(name = "CARD-SSL")
                public CardDetails getCardDetails() {
                    return cardDetails;
                }

                public void setCardDetails(CardDetails cardDetails) {
                    this.cardDetails = cardDetails;
                }

                @XmlElement(name = "session")
                public Session getSession() {
                    return session;
                }

                public void setSession(Session session) {
                    this.session = session;
                }

                @XmlType(propOrder = {"cardNumber", "expiryDate", "cardHolderName", "cardAddress"})
                public static class CardDetails {

                    private String cardNumber;
                    private ExpiryDate expiryDate;
                    private String cardHolderName;
                    private CardAddress cardAddress;

                    @XmlElement(name = "cardNumber")
                    public String getCardNumber() {
                        return cardNumber;
                    }

                    public void setCardNumber(String cardNumber) {
                        this.cardNumber = cardNumber;
                    }

                    @XmlElement(name = "expiryDate")
                    public ExpiryDate getExpiryDate() {
                        return expiryDate;
                    }

                    public void setExpiryDate(ExpiryDate expiryDate) {
                        this.expiryDate = expiryDate;
                    }

                    public static class ExpiryDate {
                        private Date date;

                        @XmlElement(name = "date")
                        public Date getDate() {
                            return date;
                        }

                        public void setDate(Date date) {
                            this.date = date;
                        }

                        public static class Date {
                            private String month;
                            private String year;

                            @XmlAttribute(name = "month")
                            public String getMonth() {
                                return month;
                            }

                            public void setMonth(String month) {
                                this.month = month;
                            }

                            @XmlAttribute(name = "year")
                            public String getYear() {
                                return year;
                            }

                            public void setYear(String year) {
                                this.year = year;
                            }

                        }
                    }

                    @XmlElement(name = "cardHolderName")
                    public String getCardHolderName() {
                        return cardHolderName;
                    }

                    public void setCardHolderName(String cardHolderName) {
                        this.cardHolderName = cardHolderName;
                    }

                    @XmlElement(name = "cardAddress")
                    public CardAddress getCardAddress() {
                        return cardAddress;
                    }

                    public void setCardAddress(CardAddress cardAddress) {
                        this.cardAddress = cardAddress;
                    }

                    public static class CardAddress {
                        private Address address;

                        @XmlElement(name = "address")
                        public Address getAddress() {
                            return address;
                        }

                        public void setAddress(Address address) {
                            this.address = address;
                        }

                        @XmlType(propOrder = {"address1", "address2", "address3", "postalCode", "city", "state", "countryCode"})
                        public static class Address {
                            private String address1;
                            private String address2;
                            private String address3;
                            private String postalCode;
                            private String city;
                            private String state;
                            private String countryCode;

                            @XmlElement(name = "address1")
                            public String getAddress1() {
                                return address1;
                            }

                            public void setAddress1(String address1) {
                                this.address1 = address1;
                            }

                            @XmlElement(name = "address2")
                            public String getAddress2() {
                                return address2;
                            }

                            public void setAddress2(String address2) {
                                this.address2 = address2;
                            }

                            @XmlElement(name = "address3")
                            public String getAddress3() {
                                return address3;
                            }

                            public void setAddress3(String address3) {
                                this.address3 = address3;
                            }

                            @XmlElement(name = "postalCode")
                            public String getPostalCode() {
                                return postalCode;
                            }

                            public void setPostalCode(String postalCode) {
                                this.postalCode = postalCode;
                            }

                            @XmlElement(name = "city")
                            public String getCity() {
                                return city;
                            }

                            public void setCity(String city) {
                                this.city = city;
                            }

                            @XmlElement(name = "state")
                            public String getState() {
                                return state;
                            }

                            public void setState(String state) {
                                this.state = state;
                            }

                            @XmlElement(name = "countryCode")
                            public String getCountryCode() {
                                return countryCode;
                            }

                            public void setCountryCode(String countryCode) {
                                this.countryCode = countryCode;
                            }

                        }
                    }

                }

                public static class Session {
                    private String userIPAddress;
                    private String id;

                    @XmlAttribute(name = "shopperIPAddress")
                    public String getUserIPAddress() {
                        return userIPAddress;
                    }

                    public void setUserIPAddress(String userIPAddress) {
                        this.userIPAddress = userIPAddress;
                    }

                    @XmlAttribute(name = "id")
                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                }
            }

            @XmlType(propOrder = {"userEmailAddress", "browserDetails"})
            public static class User {
                private String userEmailAddress;
                private BrowserDetails browserDetails;

                @XmlElement(name = "shopperEmailAddress")
                public String getUserEmailAddress() {
                    return userEmailAddress;
                }

                public void setUserEmailAddress(String userEmailAddress) {
                    this.userEmailAddress = userEmailAddress;
                }

                @XmlElement(name = "browser")
                public BrowserDetails getBrowserDetails() {
                    return browserDetails;
                }

                public void setBrowserDetails(BrowserDetails browserDetails) {
                    this.browserDetails = browserDetails;
                }

                public static class BrowserDetails {
                    private String acceptHeader;
                    private String userAgentHeader;

                    @XmlElement(name = "acceptHeader")
                    public String getAcceptHeader() {
                        return acceptHeader;
                    }

                    public void setAcceptHeader(String acceptHeader) {
                        this.acceptHeader = acceptHeader;
                    }

                    @XmlElement(name = "userAgentHeader")
                    public String getUserAgentHeader() {
                        return userAgentHeader;
                    }

                    public void setUserAgentHeader(String userAgentHeader) {
                        this.userAgentHeader = userAgentHeader;
                    }

                }
            }

            public static class DynamicInteractionType {
                private String type;

                @XmlAttribute(name = "type")
                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

            }

            public static class Dynamic3DS {
                private String overrideAdvice;

                @XmlAttribute(name = "overrideAdvice")
                public String getOverrideAdvice() {
                    return overrideAdvice;
                }

                public void setOverrideAdvice(String overrideAdvice) {
                    this.overrideAdvice = overrideAdvice;
                }

            }
        }
    }

}
