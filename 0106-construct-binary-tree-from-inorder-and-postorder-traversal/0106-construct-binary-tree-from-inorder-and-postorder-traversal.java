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
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // preorder -> root , root.left, root.right
        // inorder -> root.left, root, root.right
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        TreeNode root = solver(inorder, 0, inorder.length-1, postorder,0, postorder.length-1 );
        return root;
    }

    public TreeNode solver(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
        if((inStart > inEnd) || (postStart > postEnd)){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int postRoot = map.get(root.val);
        int leftRem = postRoot - inStart;

        root.left = solver(inorder, inStart, postRoot-1, postorder, postStart, postStart + leftRem -1);
        root.right = solver(inorder, postRoot + 1, inEnd, postorder, postStart + leftRem, postEnd-1);
// postStart, postRoot - 1

        return root;
    }
}