package com.stack.stacks;

import java.util.Scanner;
import java.util.Stack;

public class CountValidBraces {
    private static Scanner scanner;

    public static void main(String args[]) throws Exception {
        Stack<Character> hs = new Stack<>();
        scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                hs.add(str.charAt(i));
            } else if (str.charAt(i) == ')' && (!hs.isEmpty() && hs.peek() == '(')) {
                hs.pop();
                count += 2;
            }
        }
        System.out.print(count);
    }
}
