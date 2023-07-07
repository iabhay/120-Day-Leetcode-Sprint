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
    public ListNode removeNthFromEnd(ListNode head, int n) {
    int lastSize = n + 1;
    ListNode[] lastNodes = new ListNode[lastSize];
    int size = 0;
    ListNode node = head;
    while (node != null) {
        lastNodes[size++ % lastSize] = node;
        node = node.next;
    }
    if (n == size) return head.next;
    node = lastNodes[(size - n - 1) % lastSize];
    node.next = node.next.next;
    return head;
}    
}