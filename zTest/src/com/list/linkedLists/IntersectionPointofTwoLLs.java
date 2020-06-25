package com.list.linkedLists;

/*
	 1 -> 2  
			-> 3 -> 4 -> 5
6 -> 7 -> 8
*/
public class IntersectionPointofTwoLLs {
	Node head1, head2;

	static class Node {
		Node next;
		int data;

		public Node(int data) {
			this.data = data;
			next = null;
		}
	}

	private static void display(Node head) {
		Node head1 = head;
		while (head1 != null) {
			System.out.print(head1.data + " ");
			head1 = head1.next;
		}
		System.out.println();
	}

	private static Node findIntersectionPoint(Node head1, Node head2) {
		int headOneNodesCount = countNodes(head1);
		int headTwoNodesCount = countNodes(head2);
		int difference = 0;
		System.out.println(headOneNodesCount + " " + headTwoNodesCount);

		if (headOneNodesCount > headTwoNodesCount) {
			difference = headOneNodesCount - headTwoNodesCount;
			return intersectionPoint(head1, head2, difference);
		} else if (headTwoNodesCount > headOneNodesCount) {
			difference = headTwoNodesCount - headOneNodesCount;
			return intersectionPoint(head2, head1, difference);
		} else {// both are same or no values will be taken care
			return intersectionPoint(head1, head2, difference);
		}
	}

	// Assuming head1 is larger LL node as per values passed to method
	private static Node intersectionPoint(Node head1, Node head2, int difference) {
		while (head1 != null && difference != 0) {
			head1 = head1.next;
			difference--;
		}
		while (head1 != null && head2 != null) {
			if (head1 == head2) {
				break;
			}
			head1 = head1.next;
			head2 = head2.next;
		}
		return head1;
	}

	private static int countNodes(Node head) {
		int count = 0;
		Node temp = head;
		while (temp != null) {
			temp = temp.next;
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		IntersectionPointofTwoLLs intersectionPointNode = new IntersectionPointofTwoLLs();
		intersectionPointNode.head1 = new Node(1);
		intersectionPointNode.head1.next = new Node(2);
		intersectionPointNode.head1.next.next = new Node(3);
		intersectionPointNode.head1.next.next.next = new Node(4);
		intersectionPointNode.head1.next.next.next.next = new Node(5);

		intersectionPointNode.head2 = new Node(6);
		intersectionPointNode.head2.next = new Node(7);
		intersectionPointNode.head2.next.next = new Node(8);
		intersectionPointNode.head2.next.next.next = intersectionPointNode.head1.next.next;

		display(intersectionPointNode.head1);
		display(intersectionPointNode.head2);
		Node result = (findIntersectionPoint(intersectionPointNode.head1, intersectionPointNode.head2));
		System.out.println(result != null ? "Intersection Point is at value: " + result.data : "Invalid Linked Lists");
	}
}
