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
    private void helper(TreeNode root, StringBuilder path, StringBuilder smallest){
        if(root == null){
            return;
        }
        path.append((char)('a' + root.val));
        // If the curr node is the leaf node
        if(root.left == null && root.right == null){
            String curr = path.reverse().toString();
            if(smallest.length() == 0 || curr.compareTo(smallest.toString()) < 0){
                smallest.setLength(0);
                smallest.append(curr);
            }
            path.reverse(); // backtrack by reversing it again
        }
        // Recursive traversal
        helper(root.left, path, smallest);
        helper(root.right, path, smallest);
        // Backtrack: remove the current node's character from the path
        path.setLength(path.length()-1);
    }

    public String smallestFromLeaf(TreeNode root) {
        StringBuilder str = new StringBuilder();
        helper(root, new StringBuilder(), str);
        return str.toString();
    }
}