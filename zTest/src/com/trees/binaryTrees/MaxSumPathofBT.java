package com.trees.binaryTrees;

import com.trees.binaryTrees.BinaryTreeImpl.Node;

/*
        1
      /   \
     2     3
    / \   /  \
   4   5 6    7
        / \
       9   8
      /
     91
*/

public class MaxSumPathofBT {
    Node root;

    public static int maxSumPath(Node root) {
        if (root == null)
            return 0;
        return Math.max(maxSumPath(root.left), maxSumPath(root.right)) + root.data;
    }

    public static void main(String[] args) {
        MaxSumPathofBT tree = new MaxSumPathofBT();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.left.left = new Node(9);
        tree.root.right.left.left.left = new Node(91);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);
        int max = maxSumPath(tree.root);
        System.out.println("max path sum is " + max);
    }
}