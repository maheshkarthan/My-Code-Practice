package com.list.linkedLists;

public class MergeMultipleSortedLinkedLists {
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
		System.out.println();
	}

	public Node mergeMultipleLLS(Node resultNode, Node newhead) {
		Node result = null;
		while (resultNode != null || newhead != null) {
			Node tmp = null;
			if (resultNode != null && newhead != null && resultNode.data >= newhead.data) {
				tmp = newhead;
				newhead = newhead.next;
				tmp.next = null;
			} else if (resultNode != null && newhead != null && resultNode.data <= newhead.data) {
				tmp = resultNode;
				resultNode = resultNode.next;
				tmp.next = null;
			} else if (resultNode != null) {
				tmp = resultNode;
				resultNode = resultNode.next;
				tmp.next = null;
			} else if (newhead != null) {
				tmp = newhead;
				newhead = newhead.next;
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
		return result;
	}

	// 2 -> 4 -> 7 -> 10 -> 11
	// 1 -> 5 -> 8
	// 1 -> 6 -> 9
	public static void main(String[] args) {
		MergeMultipleSortedLinkedLists nodes1 = new MergeMultipleSortedLinkedLists();
		nodes1.push(2);
		nodes1.push(4);
		nodes1.push(7);
		nodes1.push(10);
		nodes1.push(11);
		MergeMultipleSortedLinkedLists nodes2 = new MergeMultipleSortedLinkedLists();
		nodes2.push(1);
		nodes2.push(5);
		nodes2.push(9);
		MergeMultipleSortedLinkedLists nodes3 = new MergeMultipleSortedLinkedLists();
		nodes3.push(1);
		nodes3.push(6);
		nodes3.push(9);

		MergeMultipleSortedLinkedLists[] nodeArray = new MergeMultipleSortedLinkedLists[3];
		nodeArray[0] = nodes1;
		nodeArray[1] = nodes2;
		nodeArray[2] = nodes3;
		nodes2.display(nodes1.head);
		nodes2.display(nodes2.head);
		nodes2.display(nodes3.head);

		Node finalResult = null;
		for (int i = 0; i < nodeArray.length; i++) {
			finalResult = nodes2.mergeMultipleLLS(finalResult, nodeArray[i].head);
		}
		nodes2.display(finalResult);
	}

}
