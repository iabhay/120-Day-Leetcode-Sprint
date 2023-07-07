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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode temp = head;
        int count = 1;
        while(temp.next != null){
            count++;
            temp = temp.next;
        }
        k = k % count;
        while(k > 0){
        ListNode last = head.next;
        ListNode secLast = head;
            while(last.next != null){
                last = last.next;
                secLast = secLast.next;
            }
            last.next = head;
            secLast.next = null;
            k--;
            head = last;
        }
        return head;
    }
}