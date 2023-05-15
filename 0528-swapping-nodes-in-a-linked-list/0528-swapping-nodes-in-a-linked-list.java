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
    public ListNode swapNodes(ListNode head, int k) {
        int sz = 0;
        ListNode temp = head;
        int valK = 0;
        ListNode tht = head;
        while(temp != null){
            sz++;
            if(sz == k){
                tht = temp;
                valK = temp.val;
            }
            // if(sz == (sz - k + 1)){
            //     valKK = temp.val;
            //     temp.val = valK;
            //     tht.val = valKK;
            // }
            // if(valK > 0 && valKK > 0){
            //     break;
            // }
            temp = temp.next;
        }
        int i = 0;
        temp = head;
        while(temp != null){
            if(i == (sz-k)){
                tht.val = temp.val;
                temp.val = valK;
                break;
            }
            i++;
            temp = temp.next;
        }
        return head;
    }
}