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
    // Finding the Lowest Common Ancestor of both nodes
    private TreeNode lca(TreeNode root, int start, int end){
        if(root == null || root.val == start || root.val == end){
            return root;
        }
        TreeNode leftPart = lca(root.left, start, end);
        TreeNode rightPart = lca(root.right, start, end);
        if(leftPart == null){
            return rightPart;
        }
        if(rightPart == null){
            return leftPart;
        }
        return root;

    }
    // Generating strings
    StringBuilder lcaToStart = new StringBuilder();
    String lcaToEnd;
    private void dfs(TreeNode root, StringBuilder pathStr, int p, int q){
        if(root == null) return;
        // Left subpart
        if(root.val == p){
            lcaToStart.append(pathStr.toString());
        }
        // Right subpart
        if(root.val == q){
            lcaToEnd = pathStr.toString();
        }
        
        // Push a 'L' for left
        pathStr.append('L');
        // Call for the left subtree
        dfs(root.left, pathStr, p, q);
        
        // Backtracking
        pathStr.deleteCharAt(pathStr.length()-1);
        
        // Push a 'R' for right
        pathStr.append('R');
        // Call for the right subtree
        dfs(root.right, pathStr, p, q);
        // Backtracking
        pathStr.deleteCharAt(pathStr.length()-1);
    }
     
    public String getDirections(TreeNode root, int startValue, int destValue) {
        // Find the common parent
        TreeNode commonParent = lca(root, startValue, destValue);
        StringBuilder str = new StringBuilder();
        dfs(commonParent, str, startValue, destValue);
        for(int i=0;i<lcaToStart.length();i++){
            lcaToStart.setCharAt(i,'U');
        }
        return lcaToStart+lcaToEnd;
    }
}