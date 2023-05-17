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
    public int pairSum(ListNode head) {
        Stack<Integer> stk = new Stack<>();
        ListNode temp = head;
        int n = 0;
        while(temp != null){
            n++;
            temp = temp.next;
        }
        temp = head;
        for(int i = 0; i < n/2; i++){
            stk.push(temp.val);
            temp = temp.next;
        }
        int res = Integer.MIN_VALUE;
        while(temp != null){
            int curr = stk.pop() + temp.val;
            res = Math.max(res, curr);
            temp = temp.next;
        }
        return res;
    }
}