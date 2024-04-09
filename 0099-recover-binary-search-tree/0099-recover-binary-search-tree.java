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
    private TreeNode first;
    private TreeNode middle;
    private TreeNode last;
    private TreeNode prev;

    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        
        if(prev != null && root.val < prev.val){
            // If this is the first violation, make these two nodes as first and middle
            if(first == null){
                first = prev;
                middle = root;
            }
            // If this is the second violation, make this node as last
            else{
                last = root;
            }
        }
        
        // Mark this node as previous
        prev = root;
        inorder(root.right);
    }
    
    public void recoverTree(TreeNode root) {
        first = middle = last = null;
        TreeNode prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        // Swap the value of first and last
        if(first != null && last != null){
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
        // Swap the value of first and middle
        else if(first != null && middle != null){
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }
}