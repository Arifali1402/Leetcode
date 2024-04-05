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
// Morris InOrder Traversal
// Time Complexity -> Nearly O(N)
// Space Complexity -> O(1) ---> Constant
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new LinkedList<>();
        TreeNode curr = root;
        while(curr != null){
            // If the curr has left which is null, then adf it and move it to the right
            if(curr.left == null){
                inorder.add(curr.val);
                curr = curr.right;
            }
            else{
                //rightmost node will point to the current node
                TreeNode prev = curr.left;
                // while rightmost is not null and is not pointing to itself
                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }
                // 1st case-> if right is null
                if(prev.right == null){
                    // Create a thread
                    prev.right = curr;
                    curr = curr.left;
                }
                // 2nd case -> if it comes back to the current node
                else{
                    // cut the thread and go to the right node
                    prev.right = null;
                    // Since it is the root now
                    inorder.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return inorder;
    }
}

/*
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }
    public void helper(TreeNode root, List<Integer> res){
        if(root != null){
            helper(root.left,res);
            res.add(root.val);
            helper(root.right,res);
        }
    }
}
*/