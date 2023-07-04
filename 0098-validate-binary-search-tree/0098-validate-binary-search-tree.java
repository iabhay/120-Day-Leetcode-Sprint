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
    ArrayList<Integer> lst;
    public boolean isValidBST(TreeNode root) {
        lst = new ArrayList<>();
        inOrder(root);
        for(int i = 1; i < lst.size(); i++){
            if(lst.get(i) <= lst.get(i-1)){
                return false;
            }
        }
        return true;
    }
    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        lst.add(root.val);
        inOrder(root.right);
    }
}