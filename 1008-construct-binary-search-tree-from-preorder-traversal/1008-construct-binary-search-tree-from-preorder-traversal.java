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
    private TreeNode buildBST(int preorder[], long boundary, int[] i){
        // Base Condition
        // If no nodes are left or the value is out of boundary, return null
        if(i[0] == preorder.length || preorder[i[0]] > boundary){
            return null;
        }
        // 1st node is the root node
        TreeNode root = new TreeNode(preorder[i[0]++]);
        // All the values having boundary less than 'root.val' will be lying at the left
        root.left = buildBST(preorder, root.val, i);
        // All the values having boundary less than 'boundary' will be lying at the right
        root.right = buildBST(preorder, boundary, i);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int i[] = {0};
        return buildBST(preorder, Long.MAX_VALUE, i);
    }
}