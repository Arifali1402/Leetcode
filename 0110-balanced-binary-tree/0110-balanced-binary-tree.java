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
    // Optimize Solution in O(N)
    private int dfsHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int lh = dfsHeight(root.left);
        if(lh == -1) return -1;
        int rh = dfsHeight(root.right);
        if(rh == -1) return -1;
        
        if(Math.abs(lh - rh) > 1) return -1;
        return Math.max(lh, rh) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;
    }
}

/*
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
Time Complexity :- O(N^2)
class Solution {
    private int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return 1 + Math.max(left, right);
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        if(Math.abs(lh - rh) > 1){
            return false;
        }
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        if(left == false || right == false){
            return false;
        }
        return true;
    }
}
*/