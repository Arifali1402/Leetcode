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
    private int maxPath(TreeNode root, int maxi[]){
        if(root == null){
            return 0;
        }
        int lh = maxPath(root.left, maxi);
        // To eliminate the negative path sum
        int left = Math.max(0, lh);
        int rh = maxPath(root.right, maxi);
        // To eliminate the negative path sum
        int right = Math.max(0, rh);
        maxi[0] = Math.max(maxi[0], left+right+root.val);
        // This will allow us to know about the path it will take to get to the max path
        return root.val + Math.max(left, right);
    }
    public int maxPathSum(TreeNode root) {
        if(root.left == null && root.right == null){
            return root.val;
        }
        int maxi[] = new int[1];
        maxi[0] = Integer.MIN_VALUE;
        int x = maxPath(root, maxi);
        return maxi[0];
    }
}