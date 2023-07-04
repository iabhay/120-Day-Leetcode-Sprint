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
    int mx;
    public int maxPathSum(TreeNode root) {
        mx = Integer.MIN_VALUE;
        sumCalc(root);
        return mx;
    }
    public int sumCalc(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftSum = Math.max(0, sumCalc(root.left));
        int rightSum = Math.max(0, sumCalc(root.right));
        mx = Math.max(mx, root.val + leftSum + rightSum);
        return (root.val + Math.max(leftSum, rightSum));
    }
}