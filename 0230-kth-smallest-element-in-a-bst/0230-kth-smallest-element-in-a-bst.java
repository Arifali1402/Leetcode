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
    private void inorder(TreeNode root, List<Integer> list){
        if(root.left != null){
            inorder(root.left, list);
        }
        list.add(root.val);
        if(root.right != null){
            inorder(root.right, list);
        }        
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new LinkedList<>();
        inorder(root, list);
        return list.get(k-1);
    }
}