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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int d = 1;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            if(d == depth-1){
                for(int i=0;i<size;i++){
                    TreeNode cur = queue.poll();
                    TreeNode curLeft = cur.left;
                    TreeNode curRight = cur.right;
                    if(curLeft == null){
                        cur.left = new TreeNode(val);
                    }
                    else{
                        TreeNode newLeft = new TreeNode(val);
                        cur.left = newLeft;
                        newLeft.left = curLeft;
                    }
                    if(curRight == null){
                        cur.right = new TreeNode(val);
                    }
                    else{
                        TreeNode newRight = new TreeNode(val);
                        cur.right = newRight;
                        newRight.right = curRight;
                    }
                }
                break;
            }
            d++;
            for(int i=0;i<size;i++){
                TreeNode curr = queue.poll();
                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }
        }
        return root;
    }
}