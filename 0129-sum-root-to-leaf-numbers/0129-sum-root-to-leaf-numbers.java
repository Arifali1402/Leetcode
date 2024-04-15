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
        if(root == null){
            return;
        }
        stack.push(root.val);
        if(root.left == null && root.right == null){
            int sum = 0;
            int i = 1;
            List<Integer> temp = new LinkedList<>(stack);
            for(int k = temp.size()-1;k>=0;k--){
                sum = sum + temp.get(k)*i;
                i = i*10;
            }
            list.add(sum);
        }
        else{
            dfs(root.left, stack, list);
            dfs(root.right, stack, list);
        }
        stack.pop();
    }
    public int sumNumbers(TreeNode root) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        dfs(root, stack, list);
        int answer = 0;
        for(int l: list){
            answer += l;
        }
        return answer;
    }
}