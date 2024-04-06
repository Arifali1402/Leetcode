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
    // Helper function helps us to connect the maximum element in the Right subtree with the right side of the deleted node
    private TreeNode helper(TreeNode root){
        if(root.right == null){
            return root.left;
        }
        if(root.left == null){
            return root.right;
        }
        // // To connect left with right side of the deleted node
        // TreeNode rightChild = root.right;
        // TreeNode rightMost = findRight(root.left);
        // rightMost.right = rightChild;
        // return root.left;
        
        // To connect right with left side of the deleted node
        TreeNode leftChild = root.left;
        TreeNode leftMost = findLeft(root.right);
        leftMost.left = leftChild;
        return root.right;
    }
    
    // To find the rightmost element at the left side of a given tree/subtree
    private TreeNode findRight(TreeNode root){
        if(root.right == null){
            return root;
        }
        return findRight(root.right);
    }
    
    // To find the leftmost element at the right side of a given tree/subtree
    private TreeNode findLeft(TreeNode root){
        if(root.left == null){
            return root;
        }
        return findLeft(root.left);
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        // If the root is null
        if(root == null){
            return root;
        }
        // If the root node is to be deleted
        if(root.val == key){
            return helper(root);
        }
        TreeNode curr = root;
        while(curr != null){
            if(curr.val > key){
                if(curr.left != null && curr.left.val == key){
                    curr.left = helper(curr.left);
                }
                else{
                    curr = curr.left;
                }
            }
            else{
                if(curr.right != null && curr.right.val == key){
                    curr.right = helper(curr.right);
                }
                else{
                    curr = curr.right;
                }
            } 
        }
        return root;
    }
        
}