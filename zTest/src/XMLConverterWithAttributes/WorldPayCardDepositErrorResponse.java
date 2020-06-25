package XMLConverterWithAttributes;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "paymentService")
public class WorldPayCardDepositErrorResponse {

    private Response response;
    private String version;
    private String merchantCode;

    @XmlElement(name = "reply")
    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
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

    public static class Response {

        private Error error;
        
        
        @XmlElement(name = "error")
        public Error getError() {
            return error;
        }

        public void setError(Error error) {
            this.error = error;
        }
        
        public static class Error{
         
            private String errorCode;
            private String errorMsg;
            
            @XmlAttribute(name = "code")
            public String getErrorCode() {
                return errorCode;
            }

            public void setErrorCode(String errorCode) {
                this.errorCode = errorCode;
            }

           @XmlValue
            public String getErrorMsg() {
                return errorMsg;
            }

            public void setErrorMsg(String errorMsg) {
                this.errorMsg = errorMsg;
            }

            @Override
            public String toString() {
                return "Error [errorCode=" + errorCode + ", errorMsg=" + errorMsg + "]";
            }
            
        }

        public static class PaymentStatus {
            private String merchantTransactionId;
            private Payment payment;

            @XmlAttribute(name = "orderCode")
            public String getMerchantTransactionId() {
                return merchantTransactionId;
            }

            public void setMerchantTransactionId(String merchantTransactionId) {
                this.merchantTransactionId = merchantTransactionId;
            }

            @XmlElement(name = "payment")
            public Payment getPayment() {
                return payment;
            }

            public void setPayment(Payment payment) {
                this.payment = payment;
            }

            @XmlType(propOrder = {"paymentMethod", "amount", "paymentState", "responseCode", "balance", "cardNumber", "riskScore", "failureResponse"})
            public static class Payment {
                private String paymentMethod;
                private Amount amount;
                private String paymentState;
                private ResponseCode responseCode;
                private Balance balance;
                private String cardNumber;
                private RiskScore riskScore;
                private FailureResponse failureResponse;

                @XmlElement(name = "paymentMethod")
                public String getPaymentMethod() {
                    return paymentMethod;
                }

                public void setPaymentMethod(String paymentMethod) {
                    this.paymentMethod = paymentMethod;
                }

                @XmlElement(name = "amount")
                public Amount getAmount() {
                    return amount;
                }

                public void setAmount(Amount amount) {
                    this.amount = amount;
                }

                @XmlElement(name = "lastEvent")
                public String getPaymentState() {
                    return paymentState;
                }

                public void setPaymentState(String paymentState) {
                    this.paymentState = paymentState;
                }

                @XmlElement(name = "AuthorisationId")
                public ResponseCode getResponseCode() {
                    return responseCode;
                }

                public void setResponseCode(ResponseCode responseCode) {
                    this.responseCode = responseCode;
                }

                @XmlElement(name = "balance")
                public Balance getBalance() {
                    return balance;
                }

                public void setBalance(Balance balance) {
                    this.balance = balance;
                }

                @XmlElement(name = "cardNumber")
                public String getCardNumber() {
                    return cardNumber;
                }

                public void setCardNumber(String cardNumber) {
                    this.cardNumber = cardNumber;
                }

                @XmlElement(name = "riskScore")
                public RiskScore getRiskScore() {
                    return riskScore;
                }

                public void setRiskScore(RiskScore riskScore) {
                    this.riskScore = riskScore;
                }
                
                @XmlElement(name = "ISO8583ReturnCode")
                public FailureResponse getFailureResponse() {
                    return failureResponse;
                }

                public void setFailureResponse(FailureResponse failureResponse) {
                    this.failureResponse = failureResponse;
                }

                @XmlType(propOrder = {"value", "currencyCode", "exponent", "debitCreditIndicator"})
                public static class Amount {
                    private String value;
                    private String currencyCode;
                    private String exponent;
                    private String debitCreditIndicator;

                    @XmlAttribute
                    public String getValue() {
                        return value;
                    }

                    public void setValue(String value) {
                        this.value = value;
                    }

                    @XmlAttribute
                    public String getCurrencyCode() {
                        return currencyCode;
                    }

                    public void setCurrencyCode(String currencyCode) {
                        this.currencyCode = currencyCode;
                    }

                    @XmlAttribute
                    public String getExponent() {
                        return exponent;
                    }

                    public void setExponent(String exponent) {
                        this.exponent = exponent;
                    }

                    @XmlAttribute
                    public String getDebitCreditIndicator() {
                        return debitCreditIndicator;
                    }

                    public void setDebitCreditIndicator(String debitCreditIndicator) {
                        this.debitCreditIndicator = debitCreditIndicator;
                    }

                }
                
                @XmlType(propOrder = {"code", "failureDescription"})
                public static class FailureResponse {

                    private String code;
                    private String failureDescription;

                    @XmlAttribute
                    public String getCode() {
                        return code;
                    }

                    public void setCode(String code) {
                        this.code = code;
                    }

                    @XmlAttribute(name = "description")
                    public String getFailureDescription() {
                        return failureDescription;
                    }

                    public void setFailureDescription(String failureDescription) {
                        this.failureDescription = failureDescription;
                    }

                }

                public static class ResponseCode {
                    private String id;

                    @XmlAttribute
                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                }

                public static class Balance {
                    private String accountType;
                    private Amount amount;

                    @XmlAttribute
                    public String getAccountType() {
                        return accountType;
                    }

                    public void setAccountType(String accountType) {
                        this.accountType = accountType;
                    }

                    @XmlElement(name = "amount")
                    public Amount getAmount() {
                        return amount;
                    }

                    public void setAmount(Amount amount) {
                        this.amount = amount;
                    }

                }

                public static class RiskScore {
                    private String value;

                    @XmlAttribute
                    public String getValue() {
                        return value;
                    }

                    public void setValue(String value) {
                        this.value = value;
                    }

                }

            }
        }
    }
}
