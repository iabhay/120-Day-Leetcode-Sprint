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
    public int sumNumbers(TreeNode root) {
        return solver(root, 0);
    }
    public int solver(TreeNode root, int sm){
        if(root == null){
            return 0;
        }
        int newSm = sm*10 + root.val;
        if(root.left == null && root.right == null){
            return newSm;
        }

        return (solver(root.left, newSm) + solver(root.right, newSm));

    }
}