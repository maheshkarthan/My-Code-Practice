package com.trees.binaryTrees;

// Java implementation to print the path from root
// to a given node in a binary tree

public class PrintLeafsOfTree {

    public static void printLeafs(Node root) {

        if (root.left == null && root.right == null) {
            System.out.println(root.data);
        }
        if (root.left != null)
            printLeafs(root.left);
        if (root.right != null)
            printLeafs(root.right);

    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        printLeafs(root);
    }
}
