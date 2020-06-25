package com.list.linkedLists;

public class PairwiseLinkedListSwap {

    Node head;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            next = null;
        }
    }

    public void push(int new_data) {
        /*
         * 1 & 2: Allocate the Node &
         * Put in the data
         */
        Node new_node = new Node(new_data);
        /* 3. Make next of new Node as head */
        new_node.next = head;
        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    void pairWiseSwap() {
        Node temp = head;
        /* Traverse only till there are atleast 2 nodes left */
        while (temp != null && temp.next != null) {
            /* Swap the data */
            int k = temp.value;
            temp.value = temp.next.value;
            temp.next.value = k;
            temp = temp.next.next;
        }
    }

    public static void main(String args[]) {
        PairwiseLinkedListSwap rdia = new PairwiseLinkedListSwap();
        rdia.push(10);
        rdia.push(14);
        rdia.push(13);
        rdia.push(12);
        rdia.push(11);
        rdia.push(9);

        rdia.printList();
        rdia.pairWiseSwap();
        rdia.printList();
    }
}
