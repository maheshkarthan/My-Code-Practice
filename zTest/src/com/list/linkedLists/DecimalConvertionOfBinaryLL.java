package com.list.linkedLists;

public class DecimalConvertionOfBinaryLL {

	Node head;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		DecimalConvertionOfBinaryLL dcBLL = new DecimalConvertionOfBinaryLL();
		dcBLL.head = new Node(1);
		dcBLL.head.next = new Node(1);
		dcBLL.head.next.next = new Node(0);
		dcBLL.head.next.next.next = new Node(1);
		dcBLL.head.next.next.next.next = new Node(1);
		dcBLL.head.next.next.next.next.next = new Node(0);

		System.out.println(dcBLL.convertToDecimal(dcBLL.head));
	}

	private long value = 0L;
	private long base = 1L;

	// Binary values are kind of (...32, 16, 8, 4, 2, 1) for base
	private long convertToDecimal(Node head) {
		if (head == null) {
			return 1;
		}
		Node temp = head;
		convertToDecimal(head.next);
		if (temp.data == 1) {
			value = value + base;
		}
		base = base * 2;
		return value;
	}
}
// Time Complexity O(n)