package com.trees.binaryTrees;

public class BinaryTreeImpl {

    Node root;
    
    public static class Node {

        int data = 0;
        Node right, left;

        Node(int data) {
            this.data = data;
            right = null;
            left = null;
        }
        public Node() {
			// TODO Auto-generated constructor stub
		}
    }

    public static void main(String args[]) {

        BinaryTreeImpl bti = new BinaryTreeImpl();
        
        bti.root = new Node(10);
        bti.root.left = new Node(4);
        bti.root.right = new Node(8);
        bti.root.right.left = new Node(9);
        bti.root.left.right = new Node(45);
    }
}
