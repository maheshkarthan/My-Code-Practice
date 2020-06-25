package com.list.linkedLists;

public class AddingPlusOneInLL {
    Node head = null;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    int carry = 1;

    public void addOneToLL(Node head) {
        if (head == null) {
            return;
        }

        Node temp = head;
        addOneToLL(temp.next);

        int tmp = temp.data + carry;
        temp.data = tmp % 10;
        carry = tmp / 10;
    }

    public void addOneToLL1(Node head) {
        Node temp = head;
        Node prevToAllContinuousNines = null;
        while (temp.next != null) { // Every time temp.next will refer to the next of current object
            if (temp.data != 9) {
                prevToAllContinuousNines = temp;
            }
            temp = temp.next;
        }
        // this is when there are different values combination in LL and last value 9
        if (prevToAllContinuousNines != null && temp.data == 9) { 
            prevToAllContinuousNines.data = prevToAllContinuousNines.data + 1;
            prevToAllContinuousNines = prevToAllContinuousNines.next;
            while (prevToAllContinuousNines != null) {
                prevToAllContinuousNines.data = 0;
                prevToAllContinuousNines = prevToAllContinuousNines.next;
            }
        } else if (temp.data == 9) { // when all the node values are 9's
            temp = head;
            Node node = new Node(1);
            while (temp != null) {
                temp.data = 0;
                temp = temp.next;
            }
            node.next = head;
            this.head = node;
        } else {
            temp.data++;
        }
    }

    public void push(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node newNode = new Node(data);
        temp.next = newNode;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        AddingPlusOneInLL tree = new AddingPlusOneInLL();
        tree.push(9);
        tree.push(9);
        tree.push(9);
        tree.push(9);
        tree.push(9);
        tree.push(9);
        tree.push(9);
        tree.push(91);
        tree.push(7);
        tree.push(9);
        tree.display();
        System.out.println();
        tree.addOneToLL(tree.head);
        Node tmp = tree.head;
        if (tree.carry != 0) {
            AddingPlusOneInLL tree1 = new AddingPlusOneInLL();
            tree1.push(tree.carry);
            tree.head = tree1.head;
            tree1.head.next = tmp;
        }
        tree.display();
        System.out.println();

        System.out.println("Second Approach");
        // Approach for all 9's in O(n) time
        AddingPlusOneInLL tree2 = new AddingPlusOneInLL();
        tree2.push(9);
        tree2.push(9);
        tree2.push(9);
        tree2.push(9);
        tree2.push(9);
        tree2.push(8);
        tree2.push(9);
        tree2.push(9);
        tree2.push(9);
        tree2.push(9);
        tree2.display();
        System.out.println();
        tree2.addOneToLL1(tree2.head);
        tree2.display();
    }
}
