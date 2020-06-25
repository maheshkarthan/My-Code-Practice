package com.string.strings;

public class ConvertingNumberStringtoInt {

    public static void main(String[] args) {
        String number = "8195";
        int result = 0;
        for (int i = 0; i < number.length(); i++) {
            result = result * 10 + number.charAt(i) - '0';
            if(result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
                break;
            }
            System.out.println(number.charAt(i) - '0' +" "+number.charAt(i));
        }
        System.out.println(Integer.MIN_VALUE+"  "+result+"  "+Integer.MAX_VALUE);
    }
}
