package com.list.linkedLists;

public class MergeTwoSortedLinkedLists {
	Node head = null;

	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
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

	public void display(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public Node mergeTwoLL(Node node1, Node node2) {
		Node result = null;

		while (node1 != null || node2 != null) {
			Node tmp = null;
			if (node1 != null && node2 != null && node1.data > node2.data) {
				tmp = node2;
				node2 = node2.next;
				tmp.next = null;
			} else if (node1 != null && node2 != null && node1.data < node2.data) {
				tmp = node1;
				node1 = node1.next;
				tmp.next = null;
			} else if (node1 != null) {
				tmp = node1;
				node1 = node1.next;
				tmp.next = null;
			} else if (node2 != null) {
				tmp = node2;
				node2 = node2.next;
				tmp.next = null;
			}

			if (result == null) {
				result = tmp;
			} else {
				Node temp = result;
				while (temp.next != null) {
					temp = temp.next;
				}
				temp.next = tmp;
			}
		}
		System.out.println();
		return result;
	}

	// 2 -> 4 -> 5 -> 6 -> 8
	// 1 -> 3 -> 7
	public static void main(String[] args) {
		MergeTwoSortedLinkedLists nodes1 = new MergeTwoSortedLinkedLists();
		nodes1.push(2);
		nodes1.push(4);
		nodes1.push(5);
		nodes1.push(6);
		nodes1.push(8);
		MergeTwoSortedLinkedLists nodes2 = new MergeTwoSortedLinkedLists();
		nodes2.push(1);
		nodes2.push(3);
		nodes2.push(7);

		nodes2.display(nodes1.head);
		System.out.println();
		nodes2.display(nodes2.head);
		nodes2.display(nodes2.mergeTwoLL(nodes1.head, nodes2.head));
	}

}
