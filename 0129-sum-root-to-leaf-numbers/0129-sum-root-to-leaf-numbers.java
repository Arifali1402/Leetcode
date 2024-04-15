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
    private void dfs(TreeNode root, Stack<Integer> stack, List<Integer> list){
        // If we encounter null, then just return
        if(root == null){
            return;
        }
        // push the current node's val
        stack.push(root.val);
        // If the current node does not have any left and right nodes then do the followinf operations
        if(root.left == null && root.right == null){
            int sum = 0;
            int i = 1;
            // Store all the values of the Stack wihout deleting any value from the stack
            List<Integer> temp = new LinkedList<>(stack);
            // Add it 
            for(int k = temp.size()-1;k>=0;k--){
                sum = sum + temp.get(k)*i;
                i = i*10;
            }
            // Store the sum 
            list.add(sum);
        }
        // else call for left and right child of the current node
        else{
            dfs(root.left, stack, list);
            dfs(root.right, stack, list);
        }
        // for backtracking
        stack.pop();
    }
    public int sumNumbers(TreeNode root) {
        // for storing the values of the tree
        Stack<Integer> stack = new Stack<>();
        // to store the sum from the root to the leaf node
        List<Integer> list = new LinkedList<>();
        // This traversal is needed for calculating the sum
        dfs(root, stack, list);
        // Our main answer
        int answer = 0;
        // Add all the elements from the list
        for(int l: list){
            answer += l;
        }
        // return the answer
        return answer;
    }
}