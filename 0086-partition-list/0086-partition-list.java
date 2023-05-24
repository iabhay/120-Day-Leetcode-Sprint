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
    public ListNode partition(ListNode head, int x) {
        ListNode tmp = head;
        ArrayList<Integer> lst = new ArrayList<>();
        ArrayList<Integer> ind = new ArrayList<>();
        int i = 0; 
        while(tmp != null){
            if(tmp.val < x){
                ind.add(tmp.val);
            }
            else{
                lst.add(tmp.val);
            }
            i++;
            tmp = tmp.next;
        }
        tmp = head;
        while(tmp != null){
            for(int c : ind){
                tmp.val = c;
                tmp = tmp.next;
            }
            for(int c : lst){
                tmp.val = c;
                tmp = tmp.next;
            }
        }
        return head;
    }
}