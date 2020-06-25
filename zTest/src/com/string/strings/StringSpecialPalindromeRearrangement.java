package com.string.strings;

public class StringSpecialPalindromeRearrangement {

    public static void main(String args[]) {
        String s = "ABCdcba";

        // creating a array which stores the
        // frequency of each character
        int u[] = new int[26];
        int n = s.length();

        for (int i = 0; i < n; i++) {
            // Checking if a character is uppercase or not
            if (Character.isUpperCase(s.charAt(i))) {
                // Increasing by 1 if uppercase
                u[s.charAt(i) - 65] += 1;
            } else {
                // Decreasing by 1 if lower case
                u[s.charAt(i) - 97] -= 1;
            }

        }
        // Storing the sum of positive
        // numbers in the frequency array
        int po = 0;

        // Storing the sum of negative
        // numbers in the frequency array
        int ne = 0;

        for (int i = 0; i < 26; i++) {
            if (u[i] > 0)
                po += u[i];

            if (u[i] < 0)
                ne += u[i];
        }

        // If all character balances out then its Yes
        if (po == 0 && ne == 0)
            System.out.println("YES");

        // If there is only 1 character wich
        // does not balances then also it is Yes
        else if (po == 1 && ne == 0)
            System.out.println("YES");

        else if (po == 0 && ne == -1)
            System.out.println("YES");

        else
            System.out.println("NO");

    }
}
