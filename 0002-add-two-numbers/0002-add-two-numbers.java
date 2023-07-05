/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode ptr1 = l1;
		ListNode ptr2 = l2;
		ListNode ptr3 = new ListNode( 0 );
		ListNode dummy = ptr3;

		int carry = 0;
		while (ptr1 != null || ptr2 != null) {
			int val1 = ptr1 == null ? 0 : ptr1.val;
			ptr1 = ptr1 == null ? null : ptr1.next;
			int val2 = ptr2 == null ? 0 : ptr2.val;
			ptr2 = ptr2 == null ? null : ptr2.next;

			ptr3.next = new ListNode( 0 );
			ptr3 = ptr3.next;
			carry += val1 + val2;
			ptr3.val = carry % 10;
			carry /= 10;
		}
		if (carry > 0) {
			ptr3.next = new ListNode( carry );
		}

		return dummy.next;
    }
}