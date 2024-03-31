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
    // DFS
    private void dfs(TreeNode root, String str, List<String> list){
        if(root.left == null && root.right == null){
            list.add(str+root.val);
            return;
        }
        if(root.left != null){
            dfs(root.left, str+root.val+"->",list);
        }
        if(root.right != null){
            dfs(root.right, str+root.val+"->",list);
        }
        return;
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        dfs(root, "", list);
        return list;
    }
}