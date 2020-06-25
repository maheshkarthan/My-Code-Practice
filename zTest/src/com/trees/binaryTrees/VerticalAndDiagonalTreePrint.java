package com.trees.binaryTrees;

// Java program for printing vertical order of a given binary tree
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;
import java.util.Vector;

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

public class VerticalAndDiagonalTreePrint {
    Node root;

 // Driver program to test above functions
    public static void main(String[] args) {

        VerticalAndDiagonalTreePrint tree = new VerticalAndDiagonalTreePrint();
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

        tree.VerticalAndDiagonalTreePrintUtil(tree.root);
    }

    static TreeMap<Integer, Vector<Integer>> verticalMap = new TreeMap<>();
    static HashMap<Integer, Vector<Integer>> diagonalMap = new HashMap<>();

    public void VerticalAndDiagonalTreePrintUtil(Node root) {
        getVerticalOrder(root, 0, verticalMap);
        System.out.println("Vertical Order traversal :: ");
        for (Entry<Integer, Vector<Integer>> entry : verticalMap.entrySet()) {
            System.out.println(entry.getValue());
        }

        getDiagonalOrder(root, 0, diagonalMap);
        System.out.println("Diagonal Order Traversal :: ");
        for (Entry<Integer, Vector<Integer>> entry : diagonalMap.entrySet()) {
            System.out.println(entry.getValue());
        }

        System.out.println("Iterative Diagonal Order Traversal :: ");
        getIterativeDiagonalOrder(root);
    }

    // Function to get vertical order in map 'm'
    // 'hd' is horizontal distance of current node from root initially passed as 0.
    public void getVerticalOrder(Node root, int hd, TreeMap<Integer, Vector<Integer>> m) {
        // Base case
        if (root == null)
            return;

        // get the vector list at 'hd'
        Vector<Integer> get = m.get(hd);

        // Store current node in map 'm'
        if (get == null) {
            get = new Vector<>();
            get.add(root.data);
        } else
            get.add(root.data);

        m.put(hd, get);

        // Store nodes in left subtree
        getVerticalOrder(root.left, hd - 1, m);

        // Store nodes in right subtree
        getVerticalOrder(root.right, hd + 1, m);
    }

    // Function to get Diagonal Order
    public void getDiagonalOrder(Node root, int d, HashMap<Integer, Vector<Integer>> diagonalPrint) {

        // Base case
        if (root == null)
            return;

        // get the list at the particular d value
        Vector<Integer> k = diagonalPrint.get(d);

        // k is null then create a vector and store the data
        if (k == null) {
            k = new Vector<>();
            k.add(root.data);
        } else {
            k.add(root.data);
        }

        // Store all nodes of same line together as a vector
        diagonalPrint.put(d, k);

        // Increase the vertical distance if left child
        getDiagonalOrder(root.left, d - 1, diagonalPrint);

        // Vertical distance remains same for right child
        getDiagonalOrder(root.right, d, diagonalPrint); // to print nodes of all the levels(level order), then we need to increment d+1 in left and right
                                                        // child's
    }

    // Iterative function to print diagonal view
    public void getIterativeDiagonalOrder(Node root) {
        // base case
        if (root == null)
            return;

        // inbuilt queue of Treenode
        Queue<Node> q = new LinkedList<Node>();

        // add root
        q.add(root);

        // add delimiter
        q.add(null);

        while (q.size() > 0) {
            Node temp = q.peek();
            q.remove();

            // if current is delimiter then insert another
            // for next diagonal and cout nextline
            if (temp == null) {

                // if queue is empty return
                if (q.size() == 0)
                    return;

                // output nextline
                System.out.println();

                // add delimiter again
                q.add(null);
            } else {
                while (temp != null) {
                    System.out.print(temp.data + " ");

                    // if left child is present
                    // add into queue
                    if (temp.left != null)
                        q.add(temp.left);

                    // current equals to right child then print
                    temp = temp.right;
                }
            }
        }
    }

}