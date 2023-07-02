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
class BSTIterator {
    ArrayList<Integer> lst;
    int nxt = 0;
    public BSTIterator(TreeNode root) {
        lst = new ArrayList<>();
        inOrder(root);
    }
    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        lst.add(root.val);
        inOrder(root.right);
    }

    
    public int next() {
        nxt++;
        return lst.get(nxt-1);
    }
    
    public boolean hasNext() {
        if(nxt >= lst.size()){
            return false;
        }
        return true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */