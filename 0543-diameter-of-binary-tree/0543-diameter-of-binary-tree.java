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
// The previous solution is better but this one gives you a better time complexity
class Solution {
    private int height(TreeNode root, int dia[]){
        if(root == null){
            return 0;
        }
        int lh = height(root.left, dia);
        int rh = height(root.right, dia);
        dia[0] = Math.max(dia[0], lh+rh);
        return Math.max(lh,rh)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int diameter[] = new int[1];
        int x = height(root, diameter);
        return diameter[0];
    }
}
/*
class Solution {
    private int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight,rightHeight)+1;
    }
    private int diameter(TreeNode root){
        if(root == null){
            return 0;
        }
        // For left subtree
        int dia1 = diameter(root.left);
        // for right subtree
        int dia2 = diameter(root.right);
        // including the root node
        int dia3 = height(root.left) + height(root.right);
        return Math.max(Math.max(dia1,dia2),dia3);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return diameter(root);
    }
}
*/