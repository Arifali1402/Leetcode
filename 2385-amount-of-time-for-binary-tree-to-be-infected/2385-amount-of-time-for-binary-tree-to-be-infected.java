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
    // Function to return the total time required to burn the whole Binary Tree
    private int timeToBurn(TreeNode infected, Map<TreeNode, TreeNode> parent_track){
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(infected);
        visited.put(infected, true);
        int totalTime = 0;
        // Level Order Traversal
        while(!queue.isEmpty()){
            int size = queue.size();
            int fire = 0;
            for(int i = 0;i<size;i++){
                TreeNode curr = queue.poll();
                if(curr.left != null && visited.get(curr.left) == null){
                    visited.put(curr.left, true);
                    fire = 1;
                    queue.offer(curr.left);
                }
                if(curr.right != null && visited.get(curr.right) == null){
                    visited.put(curr.right, true);
                    fire = 1;
                    queue.offer(curr.right);
                }
                if(parent_track.get(curr) != null && visited.get(parent_track.get(curr)) == null){
                    visited.put(parent_track.get(curr), true);
                    fire = 1;
                    queue.offer(parent_track.get(curr));
                }
            }
            if(fire == 1){
                totalTime++;
            }
        }
        return totalTime;
    }
    
    // Function to find the infected node along with mapping each node to its parent
    private TreeNode infect(TreeNode root, int start, Map<TreeNode, TreeNode> parent_track){
        // BFS to find the parent of each node
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // Starting node
        TreeNode res = new TreeNode(-1);
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            // if the value matches, then it is the starting node
            if(start == curr.val){
                res = curr;
            }
            if(curr.left != null){
                parent_track.put(curr.left, curr);
                queue.offer(curr.left);
            }
            if(curr.right != null){
                parent_track.put(curr.right, curr);
                queue.offer(curr.right);
            }
        }
        return res;
    }
    
    public int amountOfTime(TreeNode root, int start) {
        // Map<child, parent> map = new HashMap<>();
        Map<TreeNode, TreeNode> parent_track = new HashMap<>();
        TreeNode infectedNode = infect(root, start, parent_track);
        int time = timeToBurn(infectedNode, parent_track);
        return time;
    }
}