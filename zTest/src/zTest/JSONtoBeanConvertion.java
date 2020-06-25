package zTest;

import java.lang.reflect.Method;

import com.google.gson.Gson;

public class JSONtoBeanConvertion {

    public static void main(String args[]) {
        // String json = "{'userTokenId': 'xxxxxxxx','clientUniqueId': null,'userPaymentOption': {'userPaymentOptionId': '8384922','cvv': null}}";

        // MyBean myBean = new Gson().fromJson(json, MyBean.class);

        // System.out.println(myBean);
        JSONtoBeanConvertion.method();

    }

    static void method() {
        String json = "{'userTokenId': 'xxxxxxxx','clientUniqueId': null,'userPaymentOption': {'userPaymentOptionId': '8384922','cvv': null}}";

        class MyBean {
            private String userTokenId;
            private String clientUniqueId;
            private UserPaymentOption userPaymentOption;

            public String getUserTokenId() {
                return userTokenId;
            }

            public void setUserTokenId(String userTokenId) {
                this.userTokenId = userTokenId;
            }

            public String getClientUniqueId() {
                return clientUniqueId;
            }

            public void setClientUniqueId(String clientUniqueId) {
                this.clientUniqueId = clientUniqueId;
            }

            public UserPaymentOption getUserPaymentOption() {
                return userPaymentOption;
            }

            public void setUserPaymentOption(UserPaymentOption userPaymentOption) {
                this.userPaymentOption = userPaymentOption;
            }

            @Override
            public String toString() {
                return "MyBean [userTokenId=" + userTokenId + ", clientUniqueId=" + clientUniqueId + ", userPaymentOption=" + userPaymentOption + "]";
            }

            class UserPaymentOption {
                private String userPaymentOptionId;
                private String cvv;

                public String getUserPaymentOptionId() {
                    return userPaymentOptionId;
                }

                public void setUserPaymentOptionId(String userPaymentOptionId) {
                    this.userPaymentOptionId = userPaymentOptionId;
                }

                public String getCvv() {
                    return cvv;
                }

                public void setCvv(String cvv) {
                    this.cvv = cvv;
                }

                @Override
                public String toString() {
                    return "UserPaymentOption [userPaymentOptionId=" + userPaymentOptionId + ", cvv=" + cvv + "]";
                }

            }
        }

        MyBean myBean = new Gson().fromJson(json, MyBean.class);
        System.out.println(myBean);
    }

}
