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
    private boolean helper(TreeNode r1, TreeNode r2){
        if(r1 == null && r2 == null){
            return true;
        }
        if(r1 == null || r2 == null){
            return false;
        }
        if(r1.val == r2.val){
            return helper(r1.left, r2.right) && helper(r1.right, r2.left);
        }
        return false;
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return helper(root.left, root.right);
    }
}