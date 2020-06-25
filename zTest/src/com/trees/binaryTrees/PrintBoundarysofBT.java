package com.trees.binaryTrees;

import com.trees.binaryTrees.BinaryTreeImpl.Node;

// Java program to print boundary traversal of binary tree

/*
 * A binary tree node has data, pointer to left child
 * and a pointer to right child
 */

public class PrintBoundarysofBT {
    Node root;

    // A function to print all left boundry nodes, except a leaf node.
    // Print the nodes in TOP DOWN manner
    void printBoundaryLeft(Node node) {
        if (node != null) {
            if (node.left != null) {

                // to ensure top down order, print the node
                // before calling itself for left subtree
                System.out.print(node.data + " ");
                printBoundaryLeft(node.left);
            }

            // do nothing if it is a leaf node, this way we avoid
            // duplicates in output
        }
    }

    // A simple function to print leaf nodes of a binary tree
    void printLeaves(Node node) {
        if (node != null) {
            printLeaves(node.left);

            // Print it if it is a leaf node
            if (node.left == null && node.right == null)
                System.out.print(node.data + " ");
            printLeaves(node.right);
        }
    }

    // A function to print all right boundry nodes, except a leaf node
    // Print the nodes in BOTTOM UP manner
    void printBoundaryRight(Node node) {
        if (node != null) {
            if (node.right != null) {
                // to ensure bottom up order, first call for right
                // subtree, then print this node
                printBoundaryRight(node.right);
                System.out.print(node.data + " ");
            }
            // do nothing if it is a leaf node, this way we avoid
            // duplicates in output
        }
    }

    // A function to do boundary traversal of a given binary tree
    void printBoundary(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");

            // Print the left boundary in top-down manner.
            printBoundaryLeft(node.left);

            // Print all leaf nodes
            printLeaves(node.left);
            printLeaves(node.right);

            // Print the right boundary in bottom-up manner
            printBoundaryRight(node.right);
        }
    }

    // Driver program to test above functions
    public static void main(String args[]) {
        PrintBoundarysofBT tree = new PrintBoundarysofBT();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.left.left = new Node(9);
        tree.root.right.left.left.left = new Node(91);
        tree.root.right.right = new Node(7);
        tree.root.right.right.right = new Node(71);
        tree.root.right.left.right = new Node(8);
        tree.printBoundary(tree.root);
        
        /*
        1
      /   \
     2     3
    / \   /  \
   4   5 6    7
        / \     \
       9   8    71
      /
     91
*/

    }
}
