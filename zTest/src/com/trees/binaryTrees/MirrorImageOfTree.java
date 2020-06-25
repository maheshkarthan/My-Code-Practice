package com.trees.binaryTrees;

import com.trees.binaryTrees.BinaryTreeImpl.Node;

public class MirrorImageOfTree {

    public static Node mirrorImageOfTree(Node root1) {
        if (root1 == null)
            return root1;

        Node root2 = new Node();
        root2 = root1;
        Node left = mirrorImageOfTree(root1.left);
        Node right = mirrorImageOfTree(root1.right);
        Node temp = left;
        root2.left = right;
        root2.right = temp;
        return root2;
    }

    public static void inOrderTraversal(Node root) {
        if (root == null)
            return;
        inOrderTraversal(root.left);
        System.out.print(root.data);
        inOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(9);
        root.left.left = new Node(3);
        root.right.right = new Node(2);
        inOrderTraversal(root);
        Node root2 = mirrorImageOfTree(root);
        System.out.println("\n================  Mirror Tree =================");
        inOrderTraversal(root2);

    }
}