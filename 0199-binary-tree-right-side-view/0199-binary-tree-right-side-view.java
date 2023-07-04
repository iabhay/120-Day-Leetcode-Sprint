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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);
        while(!que.isEmpty()){
            int sz = que.size();
            ArrayList<Integer> curr = new ArrayList<>();
            while(sz -- > 0){
                if(que.peek().left != null) que.offer(que.peek().left);
                if(que.peek().right != null) que.offer(que.peek().right);
                curr.add(que.poll().val);
            }
            res.add(curr.get(curr.size()-1));
        }
        return res;
    }
}