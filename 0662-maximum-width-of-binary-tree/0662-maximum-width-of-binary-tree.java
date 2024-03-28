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
class Pair{
    TreeNode node;
    int num;
    Pair(TreeNode n, int x){
        node = n;
        num = x;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int ans = 0;
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.offer(new Pair(root, 0));
        // Level Order Traversal
        while(!queue.isEmpty()){
            int size = queue.size();
            // To make the starting ID from zero
            int mini = queue.peek().num;
            int first = 0, last = 0;
            for(int i = 0;i<size;i++){
                TreeNode curr_node = queue.peek().node;
                // i = i - min;
                int curr_id = queue.peek().num - mini;
                queue.poll();
                if(i == 0){
                    first = curr_id;
                }
                if(i == size-1){
                    last = curr_id;
                }
                if(curr_node.left != null){
                    queue.offer(new Pair(curr_node.left, 2*curr_id+1));
                }
                if(curr_node.right != null){
                    queue.offer(new Pair(curr_node.right, 2*curr_id+2));
                }
            }
            ans = Math.max(ans, (last - first + 1));
        }
        return ans;
    }
}