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
    HashMap<Integer, Integer> map  = new HashMap<>(); 
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // preorder -> root , root.left, root.right
        // inorder -> root.left, root, root.right
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        TreeNode root = solver(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
        return root;
    }

    public TreeNode solver(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if((preStart > preEnd) || (inStart > inEnd)){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = map.get(root.val);
        int leftRem = inRoot - inStart;

        root.left = solver(preorder, preStart + 1, preStart + leftRem, inorder, inStart, inRoot-1);

        root.right = solver(preorder, preStart + leftRem + 1, preEnd, inorder, inRoot+1, inEnd);

        return root;
    }
}