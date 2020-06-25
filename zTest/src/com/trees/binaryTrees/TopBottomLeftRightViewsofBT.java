package com.trees.binaryTrees;

import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

import com.trees.binaryTrees.BinaryTreeImpl.Node;

// Java program to print all side's views of a binary tree

/* Iterative methods of left and right views(Best understanding. some deep needs)
    https://www.geeksforgeeks.org/iterative-method-to-print-left-view-of-a-binary-tree/    (levelorder considers 1st element of that level)
    https://www.geeksforgeeks.org/right-view-binary-tree-using-queue/   (level order considers last elment of that level)
*/

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

public class TopBottomLeftRightViewsofBT {
    Node root;

    // Driver program to test the above functions
    public static void main(String args[]) {
        TopBottomLeftRightViewsofBT tree = new TopBottomLeftRightViewsofBT();
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

        tree.printViewsofBinaryTree();
    }

    void printViewsofBinaryTree() {
        System.out.print("Top View   :: ");
        getBTTopView(root);
        System.out.println();
        System.out.print("Bottom View   :: ");
        getBTBottomView(root);
        System.out.println();
        System.out.print("Right View :: ");
        getBTRightView(root, 1);
        System.out.println();
        System.out.print("Left View  :: ");
        getBTLeftView(root, 1);
        System.out.println();
        System.out.println("Iterative Left View  ::  ");
        leftViewUtil(root);
    }

    // function should print the topView of a binary tree
    public void getBTTopView(Node root) {
        class Pair {
            Node node;
            int level;

            Pair(Node node, int data) {
                this.node = node;
                this.level = data;
            }
        }
        // Queue to do BFS
        Queue<Pair> q = new LinkedList<Pair>(); // Node has single valued Constructor, Pair has two Valued Constructor

        // map to store node at each vartical distance
        Map<Integer, Node> map = new TreeMap<Integer, Node>();

        // Base case
        if (root == null) {
            return;
        } else {
            q.add(new Pair(root, 0));
        }

        // BFS
        while (!q.isEmpty()) {

            Pair temp = q.poll();
            //put a value in map only for the first time.
            if (!map.containsKey(temp.level)) {
                map.put(temp.level, temp.node);
            }

            if (temp.node.left != null) {
                q.add(new Pair(temp.node.left, temp.level - 1));
            }
            if (temp.node.right != null) {
                q.add(new Pair(temp.node.right, temp.level + 1));
            }
        }
        for (Entry<Integer, Node> entry : map.entrySet()) {
            System.out.print(entry.getValue().data + " ");
        }
    }

    // function should print the topView of a binary tree
    public void getBTBottomView(Node root) {
        class Pair {
            Node node;
            int level;

            Pair(Node node, int data) {
                this.node = node;
                this.level = data;
            }
        }
        // Queue to do BFS
        Queue<Pair> q = new LinkedList<Pair>(); // Node has single valued Constructor, Pair has two Valued Constructor

        // map to store node at each vartical distance
        Map<Integer, Node> map = new TreeMap<Integer, Node>();

        // Base case
        if (root == null) {
            return;
        } else {
            q.add(new Pair(root, 0));
        }

        // BFS
        while (!q.isEmpty()) {

            Pair temp = q.poll();
            //update a value in map every time.
            map.put(temp.level, temp.node);

            if (temp.node.left != null) {
                q.add(new Pair(temp.node.left, temp.level - 1));
            }
            if (temp.node.right != null) {
                q.add(new Pair(temp.node.right, temp.level + 1));
            }
        }
        for (Entry<Integer, Node> entry : map.entrySet()) {
            System.out.print(entry.getValue().data + " ");
        }
    }

    // Recursive function to print right view of a binary tree.
    static int rightViewsMaxLevelSoFar;

    void getBTRightView(Node node, int level) {

        // Base Case
        if (node == null)
            return;

        // If this is the last Node of its level
        if (rightViewsMaxLevelSoFar < level) {
            System.out.print(node.data + " ");
            rightViewsMaxLevelSoFar = level;
        }

        // Recur for right subtree first, then left subtree
        getBTRightView(node.right, level + 1);
        getBTRightView(node.left, level + 1);
    }

    // Recursive function to print left view of a binary tree.
    static int leftViewsMaxLevelSoFar;

    void getBTLeftView(Node node, int level) {
        // Base Case
        if (node == null)
            return;

        // If this is the first node of its level
        if (leftViewsMaxLevelSoFar < level) {
            System.out.print(node.data + " ");
            leftViewsMaxLevelSoFar = level;
        }

        // Recur for left and right subtrees
        getBTLeftView(node.left, level + 1);
        getBTLeftView(node.right, level + 1);
    }

    // Iterative function to print left view of a binary tree.
    static Queue<Node> q = new LinkedList<Node>();

    // Utility function to print the left view of
    // the binary tree
    static void leftViewUtil(Node root) {
        if (root == null)
            return;
        // add root
        q.add(root);
        // Delimiter
        q.add(null);

        while (q.size() > 0) {
            Node temp = q.peek();

            if (temp != null) {
                // Prints first Node
                // of each level
                System.out.print(temp.data + " ");
                // add children of all Nodes at
                // current level
                while (temp != null) {
                    // If left child is present
                    // add into queue
                    if (temp.left != null)
                        q.add(temp.left);
                    // If right child is present
                    // add into queue
                    if (temp.right != null)
                        q.add(temp.right);
                    // remove the current Node
                    q.remove();
                    temp = q.peek();
                }
                // add delimiter
                // for the next level
                q.add(null);
            }
            // remove the delimiter of
            // the previous level
            q.remove();
        }
    }

}
