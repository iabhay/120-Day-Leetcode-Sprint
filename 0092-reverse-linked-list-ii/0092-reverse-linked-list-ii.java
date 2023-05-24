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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 1;
        ListNode temp = head;
        while(temp!= null){
            if(i >= left && i <= right){
                map.put(i, temp.val);
            }
            i++;
            temp = temp.next;
        }
        temp = head;
        i = 1;
        int j = right;
        while(temp!= null){
            if(i >= left && i <= right){
                temp.val = map.get(j);
                j--;
            }
            i++;
            temp = temp.next;
        }
        return head;
    }
}