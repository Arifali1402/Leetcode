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
    private void helper(TreeNode root, int level, List<Integer> ans){
        if(root == null){
            return;
        }
        // Only the element which comes first will be present in the right view traversal
        if(ans.size() == level){
            ans.add(root.val);
        }
        // first move towards the right side of the root node
        helper(root.right, level+1, ans);
        // then move towards the left side of the root node
        helper(root.left, level+1, ans);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        helper(root, 0, ans);
        return ans;
    }
}