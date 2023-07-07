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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> lst = new ArrayList<>();
    if(root == null){
        return lst;
    }
    Queue<TreeNode> que = new LinkedList<>();
    que.add(root);
    boolean LtoR = true;
        while(!que.isEmpty()){
            int sz = que.size();
            int[] curr = new int[sz];
            for(int i = 0; i < sz; i++){
                TreeNode temp = que.peek();
                que.poll();
                int ind = LtoR ? i : (sz-1-i);
                curr[ind] = temp.val;
                if(temp.left != null){
                    que.offer(temp.left);
                }
                if(temp.right != null){
                    que.offer(temp.right);
                }
            }
            LtoR = !LtoR;
            List<Integer> now = new ArrayList<>();
            for(int j = 0; j < curr.length; j++){
                now.add(curr[j]);
            }
            lst.add(now);
        }
        return lst;

    }
}