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
// TC -> O(Height)
// SC -> O(1)
class BSTIterator {
    // Maintain a stack to store all the nodes of the BST
    Stack<TreeNode> stack = new Stack<>();
    
    // Define a function which will push all the left side element of the given node
    private void pushAllLeft(TreeNode root){
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }
    
    // Initially push all the left side element of the root to the stack
    public BSTIterator(TreeNode root) {
        pushAllLeft(root);
    }
    
    public int next() {
        // Mainatain a temporary node which will the top of the stack
        TreeNode temp = stack.pop();
        // Push all the right side element of the temp to the stack
        pushAllLeft(temp.right);
        return temp.val;
    }
    
    // If the stack is not empty that means it still has next element
    public boolean hasNext() {
        if(stack.isEmpty() == true){
            return false;
        }
        else{
            return true;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */