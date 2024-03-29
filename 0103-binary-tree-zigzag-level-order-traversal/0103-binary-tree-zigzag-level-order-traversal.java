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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        boolean leftToRight = true;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            Integer arr[] = new Integer[size];
            if(leftToRight){
                for(int i = 0;i<size;i++){
                    TreeNode curr = queue.poll();
                    arr[i] = curr.val;
                    if(curr.left != null){
                        queue.offer(curr.left);
                    }
                    if(curr.right != null){
                        queue.offer(curr.right);
                    }
                }
            }
            else{
                for(int i = size-1;i>=0;i--){
                    TreeNode curr = queue.poll();
                    arr[i] = curr.val;
                    if(curr.left != null){
                        queue.offer(curr.left);
                    }
                    if(curr.right != null){
                        queue.offer(curr.right);
                    }
                }
            }
            leftToRight = !leftToRight;
            list = Arrays.asList(arr);
            ans.add(list);
        }
        return ans;
    }
}