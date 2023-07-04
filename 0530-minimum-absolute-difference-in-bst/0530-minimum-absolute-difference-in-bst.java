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
    public int getMinimumDifference(TreeNode root) {
        int res = Integer.MAX_VALUE;
        if(root == null){
            return res;
        }
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);
        List<Integer> curr = new ArrayList<>();
        while(!que.isEmpty()){
            int sz = que.size();
            while(sz -- > 0){
                if(que.peek().left != null) que.offer(que.peek().left);
                if(que.peek().right != null) que.offer(que.peek().right);
                curr.add(que.poll().val);
            }
        }
        Collections.sort(curr);
        for(int i = 1; i < curr.size(); i++){
            res = Math.min(res, Math.abs(curr.get(i)- curr.get(i-1)));
        }
        return res;
    }
}