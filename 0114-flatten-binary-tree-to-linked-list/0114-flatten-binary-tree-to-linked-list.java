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
    // Recursive Solution
    // TreeNode prev = null;
    // public void flatten(TreeNode root) {
    //     if(root == null) return;
    //     flatten(root.right);
    //     flatten(root.left);
    //     root.right = prev;
    //     root.left = null;
    //     prev = root;
    // }
    // Iterative Solution
    // public void flatten(TreeNode root) {
    //     Stack<TreeNode> stack = new Stack<>();
    //     stack.push(root);
    //     while(!stack.isEmpty()){
    //         TreeNode curr = stack.peek();
    //         stack.pop();
    //         if(curr.right != null) stack.push(curr.right);
    //         if(curr.left != null) stack.push(curr.left);
    //         if(!stack.isEmpty()){
    //             curr.right = stack.peek();                
    //         }
    //         curr.left = null;
    //     }
    // }
    // Morris Solution
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while(curr != null){
            if(curr.left != null){
                TreeNode prev = curr.left;
                while(prev.right != null){
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
    
    
}