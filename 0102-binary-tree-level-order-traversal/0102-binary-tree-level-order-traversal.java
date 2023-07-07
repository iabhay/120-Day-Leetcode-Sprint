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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root ==  null){
            return levels;
        }
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.remove();
                if(curr != null){
                    temp.add(curr.val);
                    if(curr.left != null){
                        queue.add(curr.left);
                    }
                    if(curr.right != null){
                        queue.add(curr.right);
                    }
                }
            }
            levels.add(temp);
        }
        return levels;
    }
    
}