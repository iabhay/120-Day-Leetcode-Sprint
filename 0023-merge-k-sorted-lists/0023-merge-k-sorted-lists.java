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
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> lst = new ArrayList<>();
        ListNode temp = new ListNode();
        ListNode newNode = temp;
        for(ListNode i : lists){
            if(i == null){
                continue;
            }
            temp.next = i;
            temp = temp.next;
            while(temp.next != null){
                lst.add(temp.val);
                temp = temp.next;
            }
            lst.add(temp.val);
        }
        Collections.sort(lst);
        ListNode tmp = newNode.next;
        for(int j : lst){
            tmp.val = j;
            tmp = tmp.next;
        }
        return newNode.next;
    }
}