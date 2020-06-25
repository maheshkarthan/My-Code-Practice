package com.string.strings;

// Java program to find Excel
// column name from a given
// column number

public class ExcelColumnTitle {
    // Function to print Excel column
    // name for a given column number
    private static void printString(int columnNumber) {
        // To store result (Excel column name)
        StringBuilder columnName = new StringBuilder();

        while (columnNumber > 0) {
            // Find remainder , Here we are using -1because index of A = 0 and Z = 25
            int index = (columnNumber - 1) % 26;
            columnName.append((char) ((index) + 'A'));
            columnNumber = (columnNumber - 1) / 26;
        }

        // Reverse the string and print result
        System.out.println(columnName.reverse());
    }

    public static void main(String[] args) {
        printString(26);
        printString(51);
        printString(52);
        printString(80);
        printString(676);
        printString(702);
        printString(950);
    }
}