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
    private boolean validate(TreeNode root, long left, long right){
        if(root == null){
            return true;
        }
        if(root.val > left && root.val < right){
            return validate(root.left, left, root.val) && validate(root.right, root.val, right);
        }
        return false;
    }
    public boolean isValidBST(TreeNode root) {
        long left = Long.MIN_VALUE;
        long right = Long.MAX_VALUE;
        return validate(root, left, right);
    }
}