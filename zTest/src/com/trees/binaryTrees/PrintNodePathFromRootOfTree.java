package com.trees.binaryTrees;

// Java implementation to print the path from root
// to a given node in a binary tree

public class PrintNodePathFromRootOfTree {

    public static boolean hasPath(Node root, int x) {
        // if root is NULL
        // there is no path
        if (root == null)
            return false;

        if (root.data == x) {
            System.out.print(root.data);
            return true;
        }

        if (hasPath(root.right, x) || hasPath(root.left, x)) {
            System.out.print("->"+root.data);
            return true;
        }
        return false;
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        int x = 6;
        if (!hasPath(root, x))
            System.out.println("Path for the given key "+x+" Does not exist.");
    }
}

// A node of binary tree
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
};
