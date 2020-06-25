package XMLConverterWithAttributes;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "paymentService")
public class PayPalDepositResponse {

    private String version = "1.4";
    private String merchantCode;
    private Response response;

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

    @XmlElement(name = "reply")
    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public static class Response {

        private OrderStatus orderStatus;

        @XmlElement(name = "orderStatus")
        public OrderStatus getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(OrderStatus orderStatus) {
            this.orderStatus = orderStatus;
        }

        public static class OrderStatus {

            private String orderCode;
            private Reference reference;
            private Error error;
            
            @XmlElement(name = "error")
            public Error getError() {
                return error;
            }

            public void setError(Error error) {
                this.error = error;
            }

            @XmlAttribute
            public String getOrderCode() {
                return orderCode;
            }

            public void setOrderCode(String orderCode) {
                this.orderCode = orderCode;
            }

            @XmlElement(name = "reference")
            public Reference getReference() {
                return reference;
            }

            public void setReference(Reference reference) {
                this.reference = reference;
            }

            public static class Reference {

                private String id;
                private String reference;

                @XmlAttribute
                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                @XmlValue
                public String getReference() {
                    return reference;
                }

                public void setReference(String reference) {
                    this.reference = reference;
                }
            }
            
            public static class Error {

                private String errorCode;
                private String errorMessage;

                @XmlAttribute(name = "code")
                public String getErrorCode() {
                    return errorCode;
                }

                public void setErrorCode(String errorCode) {
                    this.errorCode = errorCode;
                }

                @XmlValue
                public String getErrorMessage() {
                    return errorMessage;
                }

                public void setErrorMessage(String errorMessage) {
                    this.errorMessage = errorMessage;
                }
            }
        }
    }
}
