package com.list.linkedLists;

public class PalindromeLinkedList {

    Node head;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // push elements in the end of LL
    public void push(int value) {
        if (head == null) {
            head = new Node(value);
            return;
        }
        Node temp = head;
        Node newNode = new Node(value);
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    private void print() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        PalindromeLinkedList pl = new PalindromeLinkedList();
        pl.push(1);
        pl.push(2);
        pl.push(3);
        pl.push(4);
        pl.push(3);
        pl.push(2);
        pl.push(1);
        pl.print();
        System.out.println(pl.isPalindrome());
        pl.print();
        
        // Recursive way to check palindrome or not in O(n) time
        if (pl.recursivePalindromeCheck(pl.head)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }

    private boolean recursivePalindromeCheck(Node node) {
        if (node == null) {
            return true;
        }
        Node temp = node;
        recursivePalindromeCheck(temp.next);
        System.out.println(temp.value +" "+ head.value);
        if(temp.value != head.value) {
            return false;
        }
        head = head.next;
        return true;
    }

    Node slowPointer, fastPointer, secondHalf;

    private boolean isPalindrome() {
        Node previousSlowPointer = null, midnode = null;
        slowPointer = head;
        fastPointer = head;
        boolean res = true;
        // to Get the mid pointer in LL
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            previousSlowPointer = slowPointer;
            slowPointer = slowPointer.next;
        }

        //when odd make copy of middle element
        if (fastPointer != null) {
            midnode = slowPointer;
            slowPointer = slowPointer.next;
            System.out.println("Mid Node: "+midnode.value);
        }

        //copy the second half (if odd then after copying mid node)
        secondHalf = slowPointer;
        previousSlowPointer.next = null;

        //reverse the second half
        reverseLL();
        res = compareLL(head, secondHalf);
        reverseLL();
        if (midnode != null) {
            // If there was a mid node (odd size case) which
            // was not part of either first half or second half.
            previousSlowPointer.next = midnode;
            midnode.next = secondHalf;
        } else
            previousSlowPointer.next = secondHalf;
        return res;
    }

    private boolean compareLL(Node temp1, Node slowPointer) {
        Node temp = temp1;
        Node slowPointer2 = slowPointer;
        while (slowPointer2 != null && temp != null)
            if (temp.value == slowPointer2.value) {
                temp = temp.next;
                slowPointer2 = slowPointer2.next;
            } else {
                return false;
            }
        if (temp == null && slowPointer2 == null)
            return true;
        return false;
    }

    private void reverseLL() {
        Node prev = null;
        Node current = secondHalf;
        while (current != null) {
            Node temp = current.next;
            current.next = prev;

            prev = current;
            current = temp;
        }
        secondHalf = prev;
    }
}
