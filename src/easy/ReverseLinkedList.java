package easy;

import utils.ListNode;

/**
 * 206. Reverse Linked List
 * 
 * Given the head of a singly linked list, reverse the list, and return the
 * reversed list.
 * 
 * @Example Input: head = [1,2,3,4,5]; Output: [5,4,3,2,1];
 * 
 * @Topics Linked List, Recursion
 * 
 * @author Bhavesh
 * 
 */
public class ReverseLinkedList {

	public static void main(String[] args) {
		ListNode head = SampleInput.getSampleListNode();
		System.out.println(head);
		System.out.println(reverseList(head));
	}

	/**
	 * Reversing a linked list means rearranging the pointers so that each node
	 * points to its predecessor instead of its successor.
	 * 
	 * @param head
	 * @return
	 */
	public static ListNode reverseList(ListNode head) {
		ListNode prev = null; // Initially, there's no previous node.
		ListNode curr = head;

		while (curr != null) {
			ListNode nextNode = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextNode;
		}
		return prev;
	}

	public static ListNode reverseList_NotInPlace(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode newHead = new ListNode(head.val, null);
		while (head.next != null) {
			head = head.next;
			newHead = new ListNode(head.val, newHead);
		}
		return newHead;
	}

}

class SampleInput {

	public static ListNode getSampleListNode() {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		return node;
	}

}