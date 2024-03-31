/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q || root == null){
            return root;
        }
        TreeNode leftPart = lowestCommonAncestor(root.left, p, q);
        TreeNode rightPart = lowestCommonAncestor(root.right, p, q);

        if(leftPart == null){
            return rightPart;
        }
        if(rightPart == null){
            return leftPart;
        }
        // Hence we have found both left and right nodes
        return root;
    }
}