package com.list.linkedLists;

public class AddTwoLinkedLists {
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

	public Node addTwoLL(Node node1, Node node2) {
		Node result = null;

		int carry = 0;
		while (node1 != null || node2 != null) {
			int sum = 0;
			if (node1 != null && node2 != null) {
				sum = node1.data + node2.data;
				node1 = node1.next;
				node2 = node2.next;
			} else if (node1 != null) {
				sum = node1.data;
				node1 = node1.next;
			} else if (node2 != null) {
				sum = node2.data;
				node2 = node2.next;
			}
			sum = sum + carry;
			carry = sum / 10;
			sum = sum % 10;

			if (result == null) {
				result = new Node(sum);
			} else {
				Node newNode = new Node(sum);
				Node temp = result;
				while (temp.next != null) {
					temp = temp.next;
				}
				temp.next = newNode;
			}
		}
		System.out.println();
		return result;
	}

	// 2 -> 4 -> 5 -> 6 -> 8
	// 1 -> 3 -> 7
	public static void main(String[] args) {
		AddTwoLinkedLists nodes1 = new AddTwoLinkedLists();
		nodes1.push(2);
		nodes1.push(4);
		nodes1.push(5);
		nodes1.push(6);
		nodes1.push(8);
		AddTwoLinkedLists nodes2 = new AddTwoLinkedLists();
		nodes2.push(1);
		nodes2.push(6);
		nodes2.push(7);

		nodes2.display(nodes1.head);
		System.out.println();
		nodes2.display(nodes2.head);
		nodes2.display(nodes2.addTwoLL(nodes1.head, nodes2.head));
	}

}
