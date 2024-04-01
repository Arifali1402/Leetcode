/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private void markParent(TreeNode root,Map<TreeNode, TreeNode> parent_track){
        // Simple BFS Traversal to mark the parent of each node
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr.left != null){
                parent_track.put(curr.left, curr);
                queue.offer(curr.left);
            }
            if(curr.right != null){
                parent_track.put(curr.right, curr);
                queue.offer(curr.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // Map<child, parent> parent_track = new HashMap<>();
        Map<TreeNode, TreeNode> parent_track = new HashMap<>();
        markParent(root,parent_track); // Marking the parent of all the nodes in the Tree
        // Map to track visited nodes
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        // Enqueuing target node and mark it as visited.
        queue.offer(target);
        visited.put(target, true);
        int curr_level = 0;
        while(!queue.isEmpty()){
            if(curr_level == k) break;
            curr_level++;
            int size = queue.size();
            for(int i = 0;i<size;i++){
                TreeNode curr = queue.poll();
            // if it has any left unvisited node, then put it inside the queue and mark it present else ignore
                  if(curr.left != null && visited.get(curr.left) == null){
                      queue.offer(curr.left);
                      visited.put(curr.left, true);
                  }  
            // if it has any right unvisited node, then put it inside the queue and mark it present else ignore
                  if(curr.right != null && visited.get(curr.right) == null){
                      queue.offer(curr.right);
                      visited.put(curr.right, true);
                  }
            // if it has any parent unvisited node, then put it inside the queue and mark it present else ignore
                  if(parent_track.get(curr) != null && visited.get(parent_track.get(curr)) == null){
                      queue.offer(parent_track.get(curr));
                      visited.put(parent_track.get(curr), true);
                  }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            ans.add(queue.poll().val);
        }
        return ans;
    }
}