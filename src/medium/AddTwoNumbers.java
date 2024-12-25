package medium;

/**
 * 
 * @author bhavesh
 *
 */
public class AddTwoNumbers {

	public static void main(String[] args) {
		Solution solution = new AddTwoNumbers().new Solution1();

		ListNode listNode1 = getListNode(new int[] { 2, 4, 3 });
		System.out.println(listNode1);
		ListNode listNode2 = getListNode(new int[] { 5, 6, 4 });
		System.out.println(listNode2);

		ListNode addTwoNumbers = solution.addTwoNumbers(listNode1, listNode2);
		System.out.println(addTwoNumbers);
	}

	private static ListNode getListNode(int[] array) {
		ListNode node = null;
		ListNode currentNode = null;
		for (int i : array) {
			if (currentNode != null) {
				ListNode next = new ListNode(i);
				currentNode.next = next;
				currentNode = next;
			} else {
				currentNode = new ListNode(i);
				node = currentNode;
			}
		}
		return node;
	}

	interface Solution {
		ListNode addTwoNumbers(ListNode l1, ListNode l2);
	}

	class Solution1 implements Solution {

		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			ListNode node = null;
			ListNode currentNode = null;
			int carry = 0;

			while (l1 != null || l2 != null || carry == 1) {
				int sum = 0;
				if (l1 != null) {
					sum += l1.val;
					l1 = l1.next;
				}
				if (l2 != null) {
					sum += l2.val;
					l2 = l2.next;
				}
				sum += carry;
				carry = sum / 10;
				if (currentNode != null) {
					ListNode next = new ListNode(sum % 10);
					currentNode.next = next;
					currentNode = next;
				} else {
					currentNode = new ListNode(sum % 10);
					node = currentNode;
				}
			}
			return node;
		}

	}

}

/*
 * Definition for singly-linked list.
 */
class ListNode {

	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	@Override
	public String toString() {
		return "ListNode [val=" + val + ", next=" + next + "]";
	}

}
