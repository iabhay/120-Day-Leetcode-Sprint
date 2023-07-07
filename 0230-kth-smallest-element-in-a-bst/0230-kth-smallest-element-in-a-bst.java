/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Queue<Integer>  queue = new LinkedList<>();
        inOrder(root, queue);
            int size = queue.size();
            if(k < size || k == size){
                for(int i = 0; i< k-1; i++){
                    queue.remove();
                }
            }
            int value = queue.poll();
        return value;
        
    }
    public void inOrder(TreeNode root, Queue<Integer> queue){
        if(root == null){
            return;
        }
        inOrder(root.left, queue);
        queue.add(root.val);
        inOrder(root.right, queue);
    }
}