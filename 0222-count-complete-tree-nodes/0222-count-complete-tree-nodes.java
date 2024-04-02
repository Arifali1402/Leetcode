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
// Time Complexity -> O(log(n)^2) which is less than O(N).
// Space Complexity -> O(log(n)).
class Solution {
    private int leftHeight(TreeNode root){
        int count = 0;
        while(root != null){
            count++;
            root = root.left;
        }
        return count;
    }
    
    private int rightHeight(TreeNode root){
        int count = 0;
        while(root != null){
            count++;
            root = root.right;
        }
        return count;
    }
    
    private int count(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = leftHeight(root);
        int right = rightHeight(root);
        
        if(left == right){
            return (int)Math.pow(2,left)-1;
        }
        else{
            return 1 + count(root.left) + count(root.right);
        }
    }
    
    public int countNodes(TreeNode root) {
        int totalNodes = count(root);
        return totalNodes;
    }
}