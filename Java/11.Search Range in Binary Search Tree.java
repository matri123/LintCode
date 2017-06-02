/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        ArrayList<Integer> ans = new ArrayList<Integer>();
        helper(root, k1, k2, ans);
        return ans;
    }
    
    public void helper(TreeNode root, int k1, int k2, ArrayList<Integer> ans){
        if(root == null){
            return;
        }
        if(root.val > k2){
            helper(root.left, k1, k2, ans);
        }
        else if(root.val < k1){
            helper(root.right, k1 ,k2, ans);
        }
        else {
            helper(root.left, k1, k2, ans);
            ans.add(root.val);
            helper(root.right, k1, k2, ans);
        }
    }
}
