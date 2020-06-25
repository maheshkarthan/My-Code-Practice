package com.string.strings;

public class StringSplitter {
    public static void main(String[] args) {

        String domain = "https://www.infinity-cashierstatic.ivycomptech.co.in/jhjgdsygjhfdskgk/huhfudsgyugu/huihidh";

        if (domain.startsWith("http://")) {
            domain = domain.substring(7);
        } else if (domain.startsWith("https://")) {
            domain = domain.substring(8);
        }
        System.out.println((domain.startsWith("www.") ? domain.substring(4) : domain).split("/")[0]);

        // Converting IVYComptech to i v y c omptech
        String str = "IVYComptech";
        String lcSpace = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) > 'A' && str.charAt(i) < 'Z') { // can do using Character.isUpperCase(str.charAt(i))
                lcSpace += Character.toLowerCase(str.charAt(i)) + " ";
            } else {
                lcSpace += str.charAt(i);
            }
        }
        System.out.println(lcSpace);
    }

}
