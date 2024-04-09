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
        if(root == null){
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        int low = 0;
        int high = list.size()-1;
        while(low < high){
            int first = list.get(low);
            int last = list.get(high);
            int total = first + last;
            if(total == k){
                return true;
            }
            else if(total < k){
                low++;
            }
            else{
                high--;
            }
        }
        return false;
    }
}

/*
class BSTIterator {
    // Maintain a stack to store all the nodes of the BST
    Stack<TreeNode> stack = new Stack<>();
    
    // reverse --> true --> before
    // reverse --> false --> next

    boolean reverse = true;
    
    // Initially push all the left side element of the root to the stack
    public BSTIterator(TreeNode root, boolean isReverse) {
        reverse = isReverse;
        pushAll(root);
    }
    
    public int next() {
        // Mainatain a temporary node which will the top of the stack
        TreeNode temp = stack.pop();
        if(reverse == false){
            // Push all the right side element of the temp to the stack
            pushAll(temp.right);
        }
        else{
            // Push all the left side element of the temp to the stack
            pushAll(temp.left);
        }
        return temp.val;
    }
    
    // Define a function which will push all the left/right side element of the given node
    private void pushAll(TreeNode root){
        while(root != null){
            stack.push(root);
            if(reverse = true){
                root = root.right;
            }
            else{
                root = root.left;
            }
        }        
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

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null){
            return false;
        }
        BSTIterator l = new BSTIterator(root, false);
        BSTIterator r = new BSTIterator(root, true);
        
        int i = l.next();
        int j = r.next();
        while(i < j){
            if(i + j == k){
                return true;
            }
            else if(i + j < k){
                i = l.next();
            }
            else{
                j = r.next();
            }
        }
        return false;
    }
}
*/