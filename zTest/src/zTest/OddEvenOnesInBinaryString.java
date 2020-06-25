package zTest;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class OddEvenOnesInBinaryString {
    static String binary = "";

    static void bin(BigInteger n) {
        if (n.compareTo(new BigInteger("1")) == 1)
            bin(n.divide(new BigInteger("2")));
        binary += String.valueOf(n.mod(new BigInteger("2")));
    }

    // Driver code
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseSize = Integer.parseInt(scanner.nextLine());
        BigInteger inputValues[] = new BigInteger[testCaseSize];
        for (int i = 0; i < testCaseSize; i++) {
            inputValues[i] = new BigInteger(scanner.nextLine());
            bin(inputValues[i]);
            System.out.println(binary);
            segrigateOddZerosAndOddOnes(binary, generateSubStringsToArrayList(binary));
            binary = "";
        }
    }

    static ArrayList<String> generateSubStringsToArrayList(String s) {
        ArrayList<String> al = new ArrayList<String>();
        for (int len = 1; len <= s.length(); len++) {
            // Pick ending point
            for (int i = 0; i <= s.length() - len; i++) {
                String subStringofS = "";
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    subStringofS += s.charAt(k);
                }

                al.add(subStringofS);
            }
        }
        return al;
    }

    static void segrigateOddZerosAndOddOnes(String binary, ArrayList<String> al) {
        int totalOdd0Count = 0;
        int totalOdd1Count = 0;
        for (String string : al) {
            int oddZerosCount = 0;
            int oddOnesCount = 0;
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) == '0')
                    oddZerosCount++;
                else
                    oddOnesCount++;
            }
            if (oddZerosCount % 2 != 0)
                totalOdd0Count++;
            if (oddOnesCount % 2 != 0)
                totalOdd1Count++;
        }
        System.out.println(totalOdd0Count + " " + totalOdd1Count);
    }

}
